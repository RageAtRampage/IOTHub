package com.projectdata.IOTHub.services;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.repos.ProjectRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private static ProjectRepository projectRepository;
	
	public ProjectService (ProjectRepository projectRepository)
	{
		ProjectService.projectRepository=projectRepository;
	}
/*-----------------------------------------------------------------*/
	public static List<Project> listProject() {
		return projectRepository.findAll();
	}
	
	public static void createProject(Project project) {
		projectRepository.insert(project);
	}
	
	public static void updateProject(Project project) {
		projectRepository.save(project);
	}

	public static void deleteProject(String projectId) {
		projectRepository.deleteById(projectId);
	}

	public static Project getProject(String projectId) {
		Optional<Project> pro = projectRepository.findById(projectId);
		if(pro.isPresent()) {
			return pro.get();
		}	
		return null;
	}
	

}
