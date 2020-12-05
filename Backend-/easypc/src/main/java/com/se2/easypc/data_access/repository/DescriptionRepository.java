package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.Description;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DescriptionRepository inherits from JpaRepository for communication with database
@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
    Description findByPartName( String partName ); // Find Description by part_name
}