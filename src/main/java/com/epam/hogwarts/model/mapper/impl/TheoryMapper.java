package com.epam.hogwarts.model.mapper.impl;

import com.epam.hogwarts.model.entity.Theory;
import com.epam.hogwarts.model.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.model.dao.ColumnName.*;

public class TheoryMapper implements RowMapper<Theory> {

    @Override
    public Theory mapRow(ResultSet resultSet) throws SQLException {
        long theoryId = resultSet.getLong(THEORY_ID);
        String text = resultSet.getString(THEORY_TEXT);
        int number = resultSet.getInt(THEORY_NUMBER);
        long courseId = resultSet.getLong(THEORY_COURSE_ID);
        Theory theory = new Theory(theoryId, text, number, courseId);
        return theory;
    }
}
