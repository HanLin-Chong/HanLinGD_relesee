package com.relesee;


import com.relesee.dao.UserDao;
import com.relesee.domains.User;
import com.relesee.framework.sax.AssemblyPlant;
import com.relesee.framework.sax.utils.SaxUtil;
import com.relesee.utils.RedisUtil;
import org.junit.Test;
import com.relesee.framework.sax.domains.*;


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
        User u = userDao.selectUserById("MSID_0000005");
        System.out.println(u.getUserName());
    }



}
