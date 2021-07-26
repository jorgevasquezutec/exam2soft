package repositories;

import java.util.ArrayList;
import java.util.List;

import data.entities.Centro;

public class CentroRepository {

    List<Centro> centros;

    private List<String> grupos = new ArrayList<>();


    public CentroRepository(){
        centros= new ArrayList<>();
        grupos.add("80 a mas");
        grupos.add("70 a 79");
        grupos.add("60 a 69");
        grupos.add("50 a 59");
        grupos.add("40 a 49");
        grupos.add("30 a 39");
        grupos.add("18 a 29");
        createRadomData();
    }


    public void add(Centro centro){
        if(getAll().size()<50){
            centros.add(centro);
        }
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

    public void createRadomData(){
        int min = 200;      
        int max = 1000;
        int ming=0;
        int maxg=grupos.size()-1;

        for (int i=1; i<=50;i++){
            int randomIndex = (int)(Math.random()*(maxg-ming+1)+ming); 
            int parcial = (int)(Math.random()*(max-min+1)+min); 
            int complete = (int)(Math.random()*(max-min+1)+min);  
            centros.add(new Centro(i,"lima",grupos.get(randomIndex),parcial,complete));
        }
    }

}
