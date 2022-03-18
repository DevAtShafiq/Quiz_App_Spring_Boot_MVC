package com.example.quiz_app_spring_boot_mvc.service;
import com.example.quiz_app_spring_boot_mvc.entity.Question;
import com.example.quiz_app_spring_boot_mvc.entity.QuestionForm;
import com.example.quiz_app_spring_boot_mvc.entity.Result;
import com.example.quiz_app_spring_boot_mvc.repository.QuestionRepository;
import com.example.quiz_app_spring_boot_mvc.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuestionForm questionForm;
    @Autowired
    ResultRepository resultRepository;


    public QuestionForm getQuestion(){

        List<Question> allQues = questionRepository.findAll();

        List<Question> questions =new ArrayList<>();

        Random random = new Random();
        int r;
        for(int i=0;i<5;i++)
        {
             r = random.nextInt(5);

            questions.add(allQues.get(r));
            allQues.remove(r);
        }
        questionForm.setQuestions(questions);

        return questionForm;
    }




            public int getResult (QuestionForm questionForm){

            int correct=0;

            for( Question q: questionForm.getQuestions()){

                if(q.getAns()==q.getChose()){
                    correct++;
                }

            }

                return  correct;
            }


public void saveScore(Result result)
{
    Result saveResult = new Result();
    saveResult.setUserName(result.getUserName());
    saveResult.setTotalCorrect(result.getTotalCorrect());

    resultRepository.save(saveResult);

}


public List<Result> getTopScore(){

       List <Result> sList  = resultRepository.findAll(Sort.by(Sort.Order.desc("totalCorrect")));

    return sList;
    }



}
