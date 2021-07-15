package com.epam.hogwarts.entity;

public enum CourseStatus {
    ACTIVE("active"),
    DELETED("deleted"),
    FINISHED("finished"),
    IN_PROGRESS("in_progress"),
    STARTED("started");

    private String title;

    CourseStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
