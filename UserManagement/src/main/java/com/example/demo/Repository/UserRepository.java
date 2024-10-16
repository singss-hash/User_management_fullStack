//package com.example.demo.Repository;
//
//import com.example.demo.Entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByName(String username);
//    boolean existsByUserId(long userId);
//
//    Optional<Object> findByEmailId(String username);
//}


package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by name
    Optional<User> findByName(String username);

    // Check if a user with a specific userId exists
    boolean existsByUserId(long userId);

    // Find user by userId
    Optional<User> findByUserId(long userId);

    // Find user by emailId (unique field)
    Optional<User> findByEmailId(String emailId);
}
