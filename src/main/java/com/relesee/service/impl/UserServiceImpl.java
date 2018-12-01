package com.relesee.service.impl;


import com.relesee.dao.UserDao;
import com.relesee.domains.User;
import com.relesee.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @author HanLin
 * 尽量少创建对象，功能注解请看接口
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean UserLogin(HttpSession session, User user) {
        //账号或密码为空就不通过
        if( StringUtils.isBlank(user.getUserId()) || StringUtils.isBlank(user.getPassword()) ){
            System.out.println("第一个if");
            return false;
        } else {
            System.out.println("fuckyou");
            try{
                User searchedUser = userDao.selectUserById(user.getUserId());
                //验证账号密码是否一样
                //左边参数是前端传来的user，右边参数是数据库中查出来的user
                if( StringUtils.equals(user.getPassword(),searchedUser.getPassword()) ){
                    //登录成功
                    session.setAttribute("user", searchedUser);
                    return true;
                }else{
                    //登陆失败
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            }

        }

    }

}
