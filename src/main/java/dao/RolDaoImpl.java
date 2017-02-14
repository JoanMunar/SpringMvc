package dao;

import dbc.DataBaseConection;
import pojo.Rol;

import java.sql.SQLException;
import java.util.List;


public class RolDaoImpl implements RolDao {

    private DataBaseConection database;

    public RolDaoImpl(DataBaseConection database) {
        this.database = database;
    }


    @Override
    public List<Rol> getAllRoles() {
        return database.getAllRoles();
    }

    @Override
    public Rol altaRol() throws SQLException {
        return database.altaRol();
    }


    @Override
    public Rol baixaRol(String rol) throws SQLException {
        return database.baixaRol(rol);
    }

    @Override
    public Rol modRol(String rol) throws SQLException {
        return database.modRol(rol);
    }
}
