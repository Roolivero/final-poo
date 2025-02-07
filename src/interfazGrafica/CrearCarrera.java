package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class CrearCarrera extends JPanel {
    public CrearCarrera(){
        setLayout(new BorderLayout());
        add(new JLabel("Contenido de Agregar Carrera", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}