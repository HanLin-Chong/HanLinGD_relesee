package com.relesee.controller;

import com.relesee.domains.User;
import com.relesee.service.UserService;
import com.relesee.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        System.out.println(user.getUserName());
    }

    /*
    public void userLogin(User user, HttpServletRequest request, HttpServletResponse response){
        //在spring-applicationcontext/domains.xml中配置了user模型,spring将请求中的参数自动封装为user


        if( userService.UserLogin(user) ){

            request.getSession().setAttribute("currentUserId",user.getUserId());

            if( StringUtils.startsWith(user.getUserId(),"MSID") ){
                //经理
                logger.info("客户经理"+user.getUserId()+":"+user.getUserName()+"登录系统");

                try {
                    logger.info("客户经理"+user.getUserId()+":"+user.getUserName()+"重定向至客户经理页");
                    request.getRequestDispatcher("../CustomerManager.jsp").forward(request,response);
                } catch (Exception e) {
                    logger.fatal("客户经理"+user.getUserId()+":"+user.getUserName()+"重定向至客户经理页出错:(详细信息)"+
                            e.getMessage()+"(原因)"+e.getCause()+"(stackTrace)"+e.getStackTrace());
                }
            } else if ( StringUtils.startsWith(user.getUserId(),"LDID") || StringUtils.startsWith(user.getUserId(),"LDID") ){
                //审核员或领导
                logger.info("审核员"+user.getUserId()+":"+user.getUserName()+"登录系统");
                try {
                    logger.info("审核员"+user.getUserId()+":"+user.getUserName()+"重定向至审核员页");
                    request.getRequestDispatcher("../Auditor.jsp").forward(request,response);
                    //response.sendRedirect("../Auditor.jsp");
                } catch (Exception e){
                    logger.fatal("审核员"+user.getUserId()+":"+user.getUserName()+"重定向至审核员页出错:(详细信息)"+
                            e.getMessage()+"(原因)"+e.getCause()+"(stackTrace)"+e.getStackTrace());
                }

            } else if ( StringUtils.equals(user.getUserId(),"root") ){
                //root
                //开发用的，不记录日志，自己调跳到哪
                try {
                    response.sendRedirect("../Auditor.jsp");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        }


    }
    */
}
