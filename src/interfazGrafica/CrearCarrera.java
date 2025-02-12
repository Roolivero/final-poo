package interfazGrafica;

import carrera.Carrera;
import planDeEstudio.PlanEstudio;
import universidad.Universidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCarrera extends JPanel {
    private MainFrame mainFrame;
    private JPanel panelBotonVolver;
    private JComboBox<String> comboPlan;
    private JComboBox<String> comboDuracion;
    private JButton botonCrear;
    private JTextField campoNombre;


    public CrearCarrera(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver, new Color(166, 144, 246), new Color(10, 2, 43), 14);
        //botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("carrera");
            }
        });

        panelBotonVolver.add(botonVolver);
        panelBotonVolver.setMaximumSize(panelBotonVolver.getPreferredSize());
        add(panelBotonVolver, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        JLabel labelNombre = new JLabel("Nombre de la carrera:");
        campoNombre = new JTextField(20);
        campoNombre.setPreferredSize(new Dimension(250, 30));
        campoNombre.setMaximumSize(new Dimension(250, 30));

        panelNombre.add(labelNombre);
        panelNombre.add(Box.createHorizontalStrut(5));
        panelNombre.add(campoNombre);
        panelNombre.setMaximumSize(panelNombre.getPreferredSize());
        panelFormulario.add(panelNombre);
        panelFormulario.add(Box.createVerticalStrut(10));

        JPanel panelDuracion = new JPanel();
        panelDuracion.setLayout(new BoxLayout(panelDuracion, BoxLayout.X_AXIS));
        JLabel labelDuracion = new JLabel("Duración (años):");
        String[] opcionesDuracion = {"1", "2", "3", "4", "5", "6"};
        comboDuracion = new JComboBox<>(opcionesDuracion);

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

        comboDuracion.setRenderer(renderer);
        comboDuracion.setBackground(Color.WHITE);
        comboDuracion.setSelectedIndex(-1);
        Dimension tamañoComboDuracion = new Dimension(100, comboDuracion.getPreferredSize().height);
        comboDuracion.setPreferredSize(tamañoComboDuracion);
        comboDuracion.setMaximumSize(tamañoComboDuracion);

        panelDuracion.add(labelDuracion);
        panelDuracion.add(Box.createHorizontalStrut(5));
        panelDuracion.add(comboDuracion);
        panelDuracion.setMaximumSize(panelDuracion.getPreferredSize());
        panelFormulario.add(panelDuracion);
        panelFormulario.add(Box.createVerticalStrut(10));


        JPanel panelPlan = new JPanel();
        panelPlan.setLayout(new BoxLayout(panelPlan, BoxLayout.X_AXIS));
        JLabel labelPlan = new JLabel("Plan de Estudio:");
        String[] opcionesPlan = {"A", "B", "C", "D", "E"};
        comboPlan = new JComboBox<>(opcionesPlan);

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

        comboPlan.setRenderer(renderer1);
        comboPlan.setBackground(Color.WHITE);
        comboPlan.setSelectedIndex(-1);
        Dimension tamañoComboPlan = new Dimension(100, comboPlan.getPreferredSize().height);
        comboPlan.setPreferredSize(tamañoComboPlan);
        comboPlan.setMaximumSize(tamañoComboPlan);
        panelPlan.add(labelPlan);
        panelPlan.add(Box.createHorizontalStrut(5)); // Espacio horizontal
        panelPlan.add(comboPlan);
        panelPlan.setMaximumSize(panelPlan.getPreferredSize());
        panelFormulario.add(panelPlan);
        panelFormulario.add(Box.createVerticalStrut(20));


        botonCrear = new JButton("Crear Carrera");
        mainFrame.personalizarBoton(botonCrear, new Color(166, 144, 246),new Color(10, 2, 43), 16);
        botonCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearCarrera();
            }
        });
        panelFormulario.add(botonCrear);

        add(panelFormulario, BorderLayout.CENTER);
    }

    private void crearCarrera() {
        String nombre = campoNombre.getText().trim();

        //
        if(nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de la carrera", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object duracionObj = comboDuracion.getSelectedItem();
        if (duracionObj == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la duración.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int duracion;
        try {
            duracion = Integer.parseInt(duracionObj.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La duración seleccionada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object itemSeleccionado = comboPlan.getSelectedItem();
        if (itemSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un plan de estudio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char planEstudioChar = ((String) itemSeleccionado).charAt(0);

        PlanEstudio plan = new PlanEstudio(planEstudioChar);
        Carrera nuevaCarrera = new Carrera(nombre, duracion, plan);

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
        comboDuracion.setSelectedIndex(-1);
        comboPlan.setSelectedIndex(-1);
    }
}
