package com.epam.hogwarts.model.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Course extends AbstractEntity {

    private final long professorId;
    private final String name;
    private final double rating;
    private final int complexity;
    private final Date creationDate;
    private final boolean isActual;
    private final String description;
    private final String conclusion;
    private final byte[] icon;

    public Course(Builder builder) {
        super(builder.courseId);
        this.professorId = builder.professorId;
        this.name = builder.name;
        this.rating = builder.rating;
        this.complexity = builder.complexity;
        this.creationDate = builder.creationDate;
        this.isActual = builder.isActual;
        this.description = builder.description;
        this.conclusion = builder.conclusion;
        this.icon = builder.icon;
    }

    public long getProfessorId() {
        return professorId;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getComplexity() {
        return complexity;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean getIsActual() {
        return isActual;
    }

    public String getDescription() {
        return description;
    }

    public String getConclusion() {
        return conclusion;
    }

    public byte[] getIcon() {
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Course course = (Course) o;
        return professorId == course.professorId
                && Double.compare(course.rating, rating) == 0
                && complexity == course.complexity
                && isActual == course.isActual
                && name.equals(course.name)
                && creationDate.equals(course.creationDate)
                && Objects.equals(description, course.description)
                && Objects.equals(conclusion, course.conclusion)
                && Arrays.equals(icon, course.icon);
    }

    @Override
    public int hashCode() { //fixme: rewrite
        int result = Objects.hash(super.hashCode(), professorId, name, rating, complexity, creationDate, isActual, description, conclusion);
        result = 31 * result + Arrays.hashCode(icon);
        return result;
    }

    public static class Builder {
        private long courseId;
        private long professorId;
        private String name;
        private double rating;
        private int complexity;
        private Date creationDate;
        private boolean isActual;
        private String description;
        private String conclusion;
        private byte[] icon;

        public Builder setCourseId(long courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setProfessorId(long professor) {
            this.professorId = professor;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComplexity(int complexity) {
            this.complexity = complexity;
            return this;
        }

        public Builder setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder setIsActual(boolean isActual) {
            this.isActual = isActual;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setConclusion(String conclusion) {
            this.conclusion = conclusion;
            return this;
        }

        public Builder setIcon(byte[] icon) {
            this.icon = icon;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
