package universidad;

import carrera.Carrera;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    //Atributos
    private List<Carrera> listaCarreras;
    private String nombre;

    //Constructor
    public Universidad(String nombre){
        this.setNombre(nombre);
        this.listaCarreras = new ArrayList<>();
    }

    //Setters y getters
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return this.nombre; }
}
