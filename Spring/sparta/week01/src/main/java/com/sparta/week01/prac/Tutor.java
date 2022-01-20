package com.sparta.week01review.prac;

public class Tutor {
    // 속성, 이름/경력
    private String name;
    private int bio;

    // 생성자
    public Tutor(String name, int bio) {
        this.name = name;
        this.bio = bio;
    }

    // 기본 생성자
    public Tutor() {
        this("정보없음",0);
    }

    // Getter / Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBio() {
        return bio;
    }

    public void setBio(int bio) {
        this.bio = bio;
    }
}
