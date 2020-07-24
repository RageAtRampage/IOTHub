package com.projectdata.IOTHub.models;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Datas {
	@Id
	private long timestamp;
	private Map<String, Double> variables;
	
	public Datas() {}

	public Datas (int a, Map<String,Double> d) {
		this.setTimestamp(a);
		this.setVariables(d);
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, Double> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Double> variables) {
		this.variables = variables;
	}
}
