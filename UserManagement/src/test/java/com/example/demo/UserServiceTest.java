package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;


import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        user = new User(1L, 101L, "John Doe", "john@example.com", "IT", "Project A", "Developer");
        userDTO = new UserDTO(1L, 101L, "John Doe", "john@example.com", "IT", "Project A", "Developer");
    }

    @Test
    void testGetALLUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<UserDTO> users = userService.getALLUsers();

        assertEquals(1, users.size());
        assertEquals(userDTO.getName(), users.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserByUserId() {
        when(userRepository.findByUserId(101L)).thenReturn(Optional.of(user));

        UserDTO foundUser = userService.getUserByUserId(101L);

        assertEquals(userDTO.getUserId(), foundUser.getUserId());
        verify(userRepository, times(1)).findByUserId(101L);
    }

    @Test
    void testCreateUser() {
        when(userRepository.existsByUserId(userDTO.getUserId())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO createdUser = userService.createUser(userDTO);

        assertEquals(userDTO.getName(), createdUser.getName());
        verify(userRepository, times(1)).existsByUserId(userDTO.getUserId());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testCreateUser_UserExists() {
        when(userRepository.existsByUserId(userDTO.getUserId())).thenReturn(true);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.createUser(userDTO);
        });

        assertEquals("User with userId " + userDTO.getUserId() + " already exists!", exception.getMessage());
        verify(userRepository, times(1)).existsByUserId(userDTO.getUserId());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testUpdateUser() {
        when(userRepository.findByUserId(101L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO updatedUser = userService.updateUser(101L, userDTO);

        assertEquals(userDTO.getName(), updatedUser.getName());
        verify(userRepository, times(1)).findByUserId(101L);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testUpdateUser_UserNotFound() {
        when(userRepository.findByUserId(101L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.updateUser(101L, userDTO);
        });

        assertEquals("User not found with userId: 101", exception.getMessage());
        verify(userRepository, times(1)).findByUserId(101L);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testDeleteUser() {
        when(userRepository.findByUserId(101L)).thenReturn(Optional.of(user));

        userService.deleteUser(101L);

        verify(userRepository, times(1)).findByUserId(101L);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    void testDeleteUser_UserNotFound() {
        when(userRepository.findByUserId(101L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.deleteUser(101L);
        });

        assertEquals("User not found with userId: 101", exception.getMessage());
        verify(userRepository, times(1)).findByUserId(101L);
        verify(userRepository, never()).delete(any(User.class));
    }
}

