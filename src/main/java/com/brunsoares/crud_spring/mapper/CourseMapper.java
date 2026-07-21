package com.brunsoares.crud_spring.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brunsoares.crud_spring.dto.CourseDTO;
import com.brunsoares.crud_spring.dto.LessonDTO;
import com.brunsoares.crud_spring.model.Course;
import com.brunsoares.crud_spring.model.Lesson;

@Component
public class CourseMapper {

    private final LessonMapper lessonMapper;

    public CourseMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    public CourseDTO toDTO(Course course) {
        List<LessonDTO> lessons = course.getLessons().stream().map(lessonMapper::toDTO).toList();
        return new CourseDTO(course.getId(), course.getName(), course.getCategory(), lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {
        List<Lesson> lessons = courseDTO.lessons().stream().map(lessonMapper::toEntity).toList();
        return new Course(courseDTO.name(), courseDTO.category(), lessons);
    }
}
