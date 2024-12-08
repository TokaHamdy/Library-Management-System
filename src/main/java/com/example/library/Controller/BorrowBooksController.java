package com.example.library.Controller;

import com.example.library.Entity.BorrowBooks;
import com.example.library.Service.BorrowBooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow-books")
@Tag(name = "Borrow Books Controller", description = "Endpoints for borrowing and returning books")
public class BorrowBooksController {
    private final BorrowBooksService borrowBooksService;


    @Autowired
    public BorrowBooksController(BorrowBooksService borrowBooksService) {
        this.borrowBooksService = borrowBooksService;
    }

    // Borrow a book
    @Operation(summary = "Borrow a Book", description = "Borrow a specific book for a user.")
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
    @Operation(summary = "Return a Book", description = "Return a borrowed book for a user.")
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
