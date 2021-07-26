package data.entities;

public class Centro {
    int id;
    String localidad;
    String tipo;
    int personasVacunadasParcialmente;
    int personasVacunadasCompletamente;
    

    public Centro() {

    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Centro(int id,String localidad, String tipo, int personasVacunadasParcialmente,
            int personasVacunadasCompletamente) {
        this.id=id;
        this.localidad = localidad;
        this.tipo = tipo;
        this.personasVacunadasParcialmente = personasVacunadasParcialmente;
        this.personasVacunadasCompletamente = personasVacunadasCompletamente;
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

    public int getPersonasVacunadasParcialmente() {
        return personasVacunadasParcialmente;
    }

    public void setPersonasVacunadasParcialmente(int personasVacunadasParcialmente) {
        this.personasVacunadasParcialmente = personasVacunadasParcialmente;
    }

    public int getPersonasVacunadasCompletamente() {
        return personasVacunadasCompletamente;
    }

    public void setPersonasVacunadasCompletamente(int personasVacunadasCompletamente) {
        this.personasVacunadasCompletamente = personasVacunadasCompletamente;
    }


    



    

}
