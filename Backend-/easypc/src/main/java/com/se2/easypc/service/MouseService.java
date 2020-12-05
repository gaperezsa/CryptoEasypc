package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.Mouse;
import com.se2.easypc.data_access.repository.MouseRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Mouse, recives calls from MouseController and calls MouseRepository
@Service
public class MouseService {

    private static final Logger logger = LogManager.getLogger();
        
    @Autowired
    MouseRepository mouseRepository; 

    public List<Mouse> getAllMice() { // returns a list with all Mice in the database
        try{
            return mouseRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public Mouse getMouseById( Long id ) { // returns the Mouse with the requested ID or an exception if it does not exist
        try{
            return mouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mouse", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public Mouse createMouse(Mouse mouse) { // creates a new Mouse in the database
        try{
            return mouseRepository.save(mouse);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public void deleteMouse( Long id ) { // deletes the Mouse with the requested ID or an exception if it does not exist
        try{
            Mouse mouse = mouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mouse", "id", id));
            mouseRepository.delete(mouse);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }
}
