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
		Lesson lesson = new Lesson();
		lesson.setName("Introdução ao Angular");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course1);
		lessons1.add(lesson);
		lesson = new Lesson();
		lesson.setName("Introdução ao Angular 2");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course1);
		lessons1.add(lesson);
		course1.setLessons(lessons1);

		// ---
		Course course2 = new Course();
		course2.setName("Java");
		course2.setCategory(Category.BACKEND);

		List<Lesson> lessons2 = new ArrayList<>();
		lesson = new Lesson();
		lesson.setName("Introdução ao Java");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course2);
		lessons2.add(lesson);
		course2.setLessons(lessons2);

		// ---
		Course course3 = new Course();
		course3.setName("Spring Boot");
		course3.setCategory(Category.BACKEND);

		List<Lesson> lessons3 = new ArrayList<>();
		lesson = new Lesson();
		lesson.setName("Introdução ao Spring Boot");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course3);
		lessons3.add(lesson);
		lesson = new Lesson();
		lesson.setName("Introdução ao Spring Boot 2");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course3);
		lessons3.add(lesson);
		course3.setLessons(lessons3);

		// ---
		Course course4 = new Course();
		course4.setName("React");
		course4.setCategory(Category.FRONTEND);

		List<Lesson> lessons4 = new ArrayList<>();
		lesson = new Lesson();
		lesson.setName("Introdução ao React");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course4);
		lessons4.add(lesson);
		course4.setLessons(lessons4);

		// ---
		Course course5 = new Course();
		course5.setName("SQL");
		course5.setCategory(Category.PROGRAMMING);

		List<Lesson> lessons5 = new ArrayList<>();
		lesson = new Lesson();
		lesson.setName("Introdução ao SQL");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course5);
		lessons5.add(lesson);
		lesson = new Lesson();
		lesson.setName("Introdução ao SQL 2");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course5);
		lessons5.add(lesson);
		course5.setLessons(lessons5);

		// ---
		Course course6 = new Course();
		course6.setName("Python");
		course6.setCategory(Category.PROGRAMMING);

		List<Lesson> lessons6 = new ArrayList<>();
		lesson = new Lesson();
		lesson.setName("Introdução ao Python");
		lesson.setYoutubeUrl("Nb4uxLxdvxo");
		lesson.setCourse(course6);
		lessons6.add(lesson);
		course6.setLessons(lessons6);

		return args -> {
			courseRepository.deleteAll();
			courseRepository.save(course1);
			courseRepository.save(course2);
			courseRepository.save(course3);
			courseRepository.save(course4);
			courseRepository.save(course5);
			courseRepository.save(course6);
		};
	}

}
