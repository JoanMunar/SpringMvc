package dao;

import pojo.Rol;

import java.sql.SQLException;
import java.util.List;


public interface RolDao {

    List<Rol> getAllRoles();

    Rol altaRol() throws SQLException;

    Rol baixaRol(String rol) throws SQLException;

    Rol modRol(String rol) throws SQLException;
}
