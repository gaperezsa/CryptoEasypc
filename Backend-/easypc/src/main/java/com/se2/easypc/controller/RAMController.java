package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.RAM;
import com.se2.easypc.service.RAMService;

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
public class RAMController {
    
    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    RAMService ramService;

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
        //return the corresponding service logical function
        return ramService.createRAM(ram);
    }

    //Delete http request for ram by ID
    @DeleteMapping("delete/ram/{id}")
    public ResponseEntity<Void> deleteRAM(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        ramService.deleteRAM(ramId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
