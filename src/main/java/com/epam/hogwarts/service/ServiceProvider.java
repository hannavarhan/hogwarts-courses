package com.epam.hogwarts.service;

import com.epam.hogwarts.service.impl.CourseServiceImpl;
import com.epam.hogwarts.service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();
    private static final UserService userService = new UserServiceImpl();
    private static final CourseService courseService = new CourseServiceImpl();

    private ServiceProvider() {}

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public CourseService getCourseService() {
        return courseService;
    }
}
