package repositories;

import java.util.ArrayList;
import java.util.List;

import data.entities.Usuario;

public class UsuarioRepository {

    List<Usuario> usuarios;
    public UsuarioRepository(){
        usuarios=new ArrayList<>();
        usuarios.add(new Usuario("jorge","aveces"));
        usuarios.add(new Usuario("lues","contraseña"));
    }


    public List<Usuario> getUsarios(){
        return usuarios;
    }
    
}
