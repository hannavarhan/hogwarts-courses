package com.epam.hogwarts.model.mapper.impl;

import com.epam.hogwarts.model.entity.Answer;
import com.epam.hogwarts.model.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.model.dao.ColumnName.*;

public class AnswerMapper implements RowMapper<Answer> {

    @Override
    public Answer mapRow(ResultSet resultSet) throws SQLException {
        long answerId = resultSet.getLong(ANSWER_ID);
        long questionId = resultSet.getLong(ANSWER_QUESTION_ID);
        String answerText = resultSet.getString(ANSWER_TEXT);
        boolean isCorrect = resultSet.getBoolean(ANSWER_IS_CORRECT);
        Answer answer = new Answer(answerId, questionId, answerText, isCorrect);
        return answer;
    }
}
