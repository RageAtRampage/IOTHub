package com.projectdata.IOTHub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.models.ProjectDescription;
import com.projectdata.IOTHub.services.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	@Operation(summary = "List Projects", security = @SecurityRequirement(name = "basicAuth"))
	public List<Project> listProjects()
	{
		return projectService.listProject();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Operation(summary = "Create a project", security = @SecurityRequirement(name = "basicAuth"))
	public void createProject(@RequestBody ProjectDescription projectDescription)
	{
		projectService.createProject(projectDescription);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{projectId}")
	@Operation(summary = "Delete a project", security = @SecurityRequirement(name = "basicAuth"))
	public void deleteProject(@PathVariable String projectId)
	{
		projectService.deleteProject(projectId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}")
	@Operation(summary = "Get a project", security = @SecurityRequirement(name = "basicAuth"))
	public Project getProject(@PathVariable String projectId)
	{
		return projectService.getProject(projectId);
	}
}
