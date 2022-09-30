package com.nj.filter;


import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-14 10:27
 */
/*@WebFilter("/*")*/
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        System.out.println(request.getRequestURI());

        if (url.contains(".jpg") || url.contains(".png") || url.contains("forward/toLogin")
            || url.contains("user/login") || url.contains("code") || url.contains(".css") || url.contains(".js")
        ){
            filterChain.doFilter(request,response);

            return;
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (null == user){
            System.out.println(user);
            response.sendRedirect("/forward/toLogin");
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
