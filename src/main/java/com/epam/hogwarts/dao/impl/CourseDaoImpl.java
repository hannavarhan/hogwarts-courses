package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.BaseDao;
import com.epam.hogwarts.dao.CourseDao;
import com.epam.hogwarts.dao.JdbcTemplate;
import com.epam.hogwarts.entity.Course;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.impl.CourseMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class CourseDaoImpl implements CourseDao {

    private static final String SQL_SELECT_COURSE_BY_ID = "SELECT id_course, id_professor, " +
            "courses.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon " +
            "FROM hogwarts_courses.courses " +
            "WHERE id_course=?;";

    private JdbcTemplate<Course> jdbcTemplate;

    private CourseDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    @Override
    public Optional<Course> findById(Long id) throws DaoException {
        Optional<Course> result = jdbcTemplate.query(SQL_SELECT_COURSE_BY_ID, new CourseMapper());
        return result;
    }

    @Override
    public Optional<Course> insert(Course entity) throws DaoException {
        return Optional.empty();
    }

    @Override
    public int update(Course entity) throws DaoException {
        return 0;
    }

    @Override
    public List<Course> findCoursesByActual(boolean isActual) throws DaoException {
        return null;
    }

    @Override
    public List<Course> findCoursesByProfessor(long professorId) throws DaoException {
        return null;
    }
}
