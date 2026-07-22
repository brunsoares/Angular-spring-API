package com.brunsoares.crud_spring.mapper;

import org.springframework.stereotype.Component;

import com.brunsoares.crud_spring.dto.LessonDTO;
import com.brunsoares.crud_spring.model.Course;
import com.brunsoares.crud_spring.model.Lesson;

@Component
public class LessonMapper {
    public LessonDTO toDTO(Lesson lesson) {
        return new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl());
    }

    public Lesson toEntity(LessonDTO lessonDTO, Course course) {
        return new Lesson(lessonDTO.name(), lessonDTO.youtubeUrl(), course);
    }
}
