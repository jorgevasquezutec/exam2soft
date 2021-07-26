package data.entities;

public class Centro {
    int id;
    String localidad;
    String tipo;
    int personas_vacunadas_parcialmente;
    int personas_vacunadas_completamente;
    

    public Centro() {

    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Centro(int id,String localidad, String tipo, int personas_vacunadas_parcialmente,
            int personas_vacunadas_completamente) {
        this.id=id;
        this.localidad = localidad;
        this.tipo = tipo;
        this.personas_vacunadas_parcialmente = personas_vacunadas_parcialmente;
        this.personas_vacunadas_completamente = personas_vacunadas_completamente;
    }


    public String getLocalidad() {
        return localidad;
    }


    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getPersonas_vacunadas_parcialmente() {
        return personas_vacunadas_parcialmente;
    }


    public void setPersonas_vacunadas_parcialmente(int personas_vacunadas_parcialmente) {
        this.personas_vacunadas_parcialmente = personas_vacunadas_parcialmente;
    }


    public int getPersonas_vacunadas_completamente() {
        return personas_vacunadas_completamente;
    }


    public void setPersonas_vacunadas_completamente(int personas_vacunadas_completamente) {
        this.personas_vacunadas_completamente = personas_vacunadas_completamente;
    }

    



    

}
