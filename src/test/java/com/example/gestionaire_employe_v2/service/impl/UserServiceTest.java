package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.repository.impl.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setId(1);
        user.setEmail("test@example.com");
        user.setPassword("password123");
    }

    @Test
    public void testAuthenticate_Success() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(user);
        User authenticatedUser = userService.authenticate("test@example.com", "password123");
        assertEquals(user, authenticatedUser);
    }

    @Test
    public void testAuthenticate_IncorrectPassword() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(user);
        User authenticatedUser = userService.authenticate("test@example.com", "wrongpassword");
        assertNull(authenticatedUser);
    }

    @Test
    public void testAuthenticate_UserNotFound() {
        when(userRepository.findByEmail("unknown@example.com")).thenReturn(null);
        User authenticatedUser = userService.authenticate("unknown@example.com", "password123");
        assertNull(authenticatedUser);
    }
}
