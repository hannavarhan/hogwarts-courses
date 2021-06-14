/*Выбрать все активные начатые курсы для определенного ученика*/
SELECT courses.name, users.name, users.surname, complexity, courses.description, courses.icon FROM courses
INNER JOIN users
ON courses.id_professor=users.id_user
INNER JOIN pupil_courses AS pupils
ON pupils.id_course=courses.id_course
AND (pupils.id_course_status=
    (SELECT course_statuses.id_course_status FROM course_statuses WHERE course_statuses.name='started')
OR pupils.id_course_status=
    (SELECT course_statuses.id_course_status FROM course_statuses WHERE course_statuses.name='in_progress'))
INNER JOIN course_statuses
ON courses.id_course_status=course_statuses.id_course_status
WHERE course_statuses.name='active'
  AND pupils.id_pupil=
      (SELECT users.id_user FROM users WHERE users.login='harry' AND users.password='password');