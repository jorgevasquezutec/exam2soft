package controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    public AuthController(){
        authService= new AuthService();
    }

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody Usuario usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Usuario user=authService.login(usuario);
            if(user!=null){
                map.put("message","Usuario "+user.getUsuario()+" logueado.");
                return new ResponseEntity<>(map,HttpStatus.OK);
            }
            else{
                map.put("message","Usuario "+usuario.getUsuario()+" no encontrado.");
                return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    @PostMapping("/logout")
    public ResponseEntity<HashMap<String, Object>> logout(@RequestBody Usuario usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Usuario user=authService.login(usuario);
            if(user!=null){
                map.put("message","Usuario "+user.getUsuario()+" cerro sesion.");
                return new ResponseEntity<>(map,HttpStatus.OK);
            }
            else{
                map.put("message","Usuario "+usuario.getUsuario()+" no encontrado.");
                return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }
        
    
}
