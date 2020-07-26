package com.projectdata.IOTHub.serviceInterfaces;

import java.util.List;

import com.projectdata.IOTHub.models.DataDescription;

public interface DataServiceInterface {
	public List<DataDescription> getData(String projectId, String apiKey);

	public void putData(String projectId, DataDescription dataDescription, String apiKey);

	public void deleteData(String projectId, String apiKey);
}
