package com.example.demo.Service;


import com.example.demo.DTO.ProjectDTO;
import com.example.demo.Entity.Project;
import com.example.demo.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> getALLProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
        return convertEntityToDTO(project);
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        // Check if project ID already exists
        if (projectRepository.existsByProjectId(projectDTO.getProjectId())) {
            throw new RuntimeException("Project with projectId " + projectDTO.getProjectId() + " already exists!");
        }

        Project project = convertDTOToEntity(projectDTO);
        Project savedProject = projectRepository.save(project);
        return convertEntityToDTO(savedProject);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));

        // Check if the new project ID already exists for another project
        /*
        if (!(project.getProjectId() == (projectDTO.getProjectId())) &&
            projectRepository.existsByProjectId(projectDTO.getProjectId())) {
            throw new RuntimeException("Project with projectId " + projectDTO.getProjectId() + " already exists!");
        }
        */

        project.setProjectName(projectDTO.getProjectName());
        project.setDepartmentID(projectDTO.getDepartmentID());
        project.setDepartmentName(projectDTO.getDepartmentName());
        project.setDescription(projectDTO.getDescription());
        project.setClient(projectDTO.getClient());

        Project updatedProject = projectRepository.save(project);
        return convertEntityToDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
        projectRepository.delete(project);
    }

    // Helper method to convert Entity to DTO
    private ProjectDTO convertEntityToDTO(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getProjectId(),
                project.getProjectName(),
                project.getDepartmentID(),
                project.getDepartmentName(),
                project.getDescription(),
                project.getClient()
        );
    }

    // Helper method to convert DTO to Entity
    private Project convertDTOToEntity(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectId(projectDTO.getProjectId());
        project.setProjectName(projectDTO.getProjectName());
        project.setDepartmentID(projectDTO.getDepartmentID());
        project.setDepartmentName(projectDTO.getDepartmentName());
        project.setDescription(projectDTO.getDescription());
        project.setClient(projectDTO.getClient());
        return project;
    }
}
