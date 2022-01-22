package com.sparta.week03review.controller;


import com.sparta.week03review.domain.Memo;
import com.sparta.week03review.domain.MemoRepository;
import com.sparta.week03review.domain.MemoRequestDto;
import com.sparta.week03review.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // 생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        // 1. 매개변수로 넘어온 데이터를 DB에 넣기위해 Memo객체로 만든다.
        Memo memo = new Memo(requestDto);
        // 2. DB에 넣는다.
        return memoRepository.save(memo);
    }

    // 조회
    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        // 1. DB에 있는 데이터들을 반환 ( 최신순으로 정렬 )
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    // 수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {  // (업데이트 할 데이터의 id, 업데이트할 내용)
        // 1. Service의 update메소드를 호출한다. (Service에게 넘겨준다.)
        return memoService.update(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
