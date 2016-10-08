package us.waw.gaara.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.waw.gaara.dao.entity.User;

/**
 * Created by lenn on 16/10/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void getUserById(){
        User user = userDao.getUserByUserId("gsm");
        System.out.println(user.getNickname());
    }

    @Test
    public void saveUser(){
        User user = new User("gsm", "youshenbubai", "管哥");
        int affectLineNumber = userDao.saveUser(user);
        System.out.println(affectLineNumber);
        System.out.println(user);
    }
}
