package com.projectdata.IOTHub.services;

import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.repos.ProjectRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	@Autowired
	private static ProjectRepository projectRepository;

	public DataService(ProjectRepository projectRepository) {
		DataService.projectRepository = projectRepository;
	}

	/*-----------------------------------------------------------------*/
	public static List<Datas> getData(String projectId, String apiKey) {
		Optional<Project> pro = projectRepository.findById(projectId);
		if (pro.isPresent() && pro.get().getApiKey().equals(apiKey)) {
			return pro.get().getValues();
		} else {
			return null;
		}
	}

	public static void putData(String projectId, Datas datas, String apiKey) {
		Optional<Project> pro = projectRepository.findById(projectId);
		if (pro.isPresent()) {
			pro.get().getValues().add(datas);
			if (pro.get().getApiKey().equals(apiKey)) {
				Project proadd = pro.get();
				projectRepository.save(proadd);
			}
		}
	}

	public static void deleteData(String projectId, String apiKey) {
		Optional<Project> pro = projectRepository.findById(projectId);
		if (pro.isPresent()) {
			if (pro.get().getApiKey().equals(apiKey)) {
				pro.get().getValues().clear();
				Project proremove = pro.get();
				projectRepository.save(proremove);
			}
		}
	}

}
