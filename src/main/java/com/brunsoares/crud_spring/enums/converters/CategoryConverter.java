package com.brunsoares.crud_spring.enums.converters;

import java.util.stream.Stream;

import com.brunsoares.crud_spring.enums.Category;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getDescription();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Category.values())
                .filter(c -> c.getDescription().equals(dbData))
                .findFirst()
                .orElse(null);
    }

}
