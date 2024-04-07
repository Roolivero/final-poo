package libretaUniversitaria;

import grafoMaterias.Grafo;
import grafoMaterias.Nodo;
import materia.Materia;
import materia.MateriaLibreta;
import planDeEstudio.PlanEstudio;

import java.util.List;

public class Libreta {

    // Atributos
    private Grafo grafoNotas;
    private List<MateriaLibreta> materiasObligatorias;
    private List<MateriaLibreta> materiasOptativas;

    //Constructor
    public Libreta(PlanEstudio planEstudio) {
        this.grafoNotas = new Grafo();






        for(Materia materia : planEstudio.getMateriasObligatorias()){
            MateriaLibreta materiaLibreta = new MateriaLibreta(materia.getNombre(),materia.getEsObligatoria(),materia.getCuatrimestre(),0,"Sin cursar");
            this.materiasObligatorias.add(materiaLibreta);
        }
        for(Materia materia : planEstudio.getMateriasOptativas()){
            MateriaLibreta materiaLibreta = new MateriaLibreta(materia.getNombre(),materia.getEsObligatoria(),materia.getCuatrimestre(),0,"Sin cursar");
            this.materiasOptativas.add(materiaLibreta);
        }
    }

    public void grafoNotas(Materia materia, Materia correlativa){
        Nodo nodoMateria = correlativas.agregarMateria(materia);
        if (correlativa != null){
            Nodo nodoCorrelativa = correlativas.agregarMateria(correlativa);
            correlativas.agregarArista(nodoMateria,nodoCorrelativa);
        }
    }


}

