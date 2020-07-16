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
	private  ProjectRepository projectRepository;
	
/*-----------------------------------------------------------------*/
	public  List<Project> listProject() {
		return projectRepository.findAll();
	}
	
	public  void createProject(Project project) {
		projectRepository.insert(project);
	}
	
	public  void updateProject(Project project) {
		projectRepository.save(project);
	}

	public  void deleteProject(String projectId) {
		projectRepository.deleteById(projectId);
	}

	public  Project getProject(String projectId) {
		Optional<Project> pro = projectRepository.findById(projectId);
		if(pro.isPresent()) {
			return pro.get();
		}	
		return null;
	}
	

}
