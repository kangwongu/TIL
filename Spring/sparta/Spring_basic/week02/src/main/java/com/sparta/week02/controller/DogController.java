package com.sparta.week02.controller;

import com.sparta.week02.domain.Dog;
import com.sparta.week02.domain.DogRepository;
import com.sparta.week02.domain.DogRequestDto;
import com.sparta.week02.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class DogController {

    private final DogRepository dogRepository;
    private final DogService dogService;

    // 생성
    @PostMapping("/myDog/dog")
    public Dog createDog(@RequestBody DogRequestDto dogRequestDto) {
        Dog dog = new Dog(dogRequestDto);
        return dogRepository.save(dog);
    }

    // 조회
    @GetMapping("/myDog/dog")
    public List<Dog> getDog() {
        return dogRepository.findAll();
    }

    // 수정
    @PutMapping("/myDog/dog/{id}")
    public Long modifyDog(@PathVariable Long id, @RequestBody DogRequestDto dogRequestDto) {
        return dogService.update(id, dogRequestDto);
    }

    // 삭제
    @DeleteMapping("/mydog/dog/{id}")
    public Long deleteDog(@PathVariable Long id) {
        dogRepository.deleteById(id);
        return id;
    }
}
