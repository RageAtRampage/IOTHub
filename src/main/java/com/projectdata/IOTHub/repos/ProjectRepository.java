package com.projectdata.IOTHub.repos;

import com.projectdata.IOTHub.models.Project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository("com.projectdata.IOTHub.repos.ProjectRepository")
public interface ProjectRepository extends MongoRepository<Project, String> {

}
