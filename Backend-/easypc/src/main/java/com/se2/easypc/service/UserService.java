package com.se2.easypc.service;

import java.util.List;

import com.se2.easypc.data_access.model.User;
import com.se2.easypc.data_access.repository.UserRepository;
import com.se2.easypc.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for User, recives calls from UserController and calls UserRepository
@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    UserRepository userRepository; 

    public List<User> getAllUsers() { // returns a list with all Users in the database
        try{
            return userRepository.findAll();
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public User getUserById( Long id ) { // returns the User with the requested ID or an exception if it does not exist
        try{
            return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
       
    }

    public User createUser(User user) { // creates a new User in the database
        try{
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder( );
            user.setPassword(passwordEncoder.encode( user.getPassword() ) );
            return userRepository.save(user);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
        
    }

    public void deleteUser( Long id ) { // deletes the User with the requested ID or an exception if it does not exist
        try{
            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
            userRepository.delete(user);
        }catch( Exception e ){
            logger.warn( e );
            throw e;
        }
    }

    public User findByUsername( String username ){
        return userRepository.findByUsername( username );
    }

    public User changePassword(User user,String newPass){
        user.setPassword(newPass);
        return createUser(user);
    }

}
