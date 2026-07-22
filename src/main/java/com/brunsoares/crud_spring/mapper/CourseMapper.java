package com.brunsoares.crud_spring.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brunsoares.crud_spring.dto.CourseDTO;
import com.brunsoares.crud_spring.dto.LessonDTO;
import com.brunsoares.crud_spring.enums.Category;
import com.brunsoares.crud_spring.model.Course;

@Component
public class CourseMapper {

    private final LessonMapper lessonMapper;

    public CourseMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    public CourseDTO toDTO(Course course) {
        List<LessonDTO> lessons = course.getLessons().stream().map(lessonMapper::toDTO).toList();
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getDescription(), lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.name());
        course.setCategory(Category.fromDescription(courseDTO.category()));
        course.setLessons(
                courseDTO.lessons().stream().map(lessonDTO -> lessonMapper.toEntity(lessonDTO, course)).toList());
        return course;
    }
}
