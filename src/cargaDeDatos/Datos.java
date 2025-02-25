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
        Carrera carrera4 = new Carrera("Lic. en Turismo", 5, planD);

        //Agregar carreras a la universidad
        universidad.agregarCarrera(carrera1);
        universidad.agregarCarrera(carrera2);
        universidad.agregarCarrera(carrera3);
        universidad.agregarCarrera(carrera4);

        // ---------------------------------------------------

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

        // ---------------------------------------------

        // Materias Geologia
        Materia introduccion = new Materia("Introducción a la Geología",true, 1);
        Materia quimicaInorganica = new Materia("Química general e inorgánica", true, 1);
        Materia matematica1 = new Materia("Matemática I", true, 1);

        Materia fisica1 = new Materia("Física I",true, 2);
        Materia introOceanosAtmosferas = new Materia("Introducción a las Ciencias del Océano y Atmósfera", true, 2);
        Materia mateAvanzada = new Materia("Matemática avanzada", true, 2);

        Materia minerologia1 = new Materia("Minerología I",true, 3);
        Materia paleontologia1 = new Materia("Paleontología I", true, 3);
        Materia estadisticaGeo = new Materia("Estadística para Geología", true, 3);

        Materia fisica2 = new Materia("Física II",true, 4);
        Materia minerologia2 = new Materia("Minerología II", true, 4);
        Materia geoquimica = new Materia("Geoquímica", true, 4);

        Materia petrologia = new Materia("Petrología de rocas ígneas",true, 5);
        Materia geoEstructural = new Materia("Geología estructural", true, 5);
        Materia sedimentologia = new Materia("Sedimentología", true, 5);
        Materia geofisica = new Materia("Geofísica", true, 5);

        Materia metodologias = new Materia("Metodologías de las Ciencias Naturales", true, 6);
        Materia petrologiaRocas = new Materia("Petrología de Rocas Metamórficas", true, 6);
        Materia geomorfologia = new Materia("Geomorfología", true, 6);
        Materia yacimientosNoMetaliferos = new Materia("Yacimientos no metalíferos", false,6);

        Materia estratigrafia = new Materia("Estratigrafía", true, 7);
        Materia yacimientos = new Materia("Geología de Yacimientos", true, 7);
        Materia hidrogeologia = new Materia("Hidrogeología", true, 7);

        Materia geoHistorica = new Materia("Geología Histórica", true, 8);
        Materia teledeteccion = new Materia("Teledetección y SIG", true, 8);
        Materia geoMarina = new Materia("Geología Marina", false,8);

        Materia geoArgentina = new Materia("Geología Regional Argentina", true, 9);
        Materia geoEconomica = new Materia("Geología Económica", true, 9);
        Materia geoCombustibles = new Materia("Geología de Combustibles", true, 9);
        Materia energias = new Materia("Energías Renovables", true, 9);

        Materia riesgoGeo = new Materia("Riesgo Geológico y Geología Ambiental", true, 10);
        Materia geoLegal = new Materia("Geología Legal", true, 10);
        Materia geotecnia = new Materia("Geotécnia", true, 10);
        Materia cambioGlobal = new Materia("Cambio Global", false,8);

        //Agregar las materias de geologia a la universidad
        universidad.agregarMateria(introduccion);
        universidad.agregarMateria(quimicaInorganica);
        universidad.agregarMateria(matematica1);
        universidad.agregarMateria(fisica1);
        universidad.agregarMateria(introOceanosAtmosferas);
        universidad.agregarMateria(mateAvanzada);
        universidad.agregarMateria(minerologia1);
        universidad.agregarMateria(paleontologia1);
        universidad.agregarMateria(estadisticaGeo);
        universidad.agregarMateria(fisica2);
        universidad.agregarMateria(minerologia2);
        universidad.agregarMateria(geoquimica);
        universidad.agregarMateria(petrologia);
        universidad.agregarMateria(geoEstructural);
        universidad.agregarMateria(sedimentologia);
        universidad.agregarMateria(geofisica);
        universidad.agregarMateria(metodologias);
        universidad.agregarMateria(petrologiaRocas);
        universidad.agregarMateria(geomorfologia);
        universidad.agregarMateria(estratigrafia);
        universidad.agregarMateria(yacimientos);
        universidad.agregarMateria(hidrogeologia);
        universidad.agregarMateria(geoHistorica);
        universidad.agregarMateria(teledeteccion);
        universidad.agregarMateria(geoArgentina);
        universidad.agregarMateria(geoEconomica);
        universidad.agregarMateria(geoCombustibles);
        universidad.agregarMateria(energias);
        universidad.agregarMateria(riesgoGeo);
        universidad.agregarMateria(geoLegal);
        universidad.agregarMateria(geotecnia);
        universidad.agregarMateria(yacimientosNoMetaliferos);
        universidad.agregarMateria(geoMarina);
        universidad.agregarMateria(cambioGlobal);

        //Agregar las materias a Geologia
        carrera2.agregarMaterias(introduccion);
        carrera2.agregarMaterias(quimicaInorganica);
        carrera2.agregarMaterias(matematica1);
        carrera2.agregarMaterias(fisica1);
        carrera2.agregarMaterias(introOceanosAtmosferas);
        carrera2.agregarMaterias(mateAvanzada);
        carrera2.agregarMaterias(minerologia1);
        carrera2.agregarMaterias(paleontologia1);
        carrera2.agregarMaterias(estadisticaGeo);
        carrera2.agregarMaterias(fisica2);
        carrera2.agregarMaterias(minerologia2);
        carrera2.agregarMaterias(geoquimica);
        carrera2.agregarMaterias(petrologia);
        carrera2.agregarMaterias(geoEstructural);
        carrera2.agregarMaterias(sedimentologia);
        carrera2.agregarMaterias(geofisica);
        carrera2.agregarMaterias(metodologias);
        carrera2.agregarMaterias(petrologiaRocas);
        carrera2.agregarMaterias(geomorfologia);
        carrera2.agregarMaterias(estratigrafia);
        carrera2.agregarMaterias(yacimientos);
        carrera2.agregarMaterias(hidrogeologia);
        carrera2.agregarMaterias(geoHistorica);
        carrera2.agregarMaterias(teledeteccion);
        carrera2.agregarMaterias(geoArgentina);
        carrera2.agregarMaterias(geoEconomica);
        carrera2.agregarMaterias(geoCombustibles);
        carrera2.agregarMaterias(energias);
        carrera2.agregarMaterias(riesgoGeo);
        carrera2.agregarMaterias(geoLegal);
        carrera2.agregarMaterias(geotecnia);
        carrera2.agregarMaterias(yacimientosNoMetaliferos);
        carrera2.agregarMaterias(geoMarina);
        carrera2.agregarMaterias(cambioGlobal);

        //Agregar las materias al plan de estudio B

        planB.grafoMaterias(introduccion,null); //Introduccion no tiene correlativas
        planB.grafoMaterias(quimicaInorganica,null); //quimica inorganica no tiene correlativas
        planB.grafoMaterias(matematica1,null); //mate 1 no tiene correlativas
        planB.grafoMaterias(fisica1,null); //fisica 1 no tiene correlativas
        planB.grafoMaterias(introOceanosAtmosferas,null); //Introduccion a oceanos y atmosferas no tiene correlativas
        planB.grafoMaterias(mateAvanzada,matematica1); //mate1 es correlativa de matematica avanzada
        planB.grafoMaterias(minerologia1,introduccion); //introduccion es correlativa de minerologia 1
        planB.grafoMaterias(paleontologia1,introduccion); //introduccion es correlativa de paleontologia 1
        planB.grafoMaterias(estadisticaGeo,mateAvanzada); //mateAvanzada es correlativa de estadistica para geologia
        planB.grafoMaterias(fisica2,fisica1); //fisica1 es correlativa de fisica2
        planB.grafoMaterias(minerologia2,minerologia1); //minerologia1 es correlativa de minerologia2
        planB.grafoMaterias(geoquimica,quimicaInorganica); //quimica inorganica es correlativa de geoQuimica
        planB.grafoMaterias(petrologia,null); //Petrologia no tiene corerlativas
        planB.grafoMaterias(geoEstructural,introduccion); //introduccion es correlativa de geoEstructural
        planB.grafoMaterias(sedimentologia,introduccion); //introduccion es correlativa de sedimentologia
        planB.grafoMaterias(sedimentologia,minerologia2);//minerologia2 es correlativa de sedimentologia
        planB.grafoMaterias(geofisica,fisica2);//fisica2 es correlativa de geofisica
        planB.grafoMaterias(metodologias,null); //Metodologias no tiene correlativas
        planB.grafoMaterias(petrologiaRocas,petrologia);//minerologia2 es correlativa de sedimentologia
        planB.grafoMaterias(geomorfologia,fisica2);//fisica2 es correlativa de geomorfologia
        planB.grafoMaterias(yacimientosNoMetaliferos,null); //yacimientosNoMetaliferos no tiene correlativas
        planB.grafoMaterias(estratigrafia,geoEstructural); //geoEstructural es corerlativa de estratigrafia
        planB.grafoMaterias(yacimientos,yacimientosNoMetaliferos); //yacimientosNoMetaliferos es correlativa de yacimientos
        planB.grafoMaterias(hidrogeologia,sedimentologia); //sedimentologia es correlativa de hidrogeologia
        planB.grafoMaterias(geoHistorica,null);//geoHistorica no tiene correlativas
        planB.grafoMaterias(teledeteccion,geofisica);//geofisica es correlativa de teledeteccion
        planB.grafoMaterias(geoMarina,null); //geoMarina no tiene correlativas
        planB.grafoMaterias(geoArgentina,geoHistorica);//geoHistorica es correlativa de geoArgentina
        planB.grafoMaterias(geoEconomica,fisica2);//fisica2 es correlativa de geoEconomica
        planB.grafoMaterias(geoCombustibles,estratigrafia); //estratigrafia es correlativa de geoCombustibles
        planB.grafoMaterias(energias,null);//energias no tiene correlativas
        planB.grafoMaterias(riesgoGeo,teledeteccion); //teledeteccion es correlativa de riesgoGeo
        planB.grafoMaterias(geoLegal,geoHistorica);//geoHistorica es correlativa de geoLegal
        planB.grafoMaterias(geotecnia,estratigrafia);//estratigrafia es correlativa de geotecnia
        planB.grafoMaterias(cambioGlobal,yacimientos); //yacimientos es correlativa de cambioGlobal


        // Materias de Biologia

        // Materias de Biologia
        Materia introduccionABiologia = new Materia("Introducción a la Biología", true, 1);
        Materia microorganismosProtistasHongos = new Materia("Biología de Microorganismos, Protistas y Hongos", true, 2);
        Materia quimicaOrganica = new Materia("Química Orgánica", true, 2);
        Materia matematica2 = new Materia("Matemática II para Ciencias Naturales", true, 2);
        Materia biologiaAnimal = new Materia("Biología Animal", true, 3);
        Materia quimicaBiologica = new Materia("Química Biológica", true, 3);
        Materia biologiaVegetal = new Materia("Biología Vegetal", true, 4);
        Materia diversidadAnimal1 = new Materia("Diversidad Animal I", true, 4);
        Materia biologiaMolecularCelular = new Materia("Biología Molecular y Celular", true, 4);
        Materia biologiaGenetica = new Materia("Genética", true, 5);
        Materia biologiaEstadistica2 = new Materia("Estadística II para Ciencias Naturales", true, 5);
        Materia biologiaFisiologiaVegetal = new Materia("Fisiología Vegetal", true, 5);
        Materia diversidadAnimal2 = new Materia("Diversidad Animal II", true, 6);
        Materia biologiaDiversidadVegetal = new Materia("Diversidad Vegetal", true, 6);
        Materia biologiaEcologiaGeneral = new Materia("Ecología General", true, 6);
        Materia biologiaConservacion = new Materia("Biología de la Conservación", true, 7);
        Materia biologiaEvolucion = new Materia("Evolución", true, 7);
        Materia biologiaFisiologiaAnimal = new Materia("Fisiología Animal", true, 7);
        Materia biologiaTallerTrabajoFinal = new Materia("Taller del Trabajo Final", true, 8);
        Materia biologiaEcologiaPoblaciones = new Materia("Ecología de las Poblaciones", true, 8);
        Materia biologiaEcologiaMarina = new Materia("Ecología Marina", false, 8);
        Materia biologiaEcologiaComunidades = new Materia("Ecología de las Comunidades", true, 9);
        Materia biologiaEcologiaAplicada = new Materia("Ecología Aplicada", true, 9);
        Materia biologiaQuimicaAmbiental = new Materia("Química Ambiental", false, 9);
        Materia oceanografiaBiologica = new Materia("Oceanografía Biológica", false, 10);
        Materia limnologia = new Materia("Cambio Global", false, 10);

// Agregar las materias de Biologia a la universidad
        universidad.agregarMateria(introduccionABiologia);
        universidad.agregarMateria(microorganismosProtistasHongos);
        universidad.agregarMateria(quimicaOrganica);
        universidad.agregarMateria(matematica2);
        universidad.agregarMateria(biologiaAnimal);
        universidad.agregarMateria(quimicaBiologica);
        universidad.agregarMateria(biologiaVegetal);
        universidad.agregarMateria(diversidadAnimal1);
        universidad.agregarMateria(biologiaMolecularCelular);
        universidad.agregarMateria(biologiaGenetica);
        universidad.agregarMateria(biologiaEstadistica2);
        universidad.agregarMateria(biologiaFisiologiaVegetal);
        universidad.agregarMateria(diversidadAnimal2);
        universidad.agregarMateria(biologiaDiversidadVegetal);
        universidad.agregarMateria(biologiaEcologiaGeneral);
        universidad.agregarMateria(biologiaConservacion);
        universidad.agregarMateria(biologiaEvolucion);
        universidad.agregarMateria(biologiaFisiologiaAnimal);
        universidad.agregarMateria(biologiaTallerTrabajoFinal);
        universidad.agregarMateria(biologiaEcologiaPoblaciones);
        universidad.agregarMateria(biologiaEcologiaMarina);
        universidad.agregarMateria(biologiaEcologiaComunidades);
        universidad.agregarMateria(biologiaEcologiaAplicada);
        universidad.agregarMateria(biologiaQuimicaAmbiental);
        universidad.agregarMateria(oceanografiaBiologica);
        universidad.agregarMateria(limnologia);

// Agregar las materias a la carrera "Biologia"
        carrera3.agregarMaterias(introduccionABiologia);
        carrera3.agregarMaterias(matematica1);
        carrera3.agregarMaterias(quimicaInorganica);
        carrera3.agregarMaterias(fisica1);
        carrera3.agregarMaterias(estadisticaGeo);
        carrera3.agregarMaterias(fisica2);
        carrera3.agregarMaterias(metodologias);
        carrera3.agregarMaterias(introduccion);
        carrera3.agregarMaterias(teledeteccion);
        carrera3.agregarMaterias(microorganismosProtistasHongos);
        carrera3.agregarMaterias(quimicaOrganica);
        carrera3.agregarMaterias(matematica2);
        carrera3.agregarMaterias(biologiaAnimal);
        carrera3.agregarMaterias(quimicaBiologica);
        carrera3.agregarMaterias(biologiaVegetal);
        carrera3.agregarMaterias(diversidadAnimal1);
        carrera3.agregarMaterias(biologiaMolecularCelular);
        carrera3.agregarMaterias(biologiaGenetica);
        carrera3.agregarMaterias(biologiaEstadistica2);
        carrera3.agregarMaterias(biologiaFisiologiaVegetal);
        carrera3.agregarMaterias(diversidadAnimal2);
        carrera3.agregarMaterias(biologiaDiversidadVegetal);
        carrera3.agregarMaterias(biologiaEcologiaGeneral);
        carrera3.agregarMaterias(biologiaConservacion);
        carrera3.agregarMaterias(biologiaEvolucion);
        carrera3.agregarMaterias(biologiaFisiologiaAnimal);
        carrera3.agregarMaterias(biologiaTallerTrabajoFinal);
        carrera3.agregarMaterias(biologiaEcologiaPoblaciones);
        carrera3.agregarMaterias(biologiaEcologiaMarina);
        carrera3.agregarMaterias(biologiaEcologiaComunidades);
        carrera3.agregarMaterias(biologiaEcologiaAplicada);
        carrera3.agregarMaterias(biologiaQuimicaAmbiental);
        carrera3.agregarMaterias(oceanografiaBiologica);
        carrera3.agregarMaterias(limnologia);

        //Agregar las materias al plan C de biologa
        planC.grafoMaterias(introduccionABiologia,null);
        planC.grafoMaterias(introduccion,null);
        planC.grafoMaterias(matematica1,null);
        planC.grafoMaterias(quimicaInorganica,null);
        planC.grafoMaterias(fisica1,null);
        planC.grafoMaterias(microorganismosProtistasHongos,null);
        planC.grafoMaterias(quimicaOrganica,quimicaInorganica);
        planC.grafoMaterias(matematica2,matematica1);
        planC.grafoMaterias(fisica2,fisica1);
        planC.grafoMaterias(biologiaAnimal,quimicaOrganica);
        planC.grafoMaterias(biologiaAnimal,introduccionABiologia);
        planC.grafoMaterias(quimicaBiologica,quimicaOrganica);
        planC.grafoMaterias(biologiaMolecularCelular,quimicaOrganica);
        planC.grafoMaterias(estadisticaGeo,matematica2);
        planC.grafoMaterias(biologiaEstadistica2,estadisticaGeo);
        planC.grafoMaterias(biologiaVegetal,introduccionABiologia);
        planC.grafoMaterias(biologiaVegetal,introduccion);
        planC.grafoMaterias(biologiaFisiologiaVegetal,biologiaVegetal);
        planC.grafoMaterias(metodologias,introduccion);
        planC.grafoMaterias(metodologias,introduccionABiologia);
        planC.grafoMaterias(biologiaEcologiaGeneral,introduccion);
        planC.grafoMaterias(biologiaEcologiaGeneral,biologiaFisiologiaVegetal);
        planC.grafoMaterias(biologiaDiversidadVegetal,biologiaFisiologiaVegetal);
        planC.grafoMaterias(biologiaConservacion,biologiaEcologiaGeneral);
        planC.grafoMaterias(biologiaConservacion,biologiaGenetica);
        planC.grafoMaterias(biologiaGenetica,quimicaBiologica);
        planC.grafoMaterias(biologiaGenetica,biologiaMolecularCelular);
        planC.grafoMaterias(diversidadAnimal1,biologiaAnimal);
        planC.grafoMaterias(diversidadAnimal2,diversidadAnimal1);
        planC.grafoMaterias(biologiaFisiologiaAnimal,diversidadAnimal2);
        planC.grafoMaterias(biologiaEvolucion,biologiaGenetica);
        planC.grafoMaterias(biologiaTallerTrabajoFinal,biologiaFisiologiaAnimal);
        planC.grafoMaterias(biologiaEcologiaPoblaciones,biologiaEcologiaGeneral);
        planC.grafoMaterias(biologiaEcologiaMarina,biologiaEcologiaGeneral);
        planC.grafoMaterias(biologiaEcologiaComunidades,biologiaEcologiaMarina);
        planC.grafoMaterias(biologiaEcologiaComunidades,biologiaEcologiaPoblaciones);
        planC.grafoMaterias(limnologia,biologiaEcologiaPoblaciones);
        planC.grafoMaterias(biologiaEcologiaAplicada,biologiaTallerTrabajoFinal);
        planC.grafoMaterias(biologiaQuimicaAmbiental,quimicaOrganica);
        planC.grafoMaterias(oceanografiaBiologica,biologiaEvolucion);
        planC.grafoMaterias(teledeteccion,biologiaEstadistica2);

        //Materias lic. en turismo

        Materia introduccionAlTurismo = new Materia("Introducción al Turismo", true, 1);
        Materia geografiaFisica = new Materia("Geografía Física", true, 1);
        Materia sociologia = new Materia("Sociología", true, 2);
        Materia epistemologia = new Materia("Epistemología", true, 2);
        Materia seminarioIntroPracticasProf = new Materia("Seminario: Introducción a las Prácticas Profesionales", true, 2);
        Materia servTurTransporte = new Materia("Servicios Turísticos. Transporte", true, 3);
        Materia servTurAlojamiento = new Materia("Servicios Turísticos. Alojamiento", true, 3);
        Materia ecologiaYConservacion = new Materia("Ecología y Conservación", true, 3);
        Materia psicologiaSocial = new Materia("Psicología Social", true, 3);
        Materia parquesNacionales = new Materia("Parques Nacionales", true, 4);
        Materia geografiaHumana = new Materia("Geografía Humana", true, 4);
        Materia historiaSocialArgentina = new Materia("Historia Social Argentina", true, 4);
        Materia practicaProfesionalI = new Materia("Práctica Profesional I", true, 4);
        Materia servTurAgenciasViajes = new Materia("Servicios Turísticos. Agencias de Viajes", true, 5);
        Materia psicologiaGruposInstituciones = new Materia("Psicología de los Grupos y de las Instituciones", true, 5);
        Materia patrimonioCultural = new Materia("Patrimonio Cultural", true, 5);
        Materia metodologiaInvestigacion = new Materia("Metodología de la Investigación", true, 5);
        Materia teoriaAdministracion = new Materia("Teoría de la Administración", true, 6);
        Materia administracion = new Materia("Administración", true, 6);
        Materia practicaProfesionalII = new Materia("Práctica Profesional II", true, 6);
        Materia primerNivelIngles = new Materia("Primer Nivel de Idioma - Inglés", true, 6);
        Materia adminEmpresasTuristicas = new Materia("Administración de Empresas Turísticas", true, 7);
        Materia economia = new Materia("Economía", true, 7);
        Materia antropologiaCultural = new Materia("Antropología Cultural", true, 7);
        Materia politicaTuristica = new Materia("Política Turística", true, 8);
        Materia historiaAmericana = new Materia("Historia Americana", true, 8);
        Materia practicaProfesionalIII = new Materia("Práctica Profesional III", true, 8);
        Materia planificacionTuristica = new Materia("Planificación Turística", true, 9);
        Materia investigacionTuristica = new Materia("Investigación Turística", true, 9);
        Materia practicaProfesionalIV = new Materia("Práctica Profesional IV", true, 9);
        Materia seminarioOptativoI = new Materia("Seminario Optativo I", true, 10);
        Materia seminarioOptativoII = new Materia("Seminario Optativo II", true, 10);
        Materia tesisDeGrado = new Materia("Tesis de Grado", true, 10);

        //Agregar las materias de tursimo a la universidad

        universidad.agregarMateria(introduccionAlTurismo);
        universidad.agregarMateria(geografiaFisica);
        universidad.agregarMateria(sociologia);
        universidad.agregarMateria(epistemologia);
        universidad.agregarMateria(seminarioIntroPracticasProf);
        universidad.agregarMateria(servTurTransporte);
        universidad.agregarMateria(servTurAlojamiento);
        universidad.agregarMateria(ecologiaYConservacion);
        universidad.agregarMateria(psicologiaSocial);
        universidad.agregarMateria(parquesNacionales);
        universidad.agregarMateria(geografiaHumana);
        universidad.agregarMateria(historiaSocialArgentina);
        universidad.agregarMateria(practicaProfesionalI);
        universidad.agregarMateria(servTurAgenciasViajes);
        universidad.agregarMateria(psicologiaGruposInstituciones);
        universidad.agregarMateria(patrimonioCultural);
        universidad.agregarMateria(metodologiaInvestigacion);
        universidad.agregarMateria(teoriaAdministracion);
        universidad.agregarMateria(administracion);
        universidad.agregarMateria(practicaProfesionalII);
        universidad.agregarMateria(primerNivelIngles);
        universidad.agregarMateria(adminEmpresasTuristicas);
        universidad.agregarMateria(economia);
        universidad.agregarMateria(antropologiaCultural);
        universidad.agregarMateria(politicaTuristica);
        universidad.agregarMateria(historiaAmericana);
        universidad.agregarMateria(practicaProfesionalIII);
        universidad.agregarMateria(planificacionTuristica);
        universidad.agregarMateria(investigacionTuristica);
        universidad.agregarMateria(practicaProfesionalIV);
        universidad.agregarMateria(seminarioOptativoI);
        universidad.agregarMateria(seminarioOptativoII);
        universidad.agregarMateria(tesisDeGrado);

        // Agregamos las materias a la carrera de turismo
        carrera4.agregarMaterias(introduccionAlTurismo);
        carrera4.agregarMaterias(geografiaFisica);
        carrera4.agregarMaterias(sociologia);
        carrera4.agregarMaterias(epistemologia);
        carrera4.agregarMaterias(seminarioIntroPracticasProf);
        carrera4.agregarMaterias(servTurTransporte);
        carrera4.agregarMaterias(servTurAlojamiento);
        carrera4.agregarMaterias(ecologiaYConservacion);
        carrera4.agregarMaterias(psicologiaSocial);
        carrera4.agregarMaterias(parquesNacionales);
        carrera4.agregarMaterias(geografiaHumana);
        carrera4.agregarMaterias(historiaSocialArgentina);
        carrera4.agregarMaterias(practicaProfesionalI);
        carrera4.agregarMaterias(servTurAgenciasViajes);
        carrera4.agregarMaterias(psicologiaGruposInstituciones);
        carrera4.agregarMaterias(patrimonioCultural);
        carrera4.agregarMaterias(metodologiaInvestigacion);
        carrera4.agregarMaterias(teoriaAdministracion);
        carrera4.agregarMaterias(administracion);
        carrera4.agregarMaterias(practicaProfesionalII);
        carrera4.agregarMaterias(primerNivelIngles);
        carrera4.agregarMaterias(adminEmpresasTuristicas);
        carrera4.agregarMaterias(economia);
        carrera4.agregarMaterias(antropologiaCultural);
        carrera4.agregarMaterias(politicaTuristica);
        carrera4.agregarMaterias(historiaAmericana);
        carrera4.agregarMaterias(practicaProfesionalIII);
        carrera4.agregarMaterias(planificacionTuristica);
        carrera4.agregarMaterias(investigacionTuristica);
        carrera4.agregarMaterias(practicaProfesionalIV);
        carrera4.agregarMaterias(seminarioOptativoI);
        carrera4.agregarMaterias(seminarioOptativoII);
        carrera4.agregarMaterias(tesisDeGrado);

        //Agregar las materias al plan de estudio D

        planD.grafoMaterias(introduccionAlTurismo,null);
        planD.grafoMaterias(geografiaFisica,null);
        planD.grafoMaterias(sociologia,null);
        planD.grafoMaterias(epistemologia,null);
        planD.grafoMaterias(seminarioIntroPracticasProf,null);
        planD.grafoMaterias(servTurTransporte,introduccionAlTurismo);
        planD.grafoMaterias(servTurAlojamiento,introduccionAlTurismo);
        planD.grafoMaterias(ecologiaYConservacion, geografiaFisica);
        planD.grafoMaterias(psicologiaSocial, sociologia);
        planD.grafoMaterias(parquesNacionales, geografiaFisica);
        planD.grafoMaterias(parquesNacionales, ecologiaYConservacion);
        planD.grafoMaterias(geografiaHumana, geografiaFisica);
        planD.grafoMaterias(historiaSocialArgentina, sociologia);
        planD.grafoMaterias(practicaProfesionalI, introduccionAlTurismo);
        planD.grafoMaterias(practicaProfesionalI, geografiaFisica);
        planD.grafoMaterias(practicaProfesionalI, seminarioIntroPracticasProf);
        planD.grafoMaterias(servTurAgenciasViajes, servTurTransporte);
        planD.grafoMaterias(psicologiaGruposInstituciones, psicologiaSocial);
        planD.grafoMaterias(patrimonioCultural, historiaSocialArgentina);
        planD.grafoMaterias(metodologiaInvestigacion, epistemologia);
        planD.grafoMaterias(teoriaAdministracion, null);
        planD.grafoMaterias(practicaProfesionalII, practicaProfesionalI);
        planD.grafoMaterias(primerNivelIngles, null);
        planD.grafoMaterias(adminEmpresasTuristicas, servTurAgenciasViajes);
        planD.grafoMaterias(adminEmpresasTuristicas, teoriaAdministracion);
        planD.grafoMaterias(economia, null);
        planD.grafoMaterias(antropologiaCultural, sociologia);
        planD.grafoMaterias(politicaTuristica, introduccionAlTurismo);
        planD.grafoMaterias(politicaTuristica, sociologia);
        planD.grafoMaterias(historiaAmericana, historiaSocialArgentina);
        planD.grafoMaterias(practicaProfesionalIII, practicaProfesionalII);
        planD.grafoMaterias(planificacionTuristica, metodologiaInvestigacion);
        planD.grafoMaterias(investigacionTuristica, metodologiaInvestigacion);
        planD.grafoMaterias(practicaProfesionalIV, practicaProfesionalIII);
        planD.grafoMaterias(seminarioOptativoI, null);
        planD.grafoMaterias(seminarioOptativoII, seminarioOptativoI);
        planD.grafoMaterias(tesisDeGrado, practicaProfesionalIV);


        //Alumnos
        Alumno alumno1 = new Alumno("Rocio", "Jofre Olivero", "41789823", LocalDate.of(1999, 12, 22),new Libreta());
        Alumno alumno2 = new Alumno("Giuliano ignacio", "Poeta", "41789518", LocalDate.of(1999, 9, 14),new Libreta());
        Alumno alumno3 = new Alumno("Ignacio", "Sanchez", "51893674", LocalDate.of(2002, 8, 3),new Libreta());
        Alumno alumno4 = new Alumno("Constanza", "Benedetti", "52145827", LocalDate.of(2002, 4, 12),new Libreta());
        Alumno alumno5 = new Alumno("Tiago", "Cardenas", "52937169", LocalDate.of(2002, 5, 23),new Libreta());

        //Agregar alumnos a la universidad
        universidad.agregarAlumno(alumno1);
        universidad.agregarAlumno(alumno2);
        universidad.agregarAlumno(alumno3);
        universidad.agregarAlumno(alumno4);
        universidad.agregarAlumno(alumno5);

        // ----------------------------------------

        //Inscribir al Rocio a la lic. en Sistemas
        carrera1.inscribirAlumno(alumno1);

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

        // ------------------------------------

        //Inscribir a Giuliano a Geologia
        carrera2.inscribirAlumno(alumno2);

        // Crear las materias de la Libreta de Giuliano
        MateriaLibreta introduccionLibreta = new MateriaLibreta("Introducción a la Geología",true, 1,10,"Aprobada");
        MateriaLibreta quimicaInorganicaLibreta = new MateriaLibreta("Química general e inorgánica", true, 1,8,"Regular");
        MateriaLibreta matematica1Libreta = new MateriaLibreta("Matemática I", true, 1,8,"Aprobada");
        MateriaLibreta fisica1Libreta = new MateriaLibreta("Física I",true, 2,9,"Aprobada");
        MateriaLibreta mateAvanzadaLibreta = new MateriaLibreta("Matemática avanzada", true, 2,10,"Aprobada");
        MateriaLibreta paleontologiaLibreta = new MateriaLibreta("Paleontología I", true, 3,7,"Regular");
        MateriaLibreta estadisticaGeoLibreta = new MateriaLibreta("Estadística para Geología", true, 3,8,"Aprobada");

        //Agregar materias a la libreta de Giuliano
        alumno2.agregarMateriaLibreta(introduccionLibreta);
        alumno2.agregarMateriaLibreta(quimicaInorganicaLibreta);
        alumno2.agregarMateriaLibreta(matematica1Libreta);
        alumno2.agregarMateriaLibreta(fisica1Libreta);
        alumno2.agregarMateriaLibreta(mateAvanzadaLibreta);
        alumno2.agregarMateriaLibreta(paleontologiaLibreta);
        alumno2.agregarMateriaLibreta(estadisticaGeoLibreta);

        // ----------------------------------------

        //Inscribir a Ignacio sanchez a Biologia
        carrera3.inscribirAlumno(alumno3);

        // Crear las materias de la Libreta de Ignacio
        MateriaLibreta introduccionLibreta2 = new MateriaLibreta("Introducción a la Geología",true, 1,9,"Aprobada");
        MateriaLibreta introduccionABiologiaLibreta = new MateriaLibreta("Introducción a la Biología",true, 1,9,"Aprobada");
        MateriaLibreta quimicaInorganicaLibreta2 = new MateriaLibreta("Química general e inorgánica", true, 1,7,"Aprobada");
        MateriaLibreta matematica1Libreta1 = new MateriaLibreta("Matemática I", true, 1,7,"Aprobada");
        MateriaLibreta fisica1Libreta1 = new MateriaLibreta("Física I",true, 2,8,"Aprobada");
        MateriaLibreta matematica2Libreta = new MateriaLibreta("Matemática II para Ciencias Naturales", true, 2,10,"Aprobada");
        MateriaLibreta quimicaOrganicaLibreta = new MateriaLibreta("Química Orgánica", true, 2,7,"Aprobada");
        MateriaLibreta microorganismosProtistasHongosLibreta = new MateriaLibreta("Biología de Microorganismos, Protistas y Hongos", true, 2,8,"Aprobada");
        MateriaLibreta biologiaAnimalLibreta = new MateriaLibreta("Biología Animal", true, 3,8,"Aprobada");
        MateriaLibreta quimicaBiologicaLibreta = new MateriaLibreta("Química Biológica", true, 3,10,"Aprobada");
        MateriaLibreta estadisticaBioLibreta = new MateriaLibreta("Estadística para Geología", true, 3,7,"Aprobada");
        MateriaLibreta diversidadAnimal1Libreta = new MateriaLibreta("Diversidad Animal I", true, 4,8,"Aprobada");
        MateriaLibreta biologiaMolecularCelularLibreta = new MateriaLibreta("Biología Molecular y Celular", true, 4,9,"Aprobada");
        MateriaLibreta estadistica1Libreta = new MateriaLibreta("Estadística para Geología", true, 3,7,"Aprobada");


        //Agregar materias a la libreta de Ignacio
        alumno3.agregarMateriaLibreta(introduccionLibreta2);
        alumno3.agregarMateriaLibreta(introduccionABiologiaLibreta);
        alumno3.agregarMateriaLibreta(quimicaInorganicaLibreta2);
        alumno3.agregarMateriaLibreta(matematica1Libreta1);
        alumno3.agregarMateriaLibreta(fisica1Libreta1);
        alumno3.agregarMateriaLibreta(matematica2Libreta);
        alumno3.agregarMateriaLibreta(quimicaOrganicaLibreta);
        alumno3.agregarMateriaLibreta(microorganismosProtistasHongosLibreta);
        alumno3.agregarMateriaLibreta(biologiaAnimalLibreta);
        alumno3.agregarMateriaLibreta(quimicaBiologicaLibreta);
        alumno3.agregarMateriaLibreta(estadisticaBioLibreta);
        alumno3.agregarMateriaLibreta(diversidadAnimal1Libreta);
        alumno3.agregarMateriaLibreta(quimicaOrganicaLibreta);
        alumno3.agregarMateriaLibreta(biologiaMolecularCelularLibreta);
        alumno3.agregarMateriaLibreta(estadistica1Libreta);

        //---------------------------------------------\

        //Inscribir a constanza a Turismo
        carrera4.inscribirAlumno(alumno4);

        // Crear las materias de la Libreta de constanza
        MateriaLibreta introduccionTurismoLibreta = new MateriaLibreta("Introducción al Turismo", true, 1,8,"Aprobada");
        MateriaLibreta geografiaFisicaLibreta = new MateriaLibreta("Geografía Física", true, 1,9,"Aprobada");
        MateriaLibreta sociologiaLibreta = new MateriaLibreta("Sociología", true, 2,10,"Aprobada");
        MateriaLibreta epistemologiaLibreta = new MateriaLibreta("Epistemología", true, 2,7,"Aprobada");
        MateriaLibreta seminarioIntroPracticasProfLibreta = new MateriaLibreta("Seminario: Introducción a las Prácticas Profesionales", true, 2,8,"Aprobada");
        MateriaLibreta servTurTransporteLibreta = new MateriaLibreta("Servicios Turísticos. Transporte", true, 3,8,"Aprobada");
        MateriaLibreta servTurAlojamientoLibreta = new MateriaLibreta("Servicios Turísticos. Alojamiento", true, 3,10,"Aprobada");
        MateriaLibreta ecologiaYConservacionLibreta = new MateriaLibreta("Ecología y Conservación", true, 3,7,"Aprobada");
        MateriaLibreta psicologiaSocialLibreta = new MateriaLibreta("Psicología Social", true, 3,8,"Aprobada");
        MateriaLibreta parquesNacionalesLibreta = new MateriaLibreta("Parques Nacionales", true, 4,8,"Aprobada");

        //Agregar las materias a su libreta

        alumno4.agregarMateriaLibreta(introduccionTurismoLibreta);
        alumno4.agregarMateriaLibreta(geografiaFisicaLibreta);
        alumno4.agregarMateriaLibreta(sociologiaLibreta);
        alumno4.agregarMateriaLibreta(epistemologiaLibreta);
        alumno4.agregarMateriaLibreta(seminarioIntroPracticasProfLibreta);
        alumno4.agregarMateriaLibreta(servTurTransporteLibreta);
        alumno4.agregarMateriaLibreta(servTurAlojamientoLibreta);
        alumno4.agregarMateriaLibreta(ecologiaYConservacionLibreta);
        alumno4.agregarMateriaLibreta(psicologiaSocialLibreta);
        alumno4.agregarMateriaLibreta(parquesNacionalesLibreta);


    }
}
