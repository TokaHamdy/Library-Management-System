package com.example.library.Repository;

import com.example.library.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE " +
            "(:author IS NULL OR b.author LIKE %:author%) AND " +
            "(:title IS NULL OR b.title LIKE %:title%) AND " +
            "(:category IS NULL OR b.category = :category) AND " +
            "(:startDate IS NULL OR b.publicationDate >= :startDate) AND " +
            "(:endDate IS NULL OR b.publicationDate <= :endDate)")
    Page<Book> advancedSearch(
            @Param("author") String author,
            @Param("title") String title,
            @Param("category") String category,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);  // Added Pageable parameter
}
