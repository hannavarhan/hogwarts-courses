package com.epam.hogwarts.controller;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Controller.class);
    private final CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(RequestParameter.COMMAND);
        Command command = commandProvider.getCommand(commandName);
        CommandResult commandResult = command.execute(request);
        switch (commandResult.getRoutingType()) {
            case REDIRECT:
                response.sendRedirect(commandResult.getPage());
                break;
            case FORWARD:
                RequestDispatcher dispatcher = request.getRequestDispatcher(commandResult.getPage());
                dispatcher.forward(request, response);
                break;
            default:
                logger.error("incorrect route type {}", commandResult.getRoutingType());
                response.sendRedirect(PagePath.ERROR_PAGE);
        }
    }
}