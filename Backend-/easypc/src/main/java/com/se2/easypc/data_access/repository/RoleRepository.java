package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//RoleRepository inherits from JpaRepository for communication with database
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
