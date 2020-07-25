package com.projectdata.IOTHub.models;

import java.util.List;


public class ProjectDescription {

	private String projectName;
	
	List<String> projectVariables;

	public ProjectDescription() {
	}

	public ProjectDescription(String a, List<String> d) {
		this.setProjectName(a);
		this.setProjectVariables(d);

	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<String> getProjectVariables() {
		return projectVariables;
	}

	public void setProjectVariables(List<String> projectVariables) {
		this.projectVariables = projectVariables;
	}

}
