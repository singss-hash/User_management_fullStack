package com.example.demo.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;




/*@NoArgsConstructor
@AllArgsConstructor*/
public class ProjectDTO {
	
    public ProjectDTO() {
		super();
	}

	public ProjectDTO(long id,
			@NotBlank(message = "projectID is mandatory") @Size(max = 100, message = "ProjectID should not be more than 10 digits") long projectId,
			@NotBlank(message = "projectName is mandatory") @Size(max = 100, message = "projectName  should not exceed 100 characters") String projectName,
			@NotBlank(message = "departmentID is mandatory") @Size(max = 100, message = "departmentID  should not exceed 10 digits") long departmentID,
			@NotBlank(message = "departmentName is mandatory") @Size(max = 100, message = "departmentName  should not exceed 100 characters") String departmentName,
			@NotBlank(message = "description is mandatory") @Size(max = 100, message = "description  should not exceed 100 characters") String description,
			@NotBlank(message = "client info is mandatory") @Size(max = 100, message = "client info  should not exceed 100 characters") String client) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.projectName = projectName;
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.description = description;
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	private long id;       // corresponds to Project entity's id field
    
   // @NotBlank(message = "projectID is mandatory")
    //@Size(max = 100, message = "ProjectID should not be more than 10 digits")
    private long projectId;        // corresponds to Project entity's ProjectId field
    
   // @NotBlank(message = "projectName is mandatory")
    @Size(max = 100, message = "projectName  should not exceed 100 characters")
    private String projectName;    // corresponds to Project entity's ProjectName field
    
  //  @NotBlank(message = "departmentID is mandatory")
   // @Size(max = 100, message = "departmentID  should not exceed 10 digits")
    private long departmentID;     // corresponds to Project entity's DepartmentID field
    
   // @NotBlank(message = "departmentName is mandatory")
    @Size(max = 100, message = "departmentName  should not exceed 100 characters")
    private String departmentName; // corresponds to Project entity's DepartmentName field
    
   // @NotBlank(message = "description is mandatory")
    @Size(max = 100, message = "description  should not exceed 100 characters")
    private String description;    // corresponds to Project entity's Description field
    
    //@NotBlank(message = "client info is mandatory")
    @NotNull(message = "client info is mandatory")
    @Size(max = 100, message = "client info  should not exceed 100 characters")
    private String client;         // corresponds to Project entity's Client field
}


	


