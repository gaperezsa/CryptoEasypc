package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.GPU;
import com.se2.easypc.service.GPUService;

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
public class GPUController {
    
    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    GPUService gpuService;

    @Autowired
    AuditEventLogService AEservice;

    //get http request for all gpus
    @GetMapping("/gpus")
    public List<GPU> getAllGPUs(HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return gpuService.getAllGPUs();
    }

    //get http request for gpu by specific ID
    @GetMapping("/gpu/{id}")
    public GPU getGPUById(@PathVariable(value = "id") Long gpuId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return gpuService.getGPUById(gpuId);
    }

    //Post http request for gpu
    @PostMapping("create/gpu")
    //request body with object to post
    public GPU createGPU(@Valid @RequestBody GPU gpu, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Insert(this.getClass().getSimpleName() + " of GPU with model " + gpu.getModel(), admin,  request.getRemoteAddr());
        
        //return the corresponding service logical function
        return gpuService.createGPU(gpu);
    }

    //Delete http request for gpu by ID
    @DeleteMapping("delete/gpu/{id}")
    public ResponseEntity<Void> deleteGPU(@PathVariable(value = "id") Long gpuId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        User admin = userService.getUserById(2L);
        AEservice.Delete(this.getClass().getSimpleName() + " of Cooling with id " + gpuId, admin,  request.getRemoteAddr());
        
        //call the corresponding service logical function
        gpuService.deleteGPU(gpuId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
