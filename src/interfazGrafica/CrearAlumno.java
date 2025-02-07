package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class CrearAlumno extends JPanel {
    public CrearAlumno(){
        setLayout(new BorderLayout());
        add(new JLabel("Contenido de Agregar Alumno", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
