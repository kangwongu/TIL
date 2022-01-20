package com.sparta.week01review.controller;


import com.sparta.week01review.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// JSON으로 응답하는 자동응답기라는 것을 명시
@RestController
public class CourseController {

    @GetMapping("/course")
    public Course getCourse() {
        Course course = new Course();
        course.setTitle("웹개발의 봄 Spring");
        course.setTutor("남병관");
        course.setDays(35);
        // JSON으로 변환해서 반환
        return course;
    }
}
