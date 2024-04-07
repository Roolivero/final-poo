package planDeEstudio;

import grafoMaterias.Grafo;
import grafoMaterias.Nodo;
import materia.Materia;

import java.util.ArrayList;
import java.util.List;

public class PlanEstudio {
    //Atributos
    private Grafo correlativas;
    private char tipoPlan;

    //Constructor
    public PlanEstudio(char tipoPlan) {
        this.correlativas = new Grafo();
        this.setTipoPlan(tipoPlan);
    }

    //Metodos
    public void grafoMaterias(Materia materia, Materia correlativa){
        Nodo nodoMateria = correlativas.agregarMateria(materia);
        if (correlativa != null){
            Nodo nodoCorrelativa = correlativas.agregarMateria(correlativa);
            correlativas.agregarArista(nodoMateria,nodoCorrelativa);
        }
    }


    //Setters y getters
    public void setTipoPlan(char tipoPlan){this.tipoPlan = tipoPlan;}

    public int getTipoPlan() { return tipoPlan; }
    public Grafo getGrafo(){return correlativas;}
}
