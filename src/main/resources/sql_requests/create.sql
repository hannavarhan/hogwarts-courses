CREATE TABLE `answers` (
                           `id_answer` int unsigned NOT NULL AUTO_INCREMENT,
                           `id_question` int unsigned NOT NULL,
                           `answer` varchar(45) NOT NULL,
                           `is_correct` bit(1) NOT NULL DEFAULT b'0',
                           PRIMARY KEY (`id_answer`),
                           UNIQUE KEY `id_UNIQUE` (`id_answer`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE `course_statuses` (
                                   `id_course_status` tinyint unsigned NOT NULL AUTO_INCREMENT,
                                   `status_name` varchar(30) NOT NULL,
                                   PRIMARY KEY (`id_course_status`),
                                   UNIQUE KEY `id_course_statuse_UNIQUE` (`id_course_status`),
                                   UNIQUE KEY `name_UNIQUE` (`status_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `courses` (
                           `id_course` int NOT NULL AUTO_INCREMENT,
                           `id_professor` int NOT NULL,
                           `name` varchar(50) NOT NULL,
                           `rating` float(3,2) NOT NULL DEFAULT '0.00',
  `complexity` tinyint unsigned NOT NULL,
  `creation_date` date NOT NULL,
  `is_actual` bit(1) NOT NULL DEFAULT b'1',
  `description` text,
  `conclusion` text,
  `icon` blob,
  PRIMARY KEY (`id_course`),
  UNIQUE KEY `id_course_UNIQUE` (`id_course`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `feedback` (
                            `id` int NOT NULL,
                            `comment` text NOT NULL,
                            `estimator` float(3,2) unsigned NOT NULL,
  `id_course` int unsigned NOT NULL,
  `id_pupil` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pupil_courses` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `id_course` int NOT NULL,
                                 `id_pupil` int NOT NULL,
                                 `id_course_status` tinyint unsigned NOT NULL,
                                 `start_date` date NOT NULL,
                                 `mark` int unsigned NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `questions` (
                             `id_question` int NOT NULL AUTO_INCREMENT,
                             `text` text NOT NULL,
                             `number` int unsigned NOT NULL,
                             `id_course` int unsigned NOT NULL,
                             PRIMARY KEY (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `rating` (
                          `id_rate` tinyint unsigned NOT NULL AUTO_INCREMENT,
                          `rating_name` varchar(30) NOT NULL,
                          `lower_bound` float(3,2) unsigned NOT NULL,
  `upper_bound` float(3,2) unsigned NOT NULL,
  PRIMARY KEY (`id_rate`),
  UNIQUE KEY `id_rate_UNIQUE` (`id_rate`),
  UNIQUE KEY `name_UNIQUE` (`rating_name`),
  UNIQUE KEY `lower_bound_UNIQUE` (`lower_bound`),
  UNIQUE KEY `upper_bound_UNIQUE` (`upper_bound`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
                         `id_role` tinyint unsigned NOT NULL AUTO_INCREMENT,
                         `role_name` varchar(15) NOT NULL,
                         PRIMARY KEY (`id_role`),
                         UNIQUE KEY `id_role_UNIQUE` (`id_role`),
                         UNIQUE KEY `name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `theory` (
                          `id_theory` int NOT NULL AUTO_INCREMENT,
                          `text` mediumtext NOT NULL,
                          `number` int unsigned NOT NULL,
                          `id_course` int unsigned NOT NULL,
                          PRIMARY KEY (`id_theory`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
                         `id_user` int unsigned NOT NULL AUTO_INCREMENT,
                         `login` varchar(15) NOT NULL,
                         `password` varchar(12) NOT NULL,
                         `id_role` tinyint unsigned NOT NULL,
                         `status` varchar(45) NOT NULL DEFAULT 'not_confirmed',
                         `rating` float(3,2) NOT NULL DEFAULT '0.00',
  `name` varchar(15) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `email` varchar(255) NOT NULL,
  `avatar` blob,
  `about` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8;

