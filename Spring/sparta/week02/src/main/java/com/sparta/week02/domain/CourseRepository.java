package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// jpa는 인터페이스를 통해서만 사용할 수 있기 때문에 인터페이스로 정의
// sql역할을 대신 해줌,                                  // 클래스, id
public interface CourseRepository extends JpaRepository<Course, Long> {
}
