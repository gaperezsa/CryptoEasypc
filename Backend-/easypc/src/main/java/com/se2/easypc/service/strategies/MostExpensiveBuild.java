package com.se2.easypc.service.strategies;

import java.util.List;

import com.se2.easypc.data_access.model.Build;

public class MostExpensiveBuild implements BuildChooser {
    
    @Override
    public Build chooseBuild ( List<Build> options ){
        Build selected = null;
        for( Build option : options ){
            if( selected == null || selected.getPrice() < option.getPrice() ) selected = option;
        }
        return selected;
    }
}
