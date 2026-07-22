package com.brunsoares.crud_spring.enums;

import java.util.Arrays;

public enum Category {
    BACKEND("Backend"),
    FRONTEND("Frontend"),
    PROGRAMMING("Programming");

    private final String description;

    private Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Category fromDescription(String description) {
        return Arrays.stream(values())
                .filter(category -> category.description.equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return description;
    }

}
