package com.relesee.filter;

import com.relesee.domains.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestFilter extends OncePerRequestFilter {

    private static Logger logger = Logger.getLogger(RequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 不过滤的uri,先写死，之后记得写到配置文件里
        String[] notFilter = new String[] { "login.html", "error.jsp", "user/login", "/css", "/js", "/assets", "/easyui", "/fonts", "/img", "/less"};



        String requestURI = request.getRequestURI();//请求相对路径
        StringBuffer requestURL = request.getRequestURL();//请求绝对路径

        //默认状态：需要过滤，false为不需要过滤
        boolean needFilter = true;
        for (String s:notFilter){
            if (requestURI.contains(s)){
                needFilter = false;
            }
        }
        if (needFilter){
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null){
                response.sendRedirect("error.jsp?error=2");
            } else {
                chain.doFilter(request, response);
            }


        } else {
            chain.doFilter(request, response);
        }




    }
}
