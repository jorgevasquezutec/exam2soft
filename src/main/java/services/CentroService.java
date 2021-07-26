package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import static config.GlobalConstants.*;

import data.entities.Centro;
import repositories.CentroRepository;

@Service
public class CentroService {
    

    CentroRepository centroRepository;

    public CentroService(){
        centroRepository = new CentroRepository();
    }

    public Centro crear(Centro centro){
        centroRepository.add(centro);
        return centro;
    }

    public Centro baja(int id){
        Centro cen = centroRepository.finbyId(id);
        centroRepository.delete(cen);
        return cen;
    }

    public List<Centro> getCentros(){
        return centroRepository.getAll();
    }
    
    public Centro edit(Centro cen ,int id){
        if(centroRepository.finbyId(id)!=null){
            centroRepository.finbyId(id).setLocalidad(cen.getLocalidad());
            centroRepository.finbyId(id).setPersonas_vacunadas_parcialmente(cen.getPersonas_vacunadas_parcialmente());
            centroRepository.finbyId(id).setPersonas_vacunadas_completamente(cen.getPersonas_vacunadas_completamente());
        }
        return centroRepository.finbyId(id);
    }

    public HashMap<String, Object> getReporteEdades(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("80 a mas", "0%");
        map.put("70 a 79", "0%");
        map.put("60 a 69", "0%");
        map.put("50 a 59", "0%");
        map.put("40 a 49", "0%");
        map.put("30 a 39", "0%");
        map.put("18 a 29", "0%");

        return map;
    }

    public HashMap<String, Object> getReporteConsolidado(){
        HashMap<String, Object> map = new HashMap<>();

        map.put("Avanze de Vacunacipón", "50%");
        map.put("Cobertura de Vacunación", "0%");
        map.put("Numero de Centros de Vacunacion",getCentros().size());
        map.put("Número de personas vacunadas parcialmente", "0%");
        map.put("Número de personas vacunadas completamente", "0%");

        return map;
    }

    
}
