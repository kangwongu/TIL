package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter    // Lombok 사용 o
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

//    lombok 사용 x
//    public Long getId() {
//        return this.id;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getTutor() {
//        return this.tutor;
//    }

    // setter 설정 안하는 이유?
    // repository에서 해줄 것이기 때문에 안함

    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    // 업데이트 메소드
    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}
