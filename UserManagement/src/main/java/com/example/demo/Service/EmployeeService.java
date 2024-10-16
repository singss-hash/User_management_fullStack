package com.example.demo.Service;

import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;


import java.util.List;

public interface EmployeeService {



    Employee register(EmployeeDTO employeeDTO);
    AuthResponseDTO login(String email, String password);
}



