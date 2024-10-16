package com.example.demo.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
public class UserDTO {

	private long id;

	@NotNull(message = "UserID is mandatory")
	private long userId;

	@Size(max = 256, message = "Name cannot be more than 256 characters")
	private String name;

	@Size(max = 50, message = "Email cannot be more than 50 characters")
	private String emailId;

	@NotNull(message= "department_name is necessary")
	private String departmentName;

	@NotNull(message = "project_name is necessary")
	private String projectName;

	@NotNull(message = "designation is necessary")
	private String designation;

//	@NotNull(message = "Password must be strong")
//	private String passWord;
//
//	@NotNull(message = "DepartmentID is mandatory")
//	private long departmentId;
//
//	@NotNull(message = "ProjectID is mandatory")
//	private long projectId;

//	@NotNull(message = "Roles is mandatory")
//	private long roles;


}
