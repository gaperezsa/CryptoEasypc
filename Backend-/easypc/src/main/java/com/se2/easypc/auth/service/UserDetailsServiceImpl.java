package com.se2.easypc.auth.service;

import com.se2.easypc.auth.model.UserDetailsImpl;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.service.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service( "userDetailsService" )
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserService userService;

    public UserDetailsServiceImpl( UserService userService ){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername( String username ){
        User user = userService.findByUsername( username );
        if( user == null ){
            throw new UsernameNotFoundException( "" );
        }
        return new UserDetailsImpl( user );
    }

}