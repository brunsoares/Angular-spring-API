package com.brunsoares.crud_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LessonDTO(
        Long _id,
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String youtubeUrl) {

}
