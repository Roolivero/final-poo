package materia;

public class Materia {
    //Atributos
    private String nombre;
    private boolean esObligatoria;
    private int cuatrimestre;

    //Constructor
    public Materia(String nombre, boolean esObligatoria, int cuatrimestre){
        this.setNombre(nombre);
        this.setEsObligatoria(esObligatoria);
        this.setCuatrimestre(cuatrimestre);
    }

    //Setters y getters
    public void setNombre( String nombre){this.nombre = nombre;}
    public void setEsObligatoria(boolean esObligatoria){this.esObligatoria = esObligatoria;}
    public void setCuatrimestre(int cuatrimestre) {this.cuatrimestre = cuatrimestre;}

    public String getNombre(){return this.nombre;}
    public boolean getEsObligatoria(){return this.esObligatoria;}
    public int getCuatrimestre(){return this.cuatrimestre;}

    @Override
    public String toString(){
        return this.getNombre();
    }
    public String mostrarMateria() {
        if (this.getEsObligatoria() == true){
            return this.getNombre() + " es obligatoria";
        } else {
            return this.getNombre() + " es optativa";
        }
    }

}
