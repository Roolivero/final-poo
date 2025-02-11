package interfazGrafica;

import carrera.Carrera;
import universidad.Universidad;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class VerCarrera extends JPanel {
    private JTextArea infoCarrera;

    public VerCarrera() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Seleccione una carrera ");
        Font fuente = new Font("Arial", Font.BOLD, 18);
        label.setFont(fuente);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<Carrera> listaCarreras = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras();

        JComboBox<String> comboCarreras = new JComboBox<>();
        for (Carrera c : listaCarreras) {
            comboCarreras.addItem(c.getNombre());
        }

        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (isSelected) {
                    setBackground(new Color(187, 169, 250));
                    setForeground(Color.WHITE);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Color.BLACK);
                }
                return this;
            }
        };

        comboCarreras.setRenderer(renderer);
        comboCarreras.setBackground(Color.WHITE);
        comboCarreras.setSelectedIndex(-1);
        Font fuente2 = new Font("Arial", Font.PLAIN, 16);
        comboCarreras.setFont(fuente2);
        comboCarreras.setPreferredSize(new Dimension(250, 30));
        comboCarreras.setMaximumSize(new Dimension(250, 30));
        comboCarreras.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Área de texto para mostrar información
        infoCarrera = new JTextArea();
        infoCarrera.setEditable(false);
        infoCarrera.setFont(new Font("Arial", Font.PLAIN, 14));
        infoCarrera.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoCarrera.setBackground(null);
        infoCarrera.setWrapStyleWord(true);
        infoCarrera.setLineWrap(true);
        infoCarrera.setMaximumSize(new Dimension(400, 300));

        // Listener para el comboBox
        comboCarreras.addActionListener(e -> {
            String carreraSeleccionada = (String) comboCarreras.getSelectedItem();
            if (carreraSeleccionada != null) {
                Carrera carrera = listaCarreras.stream()
                        .filter(c -> c.getNombre().equals(carreraSeleccionada))
                        .findFirst()
                        .orElse(null);

                if (carrera != null) {
                    StringBuilder info = new StringBuilder();
                    info.append("• Carrera: ").append(carrera.getNombre()).append("\n");
                    info.append("• Plan de estudio: ").append(carrera.getPlanEstudio().getTipoPlan()).append("\n");
                    info.append("• Duración: ").append(carrera.getDuracion()).append(" años\n");
                    info.append("• Cantidad de alumnos inscriptos: ").append(carrera.getAlumnosInscriptos().size()).append("\n");
                    info.append("• Cantidad de materias: ").append(carrera.getMaterias().size()).append("\n");

                    infoCarrera.setText(info.toString());
                }
            }
        });

        add(Box.createVerticalStrut(20));
        add(label);
        add(Box.createVerticalStrut(10));
        add(comboCarreras);
        add(Box.createVerticalStrut(20));
        add(infoCarrera);
        add(Box.createVerticalGlue());
    }

}
