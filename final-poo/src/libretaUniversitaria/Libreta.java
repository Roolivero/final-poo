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


    //Constructor
    public Libreta(PlanEstudio planEstudio) {
        this.grafoNotas = new Grafo();
        for(Nodo nodo : planEstudio.getGrafo().getNodoMateria()){
            MateriaLibreta materiaLibreta = new MateriaLibreta(nodo.getmateria().getNombre(),nodo.getmateria().getEsObligatoria(),
                    nodo.getmateria().getCuatrimestre(),0," ");
            nodo.setMateria(materiaLibreta);
            grafoNotas.recorrerYModificarGrafo();
        }
    }


    //get
    public Grafo getGrafoNotas(){ return this.grafoNotas;}

}

