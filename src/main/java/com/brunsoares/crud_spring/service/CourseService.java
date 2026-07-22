package com.brunsoares.crud_spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.brunsoares.crud_spring.dto.CourseDTO;
import com.brunsoares.crud_spring.dto.CoursePageDTO;
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

    public CoursePageDTO getAllCourses(int page, int size) {
        Page<Course> pageCourse = courseRepository.findAll(PageRequest.of(page, size));
        List<CourseDTO> courses = pageCourse.getContent().stream().map(courseMapper::toDTO).toList();
        return new CoursePageDTO(courses, pageCourse.getTotalElements(), pageCourse.getTotalPages());
    }

    public CourseDTO getByIdCourse(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDTO).orElseThrow(() -> new NotFoundException(id));
    }

    public CourseDTO createCourse(CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO updateCourse(Long id, CourseDTO course) {
        return courseRepository.findById(id).map(existingCourse -> {
            Course courseToUpdate = courseMapper.toEntity(course);
            existingCourse.setName(courseToUpdate.getName());
            existingCourse.setCategory(courseToUpdate.getCategory());
            existingCourse.getLessons().clear();
            courseToUpdate.getLessons().forEach(lesson -> {
                lesson.setCourse(existingCourse);
                existingCourse.getLessons().add(lesson);
            });
            Course updatedCourse = courseRepository.save(existingCourse);
            return courseMapper.toDTO(updatedCourse);
        }).orElseThrow(() -> new NotFoundException(id));
    }

    public void deleteCourse(Long id) {
        courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new NotFoundException(id)));
    }
}
