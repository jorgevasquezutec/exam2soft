package services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import data.entities.Centro;
import repositories.CentroRepository;
import static config.GlobalConstants.population;

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
        map.put("80 a mas", 0);
        map.put("70 a 79", 0);
        map.put("60 a 69", 0);
        map.put("50 a 59", 0);
        map.put("40 a 49", 0);
        map.put("30 a 39", 0);
        map.put("18 a 29", 0);

        for (Centro c : getCentros() ){
            int t=(int)map.get(c.getTipo());
            t+=c.getPersonas_vacunadas_completamente();
            map.put(c.getTipo(), t);
        }

        for ( Entry<String, Object> entry : map.entrySet()) {
            int total= (int)entry.getValue();
            float percent = ((float)total/(float)population)*100;
            entry.setValue( Float.toString(percent)+"%");
        }

        return map;
    }

    public HashMap<String, Object> getReporteConsolidado(){

        int numero_vp=0;
        int numero_vc=0;
        for (Centro c : getCentros() ){
            numero_vp+=c.getPersonas_vacunadas_parcialmente();
            numero_vc+=c.getPersonas_vacunadas_completamente();
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("Avanze de Vacunación",Float.toString(((float)numero_vc/(float)population)*100)+"%" );
        map.put("Cobertura de Vacunación", "30%");
        map.put("Numero de Centros de Vacunacion",getCentros().size());
        map.put("Número de personas vacunadas parcialmente", numero_vp);
        map.put("Número de personas vacunadas completamente", numero_vc);

        return map;
    }


    
}
