package com.sparta.week02review.models;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class PersonRequestDto {
    private String name;
    private int age;
    private String address;
}
