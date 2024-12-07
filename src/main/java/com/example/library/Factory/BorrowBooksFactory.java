package com.example.library.Factory;

import com.example.library.Entity.Book;
import com.example.library.Entity.BorrowBooks;
import com.example.library.Entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BorrowBooksFactory {
    public BorrowBooks createBorrowRecord(User user, Book book) {
        BorrowBooks borrowBook= new BorrowBooks();
        borrowBook.setUser(user);
        borrowBook.setBook(book);
        borrowBook.setBorrowDate(LocalDate.now());
        borrowBook.setStatus("BORROWED");
        return borrowBook;
    }

    }
