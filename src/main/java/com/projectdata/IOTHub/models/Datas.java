package com.projectdata.IOTHub.models;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Datas {
	@Id
	private int timestamp;
	private Map<String, String> variables;
	
	public Datas() {}

	public Datas (int a, Map<String,String> d) {
		this.setTimestamp(a);
		this.setVariables(d);
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, String> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
}
