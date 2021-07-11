package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.AbstractEntity;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends AbstractEntity> {

    Optional<T> findById(Long id) throws DaoException;

    T insert(T entity) throws DaoException;
}
