package com.se2.easypc.controller;

import com.se2.easypc.service.CaseService;
import com.se2.easypc.data_access.model.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class CaseController {

    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    CaseService caseService;

    //get http request for all cases
    @GetMapping("/cases")
    public List<Case> getAllCases( HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return caseService.getAllCases();
    }

    //get http request for case by specific ID
    @GetMapping("/case/{id}")
    public Case getCaseById(@PathVariable(value = "id") Long caseId , HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return caseService.getCaseById(caseId);
    }

    //Post http request for case
    @PostMapping("/create/case")
    //request body with object to post
    public Case createCase(@Valid @RequestBody Case caseObj , HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return caseService.createCase(caseObj);
    }

    //Delete http request for case by ID
    @DeleteMapping("/delete/case/{id}")
    public ResponseEntity<Void> deleteCase(@PathVariable(value = "id") Long caseId , HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        caseService.deleteCase(caseId);
        //Check deletion
        return ResponseEntity.ok().build();
    }


}
