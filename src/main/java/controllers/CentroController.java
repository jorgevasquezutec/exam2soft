package controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.entities.Centro;
import services.CentroService;

@RestController
@RequestMapping("/centro")
@CrossOrigin
public class CentroController {

    
    CentroService centroService;
    String error="error";
    String message="message";
    String txtcentro="centro";
    String txtCCentro="Centro";
    
    public CentroController(){
        centroService= new CentroService();
    }

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getCentros(){
        HashMap<String, Object> map = new HashMap<>();
        try{

            map.put("centros", centroService.getCentros());
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }


    @PostMapping
    public ResponseEntity<HashMap<String, Object>> crearCentro(@RequestBody Centro centro){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Centro nuevo =centroService.crear(centro);
            map.put(txtcentro,nuevo);
            map.put(message,txtCCentro+" Creado");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> bajaCentro(@RequestBody Centro centro,@PathVariable int id){
        HashMap<String, Object> map = new HashMap<>();
        try{
            //valid type
            if(centroService.edit(centro, id)!=null){
                map.put(txtcentro,centroService.edit(centro, id));
                map.put(message,txtCCentro+" Modificado");
                return new ResponseEntity<>(map,HttpStatus.OK);
            }else{
                map.put(txtcentro,centro);
                map.put(message,txtCCentro+" no encontrado");
                return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> bajaCentro(@PathVariable int id){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Centro del= centroService.baja(id);
            map.put(txtcentro,del);
            map.put(message,txtCCentro+" Eliminado");
            return new ResponseEntity<>(map,HttpStatus.OK);
           
        }catch(Exception e){
            map.put(error, e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }
    
}
