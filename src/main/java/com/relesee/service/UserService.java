package com.relesee.service;

import com.relesee.domains.User;

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
    public boolean UserLogin(User user);

}
