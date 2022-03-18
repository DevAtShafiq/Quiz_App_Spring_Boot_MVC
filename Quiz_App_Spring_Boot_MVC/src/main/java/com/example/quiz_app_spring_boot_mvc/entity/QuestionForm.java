package com.example.quiz_app_spring_boot_mvc.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionForm {

    public List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
