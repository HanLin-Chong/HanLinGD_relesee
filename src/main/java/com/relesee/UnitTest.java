package com.relesee;


import com.relesee.Thread.ThreadSon;
import com.relesee.dao.UserDao;
import com.relesee.domains.User;
import com.relesee.service.impl.UserServiceImpl;
import com.relesee.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application*.xml"})
public class UnitTest {
    @Autowired
    RedisUtil redis;
    @Autowired
    UserDao userDao;

    @Test
    public void doTest(){
       User u = userDao.selectUserById("root");
       //从数据库中的user表取出id为root的用户，返回结果为User U
    }

    @Test
    public void normalTest(){
        /*
        Runnable r = new ThreadSon();
        Thread a = new Thread(){
            @Override
            public void run(){
                logger.fatal("Thread A");
            }
        };
        Thread b = new Thread(){
            @Override
            public void run(){
                logger.fatal("Thread B");
            }
        };
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
        */
        User user = new User();
        user.setUserName("hanlin");
        user.setPhone("18367025336");
        redis.set("hello",user);
        redis.set("h","youxi");
        User u = (User)redis.get("hello");
        System.out.println(u.getUserName()+":"+u.getPhone());
        System.out.println(redis.get("h"));

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
