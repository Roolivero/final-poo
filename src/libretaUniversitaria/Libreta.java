package libretaUniversitaria;


import grafoMaterias.Nodo;
import materia.Materia;
import materia.MateriaLibreta;
import planDeEstudio.PlanEstudio;

import java.util.ArrayList;
import java.util.List;

public class Libreta {

    // Atributos
    private ArrayList<MateriaLibreta> libreta;

    //Constructor
    public Libreta (){
        this.libreta = new ArrayList<>();
    }

    //Metodo
    public void completarLibreta(MateriaLibreta materia){
        this.libreta.add(materia);
    }

    public boolean buscarMateria(Materia materia){
        for(MateriaLibreta materiaLibreta : this.getLibreta()){
            if(materia.getNombre() == materiaLibreta.getNombre()){
                return true;
            }
        }
        return false;
    }

    public boolean libretaCompleta(PlanEstudio plan) {
        List<Materia> materiasGrafo = plan.getGrafo().listaMaterias();
        int cantMateriasGrafo = materiasGrafo.size();
        int cantMateriasLibreta = 0;
        for (Materia materia : materiasGrafo) {
            for (MateriaLibreta matLibreta : this.getLibreta()) {
                if (matLibreta.equals(materia) && matLibreta.getEstado().equals("Aprobada")) {
                    cantMateriasLibreta ++;
                    break;
                }
            }
        }
        if (cantMateriasGrafo == cantMateriasLibreta) {
            return true;
        } else return false;
    }



    public void mostrarLibreta(){
        for( MateriaLibreta materia : this.getLibreta()) {
            System.out.println(materia.mostrarMateria());
        }
    }

    //get
    public ArrayList<MateriaLibreta> getLibreta() {return libreta;}

}

