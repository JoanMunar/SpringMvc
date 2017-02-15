package dao;

import pojo.Rol;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alea on 05/02/2017.
 */

public interface UserDao {

    List<User> getAllUsers() throws SQLException;

    User findUser(String nom) throws SQLException;

    User findUser(String nom, boolean fillRoll) throws SQLException;

    void altaUser(String nom,String password,String[] rols) throws SQLException;

    void modUser(String nom, String nouNom, List<Rol> rols) throws SQLException;

    void baixaUser(String nom) throws SQLException;

}
