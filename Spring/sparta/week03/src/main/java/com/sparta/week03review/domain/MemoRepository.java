package com.sparta.week03review.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 수정일자를 최신순으로 정렬해서 select
    List<Memo> findAllByOrderByModifiedAtDesc();
}
