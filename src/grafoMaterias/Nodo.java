package grafoMaterias;
import alumno.Alumno;
import libretaUniversitaria.Libreta;
import materia.Materia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Nodo {
    // Atributos
    private Materia materia;
    private List<Arista> aristas;
    private boolean visitado;

    //Constructor
    public Nodo(Materia materia) {
        this.materia = materia;
        this.aristas = new ArrayList<Arista>();
        this.setVisitado(false);
    }

    //Metodos

    public void agregarArista(Nodo nodoFinal) {
        this.aristas.add(new Arista(this, nodoFinal));
    }

    public void eliminarArista(Nodo nodoFinal) {
        this.aristas.removeIf(arista -> arista.getFin().equals(nodoFinal));
    }

    public void printNodo() {
        if (this.aristas.isEmpty()) {
            System.out.println(this.materia + " --> ");
            return;
        }
        String mensaje = "";
        for (int i = 0; i < this.aristas.size(); i++) {
            if (i == 0) {
                mensaje += this.aristas.get(i).getInicio().materia + " --> ";
            }
            mensaje += this.aristas.get(i).getFin().materia + " --> ";
            if (i != this.aristas.size() - 1) {
                mensaje += ", " + this.aristas.get(i).getInicio().materia + " --> ";
            }
        }
        System.out.println(mensaje);
    }

    public boolean esVisitado() {return visitado;}


    //Setters y getters
    public void setVisitado(Boolean visitado) {this.visitado = visitado;}
    public void setMateria(Materia materia) {this.materia = materia;}

    public Materia getmateria() {return this.materia;}
    public List<Arista> getAristas() {return this.aristas;}
    public boolean getVisitado() {return this.getVisitado();}
}