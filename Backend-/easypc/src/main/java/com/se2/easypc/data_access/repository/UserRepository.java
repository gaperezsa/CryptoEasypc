package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//UserRepository inherits from JpaRepository for communication with database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username ); // Find user by username for login
}