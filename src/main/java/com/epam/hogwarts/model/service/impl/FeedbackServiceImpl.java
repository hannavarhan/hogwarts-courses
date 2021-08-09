package com.epam.hogwarts.model.service.impl;

import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.dao.DaoProvider;
import com.epam.hogwarts.model.dao.FeedbackDao;
import com.epam.hogwarts.model.entity.Feedback;
import com.epam.hogwarts.model.service.FeedbackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private static final DaoProvider daoProvider = DaoProvider.getInstance();
    private static final FeedbackDao feedbackDao = daoProvider.getFeedbackDao();
    private static final Logger logger = LogManager.getLogger(FeedbackServiceImpl.class);

    @Override
    public List<Feedback> findFeedbackByCourse(long courseId) throws ServiceException {
        try {
            List<Feedback> result = feedbackDao.findByCourse(courseId);
            return result;
        } catch (DaoException e) {
            logger.error("Error in findFeedbackByCourse");
            throw new ServiceException("Error while findFeedbackByCourse", e);
        }
    }
}
