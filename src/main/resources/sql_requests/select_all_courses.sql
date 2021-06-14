/*возвращает все активные (созданные курсы). Надо ли тут исключать начатые и пройденные курсы для конкретного ученика?
Наверное, надо сделать отдельный запрос для ученика, а этот выдавать гостю*/
SELECT courses.name, rating, complexity, courses.description FROM hogwarts_courses.courses
INNER JOIN hogwarts_courses.course_statuses
ON hogwarts_courses.courses.id_course_status=hogwarts_courses.course_statuses.id_course_status
WHERE hogwarts_courses.course_statuses.name='active';