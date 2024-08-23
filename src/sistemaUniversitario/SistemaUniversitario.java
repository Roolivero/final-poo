package sistemaUniversitario;

import universidad.Universidad;

import java.util.ArrayList;
import java.util.List;

public class SistemaUniversitario {
    //Atributos
    private List<Universidad> listaUniversidades;
    private static SistemaUniversitario instancia;

    //Constructor
    public SistemaUniversitario(){
        this.listaUniversidades = new ArrayList<>();
    }

    public void agregarUniversidad(Universidad universidad) {
        this.getListaUniversidades().add(universidad);
    }

    public static SistemaUniversitario getInstancia() {
        if (instancia == null) {
            instancia = new SistemaUniversitario();
        }
        return instancia;
    }

    //getter
        public List<Universidad> getListaUniversidades() {
        return this.listaUniversidades;
    }
}
