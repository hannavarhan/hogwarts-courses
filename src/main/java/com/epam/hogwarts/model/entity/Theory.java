package com.epam.hogwarts.model.entity;

public class Theory extends Block {
    private String text;
    private int number;
    private long courseId;

    public Theory(long entityId, String text, int number, long courseId) {
        super(entityId);
        this.text = text;
        this.number = number;
        this.courseId = courseId;
    }

    public Theory(long entityId) {
        super(entityId);
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

    public void setText(String text) {
        this.text = text;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
