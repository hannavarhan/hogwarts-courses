/*выбрать законченные курсы определенного ученика*/
SELECT courses.name, users.name, users.surname, complexity, courses.description, courses.icon, course_statuses.name, pupil_courses.mark FROM courses
    INNER JOIN users
        ON courses.id_professor=users.id_user
    INNER JOIN pupil_courses
        ON pupil_courses.id_course=courses.id_course
               AND pupil_courses.id_course_status=
                   (SELECT course_statuses.id_course_status FROM course_statuses WHERE course_statuses.name='finished')
    INNER JOIN course_statuses
        ON courses.id_course_status=course_statuses.id_course_status
               AND pupil_courses.id_pupil=
                   (SELECT users.id_user FROM users WHERE users.login='harry' AND users.password='password');