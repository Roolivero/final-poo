package libretaUniversitaria;

import materia.Materia;
import materia.MateriaLibreta;
import planDeEstudio.PlanEstudio;

import java.util;

public class Libreta {

    // Atributos
    private ArrayList libreta;

    //Constructor
    public Libreta ()
        this.libreta = new ArrayList<>;

    //Metodo
    public List completarLibreta(Materia materia){
        this.libreta.add(materia);
    }
    public void mostrarLibreta(Libreta libreta){
        for (double nota : libreta){
            System.out.println(nota);
        }
    }

    //get
    public List getLibreta() {return libreta;}
}

