package com.sparta.week02.controller;

import com.sparta.week02.domain.Person;
import com.sparta.week02.domain.PersonRepository;
import com.sparta.week02.domain.PersonRequestDto;
import com.sparta.week02.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// JSON을 반환하는 컨트롤러
@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/api/persons")
    public List<Person> getInfo() {
        // JSON으로 반환환
       return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person makePerson(@RequestBody PersonRequestDto personRequestDto) {
        Person person = new Person(personRequestDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long modifyPerson(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto) {
        return personService.update(id, personRequestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }
}
