//package com.example.demo.Service;
//
//import com.example.demo.DTO.UserDTO;
//import com.example.demo.Entity.User;
//import com.example.demo.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.Arrays;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService, UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Load user by username (emailId in this case) for Spring Security
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Fetch user by email
//        User user = (User) userRepository.findByEmailId(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        // Convert roles (assuming roles are stored as a comma-separated string in the 'roles' field)
////        List<SimpleGrantedAuthority> authorities = Arrays.stream(user.getRoles().split(","))
////                .map(SimpleGrantedAuthority::new)
////                .collect(Collectors.toList());
////
////        // Return UserDetails object for Spring Security
////        return new org.springframework.security.core.userdetails.User(
////                user.getEmailId(),
////                user.getPassWord(),
////                authorities
//
//        return null;
//    }
//
//    // Get all users
//    @Override
//    public List<UserDTO> getALLUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(this::convertEntityToDTO)
//                .collect(Collectors.toList());
//    }
//
//    // Get user by user ID
//    @Override
//    public UserDTO getUserByUserId(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//        return convertEntityToDTO(user);
//    }
//
//    // Create a new user
//    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        // Check if user with the same userId already exists
//        if (userRepository.existsByUserId(userDTO.getUserId())) {
//            throw new RuntimeException("User with userId " + userDTO.getUserId() + " already exists!");
//        }
//
//        User user = convertDTOToEntity(userDTO);
//        User savedUser = userRepository.save(user);
//        return convertEntityToDTO(savedUser);
//    }
//
//    // Update user details
//    @Override
//    public UserDTO updateUser(Long id, UserDTO userDTO) {
//        User existingUser = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//
//        // If updating userId, check if the new userId already exists for another user
//        if (existingUser.getUserId() != userDTO.getUserId() &&
//                userRepository.existsByUserId(userDTO.getUserId())) {
//            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
//            throw new RuntimeException("User with userId " + userDTO.getUserId() + " already exists!");
//        }
//
//        // Update fields
//        existingUser.setName(userDTO.getName());
//        existingUser.setEmailId(userDTO.getEmailId());
////        existingUser.setDepartmentId(userDTO.getDepartmentId());
////        existingUser.setProjectId(userDTO.getProjectId());
////        existingUser.setPassWord(userDTO.getPassWord());  // Password should be updated carefully
//
//        User updatedUser = userRepository.save(existingUser);
//        return convertEntityToDTO(updatedUser);
//    }
//
//    // Delete a user by ID
//    @Override
//    public void deleteUser(Long userId) {
//        User user = userRepository.findByuserId(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//        userRepository.delete(user);
//    }
//
//    // Helper method to convert Entity to DTO
//    private UserDTO convertEntityToDTO(User user) {
//        return new UserDTO(
//                user.getId(),
//                user.getUserId(),
//                user.getName(),
//                user.getEmailId(),
//                user.getDepartmentName(),
//                user.getProjectName(),
//                user.getDesignation()
////                user.getPassWord(),  // Include password if necessary, else omit
////                user.getDepartmentId(),
////                user.getProjectId()
//        );
//    }
//
//    // Helper method to convert DTO to Entity
//    private User convertDTOToEntity(UserDTO userDTO) {
//        User user = new User();
//        user.setUserId(userDTO.getUserId());
//        user.setName(userDTO.getName());
//        user.setEmailId(userDTO.getEmailId());
//        user.setProjectName(userDTO.getProjectName());
//        user.setDepartmentName(userDTO.getDepartmentName());
//        user.setDesignation(userDTO.getDesignation());
//
////        user.setPassWord(userDTO.getPassWord());  // Ensure password is hashed if necessary
////        user.setDepartmentId(userDTO.getDepartmentId());
////        user.setProjectId(userDTO.getProjectId());
//        return user;
//    }
//}





package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user by email
        User user = userRepository.findByEmailId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));



        return null; // Replace this with actual UserDetails when roles are handled
    }

    // Get all users
    @Override
    public List<UserDTO> getALLUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    // Get user by userId
    @Override
    public UserDTO getUserByUserId(Long userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with userId: " + userId));
        return convertEntityToDTO(user);
    }

    // Create a new user
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Check if user with the same userId already exists
        if (userRepository.existsByUserId(userDTO.getUserId())) {
            throw new RuntimeException("User with userId " + userDTO.getUserId() + " already exists!");
        }

        User user = convertDTOToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertEntityToDTO(savedUser);
    }

    // Update user details by userId
    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with userId: " + userId));

        // If updating userId, check if the new userId already exists for another user
        if (existingUser.getUserId() != userDTO.getUserId() &&
                userRepository.existsByUserId(userDTO.getUserId())) {
            throw new RuntimeException("User with userId " + userDTO.getUserId() + " already exists!");
        }

        // Update fields
        existingUser.setName(userDTO.getName());
        existingUser.setEmailId(userDTO.getEmailId());
        existingUser.setDepartmentName(userDTO.getDepartmentName());
        existingUser.setProjectName(userDTO.getProjectName());
        existingUser.setDesignation(userDTO.getDesignation());

        User updatedUser = userRepository.save(existingUser);
        return convertEntityToDTO(updatedUser);
    }

    // Delete a user by userId
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with userId: " + userId));
        userRepository.delete(user);
    }

    // Helper method to convert Entity to DTO
    private UserDTO convertEntityToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserId(),
                user.getName(),
                user.getEmailId(),
                user.getDepartmentName(),
                user.getProjectName(),
                user.getDesignation()
        );
    }

    // Helper method to convert DTO to Entity
    private User convertDTOToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setEmailId(userDTO.getEmailId());
        user.setProjectName(userDTO.getProjectName());
        user.setDepartmentName(userDTO.getDepartmentName());
        user.setDesignation(userDTO.getDesignation());
        return user;
    }
}
