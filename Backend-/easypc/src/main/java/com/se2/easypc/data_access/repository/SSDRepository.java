package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.SSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//SSDRepository inherits from JpaRepository for communication with database
@Repository
public interface SSDRepository extends JpaRepository<SSD, Long> {

}
