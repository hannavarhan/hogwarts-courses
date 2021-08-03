package com.epam.hogwarts.model.dao;

import com.epam.hogwarts.model.entity.AbstractEntity;
import com.epam.hogwarts.exception.DaoException;

import java.util.Optional;

public interface BaseDao<T extends AbstractEntity> {

    Optional<T> findById(Long id) throws DaoException;

    Optional<T> insert(T entity) throws DaoException;

    int update(T entity) throws DaoException;
}
