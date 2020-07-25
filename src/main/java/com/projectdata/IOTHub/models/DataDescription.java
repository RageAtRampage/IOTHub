package com.projectdata.IOTHub.models;

import java.util.Map;

public class DataDescription {
	
private Map<String, Double> variables;
	
	public DataDescription() {}

	public DataDescription (Map<String,Double> d) {
		this.setVariables(d);
	}

	public Map<String, Double> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Double> variables) {
		this.variables = variables;
	}

}
