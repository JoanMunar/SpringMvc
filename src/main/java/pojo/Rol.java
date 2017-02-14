package pojo;

/**
 * Created by jmunarb on 03/02/17.
 */
public class Rol {

    String rol;
    String descripcio;

    public Rol(String rol, String desc) {
        this.rol = rol;
        this.descripcio = desc;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String nom) {
        this.rol = rol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

}
