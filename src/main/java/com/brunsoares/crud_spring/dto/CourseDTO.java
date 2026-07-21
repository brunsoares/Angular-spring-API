package com.brunsoares.crud_spring.dto;

import java.util.List;

import com.brunsoares.crud_spring.enums.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseDTO(
        Long _id,
        @NotBlank @NotNull @Size(max = 100) String name,
        @NotNull Category category,
        @NotNull List<LessonDTO> lessons) {

}
