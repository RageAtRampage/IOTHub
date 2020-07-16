package com.projectdata.IOTHub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.services.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Project> listProjects()
	{
		return projectService.listProject();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void createProject(@RequestBody Project project)
	{
		projectService.createProject(project);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateProject(@RequestBody Project project)
	{
		projectService.updateProject(project);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{projectId}")
	public void deleteProject(@PathVariable String projectId)
	{
		projectService.deleteProject(projectId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}")
	public Project getProject(@PathVariable String projectId)
	{
		return projectService.getProject(projectId);
	}
}
