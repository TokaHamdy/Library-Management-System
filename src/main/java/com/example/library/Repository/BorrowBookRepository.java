package com.example.library.Repository;

import com.example.library.Entity.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBooks,Long> {
    // Find all borrowed books for a specific user with a specific status
    List<BorrowBooks> findByUserIdAndStatus(long userId, String status);

    // Find a specific borrow record for a user and a book
    Optional<BorrowBooks> findByUserIdAndBookIdAndStatus(long userId, long bookId, String status);

    // Find all borrow records for a user and a book (any status)
    List<BorrowBooks> findByUserIdAndBookId(long userId, long bookId);
}
