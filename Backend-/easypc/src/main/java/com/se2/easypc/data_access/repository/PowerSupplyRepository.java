package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.PowerSupply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//PowerSupplyRepository inherits from JpaRepository for communication with database
@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

}