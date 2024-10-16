package com.example.demo.Controller;

import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.InfoDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;



    @RestController
    @RequestMapping("/api/auth")
    public class EmployeeController {
        @Autowired
        private EmployeeService employeeService;

        @PostMapping("/register")
        public ResponseEntity<Employee> register(@Valid @RequestBody EmployeeDTO employeeDTO) {
            Employee employee = employeeService.register(employeeDTO);
            return ResponseEntity.ok(employee);
        }

        @PostMapping("/login")
        public ResponseEntity<AuthResponseDTO> login(@RequestBody InfoDTO infoDTO) {
            AuthResponseDTO authResponseDTO = employeeService.login(infoDTO.getEmailId(), infoDTO.getPassword());
            return ResponseEntity.ok(authResponseDTO); // Return the AuthResponse
        }
    }


