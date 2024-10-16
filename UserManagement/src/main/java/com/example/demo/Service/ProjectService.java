package com.example.demo.Service;

import com.example.demo.DTO.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
	List<ProjectDTO> getALLProjects();
	ProjectDTO getProjectById(Long id);
    ProjectDTO createProject(ProjectDTO projectsDTO);
    ProjectDTO updateProject(Long id, ProjectDTO projectsDTO);
    void deleteProject(Long id);	
 }

