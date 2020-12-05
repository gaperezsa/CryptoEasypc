package com.se2.easypc.service.template;

import java.util.List;

import com.se2.easypc.data_access.model.Build;
import com.se2.easypc.pojo.BuildPOJO;
import com.se2.easypc.service.strategies.BuildChooser;

import org.springframework.stereotype.Service;

@Service
public abstract class RecommendBuild {
    
    private BuildChooser buildChooser;

    public void setStrategy( BuildChooser buildChooser ){
        this.buildChooser =  buildChooser;
    }

    public abstract boolean checkAnswers( List<String> answers );
    public abstract List <Build> getOptionsList( List<String> answers );

    public BuildPOJO chooseBuild( List <Build> options ){
        Build recommendation = buildChooser.chooseBuild(options);
        return new BuildPOJO( recommendation );
    }

    public BuildPOJO getRecommendedBuild( List<String> answers ){
        if( checkAnswers(answers) == false ) return null;
        List <Build> options = getOptionsList(answers);
        return chooseBuild(options);
    }

}
