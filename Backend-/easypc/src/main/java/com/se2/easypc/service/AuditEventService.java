package com.se2.easypc.service;

import com.se2.easypc.data_access.model.AuditEventLog;
import com.se2.easypc.data_access.model.User;

import java.util.Calendar;

import com.se2.easypc.data_access.model.AuditEvent;
import com.se2.easypc.data_access.repository.AuditEventRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



// Business logic layer for CPU, recives calls from CPUController and calls CPURepository
@Service
public class AuditEventService {


    @Autowired
    AuditEventRepository AErepository; 


    public AuditEvent getAuditEventById(Long id) { 
        try{
            return AErepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuditEvent", "id", id));
        }catch( Exception e ){
            throw e;
        }
       
    }

}