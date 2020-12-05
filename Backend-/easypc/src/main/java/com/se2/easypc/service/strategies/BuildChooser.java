package com.se2.easypc.service.strategies;

import java.util.List;

import com.se2.easypc.data_access.model.Build;

public interface BuildChooser {
    
    // method that selects a Build according to a strategy
    Build chooseBuild ( List<Build> options );
}
