package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.User;
import com.se2.easypc.pojo.BuildByPartsPOJO;
import com.se2.easypc.pojo.BuildPOJO;
import com.se2.easypc.service.AuditEventLogService;
import com.se2.easypc.service.BuildService;
import com.se2.easypc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BuildController {

    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    BuildService buildService;

    @Autowired
    UserService userService;

    @Autowired
    AuditEventLogService AEservice;


    //get http request for all builds
    @GetMapping("/builds")
    public List<BuildPOJO> getAllBuilds( HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return buildService.getAllBuilds();
    }

    //get http request for build by specific ID
    @GetMapping("/build/{id}")
    public BuildPOJO getBuildById(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return buildService.getBuildById(buildId);
    }

    //Post http request for build
    @PostMapping("/build")
    //request body with object to post
    public BuildPOJO createBuild(@Valid @RequestBody BuildPOJO build,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        if ( SecurityContextHolder.getContext( ).getAuthentication( ).getName().equals("anonymousUser") ){
            return buildService.createBuild(build , null);
        }
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
        User user = userService.findByUsername( username );
        //log de auditoria
        AEservice.Insert(this.getClass().getSimpleName(), user,  request.getRemoteAddr());
        return buildService.createBuild(build,user);
    }

    //Delete http request for build by ID
    @DeleteMapping("/build/{id}")
    public ResponseEntity<Void> deleteBuild(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        buildService.deleteBuild(buildId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

    //Get price of an specific build
    @GetMapping("/build-price/{id}")
    public Integer getBuildPriceById(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return buildService.getBuildPriceById(buildId);
    }

    //Receive Build by the IDs of it parts
    @PostMapping("/build-id")
    public Long getSavedBuildByParts(@Valid @RequestBody BuildByPartsPOJO buildParts,  HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        BuildPOJO build = buildService.makeBuildFromParts(buildParts);
        return createBuild(build, request).getIdBuild();
    }

    //Get list of builds by user
    @GetMapping("/builds-user")
    public List<BuildPOJO> getBuildsByUser(HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
        User user = userService.findByUsername( username );
        return buildService.getBuildsByUser(user);
    }
}
