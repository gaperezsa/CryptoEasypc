package com.se2.easypc.service;

import com.se2.easypc.data_access.model.AuditEventLog;
import com.se2.easypc.data_access.model.User;

import java.util.Calendar;

import com.se2.easypc.data_access.model.AuditEvent;
import com.se2.easypc.data_access.repository.AuditEventLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// Business logic layer for CPU, recives calls from CPUController and calls CPURepository
@Service
public class AuditEventService {


    private static final Logger logger = LogManager.getLogger();

    @Autowired
    AuditEventLogRepository AErepository; 

    public void Login (User user,String ip){
        try{
            AuditEvent ae = new AuditEvent(1L, "Login");
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setId(1L);
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Insert by ");
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AErepository.save(aeLog);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void Insert (String detail, User user,String ip){
        try{
            AuditEvent ae = new AuditEvent(2L, "Insert");
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Insert by "+ detail);
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AErepository.save(aeLog);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void Delete (String detail, User user,String ip){
        try{
            AuditEvent ae = new AuditEvent(3L, "Delete");
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Insert by "+ detail);
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AErepository.save(aeLog);AErepository.save(aeLog);
        }catch( Exception e ){
            throw e;
        }
    }

    public void Edit (String detail, User user,String ip){
        try{
            AuditEvent ae = new AuditEvent(4L, "Edit");
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Insert by "+ detail);
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AErepository.save(aeLog);AErepository.save(aeLog);
        }catch( Exception e ){
            throw e;
        }
    }
    

}