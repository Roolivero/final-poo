package cargaDeDatos;

import alumno.Alumno;
import carrera.Carrera;
import libretaUniversitaria.Libreta;
import materia.Materia;
import materia.MateriaLibreta;
import planDeEstudio.PlanEstudio;
import sistemaUniversitario.SistemaUniversitario;
import universidad.Universidad;

import java.time.LocalDate;

public class Datos {
    //Constructor
    public Datos() {}

    public void cargarDatos() {
        SistemaUniversitario sistema1 = SistemaUniversitario.getInstancia();

        Universidad universidad = Universidad.getInstancia("Universidad Nacional Tierra del Fuego");

        sistema1.agregarUniversidad(universidad);

        PlanEstudio planA = new PlanEstudio('A');
        PlanEstudio planB = new PlanEstudio('B');
        Carrera carrera1 = new Carrera("Lic. en sistemas", 5, planA);
        Carrera carera2 = new Carrera("Geologia",5,planB);

        universidad.agregarCarrera(carrera1);
        universidad.agregarCarrera(carera2);

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

        universidad.agregarMateria(materia1);
        universidad.agregarMateria(materia2);
        universidad.agregarMateria(materia3);
        universidad.agregarMateria(materia4);
        universidad.agregarMateria(materia5);
        universidad.agregarMateria(materia6);
        universidad.agregarMateria(materia7);
        universidad.agregarMateria(materia8);
        universidad.agregarMateria(materia9);
        universidad.agregarMateria(materia10);

        planA.grafoMaterias(materia8, materia1);  // Estadística depende de Álgebra
        planA.grafoMaterias(materia8, materia5);  // Estadística depende de Análisis Matemático
        planA.grafoMaterias(materia10, materia2); // Arquitectura de Computadoras depende de Elementos de Informática
        planA.grafoMaterias(materia4, materia3);  // Algorítmica y Programación I depende de Expresión de Problemas y Algoritmos
        planA.grafoMaterias(materia7, materia4);  // Algorítmica y Programación II depende de Algorítmica y Programación I
        planA.grafoMaterias(materia7, materia3);  // Algorítmica y Programación II depende de Expresión de Problemas y Algoritmos
        planA.grafoMaterias(materia7, materia6);  // Algorítmica y Programación II depende de Elementos de Lógica y Matemática Discreta
        planA.grafoMaterias(materia9, null); // Sistemas y Organizaciones no depende de nadie
        planA.grafoMaterias(materia6, null); // Elementos de Lógica y Matemática Discreta no depende de nadie
        planA.grafoMaterias(materia1, null); // Álgebra no depende de nadie
        planA.grafoMaterias(materia2, null); // Elementos de informatica no depende de nadie


        Materia materia1Geologia = new Materia("introduccion a la geologia",true,1);

        carera2.agregarMaterias(materia1Geologia);


        Alumno alumno1 = new Alumno("Rocio", "Jofre Olivero", "41789823", LocalDate.of(1999, 12, 22),new Libreta());
        Alumno alumno2 = new Alumno("Giuliano ignacio", "Poeta", "41789518", LocalDate.of(1999, 9, 14),new Libreta());
        Alumno alumno3 = new Alumno("Ignacio", "Sanchez", "51893674", LocalDate.of(2002, 8, 3),new Libreta());

        universidad.agregarAlumno(alumno1);
        universidad.agregarAlumno(alumno2);
        universidad.agregarAlumno(alumno3);

        carrera1.inscribirAlumno(alumno1);
        carrera1.inscribirAlumno(alumno2);
        carrera1.inscribirAlumno(alumno3);


        MateriaLibreta materiaLibreta1 = new MateriaLibreta("Algebra",true,1,9,"Aprobada");
        MateriaLibreta materiaLibreta2 = new MateriaLibreta("Analisis matematico",true,1,10,"Aprobada");
        MateriaLibreta materiaLibreta3 = new MateriaLibreta("Expresión de Problemas y Algoritmos",true,1,8,"Aprobada");
        MateriaLibreta materiaLibreta4 = new MateriaLibreta("Algorítmica y Programación I",true,1,9,"Aprobada");

        alumno1.agregarMateriaLibreta(materiaLibreta1);
        alumno1.agregarMateriaLibreta(materiaLibreta2);
        alumno1.agregarMateriaLibreta(materiaLibreta3);
        alumno1.agregarMateriaLibreta(materiaLibreta4);

        System.out.println(alumno1);
        alumno1.terminoCarrera(alumno1,planA);

        planA.inscribirAlumnoMateria(alumno1,materia3);

        System.out.println("Las materias con sus correlativas son: ");
        planA.getGrafo().print();

        System.out.println("Las materia : " );



    }
}

