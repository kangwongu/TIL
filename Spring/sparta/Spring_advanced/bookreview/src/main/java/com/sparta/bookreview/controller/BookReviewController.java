package com.sparta.bookreview.controller;

import com.sparta.bookreview.dto.BookReviewRequestDto;
import com.sparta.bookreview.model.BookReview;
import com.sparta.bookreview.repository.BookReviewRepository;
import com.sparta.bookreview.service.BookReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookReviewController {

    private final BookReviewService bookReviewService;
    private final BookReviewRepository bookReviewRepository;

    @GetMapping("/review")
    public List<BookReview> getReview() {
        return bookReviewService.getReview();
    }

    @PostMapping("/review")
    public BookReview createReview(@RequestBody BookReviewRequestDto requestDto) {
        return bookReviewService.createReview(requestDto);
    }

}
