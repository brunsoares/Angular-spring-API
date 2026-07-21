package com.brunsoares.crud_spring.enums;

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

    @Override
    public String toString() {
        return description;
    }

}
