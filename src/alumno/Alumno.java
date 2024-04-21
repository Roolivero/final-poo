package alumno;

import java.time.LocalDate;

public class Alumno {
    //Atributos
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;

    //Constructor
    public Alumno (String nombre, String apellido, String dni, LocalDate fechaNacimeinto){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimeinto);

    }
    //Setters y getters
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setDni(String dni){this.dni = dni;}
    public void setFechaNacimiento(LocalDate fechaNacimiento){this.fechaNacimiento = fechaNacimiento;}

    public String getNombre(){return this.nombre;}
    public String getApellido(){return this.apellido;}
    public String getDni(){return this.dni;}
    public LocalDate getFechaNacimiento(){return this.fechaNacimiento;}

    @Override
    public String toString(){
        return this.getNombre() + ' ' + this.getApellido() + " ,Dni:" + this.getDni();
    }
    public String mostrarLista() {
        return this.getNombre() + " " + this.getApellido();
    }
}
