package com.sparta.week01review.controller;


import com.sparta.week01review.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// JSON으로 응답하는 자동응답기임을 명시
@RestController
public class PersonController {
    // /myinfo로 요청하면 수행
    @GetMapping("/myinfo")
    public List<Person> getPerson() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person("박지성", 40, "맨체스터");
        Person person2 = new Person("손흥민", 29, "런던");
        Person person3 = new Person("이승우", 24, "수원");

        personList.add(person);
        personList.add(person2);
        personList.add(person3);

        // json으로 반환 (스프링이 알아서 변환해줌)
        return personList;
    }
}
