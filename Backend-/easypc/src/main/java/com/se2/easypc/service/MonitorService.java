package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.Monitor;
import com.se2.easypc.data_access.repository.MonitorRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Monitor, recives calls from MonitorController and calls MonitorRepository
@Service
public class MonitorService {
    
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    MonitorRepository monitorRepository; 

    public List<Monitor> getAllMonitors() { // returns a list with all Monitors in the database
        try{
            return monitorRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Monitor getMonitorById( Long id ) { // returns the Monitor with the requested ID or an exception if it does not exist
        try{
            return monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Monitor createMonitor(Monitor monitor) { // creates a new Monitor in the database
        try{
            return monitorRepository.save(monitor);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void deleteMonitor( Long id ) { // deletes the Monitor with the requested ID or an exception if it does not exist
        try{
            Monitor monitor = monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
            monitorRepository.delete(monitor);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }


}
