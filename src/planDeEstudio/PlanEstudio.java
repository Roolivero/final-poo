package planDeEstudio;

import alumno.Alumno;
import grafoMaterias.Grafo;
import grafoMaterias.Nodo;
import materia.Materia;
import materia.MateriaLibreta;

import java.util.List;

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
    public void grafoMaterias(Materia materia, Materia correlativa){
        Nodo nodoMateria = correlativas.agregarMateria(materia);
        if (correlativa != null){
            Nodo nodoCorrelativa = correlativas.agregarMateria(correlativa);
            correlativas.agregarArista(nodoMateria,nodoCorrelativa);
        }
    }

    public void inscribirAlumnoMateria(Alumno alumno, Materia materia) {
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        if (this.getTipoPlan() == 'A') {
            boolean inscripcion = false;
            inscripcion = correlativasRegular(alumno, materia);
            if (inscripcion) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
            }
        } else if (this.getTipoPlan() == 'B') {
            boolean inscripcion = false;
            inscripcion = correlativasAprobadas(alumno, materia);
            if (inscripcion) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
            }
        } else if (this.getTipoPlan() == 'C') {
            boolean verificarCorrelativa = false;
            boolean verificarMateriaCuatrimestre = false;
            verificarCorrelativa = correlativasRegular(alumno, materia);
            verificarMateriaCuatrimestre = finalesAprobados(alumno, materia, 5);
            if (verificarCorrelativa && verificarMateriaCuatrimestre) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
            }
        } else if (this.getTipoPlan() == 'D') {
            boolean verificarCorrelativa = false;
            boolean verificarMateriaCuatrimestre = false;
            verificarCorrelativa = correlativasRegular(alumno, materia);
            verificarMateriaCuatrimestre = finalesAprobados(alumno, materia, 3);
            if (verificarCorrelativa && verificarMateriaCuatrimestre) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
            }
        } else if (this.getTipoPlan() == 'E') {
            boolean verificarCorrelativa = false;
            boolean verificarMateriaCuatrimestre = false;
            verificarCorrelativa = correlativasAprobadas(alumno, materia);
            verificarMateriaCuatrimestre = finalesAprobados(alumno, materia, 3);
            if (verificarCorrelativa && verificarMateriaCuatrimestre) {
                MateriaLibreta nuevaMateriaLibreta = new MateriaLibreta(materia.getNombre(), materia.getEsObligatoria(), materia.getCuatrimestre(), 0, "Cursando");
                alumno.getLibretaAlumno().getLibreta().add(nuevaMateriaLibreta);
            } else {
                System.out.println("El alumno no puede inscribirse a la materia: " + materia);
            }
        }
    }


    private boolean correlativasRegular (Alumno alumno, Materia materia){
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        if( correlativasDirectas == null) {
            return true;
        } else {
            for (Nodo correlativa : correlativasDirectas) {
                for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                    if (correlativa.getmateria().getNombre().equals(materiaLibreta.getNombre()) && ("Regular".equals(materiaLibreta.getEstado()))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean correlativasAprobadas (Alumno alumno, Materia materia){
        List<Nodo> correlativasDirectas = this.getGrafo().correlativasDirectas(materia);
        if( correlativasDirectas == null) {
            return true;
        } else {
            for (Nodo correlativa : correlativasDirectas) {
                for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                    if (correlativa.getmateria().getNombre().equals(materiaLibreta.getNombre()) && ("Aprobada".equals(materiaLibreta.getEstado()))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean finalesAprobados (Alumno alumno, Materia materia,int cuatri){
        int cuatrimestre = materia.getCuatrimestre();
        List<Nodo> materiasCuatrimestre = this.getGrafo().materiasPorCuatrimestre(cuatrimestre, cuatri);
        if( materiasCuatrimestre == null) {
            return true;
        } else {
            for (Nodo materiaGrafo : materiasCuatrimestre) {
                for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                    if((materiaGrafo.getmateria().getNombre().equals(materiaLibreta.getNombre())) && ("Aprobada".equals(materiaLibreta.getEstado()))){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //Setters y getters
    public void setTipoPlan(char tipoPlan){this.tipoPlan = tipoPlan;}

    public char getTipoPlan() { return tipoPlan; }
    public Grafo getGrafo(){return correlativas;}
}

