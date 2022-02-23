package com.sparta.springcore.repository;

import com.sparta.springcore.model.ApiUseTime;
import com.sparta.springcore.model.Folder;
import com.sparta.springcore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApiUseTimeRepository extends JpaRepository<ApiUseTime, Long> {

    // NullPointerException방지 위해 Optional로 받음
    Optional<ApiUseTime> findByUser(User user);
}
