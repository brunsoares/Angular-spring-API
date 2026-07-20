package com.brunsoares.crud_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brunsoares.crud_spring.model.Course;
import com.brunsoares.crud_spring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			courseRepository.save(new Course("Angular", "Frontend"));
			courseRepository.save(new Course("Java", "Backend"));
			courseRepository.save(new Course("Python", "Backend"));
			courseRepository.save(new Course("Algoritmo", "Programming"));
		};
	}

}
