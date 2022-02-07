package com.sparta.bookreview.repository;

import com.sparta.bookreview.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
}
