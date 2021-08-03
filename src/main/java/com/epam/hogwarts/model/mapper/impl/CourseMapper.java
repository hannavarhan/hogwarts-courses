package com.epam.hogwarts.model.mapper.impl;

import com.epam.hogwarts.model.entity.Course;
import com.epam.hogwarts.model.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.model.dao.ColumnName.*;

public class CourseMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet resultSet) throws SQLException {
        Course course = new Course.Builder()
                .setCourseId(resultSet.getLong(COURSE_ID))
                .setProfessorId(resultSet.getLong(COURSE_PROFESSOR_ID))
                .setName(resultSet.getString(COURSE_NAME))
                .setRating(resultSet.getDouble(COURSE_RATING))
                .setComplexity(resultSet.getInt(COURSE_COMPLEXITY))
                .setCreationDate(resultSet.getDate(COURSE_CREATION_DATE))
                .setIsActual(resultSet.getBoolean(COURSE_IS_ACTUAL))
                .setDescription(resultSet.getString(COURSE_DESCRIPTION))
                .setConclusion(resultSet.getString(COURSE_CONCLUSION))
                .setIcon(resultSet.getBytes(COURSE_ICON))
                .build();
        return course;
    }
}
