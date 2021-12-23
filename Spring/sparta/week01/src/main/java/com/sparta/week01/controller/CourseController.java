package com.sparta.week01.controller;

import com.sparta.week01.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 스프링에게 json으로 응답하는 자동응답기임을 알려줌
@RestController
public class CourseController {
    @GetMapping("/courses")
    public Course getCourse() {
        // 이값을 json으로 변환해서 브라우저에게 돌려주는 역할을 스프링이 함
        Course course = new Course();
        course.setTitle("웹개발의 봄 스프링");
        course.setDays(35);
        course.setTutor("남병관");
        return course;
    }
}
