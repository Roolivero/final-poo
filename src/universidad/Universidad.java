package universidad;

import carrera.Carrera;
import sistemaUniversitario.SistemaUniversitario;

import java.util.ArrayList;
import java.util.List;
public class Universidad {
    // Atributos
    private List<Carrera> listaCarreras;
    private String nombre;
    private static Universidad instancia;

    // Constructor privado
    private Universidad(String nombre) {
        this.nombre = nombre;
        this.listaCarreras = new ArrayList<>();
    }

    // Método estático para obtener la única instancia
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

    public String getNombre() {
        return this.nombre;
    }
}
