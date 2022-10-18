package dao;

import domain.User;

import java.sql.*;
import java.util.Map;

public abstract class AbstractUserDao {

    abstract Connection getConnection() throws ClassNotFoundException, SQLException ;

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, password) VALUE(?,?,?)"
        );

        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User select(String id) throws ClassNotFoundException, SQLException {

        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT id, name, password FROM users WHERE id = ?"
        );

        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        AbstractUserDao userDao = new AbstractUserDao();
//        //userDao.add(new User("21","lion2","54321"));
//        User user = userDao.select("21");

    }
}
