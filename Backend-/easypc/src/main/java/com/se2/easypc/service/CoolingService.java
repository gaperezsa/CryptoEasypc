package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.Cooling;
import com.se2.easypc.data_access.repository.CoolingRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Cooling, recives calls from CoolingController and calls CoolingRepository
@Service
public class CoolingService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    CoolingRepository coolingRepository; 

    public List<Cooling> getAllCoolings() { // returns a list with all Coolings in the database
        try{
            return coolingRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Cooling getCoolingById( Long id ) { // returns the Cooling with the requested ID or an exception if it does not exist
        try{
            return coolingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cooling", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Cooling createCooling(Cooling cooling) { // creates a new Cooling in the database
        try{
            return coolingRepository.save(cooling);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void deleteCooling( Long id ) { // deletes the Cooling with the requested ID or an exception if it does not exist
        try{
            Cooling cooling = coolingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cooling", "id", id));
            coolingRepository.delete(cooling);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }
}
