package com.projectdata.IOTHub.services;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.exception.InvalidException;
import com.projectdata.IOTHub.models.DataDescription;
import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.repos.DataRepository;
import com.projectdata.IOTHub.repos.ProjectRepository;
import com.projectdata.IOTHub.serviceInterfaces.DataServiceInterface;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("com.projectdata.IOTHub.services.DataService")
public class DataService implements DataServiceInterface {

	@Autowired
	@Qualifier("com.projectdata.IOTHub.repos.DataRepository")
	private DataRepository dataRepository;
	
	@Autowired
	@Qualifier("com.projectdata.IOTHub.repos.ProjectRepository")
	private ProjectRepository projectRepository;

	/*-----------------------------------------------------------------*/
	public List<DataDescription> getData(String projectId, String apiKey) {
		try {
			Optional<Datas> dat = dataRepository.findById(projectId);
			if (dat.isPresent() && dat.get().getApikey().equals(apiKey)) {
				return dat.get().getData();
			} else {
				throw new InvalidException("Invaid Project Id or Api Key");
			}
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

	public void putData(String projectId, DataDescription dataDescription, String apiKey) {
		try {
			Optional<Project> pro = projectRepository.findById(projectId);
			Optional<Datas> dat = dataRepository.findById(projectId);
			if (dat.isPresent() && dat.get().getApikey().equals(apiKey)) {
				DataDescription data = new DataDescription();

				data.setTimestamp(Instant.now().toEpochMilli());

				Map<String, Double> newVariables = new HashMap<String, Double>();
				List<String> variableList = pro.get().getProjectVariables();

				for (String s : variableList) {
					if (dataDescription.getVariables().containsKey(s))
						newVariables.put(s, dataDescription.getVariables().get(s));
					else
						newVariables.put(s, Double.valueOf(0));
				}

				data.setVariables(newVariables);

				if (!newVariables.isEmpty()) {
					dat.get().getData().add(data);
					Datas datadd = dat.get();
					dataRepository.save(datadd);
				}else {
					throw new InvalidException("No Similar Variable Found in Project");
				}
				
			} else {
				throw new InvalidException("Invaid Project Id or Api Key");
			}
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

	public void deleteData(String projectId, String apiKey) {
		try {
			Optional<Datas> dat = dataRepository.findById(projectId);
			if (dat.isPresent() && dat.get().getApikey().equals(apiKey)) {
				dat.get().getData().clear();
				Datas datadd = dat.get();
				dataRepository.save(datadd);
			} else {
				throw new InvalidException("Invaid Project Id or Api Key");
			}
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

}
