package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmunarb on 03/02/17.
 */

public class User {

    private String password;
    private String nom;

    private List<Rol> rols = new ArrayList<Rol>();

    public User(String nom,String password) {

        this.nom = nom;
        this.password = password;

    }

    public User(String nom){
        this.nom = nom;
    }

    public User(String nom, List<Rol> rols) {
        this.nom = nom;
        this.rols = rols;
    }


    public User() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Rol> getRols() {
        return rols;
    }

    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }


}


