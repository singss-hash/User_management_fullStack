package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="Project")
public class Project {
public Project() {
		super();
	}

public Project(long id, long projectId, String projectName, long departmentID, String departmentName,
			String description, String client) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.projectName = projectName;
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.description = description;
		this.client = client;
	}

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="ProjectId")	
private long projectId;

@Column(name="ProjectName")
private String projectName;

@NotNull
@PositiveOrZero  // or @Positive if you want it to be greater than 0


@Column(name="DepartmentId")
private long departmentID;

@Column(name="DepartmentName")
private String departmentName;

@Column(name="Description")
private String description;

@Column(name="Client")
private String client;




}
