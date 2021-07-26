package services;

import java.util.List;

import org.springframework.stereotype.Service;

import data.entities.Usuario;
import repositories.UsuarioRepository;

@Service
public class AuthService {

   
    UsuarioRepository usuarioRepository;

    public AuthService(){
        usuarioRepository = new UsuarioRepository();
    }


    public Usuario login(Usuario usuario){

        List<Usuario> users=usuarioRepository.getUsarios();
        
        for (Usuario u : users) {
            if (u.getUsername().equals(usuario.getUsername()) && u.getClave().equals(usuario.getClave())) {
                return usuario;
            }
        }
        return null;
    }
    
}
