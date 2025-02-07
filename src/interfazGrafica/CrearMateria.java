package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class CrearMateria extends JPanel{
    public CrearMateria(){
        setLayout(new BorderLayout());
        add(new JLabel("Contenido de Agregar Materia", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
