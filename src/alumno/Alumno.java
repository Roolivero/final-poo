package alumno;

import libretaUniversitaria.Libreta;
import materia.Materia;
import materia.MateriaLibreta;
import planDeEstudio.PlanEstudio;

import java.time.LocalDate;

public class Alumno {
    //Atributos
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private Libreta libretaAlumno;

    //Constructor
    public Alumno (String nombre, String apellido, String dni, LocalDate fechaNacimeinto,Libreta libretaAlumno){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimeinto);
        this.setLibretaAlumno(libretaAlumno);
    }

    public void agregarNota(MateriaLibreta materia){
        this.getLibretaAlumno().completarLibreta(materia);
    }

    public void terminoCarrera(Alumno alumno, PlanEstudio plan){
        if (this.getLibretaAlumno().libretaCompleta(plan)){
            System.out.println("El alumno " + this.getNombre() + " " + this.getApellido() + " termino la carrera");
        } else {
            System.out.println("El alumno " + this.getNombre() + " " + this.getApellido() + " no termino la carrera");
        }


    }

    //Setters y getters
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setDni(String dni){this.dni = dni;}
    public void setFechaNacimiento(LocalDate fechaNacimiento){this.fechaNacimiento = fechaNacimiento;}
    public void setLibretaAlumno(Libreta libretaAlumno) {this.libretaAlumno = libretaAlumno;}

    public String getNombre(){return this.nombre;}
    public String getApellido(){return this.apellido;}
    public String getDni(){return this.dni;}
    public LocalDate getFechaNacimiento(){return this.fechaNacimiento;}
    public Libreta getLibretaAlumno() {return libretaAlumno;}

    @Override
    public String toString(){
        return this.getNombre() + ' ' + this.getApellido() + " ,Dni:" + this.getDni();
    }
    public String mostrarLista() {
        return this.getNombre() + " " + this.getApellido();
    }
}
