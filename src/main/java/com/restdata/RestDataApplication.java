package com.restdata;

import com.restdata.entities.Student;
import com.restdata.repo.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class RestDataApplication implements CommandLineRunner {
    private final StudentRepo studentRepo;
	public static void main(String[] args) {
		SpringApplication.run(RestDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s = new Student();
		s.setName("pavan");
		s.setAddress("Hyderabad");
		List<String> hobbies = new ArrayList<>();
		hobbies.add("cricket");
		hobbies.add("tennis");
		s.setHobby(hobbies);
		studentRepo.save(s);

		Student s1 = new Student();
		s1.setName("chandu");
		s1.setAddress("Karimnagar");
		List<String> hobbies1 = new ArrayList<>();
		hobbies1.add("cricket");
		hobbies1.add("tennis");
		s1.setHobby(hobbies1);
		studentRepo.save(s1);
	}
}
