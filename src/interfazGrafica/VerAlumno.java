package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class VerAlumno extends JPanel {
    public VerAlumno(){
        setLayout(new BorderLayout());
        add(new JLabel("Contenido de Ver Alumno", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
