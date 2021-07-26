package data.entities;

public class Usuario {

    String username;
    String clave;
    boolean isLogIn;
    

    public boolean isLogIn() {
        return isLogIn;
    }
    public void setLogIn(boolean isLogIn) {
        this.isLogIn = isLogIn;
    }
    public Usuario() {

    }
    public Usuario(String username, String clave) {
        this.username = username;
        this.clave = clave;
        this.isLogIn=false;
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
