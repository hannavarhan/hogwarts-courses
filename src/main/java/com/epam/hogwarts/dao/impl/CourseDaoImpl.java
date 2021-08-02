package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.CourseDao;
import com.epam.hogwarts.dao.JdbcTemplate;
import com.epam.hogwarts.entity.Course;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.impl.CourseMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class CourseDaoImpl implements CourseDao {

    private static final CourseDaoImpl instance = new CourseDaoImpl();

    private static final String SQL_SELECT_COURSE_BY_ID = "SELECT id_course, id_professor, courses.name, " +
            "courses.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon " +
            "FROM hogwarts_courses.courses " +
            "WHERE id_course=?;";

    private static final String SQL_INSERT_COURSE = "INSERT INTO hogwarts_courses.courses " +
            "(id_professor, name, courses.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SQL_UPDATE_COURSE = "UPDATE hogwarts_courses.courses SET " +
            "id_professor=?, " +
            "name=?, " +
            "courses.rating=?, " +
            "complexity=?, " +
            "creation_date=?, " +
            "is_actual=?, " +
            "description=?, " +
            "conclusion=?, " +
            "icon=? " +
            "WHERE id_course=?;";

    private static final String SQL_SELECT_COURSES_BY_ACTUAL = "SELECT id_course, id_professor, courses.name, " +
            "courses.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon " +
            "FROM hogwarts_courses.courses " +
            "WHERE is_actual=?;";

    private static final String SQL_SELECT_COURSES_BY_ACTUAL_WITH_LIMIT = "SELECT id_course, id_professor, courses.name, " +
            "courses.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon " +
            "FROM hogwarts_courses.courses " +
            "WHERE is_actual=? " +
            "LIMIT ?;";

    private static final String SQL_SELECT_COURSES_BY_PROFESSOR = "SELECT id_course, id_professor, courses.name, " +
            "courses.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon " +
            "FROM hogwarts_courses.courses " +
            "WHERE id_professor=?";

    private JdbcTemplate<Course> jdbcTemplate;

    private CourseDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    public static CourseDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Course> findById(Long id) throws DaoException {
        Optional<Course> result = jdbcTemplate.query(SQL_SELECT_COURSE_BY_ID, new CourseMapper(), id);
        return result;
    }

    @Override
    public Optional<Course> insert(Course entity) throws DaoException {
        long courseId = jdbcTemplate.insert(SQL_INSERT_COURSE,
                entity.getProfessorId(),
                entity.getName(),
                entity.getRating(),
                entity.getComplexity(),
                entity.getCreationDate(),
                entity.getIsActual(),
                entity.getDescription(),
                entity.getConclusion(),
                entity.getIcon());
        entity.setEntityId(courseId);
        return Optional.of(entity);
    }

    @Override
    public int update(Course entity) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_COURSE,
                entity.getProfessorId(),
                entity.getName(),
                entity.getRating(),
                entity.getComplexity(),
                entity.getCreationDate(),
                entity.getIsActual(),
                entity.getDescription(),
                entity.getConclusion(),
                entity.getIcon(),
                entity.getEntityId());
        return result;
    }

    @Override
    public List<Course> findCoursesByActual(boolean isActual) throws DaoException {
        List<Course> result = jdbcTemplate.queryForList(SQL_SELECT_COURSES_BY_ACTUAL, new CourseMapper(), isActual);
        return result;
    }

    @Override
    public List<Course> findCoursesByActual(boolean isActual, int limit) throws DaoException {
        List<Course> result = jdbcTemplate.queryForList(SQL_SELECT_COURSES_BY_ACTUAL_WITH_LIMIT, new CourseMapper(), isActual);
        return result;
    }

    @Override
    public List<Course> findCoursesByProfessor(long professorId) throws DaoException {
        List<Course> result = jdbcTemplate.queryForList(SQL_SELECT_COURSES_BY_PROFESSOR, new CourseMapper(), professorId);
        return result;
    }
}
