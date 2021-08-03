package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.Command;
import com.epam.hogwarts.controller.command.CommandResult;
import com.epam.hogwarts.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class GoToAdminPersonalPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(PagePath.ADMIN_PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
    }
}
