package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.CPU;
import com.se2.easypc.data_access.model.Motherboard;
import com.se2.easypc.service.MotherboardService;

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
public class MotherboardController {
    
    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    MotherboardService motherboardService;

    //get http request for all motherboards
    @GetMapping("/motherboards")
    public List<Motherboard> getAllMotherboards(HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return motherboardService.getAllMotherboards();
    }

    //get http request for motherboard by specific ID
    @GetMapping("/motherboard/{id}")
    public Motherboard getMotherboardById(@PathVariable(value = "id") Long motherboardId,HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return motherboardService.getMotherboardById(motherboardId);
    }

    //Post http request for motherboard
    @PostMapping("create/motherboard")
    //request body with object to post
    public Motherboard createMotherboard(@Valid @RequestBody Motherboard motherboard,HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return motherboardService.createMotherboard(motherboard);
    }

    //Delete http request for motherboard by ID
    @DeleteMapping("delete/motherboard/{id}")
    public ResponseEntity<Void> deleteMotherboard(@PathVariable(value = "id") Long motherboardId,HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        motherboardService.deleteMotherboard(motherboardId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

    //get http request for compatible cpus with motherboard by specific cpu ID
    @GetMapping("/motherboard/compatible/{id}")
    public List<CPU> getCompatibleCPUsById(@PathVariable(value = "id") Long motheboardId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return motherboardService.getCompatibleCPUsById(motheboardId);
    }

    //post http request for compatible cpus with motherboard
    @PostMapping("/motherboard/compatible")
    public List<CPU> getCompatibleCPUs(@Valid @RequestBody Motherboard motherboard, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return motherboardService.getMotherboardById( motherboard.getIdMotherboard() ).getCompatibleCPUs();
    }

    //put http request for updating compatible cpus with motheboard
    @PostMapping("/motherboard/compatible-cpus/{id}")
    public Motherboard updateCompatibleCPUs( @PathVariable(value = "id") Long motheboardId , @Valid @RequestBody List<CPU> cpus, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        Motherboard motherboard = motherboardService.getMotherboardById(motheboardId);
        motherboard.setCompatibleCPUs(cpus);
        return motherboardService.createMotherboard(motherboard);
    }

}
