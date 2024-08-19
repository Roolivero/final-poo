import cargaDeDatos.Datos;
import interfazGrafica.MainFrame;

public class Main {
    public static void main(String[] args) {
        Datos cargaDatos = new Datos();
        cargaDatos.cargarDatos();

        MainFrame mainFrame = new MainFrame();
    }

}
