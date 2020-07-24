package com.projectdata.IOTHub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectdata.IOTHub.models.DataDescription;
import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.services.DataService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/project/{projectId}/data")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping(method = RequestMethod.GET)
	@Operation(summary = "List data for the project")
	public List<Datas> getData(@PathVariable String projectId, @RequestHeader String apiKey)
	{
		return dataService.getData(projectId,apiKey);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Operation(summary = "Add data to the project")
	public void putData(@PathVariable String projectId, @RequestBody DataDescription dataDescription, @RequestHeader String apiKey)
	{
		dataService.putData(projectId,dataDescription,apiKey);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@Operation(summary = "Clear data of the project")
	public void deleteAllData(@PathVariable String projectId, @RequestHeader String apiKey)
	{
		dataService.deleteData(projectId,apiKey);
	}
}
