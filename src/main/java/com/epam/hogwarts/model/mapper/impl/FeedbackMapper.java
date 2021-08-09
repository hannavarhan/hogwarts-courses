package com.epam.hogwarts.model.mapper.impl;

import com.epam.hogwarts.model.entity.Feedback;
import com.epam.hogwarts.model.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.model.dao.ColumnName.*;

public class FeedbackMapper implements RowMapper<Feedback> {

    @Override
    public Feedback mapRow(ResultSet resultSet) throws SQLException {
        long entityId = resultSet.getLong(FEEDBACK_ID);
        String comment = resultSet.getString(FEEDBACK_COMMENT);
        int estimator = resultSet.getInt(FEEDBACK_ESTIMATOR);
        long courseId = resultSet.getLong(FEEDBACK_COURSE_ID);
        long pupilId = resultSet.getLong(FEEDBACK_PUPIL_ID);
        Feedback feedback = new Feedback(entityId, comment, estimator, courseId, pupilId);
        return feedback;
    }
}
