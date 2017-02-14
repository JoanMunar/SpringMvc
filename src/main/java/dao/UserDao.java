package dao;

import pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jmunarb on 01/12/16.
 */
public interface UserDao {

    List<User> getAllUsers();

    User findUser(String nom) throws SQLException;
    User findUser(String nom,boolean fillRoll);

}
