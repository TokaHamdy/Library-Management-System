package com.example.library.Repository;

import com.example.library.Entity.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBooks,Long> {
}
