package com.epam.hogwarts.mapper.impl;

import com.epam.hogwarts.entity.Theory;
import com.epam.hogwarts.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.dao.ColumnName.*;

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
