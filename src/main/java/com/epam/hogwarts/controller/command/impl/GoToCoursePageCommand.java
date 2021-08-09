package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.Command;
import com.epam.hogwarts.controller.command.CommandResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GoToCoursePageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(GoToPupilPersonalPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return null;
    }
}
