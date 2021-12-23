package com.sparta.week01.prac;

public class Tutor {
    private String name;
    private int bio;

    public Tutor() {
        this("이름없음", 0);
    }

    public Tutor(String name, int bio) {
        this.name = name;
        this.bio = bio;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBio(int bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public int getBio() {
        return bio;
    }
}
