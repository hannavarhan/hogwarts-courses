package com.epam.hogwarts.mapper.impl;

import com.epam.hogwarts.entity.Question;
import com.epam.hogwarts.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.dao.ColumnName.*;

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
