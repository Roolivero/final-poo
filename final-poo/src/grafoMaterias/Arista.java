package grafoMaterias;

public class Arista {
    private Nodo inicio;
    private Nodo fin;

    public Arista(Nodo inicio, Nodo fin){
        this.inicio = inicio;
        this.fin = fin;;
    }

    //getters
    public Nodo getInicio(){
        return this.inicio;
    }
    public Nodo getFin(){
        return this.fin;
    }
}
