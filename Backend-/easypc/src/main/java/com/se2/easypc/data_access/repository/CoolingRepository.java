package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.Cooling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CoolingRepository inherits from JpaRepository for communication with database
@Repository
public interface CoolingRepository extends JpaRepository<Cooling, Long> {
    
}
