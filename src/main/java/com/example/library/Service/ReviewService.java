package com.example.library.Service;
import com.example.library.Entity.*;
import com.example.library.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    // Method to add a new review
    public Review addReview(Long bookId, Long userId, int rating) {
        // Fetch Book and User by their IDs
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Create and save the new review
        Review review = new Review();
        review.setBook(book);
        review.setUser(user);
        review.setRating(rating);

        return reviewRepository.save(review); // Save review to database
    }

    public List<Review> getReviewsForBook(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }
}
