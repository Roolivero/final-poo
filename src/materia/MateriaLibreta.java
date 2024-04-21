package materia;

public class MateriaLibreta extends Materia{
    //Atributos
    private int notas;
    private String estado;

    //Constructor
    public MateriaLibreta(String nombre, boolean esObligatoria, int cuatrimestre, int notas, String estado) {
        super(nombre, esObligatoria, cuatrimestre);
        this.notas = notas;
        this.estado = estado;

    }

    //Setters y getters
    public void setNotas(int notas){ this.notas = notas; }
    public void setEstado(String estado){ this.estado = estado;}

    public int getNotas(){ return notas; }
    public String getEstado(){ return estado; }
}
