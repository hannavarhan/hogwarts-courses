package com.epam.hogwarts.entity;

public class Question extends AbstractEntity {

    private final String text;
    private final int number;
    private final long courseId;

    public Question(long entityId, String text, int number, long courseId) {
        super(entityId);
        this.text = text;
        this.number = number;
        this.courseId = courseId;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public long getCourseId() {
        return courseId;
    }
}
