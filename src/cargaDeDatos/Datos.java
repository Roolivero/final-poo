package cargaDeDatos;

import alumno.Alumno;
import carrera.Carrera;
import libretaUniversitaria.Libreta;
import materia.Materia;
import planDeEstudio.PlanEstudio;
import sistemaUniversitario.SistemaUniversitario;
import universidad.Universidad;

import java.time.LocalDate;

public class Datos {
    //Constructor
    public Datos() {}

    public void cargarDatos() {
        SistemaUniversitario sistema1 = SistemaUniversitario.getInstancia();

        Universidad universidad1 = new Universidad("U");

        sistema1.agregarUniversidad(universidad1);

        PlanEstudio planA = new PlanEstudio('A');
        PlanEstudio planB = new PlanEstudio('B');
        Carrera carrera1 = new Carrera("Lic. en sistemas", 5, planA);
        Carrera carera2 = new Carrera("Geologia",5,planB);

        universidad1.agregarCarreras(carrera1);
        universidad1.agregarCarreras(carera2);

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

        carrera1.agregarMaterias(materia1);
        carrera1.agregarMaterias(materia2);
        carrera1.agregarMaterias(materia3);
        carrera1.agregarMaterias(materia4);
        carrera1.agregarMaterias(materia5);
        carrera1.agregarMaterias(materia6);
        carrera1.agregarMaterias(materia7);
        carrera1.agregarMaterias(materia8);
        carrera1.agregarMaterias(materia9);
        carrera1.agregarMaterias(materia10);

        planA.grafoMaterias(materia1,materia8);
        planA.grafoMaterias(materia5,materia8);
        planA.grafoMaterias(materia2,materia10);
        planA.grafoMaterias(materia3,materia4);
        planA.grafoMaterias(materia4,materia7);
        planA.grafoMaterias(materia3,materia7);
        planA.grafoMaterias(materia6,materia7);
        planA.grafoMaterias(materia3,materia7);
        planA.grafoMaterias(materia9,null);


        Materia materia1Geologia = new Materia("introduccion a la geologia",true,1);

        carera2.agregarMaterias(materia1Geologia);


        Alumno alumno1 = new Alumno("Rocio", "Jofre Olivero", "41789823", LocalDate.of(1999, 12, 22),new Libreta());
        Alumno alumno2 = new Alumno("Giuliano ignacio", "Poeta", "41789518", LocalDate.of(1999, 9, 14),new Libreta());
        Alumno alumno3 = new Alumno("Ignacio", "Sanchez", "51893674", LocalDate.of(2002, 8, 3),new Libreta());


        carrera1.inscribirAlumno(alumno1);
        carrera1.inscribirAlumno(alumno2);
        carrera1.inscribirAlumno(alumno3);


        System.out.println(alumno1);
        alumno1.terminoCarrera(alumno1,planA);

        planA.inscribirAlumnoMateria(alumno1,materia3);

        System.out.println("Las materias con sus correlativas son: ");
        planA.getGrafo().print();




    }
}

