package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac7 {
    public static void main(String[] args) {

        String title = "웹개발의 봄 스프링";
        String tutor = "남병관";
        int days = 35;

        Course course = new Course();
        course.setTitle(title);
        course.setTutor(tutor);
        course.setDays(days);
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());

        Course course2 = new Course("웹개발의 봄 스프링", "남병관", 35);
        System.out.println(course2.getTitle());
        System.out.println(course2.getTutor());
        System.out.println(course2.getDays());
    }
}
