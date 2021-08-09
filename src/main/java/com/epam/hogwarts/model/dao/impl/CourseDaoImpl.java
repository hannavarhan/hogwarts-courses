package com.epam.hogwarts.model.dao.impl;

import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.dao.CourseDao;
import com.epam.hogwarts.model.dao.JdbcTemplate;
import com.epam.hogwarts.model.entity.Course;
import com.epam.hogwarts.model.entity.CourseStatus;
import com.epam.hogwarts.model.mapper.impl.CourseMapper;
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

    private static final String SQL_SELECT_COURSES_BY_USER_ID_AND_STATUS = "SELECT c.id_course, id_professor, c.name, " +
            "c.rating, complexity, creation_date, " +
            "is_actual, description, conclusion, icon " +
            "FROM hogwarts_courses.courses c " +
            "INNER JOIN pupil_courses " +
            "ON pupil_courses.id_course=c.id_course " +
            "AND pupil_courses.id_course_status= " +
            "(SELECT course_statuses.id_course_status FROM course_statuses WHERE course_statuses.status_name=?)" +
            "where pupil_courses.id_pupil=?;";

    private static final String SQL_UPDATE_IS_ACTUAL = "UPDATE hogwarts_courses.courses SET " +
            "is_actual=? " +
            "WHERE id_course=?;";

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
        List<Course> result = jdbcTemplate.queryForList(SQL_SELECT_COURSES_BY_ACTUAL_WITH_LIMIT, new CourseMapper(), isActual, limit);
        return result;
    }

    @Override
    public List<Course> findCoursesByProfessor(long professorId) throws DaoException {
        List<Course> result = jdbcTemplate.queryForList(SQL_SELECT_COURSES_BY_PROFESSOR, new CourseMapper(), professorId);
        return result;
    }

    @Override
    public List<Course> findCoursesByUserAndStatus(long userId, CourseStatus courseStatus) throws DaoException {
        List<Course> result = jdbcTemplate.queryForList(SQL_SELECT_COURSES_BY_USER_ID_AND_STATUS,
                new CourseMapper(), courseStatus.name().toLowerCase(), userId);
        return result;
    }

    @Override
    public boolean updateCourseActual(long courseId, boolean isActual) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_IS_ACTUAL, isActual, courseId);
        return result > 0;
    }
}
