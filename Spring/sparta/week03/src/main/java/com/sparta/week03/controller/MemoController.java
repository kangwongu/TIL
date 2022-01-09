package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // 생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto) {
        // 요청으로 넘어온 매개변수를 메모로 생성한다
        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);
    }

    // 조회
    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        LocalDateTime today = LocalDateTime.now();
        // 메모의 목록을 조회
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, today);
    }

    // 수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        memoService.update(id, memoRequestDto);
        return id;
    }

    // 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // 해당 id의 메모를 삭제
        memoRepository.deleteById(id);
        return id;
    }
}
