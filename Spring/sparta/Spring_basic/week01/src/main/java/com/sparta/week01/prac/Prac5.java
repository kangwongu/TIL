package com.sparta.week01review.prac;

public class Prac5 {
    public static void main(String[] args) {
        // 인스턴스 생성
        Course course = new Course();

        // 인스턴스 멤버 초기화
        course.setTitle("웹개발의 봄, Spring");
        course.setTutor("남병관");
        course.setDays(35);

        // 인스턴스 멤버 출력
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());

        Course course2 = new Course();

        System.out.println(course2.getTitle());
        System.out.println(course2.getTutor());
        System.out.println(course2.getDays());

        Course course3 = new Course("축구배우자", "박지성", 180);

        System.out.println(course3.getTitle());
        System.out.println(course3.getTutor());
        System.out.println(course3.getDays());
    }
}
