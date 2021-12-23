package com.sparta.week01.prac;

public class Course {
    // title, tutor, days 가 Course 라는 맥락 아래에서 의도가 분명히 드러나죠!
    private String title;
    private String tutor;
    private int days;

    public String getTitle() {
        return title;
    }

    public String getTutor() {
        return tutor;
    }

    public int getDays() {
        return days;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setDays(int days) {
        this.days = days;
    }

    // 이렇게 아무런 파라미터가 없는 생성자를 기본생성자 라고 부릅니다.
    public Course() {

    }

    public Course(String title, String tutor, int days) {
        // this 는 "이것" 이죠? 클래스 변수를 가리킵니다.
        this.title = title;
        this.tutor = tutor;
        this.days = days;
    }
}
