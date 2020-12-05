package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.CPU;
import com.se2.easypc.data_access.model.Motherboard;
import com.se2.easypc.service.CPUService;

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
public class CPUController {

    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    CPUService cpuService;

    //get http request for all cpus
    @GetMapping("/cpus")
    public List<CPU> getAllCPUs( HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getAllCPUs();
    }

    //get http request for cpu by specific ID
    @GetMapping("/cpu/{id}")
    public CPU getCPUById(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getCPUById(cpuId);
    }

    //Post http request for cpu
    @PostMapping("create/cpu")
    //request body with object to post
    public CPU createCPU(@Valid @RequestBody CPU cpu, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.createCPU(cpu);
    }

    //Delete http request for cpu by ID
    @DeleteMapping("delete/cpu/{id}")
    public ResponseEntity<Void> deleteCPU(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        cpuService.deleteCPU(cpuId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

    //get http request for compatible motheboards with cpu by specific cpu ID
    @GetMapping("/cpu/compatible/{id}")
    public List<Motherboard> getCompatibleMotherboardsById(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getCompatibleMotherboardsById(cpuId);
    }

    //post http request for compatible motheboards with cpu
    @PostMapping("/cpu/compatible")
    public List<Motherboard> getCompatibleMotherboards(@Valid @RequestBody CPU cpu, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getCPUById( cpu.getIdCPU() ).getCompatibleMotherboards();
    }

}
