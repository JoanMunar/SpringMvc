package dao;

import dbc.DataBaseConection;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private DataBaseConection database;

    public UserDaoImpl(DataBaseConection database) {
        this.database = database;
    }

    @Override
    public List<User> getAllUsers() {

        return database.getAllUsers();
    }

    @Override
    public User findUser(String nom) throws SQLException {
        return database.findUser(nom);
    }

    @Override
    public User findUser(String nom, boolean fillRoll) {
        return database.findUser(nom,fillRoll);
    }
}