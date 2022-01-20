package com.sparta.week01review.prac;

public class Person {
    // 속성 (이름, 나이, 주소)
    private String name;
    private int age;
    private String address;

    // 생성자
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // 기본 생성자
    public Person() {
        this("정보없음", 0, "정보없음");
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
