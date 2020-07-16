package com.projectdata.IOTHub.components;

/*for testing*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.projectdata.IOTHub.models.Project;
import com.projectdata.IOTHub.models.Datas;
import com.projectdata.IOTHub.repos.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class ProjectComponents implements CommandLineRunner{

	private ProjectRepository m;
	
	public ProjectComponents (ProjectRepository m)
	{
		this.m=m;
	}
	@Override
	public void run(String... args) throws Exception {
		
		Map<String, String> x = new HashMap<String, String>() {{
			put("USA", "Washington");
			put("United Kingdom", "London");
			put("India", "New Delhi");
		}};
		Project p1 = new Project("abcd","abcd","abcd",x,Arrays.asList(new Datas(1,x)));
		
		List<Project> h = Arrays.asList(p1);
		this.m.saveAll(h);
	}
	

}
