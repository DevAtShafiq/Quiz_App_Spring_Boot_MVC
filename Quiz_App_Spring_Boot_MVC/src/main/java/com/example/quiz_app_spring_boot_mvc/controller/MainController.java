package com.example.quiz_app_spring_boot_mvc.controller;

import com.example.quiz_app_spring_boot_mvc.entity.QuestionForm;
import com.example.quiz_app_spring_boot_mvc.entity.Result;
import com.example.quiz_app_spring_boot_mvc.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    Result result;
    Boolean submitted;



    @GetMapping("/welcome")
    public String welcomePage() {

        return "index";
    }


    @PostMapping("/welcome/startQuiz")
    public String register(@RequestParam String userName, RedirectAttributes redirectAttributes, Model model) {

        if (userName == "") {


            redirectAttributes.addFlashAttribute("warning", " *You must enter your name");

            return "redirect:/welcome";
        }

        submitted =false;
        result.setUserName(userName);

//getSomeQuestionFromAllQuestion is a method
        QuestionForm questionForm = questionService.getQuestion();

        model.addAttribute("questionForm",questionForm);

        return "quiz";
    }



    @PostMapping("/submit")

    public String quizSubmit (@ModelAttribute QuestionForm questionForm){

        if(!submitted){

            result.setTotalCorrect(questionService.getResult(questionForm));
            questionService.saveScore(result);
            submitted = true;
        }
        return "result";
    }


//    @GetMapping("/result")
//public String showResult(Model model){
//
//
//
//    }
}
