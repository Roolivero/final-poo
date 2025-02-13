package interfazGrafica;

import carrera.Carrera;
import materia.Materia;
import planDeEstudio.PlanEstudio;
import universidad.Universidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearMateria extends JPanel {
    private MainFrame mainFrame;
    private JTextField campoNombre;
    private JComboBox<String> comboTipo;
    private JComboBox<String> comboCuatrimestre;

    public CrearMateria(MainFrame mainFrame) {

        Universidad universidad = Universidad.getInstancia("Universidad Nacional Tierra del Fuego");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver, new Color(166, 144, 246), new Color(10, 2, 43), 14);
        botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("materia");
            }
        });

        panelBotonVolver.add(botonVolver);
        add(panelBotonVolver);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        JLabel labelNombre = new JLabel("Nombre de la materia:");
        campoNombre = new JTextField(20);
        campoNombre.setPreferredSize(new Dimension(250, 30));
        campoNombre.setMaximumSize(new Dimension(250, 30));

        panelNombre.add(labelNombre);
        panelNombre.add(Box.createHorizontalStrut(5));
        panelNombre.add(campoNombre);
        panelNombre.setMaximumSize(panelNombre.getPreferredSize());
        panelFormulario.add(panelNombre);
        panelFormulario.add(Box.createVerticalStrut(10));

        JPanel panelTipo = new JPanel();
        panelTipo.setLayout(new BoxLayout(panelTipo, BoxLayout.X_AXIS));
        JLabel labelTipo = new JLabel("Tipo:");
        String[] opcionesTipo = {"Obligatoria", "Optativa"};
        comboTipo = new JComboBox<>(opcionesTipo);

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

        comboTipo.setRenderer(renderer);
        comboTipo.setBackground(Color.WHITE);
        comboTipo.setSelectedIndex(-1);
        Dimension tamañoComboTipo = new Dimension(100, comboTipo.getPreferredSize().height);
        comboTipo.setPreferredSize(tamañoComboTipo);
        comboTipo.setMaximumSize(tamañoComboTipo);

        panelTipo.add(labelTipo);
        panelTipo.add(Box.createHorizontalStrut(5));
        panelTipo.add(comboTipo);
        panelTipo.setMaximumSize(panelTipo.getPreferredSize());
        panelFormulario.add(panelTipo);
        panelFormulario.add(Box.createVerticalStrut(10));


        JPanel panelCuatrimestre = new JPanel();
        panelCuatrimestre.setLayout(new BoxLayout(panelCuatrimestre, BoxLayout.X_AXIS));
        JLabel labelCuatrimestre = new JLabel("Cuatrimestre en la que se dicta:");
        String[] opcionesPlan = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        comboCuatrimestre = new JComboBox<>(opcionesPlan);

        DefaultListCellRenderer renderer1 = new DefaultListCellRenderer() {
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

        comboCuatrimestre.setRenderer(renderer1);
        comboCuatrimestre.setBackground(Color.WHITE);
        comboCuatrimestre.setSelectedIndex(-1);
        Dimension tamañoComboPlan = new Dimension(100, comboCuatrimestre.getPreferredSize().height);
        comboCuatrimestre.setPreferredSize(tamañoComboPlan);
        comboCuatrimestre.setMaximumSize(tamañoComboPlan);
        panelCuatrimestre.add(labelCuatrimestre);
        panelCuatrimestre.add(Box.createHorizontalStrut(5)); // Espacio horizontal
        panelCuatrimestre.add(comboCuatrimestre);
        panelCuatrimestre.setMaximumSize(panelCuatrimestre.getPreferredSize());
        panelFormulario.add(panelCuatrimestre);
        panelFormulario.add(Box.createVerticalStrut(20));


        JButton botonCrear = new JButton("Crear materia");
        mainFrame.personalizarBoton(botonCrear, new Color(166, 144, 246), new Color(10, 2, 43), 16);
        botonCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearMateria();
            }
        });
        panelFormulario.add(botonCrear);

        add(panelFormulario, BorderLayout.CENTER);
    }

    private void crearMateria() {
        String nombre = campoNombre.getText().trim();

        //
        if(nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de la materia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object tipoObj = comboTipo.getSelectedItem();
        if (tipoObj == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione el tipo de materia.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int tipo;
        try {
            tipo = Integer.parseInt(tipoObj.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El tipo seleccionado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object itemSeleccionado = comboCuatrimestre.getSelectedItem();
        if (itemSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cuatrimestre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int cuatrimestre = ((String) itemSeleccionado).charAt(0);

        if(tipoObj.equals("Obligatoria")){
            Materia materia = new Materia(nombre, true,cuatrimestre);
        }

        // Agregar la carrera a la Universidad
        Universidad universidad = Universidad.getInstancia("Universidad Nacional Tierra del Fuego");
        universidad.agregarCarrera(nuevaCarrera);

        //JOptionPane.showMessageDialog(this, "¡Carrera creada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this,
                "¡Carrera creada exitosamente!\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "Duración: " + duracion + " años\n" +
                        "Plan de Estudio: " + planEstudioChar,
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);

        campoNombre.setText("");
        comboTipo.setSelectedIndex(-1);
        comboCuatrimestre.setSelectedIndex(-1);
    }
}