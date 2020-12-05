package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.SSD;
import com.se2.easypc.data_access.repository.SSDRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for SSD, recives calls from SSDController and calls SSDRepository
@Service
public class SSDService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    SSDRepository ssdRepository; 

    public List<SSD> getAllSSDs() { // returns a list with all SSDs in the database
        try{
            return ssdRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public SSD getSSDById( Long id ) { // returns the SSD with the requested ID or an exception if it does not exist
        try{
            return ssdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SSD", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public SSD createSSD(SSD ssd) { // creates a new SSD in the database
        try{
            return ssdRepository.save(ssd);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public void deleteSSD( Long id ) { // deletes the SSD with the requested ID or an exception if it does not exist
        try{
            SSD ssd = ssdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SSD", "id", id));
            ssdRepository.delete(ssd);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }
}
