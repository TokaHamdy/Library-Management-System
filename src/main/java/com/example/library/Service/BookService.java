package com.example.library.Service;

import com.example.library.Entity.Book;
import com.example.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    // Method to get all books
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    // Method to find a book by id
    public Book getBookById(long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book not Found with id: "+ id));
    }
    // Method to save a book
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    // Method to update a book
    public Book updateBook(long id, Book updatedBook){
        Book afterUpdate= getBookById(id);
        afterUpdate.setAuthor(updatedBook.getAuthor());
        afterUpdate.setTitle(updatedBook.getTitle());
        afterUpdate.setIsbn(updatedBook.getIsbn());

        return bookRepository.save(afterUpdate);

    }
    // Method to delete a book by id
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
    public Page<Book> advancedSearch(String author, String title, String category, LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return bookRepository.advancedSearch(author, title, category, startDate, endDate, pageable);
    }

    }
