package spring.application.web.filter;

import spring.application.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"LoginFilter"},urlPatterns = {"/calc", "/delete", "/logout", "/update",
        "/admin", "/deleteUser", "/history"})
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");

        if(user != null){
            chain.doFilter(req, res);
        }else {
            res.sendRedirect("/");
        }
    }
}
