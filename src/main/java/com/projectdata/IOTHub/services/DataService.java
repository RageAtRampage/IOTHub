package com.projectdata.IOTHub.services;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.exception.InvalidException;
import com.projectdata.IOTHub.models.DataDescription;
import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.repos.ProjectRepository;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	@Autowired
	private ProjectRepository projectRepository;

	/*-----------------------------------------------------------------*/
	public List<Datas> getData(String projectId, String apiKey) {
		try {
			Optional<Project> pro = projectRepository.findById(projectId);
			if (pro.isPresent() && pro.get().getApiKey().equals(apiKey)) {
				return pro.get().getValues();
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
			if (pro.isPresent() && pro.get().getApiKey().equals(apiKey)) {
				Datas data = new Datas();

				data.setTimestamp(Instant.now().toEpochMilli());

				Map<String, Double> variables = dataDescription.getVariables();
				Map<String, Double> newVariables = new HashMap<String, Double>();
				List<String> variableList = pro.get().getProjectVariables();

				for (String s : variableList) {
					if (variables.containsKey(s))
						newVariables.put(s, variables.get(s));
					else
						newVariables.put(s, Double.valueOf(0));
				}

				data.setVariables(newVariables);

				if (!newVariables.isEmpty()) {
					pro.get().getValues().add(data);
					Project proadd = pro.get();
					projectRepository.save(proadd);
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
			Optional<Project> pro = projectRepository.findById(projectId);
			if (pro.isPresent() && pro.get().getApiKey().equals(apiKey)) {
				pro.get().getValues().clear();
				Project proremove = pro.get();
				projectRepository.save(proremove);
			} else {
				throw new InvalidException("Invaid Project Id or Api Key");
			}
		} catch (Exception e) {
			throw new InvalidException(e.getMessage());
		}
	}

}
