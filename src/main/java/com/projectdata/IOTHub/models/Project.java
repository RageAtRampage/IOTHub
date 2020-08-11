package com.projectdata.IOTHub.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projectInfo")
public class Project {
	@Id
	private String projectId;
	private String projectName;
	private String projectDescription;
	private String apiKey;
	List<String> projectVariables;
	
	public Project() {}
	
	public Project(String a,String b,String c, String d, List<String> e) {
		this.setProjectId(a);
		this.setProjectName(b);
		this.setProjectDescription(c);
		this.setApiKey(d);
		this.setProjectVariables(e);
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public List<String> getProjectVariables() {
		return projectVariables;
	}

	public void setProjectVariables(List<String> projectVariables) {
		this.projectVariables = projectVariables;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
}
