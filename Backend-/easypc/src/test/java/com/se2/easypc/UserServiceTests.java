package com.se2.easypc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.se2.easypc.data_access.model.User;
import com.se2.easypc.data_access.repository.UserRepository;
import com.se2.easypc.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTests {
    
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testChangePassword(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder( );
        User testUser = new User();
        testUser.setUsername("testUser");
        testUser.setPassword( passwordEncoder.encode("original") );
        when(userRepository.save( any() )).thenAnswer(i -> i.getArguments()[0]);

        User user = userService.changePassword(testUser, "newPassword");

        verify(userRepository).save(any());

        assertTrue( passwordEncoder.matches("newPassword", user.getPassword() ) );
    }

}
