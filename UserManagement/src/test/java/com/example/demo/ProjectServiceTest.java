package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.Entity.Project;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Service.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository; // Mock the repository

    @InjectMocks
    private ProjectServiceImpl projectServiceImpl; // Inject the repository into the service

    private ProjectDTO projectDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        projectDTO = new ProjectDTO();
        projectDTO.setId(1L);
        projectDTO.setProjectId(100L);
        projectDTO.setProjectName("Test Project");
        projectDTO.setDepartmentID(10L);
        projectDTO.setDepartmentName("IT");
        projectDTO.setDescription("Test Description");
        projectDTO.setClient("Test Client");
    }

    @Test
    void testGetAllProjects() {
        List<Project> projectList = new ArrayList<>();
        Project project = new Project(1L, 100L, "Test Project", 10L, "IT", "Test Description", "Test Client");
        projectList.add(project);

        when(projectRepository.findAll()).thenReturn(projectList); // Mock the repository behavior

        List<ProjectDTO> result = projectServiceImpl.getALLProjects();
        assertEquals(1, result.size());
        assertEquals("Test Project", result.get(0).getProjectName());
    }

    @Test
    void testGetProjectById() {
        Project project = new Project(1L, 100L, "Test Project", 10L, "IT", "Test Description", "Test Client");
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project)); // Mock the repository behavior

        ProjectDTO result = projectServiceImpl.getProjectById(1L);
        assertEquals("Test Project", result.getProjectName());
        assertEquals(100L, result.getProjectId());
    }

    @Test
    void testCreateProject() {
        Project project = new Project(1L, 100L, "Test Project", 10L, "IT", "Test Description", "Test Client");


        when(projectRepository.existsByProjectId(100L)).thenReturn(false);
        when(projectRepository.save(any(Project.class))).thenReturn(project); // Mock the repository save operation

        ProjectDTO result = projectServiceImpl.createProject(projectDTO);
        assertNotNull(result);
        assertEquals("Test Project", result.getProjectName());
    }

    @Test
    void testUpdateProject() {
        Project project = new Project(1L, 100L, "Updated Project", 10L, "IT", "Updated Description", "Updated Client");
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project)); // Mock finding the project by id
        when(projectRepository.save(any(Project.class))).thenReturn(project);  // Mock saving the updated project

        projectDTO.setProjectName("Updated Project");
        ProjectDTO result = projectServiceImpl.updateProject(1L, projectDTO);
        assertEquals("Updated Project", result.getProjectName());
    }

    @Test
    void testDeleteProject() {
        Project project = new Project(1L, 100L, "Test Project", 10L, "IT", "Test Description", "Test Client");


        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));


        doNothing().when(projectRepository).delete(project);


        projectServiceImpl.deleteProject(1L);


        verify(projectRepository, times(1)).delete(project);
    }

}
