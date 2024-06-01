package libretaUniversitaria;


import grafoMaterias.Nodo;
import materia.Materia;
import materia.MateriaLibreta;
import java.util.ArrayList;

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

    public void mostrarLibreta(){
        for( MateriaLibreta materia : this.getLibreta()) {
            System.out.println(materia.mostrarMateria());
        }
    }

    //get
    public ArrayList<MateriaLibreta> getLibreta() {return libreta;}

}

