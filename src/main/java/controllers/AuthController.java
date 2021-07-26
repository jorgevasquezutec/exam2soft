package controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.entities.Usuario;
import services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    AuthService authService;
    String error="error";
    String message="mesage";
    String textUsuario="Usuario ";

    public AuthController(){
        authService= new AuthService();
    }

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody Usuario usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Usuario user=authService.login(usuario);
            if(user!=null){
                map.put(message,textUsuario+user.getUsername()+" logueado.");
                return new ResponseEntity<>(map,HttpStatus.OK);
            }
            else{
                map.put(message,textUsuario+usuario.getUsername()+" no encontrado.");
                return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    @PostMapping("/logout")
    public ResponseEntity<HashMap<String, Object>> logout(@RequestBody Usuario usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Usuario user=authService.login(usuario);
            if(user!=null){
                map.put(message,textUsuario+user.getUsername()+" cerro sesion.");
                return new ResponseEntity<>(map,HttpStatus.OK);
            }
            else{
                map.put(message,textUsuario+usuario.getUsername()+" no encontrado.");
                return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }
        
    
}
