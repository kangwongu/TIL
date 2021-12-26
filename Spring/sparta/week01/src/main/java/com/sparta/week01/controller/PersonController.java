package com.sparta.week01.controller;

import com.sparta.week01.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/person")
    public Person getPerson() {
        // json객체로 반환할 Person객체 생성
        Person person = new Person();
        person.setName("부카요 사카");
        person.setAge(20);
        person.setJob("Football Player");
        person.setPhoneNumber("010-1234-5678");

        return person;
    }
}
