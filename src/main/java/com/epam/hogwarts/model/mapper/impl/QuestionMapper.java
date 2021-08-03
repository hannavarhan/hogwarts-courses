package com.epam.hogwarts.model.mapper.impl;

import com.epam.hogwarts.model.entity.Question;
import com.epam.hogwarts.model.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.model.dao.ColumnName.*;

public class QuestionMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet resultSet) throws SQLException {
        long questionId = resultSet.getLong(QUESTION_ID);
        String text = resultSet.getString(QUESTION_TEXT);
        int number = resultSet.getInt(QUESTION_NUMBER);
        long courseId = resultSet.getLong(QUESTION_COURSE_ID);
        Question question = new Question(questionId, text, number, courseId);
        return question;
    }
}
