
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import trainMe.config.test.DAOTestConfig;

import trainMe.dao.implementation.*;
import trainMe.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by romab on 11/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DAOTestConfig.class)
public class DaoTests {

    @Autowired
    UserDao userDao;
    @Autowired
    ChatDao chatDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    DisciplineDao disciplineDao;
    @Autowired
    DisciplineUserLinkDao disciplineUserLinkDao;
    @Autowired
    FeedbackDao feedbackDao;
    @Autowired
    AvatarDao avatarDao;


    @Test
    public void userDaoTest (){
        User user = new User();
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setLogin("Test");
        user.setUserType("test");
//        user.setDescription("description");
        user.setBirthdayDate("date");
        user.setEmail("email");
        user.setPassword("password");

        userDao.create(user);

        User userFromDB = userDao.read(1);

        assertEquals(user.getId(), userFromDB.getId());
        assertNull( userFromDB.getAvatar());
        assertNull( userFromDB.getDescription());

        assertEquals(user.getBirthdayDate(),userFromDB.getBirthdayDate());

        userFromDB = userDao.read("Test");
        assertEquals(user.getLogin(), userFromDB.getLogin());

        List list = userDao.read("Test", "Test", "test");
        assertTrue( !list.isEmpty() && list.size() == 1);

        assertTrue(userDao.isExist(user));



        userDao.delete(user);

        assertNull(userDao.read(1));

    }


    @Test
    public void feedbackDaoTest(){

        Feedback feedback = new Feedback();
        feedback.setText("testtest");
        feedbackDao.create(feedback);

        assertEquals("testtest",feedbackDao.read(1).getText());

    }

    @Test
    public void chatDaoAndMessageDaoTest(){

        Chat chat = new Chat();
        chat.setName("name");
        chatDao.create(chat);

        assertEquals("name", chatDao.read(1).getName());


        Message message1 = new Message();
        message1.setText("text1");
        message1.setChat(chat);

        Message message2 = new Message();
        message2.setText("text2");
        message2.setChat(chat);


        messageDao.create(message1);
        messageDao.create(message2);

        List messages = messageDao.readAll();

        assertTrue( !messages.isEmpty() && messages.size()==2);

        assertEquals("text1",messageDao.read(1).getText());
        assertEquals("text2",messageDao.read(2).getText());

        messages = messageDao.getChatMessages(chat);

        assertTrue( !messages.isEmpty() && messages.size() == 2);

    }

}
