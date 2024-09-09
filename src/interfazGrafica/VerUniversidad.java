package interfazGrafica;

import carrera.Carrera;
import universidad.Universidad;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.border.LineBorder;


public class VerUniversidad extends JPanel {
    private MainFrame mainFrame;
    private Universidad universidad;
    private JPanel mainPanel;

    public VerUniversidad(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Top panel with "Volver" button
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

       mainPanel = new JPanel(new BorderLayout());
       add(mainPanel,BorderLayout.CENTER);

        updateMainPanel();
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
        updateMainPanel();
    }

    private void updateMainPanel() {
        mainPanel.removeAll();
        JPanel panel = createMainPanel();
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(new Color(251, 230, 236, 255));
        panel.setBorder(new LineBorder(new Color(156, 64, 83), 2));
        JButton volverButton = new JButton("Volver");
        mainFrame.personalizarBoton(volverButton, new Color(156, 64, 83), Color.WHITE,12);
        volverButton.addActionListener(e -> mainFrame.showCard("Main"));
        panel.add(volverButton);
        return panel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(251, 240, 242));
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(155, 63, 82)));

        if (universidad != null) {
            // Top panel for labelPrincipal and labelUniversidad
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
            topPanel.setOpaque(false);

            JLabel labelPrincipal = new JLabel("Bienvenido a la universidad:");
            labelPrincipal.setFont(new Font("Arial", Font.PLAIN, 20));
            labelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel labelUniversidad = new JLabel(universidad.getNombre());
            labelUniversidad.setFont(new Font("Arial", Font.PLAIN, 20));
            labelUniversidad.setAlignmentX(Component.CENTER_ALIGNMENT);

            topPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            topPanel.add(Box.createVerticalGlue());
            topPanel.add(labelPrincipal);
            topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            topPanel.add(labelUniversidad);
            topPanel.add(Box.createVerticalGlue());

            mainPanel.add(topPanel, BorderLayout.NORTH);


            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            centerPanel.setOpaque(false);

            JLabel labelCarreras = new JLabel("Seleccione una carrera:");
            labelCarreras.setFont(new Font("Arial", Font.PLAIN, 18));
            labelCarreras.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel dropPanel = new JPanel();
            dropPanel.setBackground(new Color(251, 240, 242));
            dropPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            if (universidad.getListaCarreras() != null && !universidad.getListaCarreras().isEmpty()) {
                String[] carreras = getCarrearas(universidad.getListaCarreras());

                JComboBox<String> dropBox = new JComboBox<>(carreras);
                dropBox.setSelectedIndex(-1);
                dropBox.setFont(new Font("Arial", Font.PLAIN, 15));
                ((JLabel)dropBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

                dropBox.addActionListener(e -> {
                    String carrera = (String) dropBox.getSelectedItem();
                    Carrera carreraSeleccionada = getNombreCarrera(carrera);
                    if (carreraSeleccionada != null) {
                        mainFrame.showVerCarrera(carreraSeleccionada);
                    }
                });
                dropPanel.add(dropBox);
            } else {
                dropPanel.add(new JLabel("No hay carreras disponibles"));
            }

            centerPanel.add(Box.createVerticalGlue());
            centerPanel.add(labelCarreras);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            centerPanel.add(dropPanel);
            centerPanel.add(Box.createVerticalGlue());

            mainPanel.add(centerPanel, BorderLayout.CENTER);
        } else {
            JLabel labelError = new JLabel("No se ha seleccionado ninguna universidad");
            labelError.setFont(new Font("Arial", Font.BOLD, 20));
            labelError.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(labelError, BorderLayout.CENTER);
        }

        return mainPanel;
    }

    private String[] getCarrearas(List<Carrera> lista) {
        if (lista == null || lista.isEmpty()) {
            return new String[]{"No hay carreras"};
        }
        String[] nombresCarreras = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            nombresCarreras[i] = lista.get(i).getNombre();
        }
        return nombresCarreras;
    }

    private Carrera getNombreCarrera(String name) {
        if (universidad != null) {
            for (Carrera carrera : universidad.getListaCarreras()) {
                if (carrera.getNombre().equals(name)) {
                    return carrera;
                }
            }
        }
        return null;
    }
}