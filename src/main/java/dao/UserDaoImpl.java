package dao;

/**
 * Created by alea on 11/01/2017.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dbc.DataBaseConection;
import pojo.Rol;
import pojo.User;

public class UserDaoImpl implements UserDao {

    private DataBaseConection dbc;

    public UserDaoImpl() {

    }

    public List<User> getAllUsers() throws SQLException {

        String sql = "SELECT * FROM dwes.user";
        ArrayList<User> userList = new ArrayList<User>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String uname = rs.getString("user.user_name");

            User user = new User(uname);
            userList.add(user);

        }
        return userList;

    }

    public User findUser(String nom) throws SQLException {

        String sql = "SELECT user.user_name FROM dwes.user WHERE user.user_name=?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, nom);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String uname = rs.getString("user.user_name");
            User user = new User(uname);

            return user;
        }
        return null;

    }

    public User findUser(String nom, boolean fillRoll) throws SQLException {

        if (fillRoll) {

            String sql = "SELECT user.user_name,user_roles.role_name FROM user,roles,user_roles WHERE user.user_name=? AND roles.role_name=user_roles.role_name AND user.user_name=user_roles.user_name";
            List<Rol> rols = new ArrayList<Rol>();
            PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();

            String usuari = "";
            while (rs.next()) {
                usuari = rs.getString("user.user_name");
                rols.add(new Rol(rs.getString("user_roles.role_name")));

            }
            return new User(usuari, rols);

        } else {
            return findUser(nom);

        }
    }

    public void altaUser(String nom, String password, String[] rols) throws SQLException {

        String sql = "INSERT INTO dwes.user VALUES(?,?)";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, nom);
        ps.setString(2, password);
        ps.execute();

        sql = "INSERT INTO user_roles VALUES(?,?)";

        for (int i = 0; i < rols.length; i++) {

            ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, rols[i]);
            ps.execute();
        }

    }

    public void modUser(String nom,String nouNom, List<Rol> rols) throws SQLException {

        String sql = "DELETE FROM dwes.user_roles WHERE user_name=?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, nom);
        ps.execute();

        sql = "UPDATE dwes.user SET user_name=? WHERE user.user_name=?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, nouNom);
        ps.setString(2, nom);
        ps.execute();

        sql = "INSERT INTO dwes.user_roles VALUES(?,?)";

        for(Rol rol : rols) {
            ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
            ps.setString(1, nouNom);
            ps.setString(2, rol.getNomRol());
            ps.execute();
        }

    }

    public void baixaUser(String nom) throws SQLException {

        String sql = "DELETE FROM dwes.user_roles WHERE user_name=?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, nom);
        ps.execute();

        sql = "DELETE FROM dwes.user WHERE user_name=?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, nom);
        ps.execute();

    }

}


