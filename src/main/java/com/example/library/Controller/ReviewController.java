package com.example.library.Controller;

import com.example.library.Entity.Review;
import com.example.library.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Add a new review
    @PostMapping("/books/{bookId}/reviews/{userId}/{rating}")
    public ResponseEntity<Review> addReview(@PathVariable Long bookId, @PathVariable Long userId, @PathVariable int rating) {
        Review savedReview = reviewService.addReview(bookId, userId, rating);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("/books/{bookId}/reviews")
    public ResponseEntity<List<Review>> getReviewsForBook(@PathVariable Long bookId) {
        List<Review> reviews = reviewService.getReviewsForBook(bookId);
        return  ResponseEntity.ok(reviews);
    }




}
