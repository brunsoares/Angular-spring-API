package com.brunsoares.crud_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunsoares.crud_spring.dto.CourseDTO;
import com.brunsoares.crud_spring.dto.CoursePageDTO;
import com.brunsoares.crud_spring.service.CourseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
@Validated
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public CoursePageDTO getAllCourses(@RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(defaultValue = "5") @Positive @Max(20) Integer size) {
        return courseService.getAllCourses(page, size);
    }

    @GetMapping("/{id}")
    public CourseDTO getByIdCourse(@PathVariable @NotNull @Positive Long id) {
        return courseService.getByIdCourse(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody @Valid CourseDTO course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid CourseDTO course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable @NotNull @Positive Long id) {
        courseService.deleteCourse(id);
    }
}
