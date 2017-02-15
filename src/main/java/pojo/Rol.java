package pojo;
import java.util.List;

/**
 * Created by jmunarb on 03/02/17.
 */

public class Rol {

    private List<User> llistaUsuaris;

    private String nomRol;
    private String descripcioRol;

    public Rol(String nom, String desc) {
        this.nomRol = nom;
        this.descripcioRol = desc;
    }

    public Rol(String nom, List<User> userList) {
        this.nomRol = nom;
        this.llistaUsuaris = userList;
    }

    public Rol() {
    }

    public Rol(String nom) {
        this.nomRol = nom;
    }

    public List<User> getLlistaUsuaris() {
        return llistaUsuaris;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public void setLlistaUsuaris(List<User> llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }

    public String getDescripcioRol() {
        return descripcioRol;
    }

    public void setDescripcioRol(String descripcioRol) {
        this.descripcioRol = descripcioRol;
    }
}

