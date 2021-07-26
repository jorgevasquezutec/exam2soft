package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import data.entities.Centro;
import repositories.CentroRepository;
import static config.GlobalConstants.*;

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
            centroRepository.finbyId(id).setPersonasVacunadasParcialmente(cen.getPersonasVacunadasParcialmente());
            centroRepository.finbyId(id).setPersonasVacunadasCompletamente(cen.getPersonasVacunadasCompletamente());
        }
        return centroRepository.finbyId(id);
    }

    public Map<String, Object> getReporteEdades(){

        Map<String, Object> map = new HashMap<>();
        map.put("80 a mas", 0);
        map.put("70 a 79", 0);
        map.put("60 a 69", 0);
        map.put("50 a 59", 0);
        map.put("40 a 49", 0);
        map.put("30 a 39", 0);
        map.put("18 a 29", 0);

        for (Centro c : getCentros() ){
            int t=(int)map.get(c.getTipo());
            t+=c.getPersonasVacunadasCompletamente();
            map.put(c.getTipo(), t);
        }

        for ( Entry<String, Object> entry : map.entrySet()) {
            int total= (int)entry.getValue();
            float percent=0;
            
            switch(entry.getKey())
            {
                case "80 a mas":
                        percent=((float)total/(float)GRUPO_80_MAS)*100;
                    break;
                case "70 a 79":
                        percent=((float)total/(float)GRUPO_70_79)*100;
                    break;
                case "60 a 69":
                        percent=((float)total/(float)GRUPO_60_69)*100;
                    break;
                case "50 a 59":
                        percent=((float)total/(float)GRUPO_50_59)*100;
                    break;
                case "40 a 49":
                        percent=((float)total/(float)GRUPO_40_49)*100;
                    break;
                case "30 a 39":
                        percent=((float)total/(float)GRUPO_30_39)*100;
                    break;
                case "18 a 29":
                        percent=((float)total/(float)GRUPO_18_29)*100;
                    break;
                default:
                        percent=0;
                    break;
            }
            entry.setValue( Float.toString(percent)+"%");
            
           
        }

        return map;
    }

    public Map<String, Object> getReporteConsolidado(){

        int numeroVp=0;
        int numeroVc=0;
        for (Centro c : getCentros() ){
            numeroVp+=c.getPersonasVacunadasParcialmente();
            numeroVc+=c.getPersonasVacunadasCompletamente();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("Avanze de Vacunación",Float.toString(((float)numeroVc/(float)POPULATION)*100)+"%" );
        map.put("Cobertura de Vacunación", "30%");
        map.put("Numero de Centros de Vacunacion",getCentros().size());
        map.put("Número de personas vacunadas parcialmente", numeroVp);
        map.put("Número de personas vacunadas completamente", numeroVc);

        return map;
    }


    
}
