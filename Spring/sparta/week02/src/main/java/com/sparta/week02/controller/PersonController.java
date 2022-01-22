package com.sparta.week02review.controller;


import com.sparta.week02review.models.Person;
import com.sparta.week02review.models.PersonRepository;
import com.sparta.week02review.models.PersonRequestDto;
import com.sparta.week02review.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    // 생성
    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        // 1. 매개변수로 넘어온 값으로 객체를 만든다.
        // 2. 만든 객체를 DB에 저장한다
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    // 조회
    @GetMapping("/api/persons")
    public List<Person> getPerson() {
        // 1. DB에서 데이터를 가져온다.
        return personRepository.findAll();
    }

    // 수정
    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        // 1. Service의 update메소드 호출 (클라로부터 받아온 데이터 넘겨줌)
        return personService.update(id, requestDto);
    }


    // 삭제
    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }

}
