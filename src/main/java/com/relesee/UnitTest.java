package com.relesee;


import com.relesee.dao.UserDao;
import com.relesee.domains.User;
import com.relesee.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application*.xml"})
public class UnitTest {
    @Autowired
    UserDao userDao;

    @Test
    public void doTest(){
       User u = userDao.selectUserById("ROOT");
       System.out.println(u.getUserId()+"--"+u.getUserName());
    }

    @Test
    public void normalTest(){
        System.out.println(StringUtils.startsWith("msid_asd","MSID"));
    }
    public boolean tmp(){
        /*
        UserServiceImpl i = new UserServiceImpl();
        User user = new User();
        user.setUserId("root");
        i.UserLoggin(user);*/
        int i = 0;
        if(i == 1){


            return true;
        } else {


            return false;
        }

    }
}
