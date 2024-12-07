package com.example.library.Service;

import com.example.library.Entity.Book;
import com.example.library.Entity.BorrowBooks;
import com.example.library.Entity.User;
import com.example.library.Factory.BorrowBooksFactory;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.BorrowBookRepository;
import com.example.library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowBooksService {

    private final BorrowBookRepository borrowBookRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowBooksFactory borrowBooksFactory;


    @Autowired
    public BorrowBooksService(BorrowBookRepository borrowBooksRepository, BorrowBookRepository borrowBookRepository,
                              BookRepository bookRepository,
                              UserRepository userRepository, BorrowBooksFactory borrowBooksFactory) {
        this.borrowBookRepository = borrowBookRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.borrowBooksFactory = borrowBooksFactory;
    }

    // Borrow book
    public BorrowBooks borrowBook(long user_id, long book_id ){
        User user= userRepository.findById(user_id)
                .orElseThrow(()-> new RuntimeException("User not found with this id: "+ user_id ));
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + book_id));

        // Check if the book is available
        if (!"Available".equalsIgnoreCase(book.getStatus())) {
            throw new RuntimeException("Book with id:" + book_id + " is already borrowed");
        }


        // Update book status to BORROWED
        book.setStatus("BORROWED");
        bookRepository.save(book);

        BorrowBooks borrowBooks = borrowBooksFactory.createBorrowRecord(user,book);

        return borrowBookRepository.save(borrowBooks);

    }

    // return book
    public BorrowBooks returnBook(long userId, long bookId) {
        // Find the borrowing record for the given user and book
        BorrowBooks borrowBooks = borrowBookRepository.findByUserIdAndBookIdAndStatus(userId, bookId, "BORROWED")
                .orElseThrow(() -> new RuntimeException("No active borrowing record found for user ID: "
                        + userId + " and book ID: " + bookId));

        // Update the status of the book to "AVAILABLE"
        Book book = borrowBooks.getBook();
        book.setStatus("AVAILABLE");
        bookRepository.save(book);

        // Update the borrowing record to "RETURNED"
        borrowBooks.setStatus("RETURNED");
        borrowBooks.setReturnDate(LocalDate.now());

        return borrowBookRepository.save(borrowBooks);



    }

    }
