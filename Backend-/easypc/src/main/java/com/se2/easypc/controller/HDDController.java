package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.HDD;
import com.se2.easypc.service.HDDService;
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
public class HDDController {
    
    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    HDDService hddService;

    @Autowired
    AuditEventLogService AEservice;

    @Autowired
    UserService userService;

    //get http request for all hdds
    @GetMapping("/hdds")
    public List<HDD> getAllHDDs(HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return hddService.getAllHDDs();
    }

    //get http request for hdd by specific ID
    @GetMapping("/hdd/{id}")
    public HDD getHDDById(@PathVariable(value = "id") Long hddId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return hddService.getHDDById(hddId);
    }

    //Post http request for hdd
    @PostMapping("create/hdd")
    //request body with object to post
    public HDD createHDD(@Valid @RequestBody HDD hdd, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Insert(this.getClass().getSimpleName() + " of HDD with model " + hdd.getModel(), admin,  request.getRemoteAddr());
        
        //return the corresponding service logical function
        return hddService.createHDD(hdd);
    }

    //Delete http request for hdd by ID
    @DeleteMapping("delete/hdd/{id}")
    public ResponseEntity<Void> deleteHDD(@PathVariable(value = "id") Long hddId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Delete(this.getClass().getSimpleName() + " of HDD with id " + hddId, admin,  request.getRemoteAddr());
        //call the corresponding service logical function
        hddService.deleteHDD(hddId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
