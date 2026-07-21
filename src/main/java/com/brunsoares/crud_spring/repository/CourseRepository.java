package com.brunsoares.crud_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunsoares.crud_spring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
