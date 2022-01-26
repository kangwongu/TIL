package com.sparta.week02review.service;

import com.sparta.week02review.models.Person;
import com.sparta.week02review.models.PersonRepository;
import com.sparta.week02review.models.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto) {
        // 1. 해당하는 id의 데이터를 DB에서 찾는다.
        Person person = personRepository.findById(id).orElseThrow(
                // 1-1 DB에 없으면 예외 발생
                () -> new NullPointerException("해당하는 아이디가 없음")
        );

        // 2. 찾은 데이터를 매개변수의 값으로 업데이트한다.
        person.update(requestDto);
        return person.getId();
    }
}
