package planDeEstudio;

import alumno.Alumno;
import grafoMaterias.Grafo;
import grafoMaterias.Nodo;
import materia.Materia;
import materia.MateriaLibreta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlanEstudio {
    //Atributos
    private Grafo correlativas;
    private char tipoPlan;

    //Constructor
    public PlanEstudio(char tipoPlan) {
        this.correlativas = new Grafo();
        this.setTipoPlan(tipoPlan);
    }


    //Metodos
    public void grafoMaterias(Materia materia, Materia correlativa) {
        if (materia == null) {
            throw new IllegalArgumentException("La materia principal no puede ser nula");
        }
        Nodo nodoMateria = correlativas.obtenernodo(materia);
        if (nodoMateria == null) {
            nodoMateria = correlativas.agregarMateria(materia);
        }
        if (correlativa != null) {
            Nodo nodoCorrelativa = correlativas.obtenernodo(correlativa);
            if (nodoCorrelativa == null) {
                nodoCorrelativa = correlativas.agregarMateria(correlativa);
            }
            correlativas.agregarArista(nodoMateria, nodoCorrelativa);
        }
    }
    public boolean inscribirAlumnoMateria(Alumno alumno, Materia materia) {
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        if (this.getTipoPlan() == 'A') {
            boolean inscripcion = false;
            inscripcion = correlativasRegular(alumno, materia);
            if (inscripcion) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
                boolean materiaNueva = alumno.getLibretaAlumno().buscarMateria(nuevaMateriaLibreta);
                if (materiaNueva){
                    System.out.println("nueva materia en la libreta: " + nuevaMateriaLibreta.getNombre());
                } else {
                    System.out.println("no se agrego nada");
                }

                return true;
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
                return false;
            }
        } else if (this.getTipoPlan() == 'B') {
            boolean inscripcion = false;
            inscripcion = correlativasAprobadas(alumno, materia);
            if (inscripcion) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
                return true;
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
                return false;
            }
        } else if (this.getTipoPlan() == 'C') {
            boolean verificarCorrelativa = correlativasRegular(alumno, materia);
            boolean verificarMateriaCuatrimestre = finalesAprobadosMenosCorrelativas(alumno, materia, 5);
            if (verificarCorrelativa && verificarMateriaCuatrimestre) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
                return true;
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
                return false;
            }
        } else if (this.getTipoPlan() == 'D') {
            boolean verificarCorrelativa = correlativasRegular(alumno, materia);
            boolean verificarMateriaCuatrimestre = finalesAprobadosMenosCorrelativas(alumno, materia, 3);
            if (verificarCorrelativa && verificarMateriaCuatrimestre) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
                return true;
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
                return false;
            }
        } else if (this.getTipoPlan() == 'E') {
            boolean verificarCorrelativa = correlativasRegular(alumno, materia);
            boolean verificarMateriaCuatrimestre = finalesAprobados(alumno, materia, 3);
            if (verificarCorrelativa && verificarMateriaCuatrimestre) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
                return true;
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
                return false;
            }
        }
        return false;
    }


    private boolean correlativasRegular(Alumno alumno, Materia materia) {
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        if(correlativasDirectas == null || correlativasDirectas.isEmpty()) {
            return true;
        }
        for (Nodo correlativa : correlativasDirectas) {
            boolean encontrada = false;
            for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                if (correlativa.getmateria().getNombre().equals(materiaLibreta.getNombre()) &&
                        ("Regular".equals(materiaLibreta.getEstado()) || "Aprobada".equals(materiaLibreta.getEstado()))) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                return false;
            }
        }
        return true;
    }

    private boolean correlativasAprobadas (Alumno alumno, Materia materia) {
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        if (correlativasDirectas == null || correlativasDirectas.isEmpty()) {
            return true;
        } else {
            for (Nodo correlativa : correlativasDirectas) {
                boolean encontrada = false;
                for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                    if (correlativa.getmateria().getNombre().equals(materiaLibreta.getNombre()) &&
                            "Aprobada".equals(materiaLibreta.getEstado())) {
                        encontrada = true;
                        break;
                    }
                }
                if (!encontrada) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean finalesAprobados(Alumno alumno, Materia materia, int cuatri) {
        int cuatrimestre = materia.getCuatrimestre();
        List<Nodo> materiasCuatrimestre = this.getGrafo().materiasPorCuatrimestre(cuatrimestre, cuatri);

        if(materiasCuatrimestre == null || materiasCuatrimestre.isEmpty()) {
            return true;
        }

        for (Nodo materiaGrafo : materiasCuatrimestre) {
            boolean encontrada = false;
            for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                if(materiaGrafo.getmateria().getNombre().equals(materiaLibreta.getNombre()) &&
                        "Aprobada".equals(materiaLibreta.getEstado())) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                return false;
            }
        }
        return true;
    }

    private boolean finalesAprobadosMenosCorrelativas(Alumno alumno, Materia materia, int cuatri) {
        int cuatrimestre = materia.getCuatrimestre();
        List<Nodo> materiasCuatrimestre = this.getGrafo().materiasPorCuatrimestre(cuatrimestre, cuatri);
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        Set<String> nombresCorrelativas = new HashSet<>();

        for (Nodo correlativa : correlativasDirectas) {
            nombresCorrelativas.add(correlativa.getmateria().getNombre());
        }

        if (materiasCuatrimestre == null || materiasCuatrimestre.isEmpty()) {
            return true;
        }

        for (Nodo nodo : materiasCuatrimestre) {
            String nombreMateria = nodo.getmateria().getNombre();
            if (nombresCorrelativas.contains(nombreMateria)) {
                continue;
            }
            boolean encontrada = false;
            for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                if (nombreMateria.equals(materiaLibreta.getNombre()) &&
                        "Aprobada".equals(materiaLibreta.getEstado())) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                return false;
            }
        }
        return true;
    }


    //Setters y getters
    public void setTipoPlan(char tipoPlan){this.tipoPlan = tipoPlan;}

    public char getTipoPlan() { return tipoPlan; }
    public Grafo getGrafo(){return correlativas;}
}

