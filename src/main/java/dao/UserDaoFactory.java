package dao;

public class UserDaoFactory {
    // 조립하는 역할
    public UserDao aUserDao() {

        AConnectionMaker acm = new AConnectionMaker();
        UserDao userDao = new UserDao(acm);

        return userDao;
    }

//    public UserDao bUserDao() {
//
//        UserDao userDao = new UserDao(new BConnectionMaker());
//
//        return userDao;
//    }
}
