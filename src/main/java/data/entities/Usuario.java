package data.entities;

public class Usuario {

    String username;
    String clave;
    
    public Usuario() {

    }
    public Usuario(String usuario, String clave) {
        this.username = usuario;
        this.clave = clave;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    
}
