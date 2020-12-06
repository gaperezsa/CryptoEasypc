package com.se2.easypc.service;

import com.se2.easypc.data_access.model.AuditEventLog;
import com.se2.easypc.data_access.model.User;

import java.util.Calendar;

import com.se2.easypc.data_access.model.AuditEvent;
import com.se2.easypc.data_access.repository.AuditEventLogRepository;
import com.se2.easypc.data_access.repository.AuditEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// Business logic layer for CPU, recives calls from CPUController and calls CPURepository
@Service
public class AuditEventLogService {


    private static final Logger logger = LogManager.getLogger();

    @Autowired
    AuditEventLogRepository AELrepository;

    @Autowired
    AuditEventService AEservice;

    public void Login (User user,String ip){
        try{
            AuditEvent ae = AEservice.getAuditEventById(1L);
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Login in EasyPC of user "+ user.getUsername());
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AELrepository.save(aeLog);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void Insert (String detail, User user,String ip){
        try{
            AuditEvent ae = AEservice.getAuditEventById(2L);
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Insert by "+detail);
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AELrepository.save(aeLog);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void Delete (String detail, User user,String ip){
        try{
            AuditEvent ae = AEservice.getAuditEventById(1L);
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Delete by "+detail);
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AELrepository.save(aeLog);
          
        }catch( Exception e ){
            throw e;
        }
    }

    public void Edit (String detail, User user,String ip){
        try{
            AuditEvent ae = AEservice.getAuditEventById(1L);
            AuditEventLog aeLog = new AuditEventLog();
            aeLog.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ));
            aeLog.setUser(user);
            aeLog.setDetail("Edit by "+ detail);
            aeLog.setAuditEventLog(ae);
            aeLog.setClientIp(ip);
            AELrepository.save(aeLog);
   
        }catch( Exception e ){
            throw e;
        }
    }
    

}