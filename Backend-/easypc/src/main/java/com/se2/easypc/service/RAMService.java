package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.RAM;
import com.se2.easypc.data_access.repository.RAMRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for RAM, recives calls from RAMController and calls RAMRepository
@Service
public class RAMService {
    
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    RAMRepository ramRepository; 

    public List<RAM> getAllRAMs() { // returns a list with all RAMs in the database
        try{
            return ramRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public RAM getRAMById( Long id ) { // returns the RAM with the requested ID or an exception if it does not exist
        try{
            return ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public RAM createRAM(RAM ram) { // creates a new RAM in the database
        try{
            return ramRepository.save(ram);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public void deleteRAM( Long id ) { // deletes the RAM with the requested ID or an exception if it does not exist
        try{
            RAM ram = ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
            ramRepository.delete(ram);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }
}
