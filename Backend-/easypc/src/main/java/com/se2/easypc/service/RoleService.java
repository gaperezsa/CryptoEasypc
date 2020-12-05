package com.se2.easypc.service;

import com.se2.easypc.data_access.model.Role;
import com.se2.easypc.data_access.repository.RoleRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class RoleService {
    
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    RoleRepository roleRepository; 

    public Role getRoleById( Long id ) { // returns the Role with the requested ID or an exception if it does not exist
        try{
            return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

}
