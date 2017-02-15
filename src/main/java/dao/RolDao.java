package dao;

import pojo.Rol;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alea on 05/02/2017.
 */

public interface RolDao {

    List<Rol> getAllRols() throws SQLException;

    Rol obtenirRol(String rol) throws SQLException;

    void altaRol(String rol,String descripcio) throws SQLException;

    void modRol(String rol, String nouRol, List<User> llistaUsuaris) throws SQLException;

    void baixaRol(String rol) throws SQLException;

}
