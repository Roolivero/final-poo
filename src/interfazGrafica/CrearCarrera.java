package interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCarrera extends JPanel {
    private MainFrame mainFrame;
    private JPanel panelBotonVolver;

    public CrearCarrera(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver,new Color(166, 144, 246),new Color(10, 2, 43),14);
        botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("carrera");
            }
        });

        panelBotonVolver.add(botonVolver);
        add(panelBotonVolver);

    }
}