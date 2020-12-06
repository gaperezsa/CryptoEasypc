package com.se2.easypc.controller;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.service.UserService;
import com.se2.easypc.data_access.model.RAM;
import com.se2.easypc.service.RAMService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.se2.easypc.service.AuditEventLogService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RAMController {
    
    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    RAMService ramService;

    @Autowired
    AuditEventLogService AEservice;

    @Autowired
    UserService userService;

    //get http request for all rams
    @GetMapping("/rams")
    public List<RAM> getAllRAMs(HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return ramService.getAllRAMs();
    }

    //get http request for ram by specific ID
    @GetMapping("/ram/{id}")
    public RAM getRAMById(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        
        //return the corresponding service logical function
        return ramService.getRAMById(ramId);
    }

    //Post http request for ram
    @PostMapping("create/ram")
    //request body with object to post
    public RAM createRAM(@Valid @RequestBody RAM ram, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Insert(this.getClass().getSimpleName()+ " of RAM with model "+ram.getModel() , admin,  request.getRemoteAddr());
        //return the corresponding service logical function
        return ramService.createRAM(ram);
    }

    //Delete http request for ram by ID
    @DeleteMapping("delete/ram/{id}")
    public ResponseEntity<Void> deleteRAM(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Delete(this.getClass().getSimpleName() +" of RAM with id "+ ramId, admin,  request.getRemoteAddr());
        //call the corresponding service logical function
        ramService.deleteRAM(ramId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
