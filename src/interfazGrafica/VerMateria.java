package interfazGrafica;

import carrera.Carrera;
import materia.Materia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class VerMateria extends JPanel {
    private Carrera carrera;
    private MainFrame mainFrame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private VerCarrera verCarrera;

    public VerMateria(Carrera carrera, MainFrame mainFrame) {
        this.carrera = carrera;
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Crear el panel con CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Agregar el panel de botones como la primera tarjeta
        cardPanel.add(crearPanelBotones(), "panelBotones");

        // Agregar las otras tarjetas para "Ver Materias" y "Agregar Materias"
        cardPanel.add(crearPanelVerMaterias(), "verMaterias");
        cardPanel.add(crearPanelAgregarMaterias(), "agregarMaterias");

        // Mostrar el cardPanel (comienza con el panel de botones)
        add(cardPanel, BorderLayout.CENTER);
        cardLayout.show(cardPanel, "panelBotones");

    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton verMateriasButton = new JButton("Ver materias");
        mainFrame.personalizarBoton(verMateriasButton, new Color(156, 64, 83), Color.WHITE, 12);
        verMateriasButton.addActionListener(e -> cardLayout.show(cardPanel, "verMaterias"));

        JButton agregarMateriasButton = new JButton("Agregar materias");
        mainFrame.personalizarBoton(agregarMateriasButton, new Color(156, 64, 83), Color.WHITE, 12);
        agregarMateriasButton.addActionListener(e -> cardLayout.show(cardPanel, "agregarMaterias"));

        panel.add(verMateriasButton);
        panel.add(agregarMateriasButton);

        return panel;
    }

    private JPanel crearPanelVerMaterias() {
        // Crear panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(251, 230, 236));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado alrededor de los componentes

        // Etiqueta de título
        JLabel tituloLabel = new JLabel("Listado de materias: ");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        panel.add(tituloLabel, gbc);

        // Panel de materias con BoxLayout
        JPanel materiasPanel = new JPanel();
        materiasPanel.setLayout(new BoxLayout(materiasPanel, BoxLayout.Y_AXIS));
        materiasPanel.setBackground(new Color(239, 223, 227, 225));

        // Panel de desplazamiento
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setPreferredSize(new Dimension(350, 100));
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPanel, gbc);

        JButton agregarButton = new JButton("Agregar Materias");
        mainFrame.personalizarBoton(agregarButton, new Color(156, 64, 83), Color.WHITE, 10);
        agregarButton.addActionListener(e -> cardLayout.show(cardPanel, "agregarMaterias"));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(agregarButton, gbc);

        // Llenar el panel de materias con datos
        displaySubjectsForMateria(materiasPanel);

        return panel;
    }



    private void displaySubjectsForMateria(JPanel subjectsPanel) {
        subjectsPanel.removeAll();

        if (carrera != null && carrera.getMaterias() != null) {
            List<Materia> materias = carrera.getMaterias();
            if (materias.isEmpty()) {
                subjectsPanel.add(new JLabel("No hay materias disponibles."));
            } else {
                for (Materia mat : materias) {
                    JLabel materiaLabel = new JLabel(mat.getNombre());
                    materiaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    subjectsPanel.add(materiaLabel);
                    subjectsPanel.add(Box.createVerticalStrut(5));
                }
            }
        } else {
            subjectsPanel.add(new JLabel("No hay materias disponibles."));
        }

        subjectsPanel.revalidate();
        subjectsPanel.repaint();
    }

    private JPanel crearPanelAgregarMaterias() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(24, 58, 225));

        JLabel titleLabel = new JLabel("Complete los datos de la materia: ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));

        JLabel nombre = new JLabel("Nombre:");
        nombre.setAlignmentX(LEFT_ALIGNMENT);
        JTextField nombreField = new JTextField(15);
        Dimension textFieldSize = new Dimension(250, 30);
        nombreField.setMaximumSize(textFieldSize);
        nombreField.setPreferredSize(textFieldSize);
        nombreField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel esObligatoria = new JLabel("Es obligatoria?");
        String[] opciones1 = {"Si", "No"};
        JComboBox<String> opciones1Box = new JComboBox<>(opciones1);
        Dimension box1 = new Dimension(250, 30);
        opciones1Box.setPreferredSize(box1);
        opciones1Box.setMaximumSize(box1);
        opciones1Box.setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones1Box.setBackground(Color.white);
        opciones1Box.setSelectedIndex(-1);

        JLabel cuatrimestre = new JLabel("Cuatrimestre en el que se dicta:");
        String[] opciones2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox<String> opciones2Box = new JComboBox<>(opciones2);
        Dimension box2 = new Dimension(250, 30);
        opciones2Box.setPreferredSize(box2);
        opciones2Box.setMaximumSize(box2);
        opciones2Box.setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones2Box.setSelectedIndex(-1);

        JButton submitButton = new JButton("Agregar");
        submitButton.addActionListener(e -> {
            opciones1Box.setSelectedIndex(-1);
            opciones2Box.setSelectedIndex(-1);
            String nombreMateria = nombreField.getText();
            if (!nombreMateria.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Materia agregada correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la materia.");
            }
        });
        mainFrame.personalizarBoton(submitButton, new Color(156, 64, 83), Color.WHITE, 10);

        JButton verListadoButton = new JButton("Ver materias");
        verListadoButton.addActionListener(e -> {
           cardLayout.show(cardPanel,"verMaterias");
        });
        mainFrame.personalizarBoton(verListadoButton, new Color(156, 64, 83), Color.WHITE, 10);

        panel.add(nombre);
        panel.add(nombreField);
        panel.add(esObligatoria);
        panel.add(opciones1Box);
        panel.add(cuatrimestre);
        panel.add(opciones2Box);
        panel.add(submitButton);
        panel.add(verListadoButton);

        return panel;
    }

}

