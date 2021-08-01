package com.epam.hogwarts.filter;

import com.epam.hogwarts.command.SessionAttribute;
import com.epam.hogwarts.entity.UserRole;

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
        UserRole userRole = UserRole.valueOf(session.getAttribute(SessionAttribute.USER_ROLE).toString().toUpperCase());
        //todo: пока всех юзеров на гостевую, но потом надо будет дописать, чтобы те, у кого еще имейл не подтвержден на другую страничку переходили мб
        if (userRole == null) {
            userRole = UserRole.GUEST;
            session.setAttribute(SessionAttribute.USER_ROLE, userRole);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/jsp/guest.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        filterChain.doFilter(request, response);
    }

}
