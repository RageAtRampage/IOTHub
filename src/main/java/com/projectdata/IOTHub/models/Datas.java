package com.projectdata.IOTHub.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projectData")
public class Datas {
	@Id
	private String projectId;
	private String apikey;
	private List<DataDescription> data;
	
	public Datas() {}
	
	public Datas(String projectId, String apikey, List<DataDescription> data) {
		this.setProjectId(projectId);
		this.setApikey(apikey);
		this.setData(data);
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<DataDescription> getData() {
		return data;
	}

	public void setData(List<DataDescription> data) {
		this.data = data;
	}
}
