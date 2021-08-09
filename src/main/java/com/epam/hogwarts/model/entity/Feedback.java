package com.epam.hogwarts.model.entity;

public class Feedback extends AbstractEntity {
    private String comment;
    private int estimator;
    private long courseId;
    private long pupilId;

    public Feedback(long entityId, String comment, int estimator, long courseId, long pupilId) {
        super(entityId);
        this.comment = comment;
        this.estimator = estimator;
        this.courseId = courseId;
        this.pupilId = pupilId;
    }

    public String getComment() {
        return comment;
    }

    public int getEstimator() {
        return estimator;
    }

    public long getCourseId() {
        return courseId;
    }

    public long getPupilId() {
        return pupilId;
    }
}
