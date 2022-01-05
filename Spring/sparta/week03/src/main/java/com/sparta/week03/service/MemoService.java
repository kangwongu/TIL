package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor    // Lombok을 이용해 필요한 생성자를 생성
@Service
public class MemoService {

    // 반드시 final을 넣어줘야 함, final을 안붙이면 스프링이 이 객체를 안넣어줄 수도 있음
    private final MemoRepository memoRepository;

    // 업데이트 메소드
    @Transactional  // DB에 반영되어야 함을 지정
    public Long update(Long id, MemoRequestDto requestDto) {
        // 업데이트할 요소를 찾는다
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        // 찾은 요소를 업데이트 한다
        memo.update(requestDto);
        return memo.getId();
    }
}
