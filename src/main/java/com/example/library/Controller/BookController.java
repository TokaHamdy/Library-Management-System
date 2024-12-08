package com.example.library.Controller;
import com.example.library.Entity.Book;
import com.example.library.Service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController 
@RequestMapping("/api/books")
@Tag(name = "Books Controller", description = "Endpoints for managing books in the library")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @Operation(summary = "Get All Books", description = "Retrieve a list of all books in the library.")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();

    }

    @Operation(summary = "Get Book by ID", description = "Retrieve the details of a specific book by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }



    @Operation(summary = "Add a new Book", description = "Add a new book to the library.")
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    @Operation(summary = "Update Book Details", description = "Update the information of an existing book by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @Operation(summary = "Delete a Book", description = "Remove a book from the library by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Book Search", description = "Search for books by criteria such as author, title, category, or publication date range with pagination.")
    @GetMapping("/advanced-search")
    public Page<Book> advancedSearch(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(defaultValue = "0") int page, // default page number
            @RequestParam(defaultValue = "10") int size) { // default page size

        Pageable pageable = PageRequest.of(page, size); // Create Pageable object
        return bookService.advancedSearch(author, title, category, startDate, endDate, pageable);
    }


}
