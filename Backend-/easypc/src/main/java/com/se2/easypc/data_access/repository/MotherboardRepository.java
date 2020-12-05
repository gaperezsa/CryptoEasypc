package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.Motherboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MotherboardRepository inherits from JpaRepository for communication with database
@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {

}
