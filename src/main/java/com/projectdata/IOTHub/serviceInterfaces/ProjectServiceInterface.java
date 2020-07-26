package com.projectdata.IOTHub.serviceInterfaces;

import java.util.List;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.models.ProjectDescription;

public interface ProjectServiceInterface {
	public List<Project> listProject();

	public void createProject(ProjectDescription projectDescription);

	public void deleteProject(String projectId);

	public Project getProject(String projectId);
}
