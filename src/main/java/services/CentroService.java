package services;

import java.util.List;

import org.springframework.stereotype.Service;

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

    
}
