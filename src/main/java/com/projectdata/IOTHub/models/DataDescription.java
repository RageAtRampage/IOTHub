package com.projectdata.IOTHub.models;

import java.util.Map;

public class DataDescription {

	private long timestamp;
	private Map<String, Double> variables;

	public DataDescription() {
	}

	public DataDescription(long timestamp, Map<String, Double> variables) {
		this.setVariables(variables);
		this.setTimestamp(timestamp);
	}

	public Map<String, Double> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Double> variables) {
		this.variables = variables;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
