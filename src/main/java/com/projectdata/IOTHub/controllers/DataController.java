package com.projectdata.IOTHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectdata.IOTHub.models.DataDescription;
import com.projectdata.IOTHub.serviceInterfaces.DataServiceInterface;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/project/{projectId}/data")
public class DataController {
	
	@Autowired
	@Qualifier("com.projectdata.IOTHub.services.DataService")
	private DataServiceInterface dataService;
	
	@RequestMapping(method = RequestMethod.GET)
	@Operation(summary = "List data for the project")
	public ResponseEntity<Object> getData(@PathVariable String projectId, @RequestHeader String apiKey)
	{
		return new ResponseEntity<Object>(dataService.getData(projectId,apiKey),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Operation(summary = "Add data to the project")
	public ResponseEntity<Object> putData(@PathVariable String projectId, @RequestBody DataDescription dataDescription, @RequestHeader String apiKey)
	{
		dataService.putData(projectId,dataDescription,apiKey);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@Operation(summary = "Clear data of the project")
	public ResponseEntity<Object> deleteAllData(@PathVariable String projectId, @RequestHeader String apiKey)
	{
		dataService.deleteData(projectId,apiKey);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
}
