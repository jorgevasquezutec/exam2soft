package controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.entities.Usuario;
import services.AuthService;

@RestController
@RequestMapping("/auth")
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
            authService.logIn(usuario);
            map.put(message,textUsuario +"logueado.");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    @PostMapping("/logout")
    public ResponseEntity<HashMap<String, Object>> logout(@RequestBody Usuario usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{

            authService.logOut(usuario);
            map.put(message,textUsuario+" cerro sesion.");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }
        
    
}
