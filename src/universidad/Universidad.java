package universidad;

import carrera.Carrera;
import materia.Materia;
import sistemaUniversitario.SistemaUniversitario;

import java.util.ArrayList;
import java.util.List;
public class Universidad {
    // Atributos
    private List<Carrera> listaCarreras;
    private String nombre;
    private static Universidad instancia;
    private List<Materia> listaMaterias;

    // Constructor privado
    private Universidad(String nombre) {
        this.nombre = nombre;
        this.listaCarreras = new ArrayList<>();
        this.listaMaterias = new ArrayList<>();
    }

    public static Universidad getInstancia(String nombre) {
        if (instancia == null) {
            instancia = new Universidad(nombre);
        }
        return instancia;
    }

    public void agregarCarrera(Carrera carrera) {
        this.listaCarreras.add(carrera);
    }

    public List<Carrera> getListaCarreras() {
        return this.listaCarreras;
    }

    public void agregarMateria(Materia materia) {
        this.listaMaterias.add(materia);
    }

    public List<Materia> getListaMaterias() {
        return this.listaMaterias;
    }

    public String getNombre() {
        return this.nombre;
    }
}
