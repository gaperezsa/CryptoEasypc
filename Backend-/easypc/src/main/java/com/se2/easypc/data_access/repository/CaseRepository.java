package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CaseRepository inherits from JpaRepository for communication with database
@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
    
}