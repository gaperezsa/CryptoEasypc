package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.PowerSupply;
import com.se2.easypc.service.PowerSupplyService;

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
public class PowerSupplyController {
    
    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    PowerSupplyService powerSupplyService;

    //get http request for all power-supplies
    @GetMapping("/power-supplies")
    public List<PowerSupply> getAllPowerSupplies(HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return powerSupplyService.getAllPowerSupplies();
    }

    //get http request for power-supply by specific ID
    @GetMapping("/power-supply/{id}")
    public PowerSupply getPowerSupplyById(@PathVariable(value = "id") Long powerSupplyId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return powerSupplyService.getPowerSupplyById(powerSupplyId);
    }

    //Post http request for power-supply
    @PostMapping("create/power-supply")
    //request body with object to post
    public PowerSupply createPowerSupply(@Valid @RequestBody PowerSupply powerSupply, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return powerSupplyService.createPowerSupply(powerSupply);
    }

    //Delete http request for power-supply by ID
    @DeleteMapping("delete/power-supply/{id}")
    public ResponseEntity<Void> deletePowerSupply(@PathVariable(value = "id") Long powerSupplyId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        powerSupplyService.deletePowerSupply(powerSupplyId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
