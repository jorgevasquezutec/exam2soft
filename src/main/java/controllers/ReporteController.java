package controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.CentroService;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    CentroService centroService;
    public ReporteController(){
        centroService= new CentroService();
    }


    @GetMapping("/edades")
    public ResponseEntity<HashMap<String, Object>> getReporteEdades(){
        HashMap<String, Object> map = new HashMap<>();
        try{
            map.put("reporte", centroService.getReporteEdades());
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping("/consolidado")
    public ResponseEntity<HashMap<String, Object>> getReporteConsolidado(){
        HashMap<String, Object> map = new HashMap<>();
        try{
            map.put("reporte", centroService.getReporteConsolidado());
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
    }

    
}
