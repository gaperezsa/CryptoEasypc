package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.Cooling;
import com.se2.easypc.service.CoolingService;
import com.se2.easypc.service.AuditEventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CoolingController {

    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    CoolingService coolingService;

    @Autowired
    AuditEventLogService AEservice;
    
    @Autowired
    UserService userService;

    //get http request for all coolings
    @GetMapping("/coolings")
    public List<Cooling> getAllCoolings( HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return coolingService.getAllCoolings();
    }

    //get http request for cooling by specific ID
    @GetMapping("/cooling/{id}")
    public Cooling getCoolingById(@PathVariable(value = "id") Long coolingId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return coolingService.getCoolingById(coolingId);
    }

    //Post http request for cooling
    @PostMapping("create/cooling")
    //request body with object to post
    public Cooling createCooling(@Valid @RequestBody Cooling cooling, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Insert(this.getClass().getSimpleName() + " of Cooling with model " + cooling.getModel(), admin,  request.getRemoteAddr());
        //return the corresponding service logical function
        return coolingService.createCooling(cooling);
    }

    //Delete http request for cooling by ID
    @DeleteMapping("delete/cooling/{id}")
    public ResponseEntity<Void> deleteCooling(@PathVariable(value = "id") Long coolingId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Delete(this.getClass().getSimpleName() + " of Cooling with id " + coolingId, admin,  request.getRemoteAddr());
        //call the corresponding service logical function
        coolingService.deleteCooling(coolingId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
