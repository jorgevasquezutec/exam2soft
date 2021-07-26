package repositories;

import java.util.ArrayList;
import java.util.List;
import data.entities.Centro;

public class CentroRepository {

    List<Centro> centros;


    public CentroRepository(){
        centros= new ArrayList<>();
    }


    public void add(Centro centro){
        centros.add(centro);
    }
    public void delete(Centro centro){
        centros.remove(centro);
    }

    public List<Centro> getAll(){
        return centros;
    }

    public Centro finbyId(int id){
        for (Centro cen: centros){
            if(cen.getId()==id){
                return cen;
            }
        }
      return null;
    }
}
