package com.projectdata.IOTHub.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projectdata")
public class Project {
	@Id
	private String projectId;
	private String projectName;
	private String apiKey;
	List<String> projectVariables;
	private List<Datas> values;
	
	public Project() {}
	
	public Project(String a,String b,String c, List<String> d, List<Datas> list) {
		this.setProjectId(a);
		this.setProjectName(b);
		this.setApiKey(c);
		this.setProjectVariables(d);
		this.setValues(list);
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

	public List<Datas> getValues() {
		return values;
	}

	public void setValues(List<Datas> values) {
		this.values = values;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
