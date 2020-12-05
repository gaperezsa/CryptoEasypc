package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.SSD;
import com.se2.easypc.service.SSDService;

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
public class SSDController {
    
    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    SSDService ssdService;

    //get http request for all ssds
    @GetMapping("/ssds")
    public List<SSD> getAllSSDs(HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return ssdService.getAllSSDs();
    }

    //get http request for ssd by specific ID
    @GetMapping("/ssd/{id}")
    public SSD getSSDById(@PathVariable(value = "id") Long ssdId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return ssdService.getSSDById(ssdId);
    }

    //Post http request for ssd
    @PostMapping("create/ssd")
    //request body with object to post
    public SSD createSSD(@Valid @RequestBody SSD ssd, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return ssdService.createSSD(ssd);
    }

    //Delete http request for ssd by ID
    @DeleteMapping("delete/ssd/{id}")
    public ResponseEntity<Void> deleteSSD(@PathVariable(value = "id") Long ssdId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        ssdService.deleteSSD(ssdId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
