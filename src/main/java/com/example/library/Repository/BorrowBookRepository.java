package com.example.library.Repository;

import com.example.library.Entity.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBooks,Long> {
    List<BorrowBooks> findByUserIdAndStatus(long userId, String status);

}
