package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.Description;
import com.se2.easypc.data_access.repository.DescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Description, recives calls from DescriptionController and calls DescriptionRepository
@Service
public class DescriptionService {
    
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    DescriptionRepository descriptionRepository;

    public List<Description> getAllDescriptions() { // returns a list with all Descriptions in the database
        try{
            return descriptionRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public Description findByPartName( String partName ){ // return Decription from part_name
        return descriptionRepository.findByPartName( partName );
    }

}
