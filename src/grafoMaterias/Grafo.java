package grafoMaterias;

import materia.Materia;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    //Artibuto
    private ArrayList<Nodo> nodoMateria;

    //Constructor
    public Grafo(){
        this.nodoMateria = new ArrayList<Nodo>();;
    }

    //Metodos
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

    public Nodo obtenernodo(Materia materia){
        for (Nodo n : this.getNodoMateria()){
            if(n.getmateria() == materia){
                return n;
            }
        }
        return null;
    }

    public List<Materia> listaMaterias(){
        List<Materia> materias = new ArrayList<>();
        for (Nodo nodo : this.getNodoMateria()){
            materias.add(nodo.getmateria());
        }
        return materias;
    }

    public List<Nodo> materiasPorCuatrimestre(int cuatrimestre, int numero){
        List<Nodo> materiasCuatrimestre = new ArrayList<>();
        int cuatrimestreInicial = cuatrimestre - numero;
        if(cuatrimestreInicial >= 0) {
            for (Nodo nodo : this.getNodoMateria()) {
                int cuatrimestreMateria = nodo.getmateria().getCuatrimestre();
                if (cuatrimestreMateria >= cuatrimestreInicial && cuatrimestreMateria < cuatrimestre) {
                    materiasCuatrimestre.add(nodo);
                }
            }
            return materiasCuatrimestre;
        } else if(((cuatrimestre <= 4) && (numero == 5)) || ((cuatrimestre <= 2) && (numero == 3))){
            for (Nodo nodo : this.getNodoMateria()) {
                int cuatrimestreMateria = nodo.getmateria().getCuatrimestre();
                if (cuatrimestreMateria >= 0 && cuatrimestreMateria < cuatrimestre) {
                    materiasCuatrimestre.add(nodo);
                }
            }
            return materiasCuatrimestre;
        }
        return materiasCuatrimestre;
    }

    public List<Nodo> correlativasDirectas(Materia materia) {
        Nodo nodoBuscado = obtenernodo(materia);
        List<Nodo> materiasCorrelativas = new ArrayList<>();
        if (nodoBuscado != null) {
            for (Arista arista : nodoBuscado.getAristas()) {
                materiasCorrelativas.add(arista.getFin());
            }
        }
        return materiasCorrelativas;
    }


    public List<Nodo> predecesores(Materia materia){
        Nodo nodoBuscado = this.obtenernodo(materia);
        List<Nodo> anteriores = new ArrayList<>();
        if (nodoBuscado == null) {
            return anteriores;
        }
        for (Nodo nodo : nodoMateria) {
            if (!nodo.equals(nodoBuscado)) {
                dfsPredecesores(nodo, nodoBuscado, anteriores);
            }
        }
        for (Nodo nodo : nodoMateria) {
            nodo.setVisitado(false);
        }
        return anteriores;
    }

    private void dfsPredecesores(Nodo actual, Nodo destino, List<Nodo> predecesores) {
        actual.setVisitado(true);
        for (Arista arista : actual.getAristas()) {
            Nodo vecino = arista.getFin();
            if (vecino.equals(destino) && !predecesores.contains(actual)) {
                predecesores.add(actual);
            }
            if (!vecino.getVisitado()) {
                dfsPredecesores(vecino, destino, predecesores);
            }
        }
        actual.setVisitado(false);
    }

    public void print(){
        for(Nodo n: this.nodoMateria){
            n.printNodo();
        }
    }

    //Setters y getters
    public ArrayList<Nodo> getNodoMateria(){return this.nodoMateria;}
}
