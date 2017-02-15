package dao;

/**
 * Created by alea on 15/02/2017.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dbc.DataBaseConection;
import pojo.Rol;
import pojo.User;


public class RolDaoImpl implements RolDao {

    private DataBaseConection dbc;

    public RolDaoImpl() {

    }

    public List<Rol> getAllRols() throws SQLException {
        /*Inici Sql*/
        String sql = "SELECT * FROM dwes.roles";
        List<Rol> rols = new ArrayList<Rol>();

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            String nom = rs.getString("roles.role_name");
            String desc = rs.getString("roles.role_description");

            Rol rol = new Rol(nom, desc);
            rols.add(rol);

        }
        return rols;

    }

    public Rol obtenirRol(String rol) throws SQLException {
        /*Inici Sql*/
        String sql = "SELECT roles.role_name,user_roles.user_name FROM user,roles,user_roles WHERE roles.role_name=? AND roles.role_name=user_roles.role_name AND user.user_name=user_roles.user_name";

        List<User> llistaUsuaris = new ArrayList<User>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(1, rol);
        ResultSet rs = ps.executeQuery();

        String nom = "";

        while (rs.next()) {
            nom = rs.getString("roles.role_name");
            llistaUsuaris.add(new User(rs.getString("user_roles.user_name")));

        }
        return new Rol(nom, llistaUsuaris);

    }

    public void altaRol(String rol, String roleDesc) throws SQLException {
        /*Inici Sql*/
        String sql = "INSERT INTO dwes.roles VALUES(?,?)";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, rol);
        ps.setString(2, roleDesc);

        ps.execute();

    }

    public void modRol(String rol, String nouRol, List<User> llistaUsuaris) throws SQLException {
        /*Inici Sql*/
        String sql =  "DELETE FROM dwes.user_roles WHERE role_name=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, rol);
        ps.execute();

        sql = "UPDATE dwes.roles SET role_name=? WHERE roles.role_name=?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, nouRol);
        ps.setString(2, rol);
        ps.execute();

        sql = "INSERT INTO dwes.user_roles VALUES(?,?)";
        for(User user : llistaUsuaris) {
            ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
            ps.setString(1, user.getNom());
            ps.setString(2, nouRol);
            ps.execute();

        }

    }

    public void baixaRol(String rol) throws SQLException {
        /*Inici Sql per eliminar el rol de user_roles*/
        String sql = "DELETE FROM dwes.user_roles WHERE role_name=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, rol);
        ps.execute();

        /*Inici Sql per eliminar el rol de roles | Eliminam a ambdos bandes per tema de foreign key*/
        sql = "DELETE FROM dwes.roles WHERE role_name=?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, rol);
        ps.execute();

    }

}
