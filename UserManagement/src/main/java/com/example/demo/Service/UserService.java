package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    List<UserDTO> getALLUsers();
	UserDTO getUserByUserId(Long id);
    UserDTO createUser(UserDTO usersDTO);
    UserDTO updateUser(Long id, UserDTO usersDTO);
    void deleteUser(Long id);
	
 }

