package com.relesee.controller;

import com.relesee.domains.User;
import com.relesee.service.UserService;
import com.relesee.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("login")
    public void userLogin(User user, HttpSession session, HttpServletResponse response){

        boolean isUser = userService.UserLogin(session, user);
        try {
            if (isUser){
                response.getWriter().write("1");
            } else {
                response.getWriter().write("0");
            }
        } catch (Exception e){
            logger.fatal("返回登录结果时出错",e);
        }
    }

    @RequestMapping("distribute")
    public void userLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user = (User) session.getAttribute("user");
        String role = user.getRole();
        if (StringUtils.equals(role, "root")){
            //TODO
            try {
                response.sendRedirect("../root.html");
            } catch (Exception e){
                e.printStackTrace();
                logger.fatal("root用户登录重定向出错");
            }
        } else if (StringUtils.equals(role, "auditor")){
            try {
                response.sendRedirect("../Auditor.jsp");
            } catch (Exception e){
                e.printStackTrace();
                logger.fatal("重定向至审核员主页出错", e);
            }
        } else if (StringUtils.equals(role, "manager")){
            try {
                response.sendRedirect("../CustomerManage.jsp");
            } catch (Exception e){
                e.printStackTrace();
                logger.fatal("重定向至客户经理首页出错", e);
            }
        } else {
            try {
                response.sendRedirect("../error.jsp?error=1");
                session.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
                logger.fatal("重定向至错误页出错", e);
            }
        }

    }


}
