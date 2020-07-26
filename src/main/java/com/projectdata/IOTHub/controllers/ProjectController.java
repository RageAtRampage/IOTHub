package com.projectdata.IOTHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectdata.IOTHub.models.ProjectDescription;
import com.projectdata.IOTHub.serviceInterfaces.ProjectServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	@Autowired
	@Qualifier("com.projectdata.IOTHub.services.ProjectService")
	private ProjectServiceInterface projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	@Operation(summary = "List Projects", security = @SecurityRequirement(name = "basicAuth"))
	public ResponseEntity<Object> listProjects()
	{
		return new ResponseEntity<Object>(projectService.listProject(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Operation(summary = "Create a project", security = @SecurityRequirement(name = "basicAuth"))
	public ResponseEntity<Object> createProject(@RequestBody ProjectDescription projectDescription)
	{
		projectService.createProject(projectDescription);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{projectId}")
	@Operation(summary = "Delete a project", security = @SecurityRequirement(name = "basicAuth"))
	public ResponseEntity<Object> deleteProject(@PathVariable String projectId)
	{
		projectService.deleteProject(projectId);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}")
	@Operation(summary = "Get a project", security = @SecurityRequirement(name = "basicAuth"))
	public ResponseEntity<Object> getProject(@PathVariable String projectId)
	{
		return new ResponseEntity<Object>(projectService.getProject(projectId),HttpStatus.OK);
	}
}
