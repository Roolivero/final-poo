package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class VerMateria extends JPanel {
    public VerMateria(){
        setLayout(new BorderLayout());
        add(new JLabel("Contenido de Ver Materia", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
