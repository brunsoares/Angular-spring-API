package com.brunsoares.crud_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brunsoares.crud_spring.enums.Category;
import com.brunsoares.crud_spring.model.Course;
import com.brunsoares.crud_spring.model.Lesson;
import com.brunsoares.crud_spring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		Course course1 = new Course();
		course1.setName("Angular");
		course1.setCategory(Category.FRONTEND);

		List<Lesson> lessons1 = new ArrayList<>();
		Lesson lesson1 = new Lesson();
		lesson1.setName("Introdução ao Angular");
		lesson1.setYoutubeUrl("Nb4uxLxdvxo");
		lesson1.setCourse(course1);
		lessons1.add(lesson1);
		Lesson lesson2_1 = new Lesson();
		lesson2_1.setName("Introdução ao Angular 2");
		lesson2_1.setYoutubeUrl("Nb4uxLxdvxo");
		lesson2_1.setCourse(course1);
		lessons1.add(lesson2_1);
		course1.setLessons(lessons1);

		Course course2 = new Course();
		course2.setName("Java");
		course2.setCategory(Category.BACKEND);

		List<Lesson> lessons2 = new ArrayList<>();
		Lesson lesson2 = new Lesson();
		lesson2.setName("Introdução ao Java");
		lesson2.setYoutubeUrl("Nb4uxLxdvxo");
		lesson2.setCourse(course2);
		lessons2.add(lesson2);
		course2.setLessons(lessons2);

		return args -> {
			courseRepository.deleteAll();
			courseRepository.save(course1);
			courseRepository.save(course2);
		};
	}

}
