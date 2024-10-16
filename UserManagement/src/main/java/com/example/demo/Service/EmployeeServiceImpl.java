package com.example.demo.Service;

import java.util.Optional;
import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;
import com.example.demo.utils.JwtTokenProviders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtTokenProviders jwtTokenProvider;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Employee register(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailId(employeeDTO.getEmailId());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        employee.setRole(employeeDTO.getRole());
        return employeeRepository.save(employee);
    }
//
//    @Override
//    public Employee register(EmployeeDTO employeeDT) {
//        return null;
//    }

    @Override
    public AuthResponseDTO login(String email, String password) {
        Optional<Employee> userOptional = employeeRepository.findByEmailId(email);
        if (userOptional.isPresent()) {
            Employee employee = userOptional.get();
            if (passwordEncoder.matches(password, employee.getPassword())) {
                String token = jwtTokenProvider.createToken(employee.getEmailId(), employee.getRole());
                return new AuthResponseDTO(token); // Return the token in a JSON object
            } else {
                throw new UserNotFoundException("Invalid password");
            }
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

}

