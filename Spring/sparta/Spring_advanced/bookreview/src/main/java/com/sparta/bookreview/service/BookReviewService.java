package com.sparta.bookreview.service;

import com.sparta.bookreview.dto.BookReviewRequestDto;
import com.sparta.bookreview.model.BookReview;
import com.sparta.bookreview.repository.BookReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;

    public List<BookReview> getReview() {
        return bookReviewRepository.findAll();
    }

    public BookReview createReview(BookReviewRequestDto requestDto) {
        BookReview bookReview = new BookReview(requestDto);
        return bookReviewRepository.save(bookReview);
    }
}
