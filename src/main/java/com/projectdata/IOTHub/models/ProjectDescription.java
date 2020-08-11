package com.projectdata.IOTHub.models;

import java.util.List;


public class ProjectDescription {

	private String projectName;
	private String projectDescription;
	List<String> projectVariables;

	public ProjectDescription() {
	}

	public ProjectDescription(String a, String b, List<String> c) {
		this.setProjectName(a);
		this.setProjectDescription(b);
		this.setProjectVariables(c);

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

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

}
