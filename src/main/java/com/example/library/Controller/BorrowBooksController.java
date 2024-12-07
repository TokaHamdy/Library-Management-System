package com.example.library.Controller;

import com.example.library.Entity.BorrowBooks;
import com.example.library.Service.BorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow-books")
public class BorrowBooksController {
    private final BorrowBooksService borrowBooksService;


    @Autowired
    public BorrowBooksController(BorrowBooksService borrowBooksService) {
        this.borrowBooksService = borrowBooksService;
    }

    // Borrow a book
    @PostMapping("/borrow/{userId}/{bookId}")
    public ResponseEntity<BorrowBooks> borrowBook(@PathVariable long userId, @PathVariable long bookId) {
        try {
            BorrowBooks borrowBooks = borrowBooksService.borrowBook(userId, bookId);
            return ResponseEntity.ok(borrowBooks);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);  // Return an error message if the book can't be borrowed
        }
    }
    // Return a book
    @PostMapping("/return/{userId}/{bookId}")
    public ResponseEntity<BorrowBooks> returnBook(@PathVariable long userId, @PathVariable long bookId) {
        try {
            BorrowBooks borrowBooks = borrowBooksService.returnBook(userId, bookId);
            return ResponseEntity.ok(borrowBooks);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
