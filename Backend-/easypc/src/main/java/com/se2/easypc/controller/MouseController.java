package com.se2.easypc.controller;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.service.UserService;
import com.se2.easypc.data_access.model.Mouse;
import com.se2.easypc.service.MouseService;
import com.se2.easypc.service.AuditEventLogService;
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
public class MouseController {

    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    MouseService mouseService;

    @Autowired
    AuditEventLogService AEservice;

    @Autowired
    UserService userService;

    //get http request for all mice
    @GetMapping("/mice")
    public List<Mouse> getAllMice(HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return mouseService.getAllMice();
    }

    //get http request for mouse by specific ID
    @GetMapping("/mouse/{id}")
    public Mouse getMouseById(@PathVariable(value = "id") Long mouseId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return mouseService.getMouseById(mouseId);
    }

    //Post http request for mouse
    @PostMapping("create/mouse")
    //request body with object to post
    public Mouse createMouse(@Valid @RequestBody Mouse mouse, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Insert(this.getClass().getSimpleName()+ " of Mouse with model "+mouse.getModel() , admin,  request.getRemoteAddr());
        //return the corresponding service logical function
        return mouseService.createMouse(mouse);
    }

    //Delete http request for mouse by ID
    @DeleteMapping("delete/mouse/{id}")
    public ResponseEntity<Void> deleteMouse(@PathVariable(value = "id") Long mouseId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Delete(this.getClass().getSimpleName() +" of Mouse with id "+ mouseId, admin,  request.getRemoteAddr());
        //call the corresponding service logical function
        mouseService.deleteMouse(mouseId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
