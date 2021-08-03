package com.epam.hogwarts.controller.filter;

import com.epam.hogwarts.controller.command.PagePath;
import com.epam.hogwarts.controller.command.SessionAttribute;
import com.epam.hogwarts.model.entity.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/controller"
)
public class AccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object attr = session.getAttribute(SessionAttribute.USER_ROLE);
        String userRoleString = (attr == null ? UserRole.GUEST : attr).toString().toUpperCase();
        UserRole userRole = UserRole.valueOf(userRoleString);
        //todo: пока всех юзеров на гостевую, но потом надо будет дописать, чтобы те, у кого еще имейл не подтвержден на другую страничку переходили мб
        if (userRole == null) {
            userRole = UserRole.GUEST;
            session.setAttribute(SessionAttribute.USER_ROLE, userRole);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(PagePath.START_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
        filterChain.doFilter(request, response);
    }

}
