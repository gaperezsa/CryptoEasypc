package com.se2.easypc.service;

import java.util.Collections;
import java.util.List;

import com.se2.easypc.data_access.model.CPU;
import com.se2.easypc.data_access.model.Motherboard;
import com.se2.easypc.data_access.repository.MotherboardRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Motherboard, recives calls from MotherboardController and calls MotherboardRepository
@Service
public class MotherboardService {

    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    MotherboardRepository motherboardRepository; 
    public List<Motherboard> getAllMotherboards() { // returns a list with all Motherboards in the database
        try{
            return motherboardRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Motherboard getMotherboardById( Long i ) { // returns the Motherboard with the requested ID or an exception if it does not exist
        try{
            return motherboardRepository.findById(i).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", i));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Motherboard createMotherboard(Motherboard motherboard) { // creates a new Motherboard in the database
        try{
            return motherboardRepository.save(motherboard);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void deleteMotherboard( Long id ) { // deletes the Motherboard with the requested ID or an exception if it does not exist
        try{
            Motherboard motherboard = motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
            motherboardRepository.delete(motherboard);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public List<CPU> getCompatibleCPUsById( Long motheboardId ) { // returns all compatible CPUs given the id of a motherboard
        Motherboard motherboard = getMotherboardById(motheboardId);
        if( motherboard == null ) return Collections.emptyList();
        return motherboard.getCompatibleCPUs();
    }

}
