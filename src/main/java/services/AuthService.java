package services;

import java.util.List;

import org.springframework.stereotype.Service;

import data.entities.Usuario;
import repositories.UsuarioRepository;
import custom_exeptions.UserNotFoundExeption;
import custom_exeptions.UserIsLogOutExeption;

@Service
public class AuthService {

   
    UsuarioRepository usuarioRepository;

    public AuthService(){
        usuarioRepository = new UsuarioRepository();
    }


    public void logIn(Usuario usuario){

        List<Usuario> users=usuarioRepository.getUsarios();
        Usuario tmp=null;
        for (Usuario u : users) {
            if (u.getUsername().equals(usuario.getUsername()) && u.getClave().equals(usuario.getClave())) {
                u.setLogIn(true);
                tmp=u;
                break;
            }
        }
        if(tmp==null){
            throw new UserNotFoundExeption("No se encontro el usuario "+usuario.getUsername());
        }

    }

    public void logOut(Usuario usuario){
        if(usuarioRepository.getByName(usuario.getUsername())==null){
            throw new UserNotFoundExeption("No se encontro el usuario"+usuario.getUsername()+".");
        }
        if(usuarioRepository.getByName(usuario.getUsername()).isLogIn()){
            usuarioRepository.getByName(usuario.getUsername()).setLogIn(false);
        }
        else{
            throw new UserIsLogOutExeption("El usario "+usuario.getUsername()+" ya se encuentra deslogueado");
        }
        
    }
    
}
