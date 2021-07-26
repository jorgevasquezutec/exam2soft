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
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }


    @PostMapping
    public ResponseEntity<HashMap<String, Object>> crearCentro(@RequestBody Centro centro){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Centro nuevo =centroService.crear(centro);
            map.put("centro",nuevo);
            map.put("message","Centro Creado");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> bajaCentro(@RequestBody Centro centro,@PathVariable int id){
        HashMap<String, Object> map = new HashMap<>();
        try{

            if(centroService.edit(centro, id)!=null){
                map.put("centro",centroService.edit(centro, id));
                map.put("message","Centro Modificado");
                return new ResponseEntity<>(map,HttpStatus.OK);
            }else{
                map.put("centro",centro);
                map.put("message","Centro no encontrado");
                return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> bajaCentro(@PathVariable int id){
        HashMap<String, Object> map = new HashMap<>();
        try{

            Centro del= centroService.baja(id);
            map.put("centro",del);
            map.put("message","Centro Eliminado");
            return new ResponseEntity<>(map,HttpStatus.OK);
           
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }
    
}
