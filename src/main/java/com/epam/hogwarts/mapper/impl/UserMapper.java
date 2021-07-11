package com.epam.hogwarts.mapper.impl;

import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.entity.UserRole;
import com.epam.hogwarts.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hogwarts.dao.ColumnName.*;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = new User.Builder()
                .setUserId(resultSet.getLong(USER_ID))
                .setLogin(resultSet.getString(USER_LOGIN))
                .setRole(UserRole.valueOf(resultSet.getString(ROLE_NAME).toUpperCase()))
                .setRating(resultSet.getString(RATING_NAME))
                .setName(resultSet.getString(USER_NAME))
                .setSurname(resultSet.getString(USER_SURNAME))
                .setEmail(resultSet.getString(USER_EMAIL))
                .setAvatar(resultSet.getBlob(USER_AVATAR))
                .setAbout(resultSet.getString(USER_ABOUT))
                .build();
        return user;
    }
}