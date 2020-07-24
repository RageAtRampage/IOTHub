package com.projectdata.IOTHub.services;

import com.fasterxml.uuid.Generators;
import com.projectdata.IOTHub.exception.InvalidException;
import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.models.ProjectDescription;
import com.projectdata.IOTHub.repos.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	/*-----------------------------------------------------------------*/
	public List<Project> listProject() {
		try {
			return projectRepository.findAll();
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

	public void createProject(ProjectDescription projectDescription) {
		try {
			if (projectDescription.getProjectName()!= null && projectDescription.getProjectVariables()!= null) {
				Project project = new Project();
				project.setProjectId(Generators.timeBasedGenerator().generate().toString());
				project.setApiKey(Generators.timeBasedGenerator().generate().toString());
				project.setValues(new ArrayList<Datas>());				
				project.setProjectName(projectDescription.getProjectName());
				project.setProjectVariables(projectDescription.getProjectVariables());
				projectRepository.insert(project);
			} else
				throw new InvalidException("Inavlid Data Structure");

		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

	public void deleteProject(String projectId) {
		try {
			Optional<Project> pro = projectRepository.findById(projectId);
			if (pro.isPresent()) {
				projectRepository.deleteById(projectId);
			} else
				throw new InvalidException("Project Not Found");
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

	public Project getProject(String projectId) {
		try {
			Optional<Project> pro = projectRepository.findById(projectId);
			if (pro.isPresent()) {
				return pro.get();
			} else
				throw new InvalidException("Project Not Found");
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

}
