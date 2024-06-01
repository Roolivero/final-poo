package cargaDeDatos;

import alumno.Alumno;
import carrera.Carrera;
import libretaUniversitaria.Libreta;
import materia.Materia;
import planDeEstudio.PlanEstudio;
import universidad.Universidad;

import java.time.LocalDate;

public class Datos {
    //Constructor
    public Datos() {}


    //Metodo

    public void cargarDatos() {
        Universidad universidad1 = new Universidad("Universidad Nacional Tierra del Fuego");

        PlanEstudio planA = new PlanEstudio('A');
        Carrera carrera1 = new Carrera("Lic. en sistemas", 5, planA);

        Materia materia1 = new Materia("Algebra", true, 1);
        Materia materia2 = new Materia("Elementos de Informática", true, 1);
        Materia materia3 = new Materia("Expresión de Problemas y Algoritmos", true, 1);
        Materia materia4 = new Materia("Algorítmica y Programación I", true, 2);
        Materia materia5 = new Materia("Análisis Matemático", true, 2);
        Materia materia6 = new Materia("Elementos de Lógica y Matemática Discreta", true, 2);
        Materia materia7 = new Materia("Algorítmica y Programación II", true, 3);
        Materia materia8 = new Materia("Estadística", true, 3);
        Materia materia9 = new Materia("Sistemas y Organizaciones", true, 3);
        Materia materia10 = new Materia("Arquitectura de Computadoras", true, 3);

        planA.grafoMaterias(materia1,materia8);
        planA.grafoMaterias(materia5,materia8);
        planA.grafoMaterias(materia2,materia10);
        planA.grafoMaterias(materia3,materia4);
        planA.grafoMaterias(materia4,materia7);
        planA.grafoMaterias(materia3,materia7);
        planA.grafoMaterias(materia6,materia7);
        planA.grafoMaterias(materia3,materia7);
        planA.grafoMaterias(materia9,null);

        Alumno alumno1 = new Alumno("Rocio", "Jofre Olivero", "41789823", LocalDate.of(1999, 12, 22),new Libreta());
        System.out.println(alumno1);

        planA.inscribirAlumnoMateria(alumno1,materia3);

        System.out.println("Las materias con sus correlativas son: ");
        planA.getGrafo().print();




    }
}

