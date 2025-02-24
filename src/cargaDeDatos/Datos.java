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

        // Planes de estudio
        PlanEstudio planA = new PlanEstudio('A');
        PlanEstudio planB = new PlanEstudio('B');
        PlanEstudio planC = new PlanEstudio('C');
        PlanEstudio planD = new PlanEstudio('D');
        PlanEstudio planE = new PlanEstudio('E');

        //Carreras
        Carrera carrera1 = new Carrera("Lic. en Sistemas", 5, planA);
        Carrera carrera2 = new Carrera("Lic. en Geología",5,planB);
        Carrera carrera3 = new Carrera("Lic. Biología", 5, planC);
        Carrera carrera4 = new Carrera("Lic. en Turísmo",5,planD);
        Carrera carrera5 = new Carrera("Ingeniería Industrial", 5, planE);

        //Agregar carreras a la universidad
        universidad.agregarCarrera(carrera1);
        universidad.agregarCarrera(carrera2);
        universidad.agregarCarrera(carrera3);
        universidad.agregarCarrera(carrera4);
        universidad.agregarCarrera(carrera5);

        //Materias - Sistemas
        Materia algebra = new Materia("Álgebra", true, 1);
        Materia epa = new Materia("Expresión de problemas y algorítmos", true, 1);
        Materia elemInfo = new Materia("Elementos de informática", true, 1);

        Materia aYp1 = new Materia("Algorítmica y programación I", true, 2);
        Materia elmd = new Materia("Elementos de lógica y matemática discreta", true, 2);
        Materia analisis = new Materia("Análisis matemático", true, 2);

        Materia sYo = new Materia("Sistemas y organizaciones", true, 3);
        Materia arquitectura = new Materia("Arquitectura de las computadoras", true, 3);
        Materia aYp2 = new Materia("Algorítmica y programación II", true, 3);
        Materia estadistica = new Materia("Estadística", true, 3);

        Materia bd1 = new Materia("Bases de datos I", true, 4);
        Materia poo = new Materia("Programación y diseño orientado a objetos", true, 4);
        Materia is1 = new Materia("Ingeniería de software I", true, 4);

        Materia lpl = new Materia("Laboratorio de programación y lenguajes", true, 5);
        Materia fundamentos = new Materia("Fundamentos teóricos de la informática", true, 5);
        Materia is2 = new Materia("Ingeniería de software II", true, 5);
        Materia concurrencia = new Materia("Introducción a la concurrencia", true, 5);

        Materia bd2 = new Materia("Bases de datos II", true, 6);
        Materia so = new Materia("Sistemas operativos", true, 6);
        Materia labSoftware = new Materia("Laboratorio de software", true, 6);
        Materia seminario1 = new Materia("Seminario de aspectos legales y profesionales I", true, 6);

        Materia redes = new Materia("Redes y transmisión de datos", true, 7);
        Materia paradigmas = new Materia("Paradigmas y lenguajes de programación", true, 7);
        Materia tallerNuevasTec = new Materia("Taller de nuevas tecnologías", true, 7);

        Materia sistemasDistribuidos = new Materia("Sistemas distribuidos", true, 8);
        Materia is3 = new Materia("Ingeniería de software III", true, 8);
        Materia seminario2 = new Materia("Seminario de aspectos legales y profesionales II", true, 8);
        Materia sistemasInteligentes = new Materia("Sistemas inteligentes", true, 8);

        Materia sistemasTiempoReal = new Materia("Sistemas de tiempo real", true, 9);
        Materia sistemasParalelos = new Materia("Sistemas paralelos", true, 9);
        Materia bdDistribuidas = new Materia("Bases de datos distribuidas", true, 9);
        Materia seminarioSeguridad = new Materia("Seminario de seguridad", true, 9);

        Materia modelosSimulacion = new Materia("Modelos y simulación", true, 10);
        Materia proyectoDeSoftware = new Materia("Proyecto de software", true, 10);




        //Agregar materias a la universidad
        universidad.agregarMateria(algebra);
        universidad.agregarMateria(epa);
        universidad.agregarMateria(elemInfo);
        universidad.agregarMateria(aYp1);
        universidad.agregarMateria(elmd);
        universidad.agregarMateria(analisis);
        universidad.agregarMateria(sYo);
        universidad.agregarMateria(arquitectura);
        universidad.agregarMateria(aYp2);
        universidad.agregarMateria(estadistica);
        universidad.agregarMateria(bd1);
        universidad.agregarMateria(poo);
        universidad.agregarMateria(is1);
        universidad.agregarMateria(lpl);
        universidad.agregarMateria(fundamentos);
        universidad.agregarMateria(is2);
        universidad.agregarMateria(concurrencia);
        universidad.agregarMateria(bd2);
        universidad.agregarMateria(so);
        universidad.agregarMateria(labSoftware);
        universidad.agregarMateria(seminario1);
        universidad.agregarMateria(redes);
        universidad.agregarMateria(paradigmas);
        universidad.agregarMateria(tallerNuevasTec);
        universidad.agregarMateria(sistemasDistribuidos);
        universidad.agregarMateria(is3);
        universidad.agregarMateria(seminario2);
        universidad.agregarMateria(sistemasInteligentes);
        universidad.agregarMateria(sistemasTiempoReal);
        universidad.agregarMateria(sistemasParalelos);
        universidad.agregarMateria(bdDistribuidas);
        universidad.agregarMateria(seminarioSeguridad);
        universidad.agregarMateria(modelosSimulacion);
        universidad.agregarMateria(proyectoDeSoftware);

        //Agregar las materias a la carrera Lic. en sistemas
        carrera1.agregarMaterias(algebra);
        carrera1.agregarMaterias(epa);
        carrera1.agregarMaterias(elemInfo);
        carrera1.agregarMaterias(aYp1);
        carrera1.agregarMaterias(elmd);
        carrera1.agregarMaterias(analisis);
        carrera1.agregarMaterias(sYo);
        carrera1.agregarMaterias(arquitectura);
        carrera1.agregarMaterias(aYp2);
        carrera1.agregarMaterias(estadistica);
        carrera1.agregarMaterias(bd1);
        carrera1.agregarMaterias(poo);
        carrera1.agregarMaterias(is1);
        carrera1.agregarMaterias(lpl);
        carrera1.agregarMaterias(fundamentos);
        carrera1.agregarMaterias(is2);
        carrera1.agregarMaterias(concurrencia);
        carrera1.agregarMaterias(bd2);
        carrera1.agregarMaterias(so);
        carrera1.agregarMaterias(labSoftware);
        carrera1.agregarMaterias(seminario1);
        carrera1.agregarMaterias(redes);
        carrera1.agregarMaterias(paradigmas);
        carrera1.agregarMaterias(tallerNuevasTec);
        carrera1.agregarMaterias(sistemasDistribuidos);
        carrera1.agregarMaterias(is3);
        carrera1.agregarMaterias(seminario2);
        carrera1.agregarMaterias(sistemasInteligentes);
        carrera1.agregarMaterias(sistemasTiempoReal);
        carrera1.agregarMaterias(sistemasParalelos);
        carrera1.agregarMaterias(bdDistribuidas);
        carrera1.agregarMaterias(seminarioSeguridad);
        carrera1.agregarMaterias(modelosSimulacion);
        carrera1.agregarMaterias(proyectoDeSoftware);

        //Agregar las materias al plan de estudio A
        planA.grafoMaterias(algebra,null);
        planA.grafoMaterias(epa,null);
        planA.grafoMaterias(elemInfo,null);
        planA.grafoMaterias(elmd,null);
        planA.grafoMaterias(analisis,null);
        planA.grafoMaterias(aYp1, epa); //Epa es correlativa de Ayp2
        planA.grafoMaterias(sYo,null);
        planA.grafoMaterias(arquitectura,elemInfo); //Elementos de informatica es correlativa de arquitectura
        planA.grafoMaterias(aYp2,aYp1); //aYp1 es correlativa de aYp2
        planA.grafoMaterias(estadistica,algebra); // algebra es correlativa de estadistica
        planA.grafoMaterias(estadistica,analisis); //Analisis es correlativa de estadistica
        planA.grafoMaterias(bd1,aYp2); //ayp2 es correlativa de BD2
        planA.grafoMaterias(poo,aYp2); // Ayp2 es correlativa de Poo
        planA.grafoMaterias(is1,aYp1); // aYp1 es correlativa de is1
        planA.grafoMaterias(lpl,bd1); // bd1 es correlativa de laboratorio de programacion y lenguajes
        planA.grafoMaterias(fundamentos,aYp2); // ayp2 es correlativa de fundamentos teoricos de la informatica
        planA.grafoMaterias(fundamentos,estadistica); // Estadistica es correlativa de fundamentos teoricos de la informatica
        planA.grafoMaterias(is2,is1); // is1 es correlativa de is2
        planA.grafoMaterias(is2,estadistica); // estadistica es correlativa de is2
        planA.grafoMaterias(concurrencia,arquitectura); // arquitectura es correlativa de concurrencia
        planA.grafoMaterias(concurrencia,aYp2); // aYp2 es correlativa de concurrencia
        planA.grafoMaterias(bd2,bd1); //bd1 es correlativa de bd2
        planA.grafoMaterias(so,concurrencia); //concurrencia es correlativa de Sistema operativos
        planA.grafoMaterias(labSoftware,bd1); //bd1 es correlativa de laboratorio de software
        planA.grafoMaterias(labSoftware,poo); //poo es correlativa de laboratorio de software
        planA.grafoMaterias(labSoftware,is1); //is1 es correlativa de laboratorio de software
        planA.grafoMaterias(seminario1,sYo); //sYo es correlativa de seminario 1
        planA.grafoMaterias(redes,so); //So es correlativa de redes
        planA.grafoMaterias(paradigmas,fundamentos); //Fundamentos es correlativa de paradigmas
        planA.grafoMaterias(paradigmas,poo); //Poo es correlativa de paradigmas
        planA.grafoMaterias(tallerNuevasTec,is1); // Is1 es correlativa de taller de nuevas tecnologias
        planA.grafoMaterias(sistemasDistribuidos,redes); //redes es correlativa de sistemas distribuidos
        planA.grafoMaterias(is3,is2); // is2 es correlativa de is3
        planA.grafoMaterias(seminario2,seminario1); // seminario1 es correlativa de seminario2
        planA.grafoMaterias(sistemasInteligentes,fundamentos); //Fundamentos es correlativa de sistemas inteligentes
        planA.grafoMaterias(sistemasTiempoReal,so); //So es correlativa de sistemas de teimpo real
        planA.grafoMaterias(sistemasParalelos,sistemasDistribuidos); //Sistemas distribuidos es correlativa de sistemas paralelos
        planA.grafoMaterias(sistemasParalelos,lpl); //laboratorio de programacion es correlativa de sistemas paralelos
        planA.grafoMaterias(bdDistribuidas,bd2); //Bd2 es correlativa de bases de datos distribuidas
        planA.grafoMaterias(bdDistribuidas,redes); //Redes es correlativa de bases de datos distribuidas
        planA.grafoMaterias(seminarioSeguridad,redes); // Redes es correlativa de bases de seminario de seguridad
        planA.grafoMaterias(modelosSimulacion,estadistica); //Estadistica es correlativa de modelos y simulacion
        planA.grafoMaterias(modelosSimulacion,paradigmas); //paradigmas es correlativa de modelos y simulacion
        planA.grafoMaterias(proyectoDeSoftware,is3); //Is3 es correlativa de proyecto de software

        System.out.println("Las materias con sus correlativas son: ");
        planA.getGrafo().print();


        // Materias Geologia


        //Alumnos
        Alumno alumno1 = new Alumno("Rocio", "Jofre Olivero", "41789823", LocalDate.of(1999, 12, 22),new Libreta());
        Alumno alumno2 = new Alumno("Giuliano ignacio", "Poeta", "41789518", LocalDate.of(1999, 9, 14),new Libreta());
        Alumno alumno3 = new Alumno("Ignacio", "Sanchez", "51893674", LocalDate.of(2002, 8, 3),new Libreta());
        Alumno alumno4 = new Alumno("Constanza", "Benedetti", "52145827", LocalDate.of(2002, 4, 12),new Libreta());
        Alumno alumno5 = new Alumno("Ignacio", "Sanchez", "51893674", LocalDate.of(2002, 5, 23),new Libreta());

        //Agregar alumnos a la universidad
        universidad.agregarAlumno(alumno1);
        universidad.agregarAlumno(alumno2);
        universidad.agregarAlumno(alumno3);
        universidad.agregarAlumno(alumno4);
        universidad.agregarAlumno(alumno5);

        //Crear las materias de la libreta de Rocio

        MateriaLibreta algebraLibreta = new MateriaLibreta("Álgebra", true, 1,10,"Aprobada");
        MateriaLibreta epaLibreta = new MateriaLibreta("Expresión de problemas y algorítmos", true, 1,8,"Aprobada");
        MateriaLibreta elemInfoLibreta = new MateriaLibreta("Elementos de informática", true, 1,9,"Regular");
        MateriaLibreta aYp1Libreta = new MateriaLibreta("Algorítmica y programación I", true, 2,8,"Aprobada");
        MateriaLibreta sYoLibreta = new MateriaLibreta("Sistemas y organizaciones", true, 3,10,"Aprobada");

        //Agregar las materias de la libreta de Rocio
        alumno1.agregarMateriaLibreta(algebraLibreta);
        alumno1.agregarMateriaLibreta(epaLibreta);
        alumno1.agregarMateriaLibreta(elemInfoLibreta);
        alumno1.agregarMateriaLibreta(aYp1Libreta);
        alumno1.agregarMateriaLibreta(sYoLibreta);

        //Inscribir al Rocio a la lic. en Sistemas
        carrera1.inscribirAlumno(alumno1);

        //

    }
}
