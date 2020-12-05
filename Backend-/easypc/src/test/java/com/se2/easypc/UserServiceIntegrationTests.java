package com.se2.easypc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.se2.easypc.data_access.model.User;
import com.se2.easypc.service.BuildService;
import com.se2.easypc.service.RoleService;
import com.se2.easypc.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceIntegrationTests {
    
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    BuildService buildService;

    @Test
    public void integrationTestChangePassword(){
        User testUser = new User();
        testUser.setUsername("testUser");
        testUser.setPassword("oldPassword");
        testUser = userService.createUser(testUser);
        testUser = userService.changePassword(testUser, "newPassword");
        userService.deleteUser( testUser.getIdUser() );
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder( );
        assertTrue( passwordEncoder.matches("newPassword", testUser.getPassword() ) );
    }

    @Test
    public void integrationTestFindByUsername(){
        User testUser = userService.getUserById( 1L );
        User user = userService.findByUsername("Invitado");
        assertEquals(testUser, user);
    }

}
