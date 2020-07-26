package com.projectdata.IOTHub.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projectdata.IOTHub.models.Datas;

@Repository("com.projectdata.IOTHub.repos.DataRepository")
public interface DataRepository extends MongoRepository<Datas, String>{

}
