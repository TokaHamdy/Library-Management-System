package com.example.library.Service;

import com.example.library.Entity.Book;
import com.example.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Book> getBookById(long id){
        return bookRepository.findById(id);
    }
    // Method to save a book
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    // Method to delete a book by id
    public void deleteBook(long id){
        bookRepository.deleteById(id);

    }

}
