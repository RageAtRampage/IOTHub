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

@Component
public class ProjectComponents implements CommandLineRunner{

	private ProjectRepository m;
	
	public ProjectComponents (ProjectRepository m)
	{
		this.m=m;
	}
	@Override
	public void run(String... args) throws Exception {
		
		/*Map<String, Double> x = new HashMap<String, Double>() {{
			put("USA", 1.23);
			put("United Kingdom", 1.23);
			put("India", 1.23);
		}};
		Project p1 = new Project("abcdee","abcd","abcd",Arrays.asList("Usa","uk"),Arrays.asList(new Datas(1,x)));
		
		List<Project> h = Arrays.asList(p1);
		this.m.saveAll(h);*/
	}
	

}
