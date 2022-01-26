package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String dogBreed;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    public Dog(DogRequestDto dogRequestDto) {
        this.dogBreed = dogRequestDto.getDogBreed();
        this.age = dogRequestDto.getAge();
        this.gender = dogRequestDto.getGender();
    }

    public void update(DogRequestDto dogRequestDto) {
        this.dogBreed = dogRequestDto.getDogBreed();
        this.age = dogRequestDto.getAge();
        this.gender = dogRequestDto.getGender();
    }

}
