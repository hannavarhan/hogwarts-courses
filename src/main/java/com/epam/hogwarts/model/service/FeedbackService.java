package com.epam.hogwarts.model.service;

import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> findFeedbackByCourse(long courseId) throws ServiceException;
}
