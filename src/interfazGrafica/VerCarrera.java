package interfazGrafica;

import carrera.Carrera;
import universidad.Universidad;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class VerCarrera extends JPanel {
    public VerCarrera() {

        JLabel label = new JLabel("Seleccione una carrera ");

        List<Carrera> listaCarreras = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras();

        JComboBox<String> comboCarreras = new JComboBox<>();
        for (Carrera c : listaCarreras) {
            comboCarreras.addItem(c.getNombre());
        }

        comboCarreras.setSelectedIndex(-1);
        Font fuente = new Font("Arial", Font.PLAIN, 16);
        comboCarreras.setFont(fuente);
        comboCarreras.setPreferredSize(new Dimension(250, 30));

        add(label);
        add(comboCarreras);

    }
}
