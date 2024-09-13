package interfazGrafica;

import carrera.Carrera;

import javax.swing.*;
import java.awt.*;

public class VerAlumno {
    private Carrera carrera;

    public VerAlumno(Carrera carrera) {
        this.carrera = carrera;

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
    }
}
