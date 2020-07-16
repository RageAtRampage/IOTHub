package com.projectdata.IOTHub.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.services.DataService;

@RestController
@RequestMapping(value = "/project/{projectId}/data")
public class DataController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Datas> getData(@PathVariable String projectId, @RequestHeader String apiKey)
	{
		return DataService.getData(projectId,apiKey);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void putData(@PathVariable String projectId,@RequestBody Datas datas, @RequestHeader String apiKey)
	{
		DataService.putData(projectId,datas,apiKey);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAllData(@PathVariable String projectId, @RequestHeader String apiKey)
	{
		DataService.deleteData(projectId,apiKey);
	}
}
