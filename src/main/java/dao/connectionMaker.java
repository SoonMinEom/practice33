package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface connectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}