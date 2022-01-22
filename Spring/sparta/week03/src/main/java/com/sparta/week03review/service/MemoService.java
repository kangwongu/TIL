package com.sparta.week03review.service;

import com.sparta.week03review.domain.Memo;
import com.sparta.week03review.domain.MemoRepository;
import com.sparta.week03review.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    // 업데이트 메소드
    @Transactional // ( 업데이트할 데이터의 id, 업데이트할 내용 )
    public Long update(Long id, MemoRequestDto requestDto) {
        // 1. DB에서 ID에 해당하는 데이터를 가져온다.
        Memo memo = memoRepository.findById(id).orElseThrow(
                // 1-1. DB에 없으면 예외 반환
                () -> new NullPointerException("해당 id가 없어요")
        );

        // 2. 매개변수 값으로 업데이트 수행
        memo.update(requestDto);
        return memo.getId();
    }
}
