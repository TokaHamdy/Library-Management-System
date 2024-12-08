package com.example.library.Controller;

import com.example.library.Entity.Review;
import com.example.library.Service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Reviews Controller", description = "Endpoints for managing book reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Add a new review
    @Operation(summary = "Add a Rate for a book", description = "Add a review for a book by a user with a specified rating.")
    @PostMapping("/books/{bookId}/reviews/{userId}/{rating}")
    public ResponseEntity<Review> addReview(@PathVariable Long bookId, @PathVariable Long userId, @PathVariable int rating) {
        Review savedReview = reviewService.addReview(bookId, userId, rating);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }


    @Operation(summary = "Get Reviews for a Book", description = "Retrieve all reviews for a specific book.")
    @GetMapping("/books/{bookId}/reviews")
    public ResponseEntity<List<Review>> getReviewsForBook(@PathVariable Long bookId) {
        List<Review> reviews = reviewService.getReviewsForBook(bookId);
        return  ResponseEntity.ok(reviews);
    }




}
