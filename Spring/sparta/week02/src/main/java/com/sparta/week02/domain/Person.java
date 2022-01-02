package com.sparta.week02.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String phoneNumber;

    public Person(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
        this.phoneNumber = personRequestDto.getPhoneNumber();
    }

    public void update(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
        this.phoneNumber = personRequestDto.getPhoneNumber();
    }
}
