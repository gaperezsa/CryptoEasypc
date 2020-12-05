package com.se2.easypc.service.template;

import java.util.ArrayList;
import java.util.List;

import com.se2.easypc.data_access.model.Build;
import com.se2.easypc.data_access.repository.BuildRepository;
import com.se2.easypc.exception.ResourceNotFoundException;
import com.se2.easypc.service.CPUService;
import com.se2.easypc.service.CaseService;
import com.se2.easypc.service.CoolingService;
import com.se2.easypc.service.GPUService;
import com.se2.easypc.service.HDDService;
import com.se2.easypc.service.MotherboardService;
import com.se2.easypc.service.PowerSupplyService;
import com.se2.easypc.service.RAMService;
import com.se2.easypc.service.SSDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class BeginnerQuizService extends RecommendBuild {

    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    BuildRepository buildRepository;
    @Autowired
    MotherboardService motherboardService;
    @Autowired
    CPUService cpuService;
    @Autowired
    GPUService gpuService;
    @Autowired
    RAMService ramService;
    @Autowired
    CoolingService coolingService;
    @Autowired
    SSDService ssdService;
    @Autowired
    HDDService hddService;
    @Autowired
    PowerSupplyService powerSupplyService;
    @Autowired
    CaseService caseService;

    private static final String BuildString = "Build";
    private static final String IdString = "id";

    private long budget;

    @Override
    public boolean checkAnswers(List<String> answers) {
        budget = 0;
        if( answers.size() != 5 ){
            logger.error( "Incorrect number of quiz answers" );
            return false;
        }
        try{
            budget = Long.parseLong( answers.get(0) );
        }catch( Exception e ){
            logger.error( "Quiz answer for budget is not a number" );
            return false;
        }
        logger.trace( "Quiz answers received" );
        return true;
    }

    @Override
    public List<Build> getOptionsList(List<String> answers) {
        Build basic = buildRepository.findById( (long)2 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 2));
        Build mid = buildRepository.findById( (long)3 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 3));
        Build ultra = buildRepository.findById( (long)4 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 4));

        Build gaming1 = buildRepository.findById( (long)5 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 5));
        Build gamingCPU = buildRepository.findById( (long)6 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 6));
        Build gamingGPU = buildRepository.findById( (long)7 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 7));

        Build design1 = buildRepository.findById( (long)8 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 8));
        Build designDisk = buildRepository.findById( (long)9 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 9));
        Build designPerformance = buildRepository.findById( (long)10 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 10));

        Build workGPU = buildRepository.findById( (long)11 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 11));
        Build workCPU = buildRepository.findById( (long)12 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 12));
        Build workDisk = buildRepository.findById( (long)13 ).orElseThrow(() -> new ResourceNotFoundException(BuildString, IdString, 13));
        List <Build> options = new ArrayList <> ();
        if( basic.getPrice() <= budget ) options.add( basic );
        if( mid.getPrice() <= budget ) options.add( mid );
        if( ultra.getPrice() <= budget ) options.add( ultra );

        if( answers.get(1).equals("1") && gaming1.getPrice() <= budget ){
            options.add( gaming1 );
            if( (answers.get(2).equals("4") || answers.get(2).equals("3") || answers.get(3).equals("1")
            || answers.get(4).equals("3") ) && gamingGPU.getPrice() <= budget ){
                options.add( gamingGPU );
            }else if( gamingCPU.getPrice() <= budget ){
                options.add( gamingCPU );
            }
        }else if( answers.get(1).equals("2") && design1.getPrice() <= budget ){
            options.add( design1 );
            if( answers.get(3).equals("3") && !answers.get(2).equals("3") && !answers.get(4).equals("3") 
                && designDisk.getPrice() <= budget ){
                options.add( designDisk );
            }else if( designPerformance.getPrice() <= budget ){
                options.add( designPerformance );
            }
        }else if( answers.get(1).equals("3") ){
            if( answers.get(2).equals("3") && workGPU.getPrice() <= budget ){
                options.add( workGPU );
            }else if( answers.get(4).equals("3") && workDisk.getPrice() <= budget ){
                options.add( workDisk );
            }else if( workCPU.getPrice() <= budget ){
                options.add( workCPU );
            }
        }
        return options;
    }
    
}
