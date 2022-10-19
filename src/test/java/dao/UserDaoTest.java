package dao;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        //UserDao userDao = new UserDao(new AConnectionMaker());

        //factory 적용
        UserDao userDao = new UserDaoFactory().aUserDao();
        // User user = new User("22","lion3","45678");
        //userDao.add(user);

        User selectedUser = userDao.select("21");
        Assertions.assertEquals("lion2",selectedUser.getName());
    }
}