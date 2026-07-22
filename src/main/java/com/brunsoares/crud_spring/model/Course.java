package com.brunsoares.crud_spring.model;

import java.util.ArrayList;
import java.util.List;

import com.brunsoares.crud_spring.enums.Category;
import com.brunsoares.crud_spring.enums.converters.CategoryConverter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(length = 20, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<>();

    public Course(String name, Category category, List<Lesson> lessons) {
        this.name = name;
        this.category = category;
        this.lessons = lessons;
    }

    public Course() {
    }
}
