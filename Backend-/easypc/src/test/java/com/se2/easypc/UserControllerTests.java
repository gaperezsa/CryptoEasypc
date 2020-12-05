package com.se2.easypc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.se2.easypc.controller.UserController;
import com.se2.easypc.data_access.model.Role;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.pojo.NewPasswordPOJO;
import com.se2.easypc.pojo.UserPOJO;
import com.se2.easypc.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testChangePassword() {

        User testUser = new User();
        testUser.setUsername("testUser");
        testUser.setPassword("original");

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("0.0.0.0");
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(testUser);

        User modUser = new User();
        modUser.setUsername("testUser");
        modUser.setPassword("newPassword");
        when(userService.changePassword(testUser, "newPassword")).thenReturn(modUser);

        NewPasswordPOJO newPasswordPOJO = new NewPasswordPOJO();
        newPasswordPOJO.setNewPassword("newPassword");

        User user = userController.changePassword(newPasswordPOJO, request);

        verify(userService).findByUsername("testUser");
        verify(userService).changePassword(testUser, "newPassword");
        verify(request).getRemoteAddr();

        assertEquals(user.getPassword(), "newPassword");
    }

    @Test
    public void testGetUserByToken() {

        User testUser = new User();
        testUser.setUsername("testUser");
        Role role = new Role();
        role.setIdRole(1L);
        List<Role> roles = Collections.singletonList(role);
        testUser.setRoles(roles);
        testUser.setIdUser(1L);
        UserPOJO testUserPOJO = new UserPOJO(testUser);

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("0.0.0.0");
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(testUser);

        UserPOJO user = userController.getUserByToken(request);

        verify(userService).findByUsername("testUser");
        verify(request).getRemoteAddr();

        assertEquals(user, testUserPOJO);

    }


}
