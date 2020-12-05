package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.Mouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MouseRepository inherits from JpaRepository for communication with database
@Repository
public interface MouseRepository extends JpaRepository<Mouse, Long> {
    
}
