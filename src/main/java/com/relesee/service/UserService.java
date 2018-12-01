package com.relesee.service;

import com.relesee.domains.User;

import javax.servlet.http.HttpSession;

/**
 * @author HanLin
 * 所有系统用户相关操作都在这里完成
 */
public interface UserService {
    /**
     *
     * @param user
     * @return
     * true表示user登录成功，false失败
     */
    boolean UserLogin(HttpSession session, User user);

}
