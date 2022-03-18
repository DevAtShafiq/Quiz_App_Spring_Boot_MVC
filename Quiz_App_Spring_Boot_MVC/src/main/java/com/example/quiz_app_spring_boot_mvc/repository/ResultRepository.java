package com.example.quiz_app_spring_boot_mvc.repository;

import com.example.quiz_app_spring_boot_mvc.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
}
