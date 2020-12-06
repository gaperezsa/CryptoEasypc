package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.Keyboard;
import com.se2.easypc.service.KeyboardService;

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
public class KeyboardController {
 
    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    KeyboardService keyboardService;
    
    @Autowired
    AuditEventLogService AEservice;
    
    //get http request for all keyboards
    @GetMapping("/keyboards")
    public List<Keyboard> getAllKeyboards( HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return keyboardService.getAllKeyboards();
    }

    //get http request for keyboard by specific ID
    @GetMapping("/keyboard/{id}")
    public Keyboard getKeyboardById(@PathVariable(value = "id") Long keyboardId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return keyboardService.getKeyboardById(keyboardId);
    }

    //Post http request for keyboard
    @PostMapping("create/keyboard")
    //request body with object to post
    public Keyboard createKeyboard(@Valid @RequestBody Keyboard keyboard, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Insert(this.getClass().getSimpleName() + " of Keyboard with model " + keyboard.getModel(), admin,  request.getRemoteAddr());
        //return the corresponding service logical function
        return keyboardService.createKeyboard(keyboard);
    }

    //Delete http request for keyboard by ID
    @DeleteMapping("delete/keyboard/{id}")
    public ResponseEntity<Void> deleteKeyboard(@PathVariable(value = "id") Long keyboardId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Delete(this.getClass().getSimpleName() + " of Keyboard with id " + keyboardId, admin,  request.getRemoteAddr());

        //call the corresponding service logical function
        keyboardService.deleteKeyboard(keyboardId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
