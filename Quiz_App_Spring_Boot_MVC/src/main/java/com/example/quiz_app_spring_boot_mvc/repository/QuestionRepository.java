package com.example.quiz_app_spring_boot_mvc.repository;

import com.example.quiz_app_spring_boot_mvc.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question,Integer>{
}
