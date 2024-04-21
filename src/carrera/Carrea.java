package carrera;

import alumno.Alumno;
import planDeEstudio.PlanEstudio;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    //Atributos
    private String nombre;
    private int duracion;
    private PlanEstudio planEstudio;
    private List <Alumno> alumnosInscriptos;

    //Constructor
    public Carrera (String nombre, int duracion, PlanEstudio planEstudio){
        this.setNombre(nombre);
        this.setDuracion(duracion);
        this.setPlanEstudio(planEstudio);
        this.alumnosInscriptos = new ArrayList<>();
    }

    //Metodos
    public void inscribirAlumno(Alumno alumno){
        this.getAlumnosInscriptos().add(alumno);
    }

    //Setters y getters
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setDuracion(int duracion){this.duracion = duracion;}
    public void setPlanEstudio (PlanEstudio planEstudio){this.planEstudio = planEstudio;}
    public void setAlumnos(List<Alumno> alumnosInscriptos){this.alumnosInscriptos = new ArrayList<>();}

    public String getNombre(){return this.nombre;}
    public int getDuracion(){return this.duracion;}
    public List<Alumno> getAlumnosInscriptos() {return this.alumnosInscriptos;}
    public PlanEstudio getPlanEstudio(){ return this.planEstudio;}

}
