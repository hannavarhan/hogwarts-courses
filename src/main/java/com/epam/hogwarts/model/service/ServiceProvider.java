package com.epam.hogwarts.model.service;

import com.epam.hogwarts.model.service.impl.*;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();
    private static final UserService userService = new UserServiceImpl();
    private static final CourseService courseService = new CourseServiceImpl();
    private static final EmailNotificationSenderService emailService = new EmailNotificationSenderServiceImpl();
    private static final TelegramNotificationSenderService telegramService = new TelegramNotificationSenderServiceImpl();
    private static final FeedbackService feedbackService = new FeedbackServiceImpl();

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

    public EmailNotificationSenderService getEmailService() {
        return emailService;
    }

    public TelegramNotificationSenderService getTelegramService() {
        return telegramService;
    }

    public FeedbackService getFeedbackService() {
        return feedbackService;
    }
}
