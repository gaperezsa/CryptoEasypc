package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.Build;
import com.se2.easypc.pojo.BuildPOJO;
import com.se2.easypc.service.strategies.MostExpensiveBuild;
import com.se2.easypc.service.template.BeginnerQuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class QuizController {

    private static final Logger logger = LogManager.getLogger();

     //declares corresponding service
     @Autowired
     BeginnerQuizService quizService;

    //Get http request for build
    @PostMapping("/quiz-beginner")
    //request body with object to post
    public BuildPOJO getRecommendedBuild(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        quizService.setStrategy( new MostExpensiveBuild() );
        return quizService.getRecommendedBuild(answers);
    }
    //Get http request for build price
    @PostMapping("/quiz-beginner-price") 
    public int getRecommendedBuildPrice(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        quizService.setStrategy( new MostExpensiveBuild() );
        Build recommended = quizService.getRecommendedBuild(answers).toBuild();
        return recommended.getPrice();
    }

}
