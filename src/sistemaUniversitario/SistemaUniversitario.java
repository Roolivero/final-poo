package sistemaUniversitario;

import universidad.Universidad;

import java.util.ArrayList;
import java.util.List;

public class SistemaUniversitario {
    //Atributos
    private List<Universidad> listaUniversidades;

    //Constructor
    public SistemaUniversitario(){
        this.listaUniversidades = new ArrayList<>();
    }

    public List<Universidad> agregarUniversidad(Universidad universidad){
        this.getListaUniversidades().add(universidad);
        return listaUniversidades;
    }

    //getter
        public List<Universidad> getListaUniversidades() {
        return this.listaUniversidades;
    }
}
