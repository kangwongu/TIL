package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // 업데이트 메소드
    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        // 1. 업데이트할 요소를 찾는다.
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 없습니다.")
        );

        // 2. 찾은 해당 요소를 업데이트 한다.
        memo.update(memoRequestDto);
        return memo.getId();
    }
}
