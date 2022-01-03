package com.sparta.week02.service;

import com.sparta.week02.domain.Dog;
import com.sparta.week02.domain.DogRepository;
import com.sparta.week02.domain.DogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor // Lombok을 사용해서 필요한 생성자를 스프링이 자동으로 넣어주게함
@Service
public class DogService {

    // 서비스에게 꼭 필요함을 명시
    private final DogRepository dogRepository;

    // 업데이트
    @Transactional
    public Long update(Long id, DogRequestDto dogRequestDto){
        // DB에서 수정할 객체를 가져옮
        Dog dog = dogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 없어요")
        );

        dog.update(dogRequestDto);
        return dog.getId();
    }
}
