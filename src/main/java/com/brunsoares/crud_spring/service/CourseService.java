package com.brunsoares.crud_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brunsoares.crud_spring.dto.CourseDTO;
import com.brunsoares.crud_spring.exception.NotFoundException;
import com.brunsoares.crud_spring.mapper.CourseMapper;
import com.brunsoares.crud_spring.model.Course;
import com.brunsoares.crud_spring.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDTO).toList();
    }

    public CourseDTO getByIdCourse(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDTO).orElseThrow(() -> new NotFoundException(id));
    }

    public CourseDTO createCourse(CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO updateCourse(Long id, CourseDTO course) {
        return courseRepository.findById(id).map(existingCourse -> {
            existingCourse.setName(course.name());
            existingCourse.setCategory(course.category());
            Course updatedCourse = courseRepository.save(existingCourse);
            return courseMapper.toDTO(updatedCourse);
        }).orElseThrow(() -> new NotFoundException(id));
    }

    public void deleteCourse(Long id) {
        courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new NotFoundException(id)));
    }
}
