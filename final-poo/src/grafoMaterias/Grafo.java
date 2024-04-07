package grafoMaterias;

import materia.Materia;

import java.util.ArrayList;

public class Grafo {
    //Artibuto
    private ArrayList<Nodo> nodoMateria;

    //Constructor
    public Grafo(){
        this.nodoMateria = new ArrayList<Nodo>();;
    }
    public Nodo agregarMateria (Materia materia){
        Nodo nodoNuevo = new Nodo(materia);
        this.nodoMateria.add(nodoNuevo);
        return nodoNuevo;
    }
    public void agregarArista(Nodo materia1, Nodo materia2){
        materia1.agregarArista(materia2);
    }
    public void eliminarArista(Nodo materia1, Nodo materia2) {
        materia1.eliminarArista(materia2);
    }
    public void eliminarnodo(Nodo materia){
        this.nodoMateria.remove(materia);
    }
    public void print(){
        for(Nodo n: this.nodoMateria){
            n.printNodo();
        }
    }

    public Nodo obtenernodo(Materia materia){
        for (Nodo n : this.nodoMateria){
            if(n.getmateria() == materia){
                return n;
            }
        }
        return null;
    }
    //Setters y getters
    public ArrayList<Nodo> getNodoMateria(){return this.nodoMateria;}
}
