package com.se2.easypc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.se2.easypc.data_access.model.Build;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.data_access.repository.BuildRepository;
import com.se2.easypc.exception.ResourceNotFoundException;
import com.se2.easypc.pojo.BuildByPartsPOJO;
import com.se2.easypc.pojo.BuildPOJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Build, recives calls from BuildService and calls BuildRepository
@Service
public class BuildService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    BuildRepository buildRepository;

    @Autowired
    UserService userService;

    @Autowired
    CaseService caseService;

    @Autowired
    CoolingService coolingService;

    @Autowired
    CPUService cpuService;

    @Autowired
    GPUService gpuService;

    @Autowired
    HDDService hddService;

    @Autowired
    KeyboardService keyboardService;

    @Autowired
    MonitorService monitorService;

    @Autowired
    MotherboardService motherboardService;

    @Autowired
    MouseService mouseService;

    @Autowired
    PowerSupplyService powerSupplyService;

    @Autowired
    RAMService ramService;

    @Autowired
    SSDService ssdService;

    private static final String BuildString = "Build";
    private static final String IdString = "id";

    public List<BuildPOJO> getAllBuilds() { // returns a list with all Builds in the database
        try{
            List<BuildPOJO> builds = new ArrayList<>();
            for( Build b : buildRepository.findAll() ){
                builds.add( new BuildPOJO( b ) );
            }
            return builds;
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public BuildPOJO getBuildById( Long id ) { // returns the Build with the requested ID or an exception if it does not exist
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, id));
            return new BuildPOJO(build);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public BuildPOJO createBuild(BuildPOJO buildPOJO , User user) { // creates a new Build in the database
        try{
            Build build = buildPOJO.toBuild();
            if (user == null){
               user = userService.getUserById((long)1);
            }
            build.setUser(user);
            if( build.getDate() == null ) build.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ) );
            build = buildRepository.save(build);
            return new BuildPOJO(build);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public void deleteBuild( Long id ) { // deletes the Build with the requested ID or an exception if it does not exist
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, id));
            buildRepository.delete(build);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public Integer getBuildPriceById( Long id ) { // returns the price of an spcefic build
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, id));
            return build.getPrice();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public BuildPOJO makeBuildFromParts( BuildByPartsPOJO buildParts ){
        BuildPOJO build = new BuildPOJO();
        if( buildParts.getIdCase() != null ) build.setCaseObj( caseService.getCaseById( buildParts.getIdCase() ) );
        if( buildParts.getIdCooling() != null ) build.setCooling( coolingService.getCoolingById( buildParts.getIdCooling() ) );
        if( buildParts.getIdCPU() != null ) build.setCpu( cpuService.getCPUById( buildParts.getIdCPU() ) );
        if( buildParts.getIdGPU() != null ) build.setGpu( gpuService.getGPUById( buildParts.getIdGPU() ) );
        if( buildParts.getIdHDD() != null ) build.setHdd( hddService.getHDDById( buildParts.getIdHDD() ) );
        if( buildParts.getIdKeyboard() != null ) build.setKeyboard( keyboardService.getKeyboardById( buildParts.getIdKeyboard() ) );
        if( buildParts.getIdMonitor() != null ) build.setMonitor( monitorService.getMonitorById( buildParts.getIdMonitor() ) );
        if( buildParts.getIdMotherboard() != null ) build.setMotherboard( motherboardService.getMotherboardById( buildParts.getIdMotherboard() ) );
        if( buildParts.getIdMouse() != null ) build.setMouse( mouseService.getMouseById( buildParts.getIdMouse() ) );
        if( buildParts.getIdPowerSupply() != null ) build.setPowerSupply( powerSupplyService.getPowerSupplyById( buildParts.getIdPowerSupply() ) );
        if( buildParts.getIdRAM() != null ) build.setRam( ramService.getRAMById( buildParts.getIdRAM() ) );
        if( buildParts.getIdSSD() != null ) build.setSsd( ssdService.getSSDById( buildParts.getIdSSD() ) );
        return build;
    }
    
    public List<BuildPOJO> getBuildsByUser(User user){
        List<BuildPOJO> builds = new ArrayList<>();
        for (Build b : user.getBuilds()){
            builds.add(new BuildPOJO(b));
        }
        return builds;
    }
}
