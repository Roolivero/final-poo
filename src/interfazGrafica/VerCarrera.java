package interfazGrafica;

import alumno.Alumno;
import carrera.Carrera;
import grafoMaterias.Grafo;
import grafoMaterias.Nodo;
import materia.Materia;
import universidad.Universidad;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VerCarrera extends JPanel {

    private MainFrame mainFrame;
    private JComboBox<String> comboCarreras;
    private JPanel panelInfoCarrera;
    private JPanel panelBotonVolver;
    private JLabel labelNombre;
    private JLabel labelPlanEstudio;
    private JLabel labelDuracion;
    private JLabel labelCantidadAlumnos;
    private JLabel labelCantidadMaterias;
    private JTabbedPane tabbedPane;
    private JList<String> listaAlumnos;
    private DefaultListModel<String> modeloAlumnos;
    private JList<String> listaMaterias;
    private DefaultListModel<String> modeloMaterias;
    private DefaultListModel<String> modeloAgregarMaterias;
    private JList<String> listaAgregarMaterias;
    private List<Materia> listaTodasMateriasCompleta;
    private JTextArea textAreaPlanEstudio;


    public VerCarrera(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setBackground(new Color(229, 224, 243));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonVolver.setBackground(new Color(229, 224, 243));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver,new Color(166, 144, 246),new Color(10, 2, 43),14);
        botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("carrera");
            }
        });

        panelBotonVolver.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonVolver.getPreferredSize().height));
        panelBotonVolver.add(botonVolver);
        add(panelBotonVolver);

        JLabel labelTitulo = new JLabel("Seleccione una carrera ");
        Font fuenteTitulo = new Font("Arial", Font.BOLD, 18);
        labelTitulo.setFont(fuenteTitulo);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<Carrera> listaCarreras = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras();
        comboCarreras = new JComboBox<>();
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
        Font fuenteCombo = new Font("Arial", Font.PLAIN, 16);
        comboCarreras.setFont(fuenteCombo);
        comboCarreras.setPreferredSize(new Dimension(250, 30));
        comboCarreras.setMaximumSize(new Dimension(250, 30));
        comboCarreras.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelInfoCarrera = new JPanel();
        panelInfoCarrera.setLayout(new BoxLayout(panelInfoCarrera, BoxLayout.Y_AXIS));
        panelInfoCarrera.setBackground(new Color(229, 224, 243));
        panelInfoCarrera.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        labelNombre = new JLabel("Nombre de la carrera: ");
        labelNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        labelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelPlanEstudio = new JLabel("Plan de estudio: ");
        labelPlanEstudio.setFont(new Font("Arial", Font.PLAIN, 14));
        labelPlanEstudio.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelDuracion = new JLabel("Duración: ");
        labelDuracion.setFont(new Font("Arial", Font.PLAIN, 14));
        labelDuracion.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelCantidadAlumnos = new JLabel("Cantidad de alumnos: ");
        labelCantidadAlumnos.setFont(new Font("Arial", Font.PLAIN, 14));
        labelCantidadAlumnos.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelCantidadMaterias = new JLabel("Cantidad de materias: ");
        labelCantidadMaterias.setFont(new Font("Arial", Font.PLAIN, 14));
        labelCantidadMaterias.setAlignmentX(Component.CENTER_ALIGNMENT);


        tabbedPane = new JTabbedPane();

        // Pestaña 1: Alumnos inscriptos
        JPanel panelAlumnos = new JPanel(new BorderLayout());
        panelAlumnos.setBackground(new Color(229, 224, 243));
        modeloAlumnos = new DefaultListModel<>();
        listaAlumnos = new JList<>(modeloAlumnos);
        listaAlumnos.setFont(new Font("Arial", Font.PLAIN, 14));
        panelAlumnos.add(new JScrollPane(listaAlumnos), BorderLayout.CENTER);
        tabbedPane.addTab("Alumnos Inscriptos", panelAlumnos);

        // Pestaña 2: Materias por cuatrimestre
        JPanel panelMaterias = new JPanel(new BorderLayout());
        modeloMaterias = new DefaultListModel<>();
        listaMaterias = new JList<>(modeloMaterias);

        DefaultListCellRenderer rendererMaterias = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Font fontNormal = new Font("Arial", Font.PLAIN, 14);
                Font fontNegrita = new Font("Arial", Font.BOLD, 14);
                if (value.toString().startsWith("Cuatrimestre")) {
                    label.setFont(fontNegrita);
                } else {
                    label.setFont(fontNormal);
                }

                return label;
            }
        };
        listaMaterias.setCellRenderer(rendererMaterias);
        listaMaterias.setFont(new Font("Arial", Font.PLAIN, 14));;
        panelMaterias.add(new JScrollPane(listaMaterias), BorderLayout.CENTER);
        tabbedPane.addTab("Materias por Cuatrimestre", panelMaterias);

        // Pestaña 3: Agregar Materias
        JPanel panelAgregarMaterias = new JPanel(new BorderLayout());

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(250, 30));
        panelAgregarMaterias.add(searchField, BorderLayout.NORTH);

        modeloAgregarMaterias = new DefaultListModel<>();
        listaAgregarMaterias = new JList<>(modeloAgregarMaterias);
        listaAgregarMaterias.setFont(new Font("Arial", Font.PLAIN, 14));
        panelAgregarMaterias.add(new JScrollPane(listaAgregarMaterias), BorderLayout.CENTER);

        JButton btnAgregarMateria = new JButton("Agregar Materia");
        btnAgregarMateria.setFont(new Font("Arial", Font.BOLD, 14));

        btnAgregarMateria.addActionListener(e -> {
            String materiaSeleccionada = listaAgregarMaterias.getSelectedValue();
            if (materiaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una materia para agregar.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            final String materiaLimpia = materiaSeleccionada.startsWith(" - ")
                    ? materiaSeleccionada.substring(3).trim()
                    : materiaSeleccionada;


            Materia materia = Universidad.getInstancia("Universidad Nacional Tierra del Fuego")
                    .getListaMaterias()
                    .stream()
                    .filter(m -> m.getNombre().equals(materiaLimpia))
                    .findFirst()
                    .orElse(null);
            if (materia == null) {
                JOptionPane.showMessageDialog(this, "Materia no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String carreraSeleccionada = (String) comboCarreras.getSelectedItem();
            Carrera carrera = listaCarreras.stream()
                    .filter(c -> c.getNombre().equals(carreraSeleccionada))
                    .findFirst()
                    .orElse(null);
            if (carrera == null) {
                JOptionPane.showMessageDialog(this, "Carrera no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (carrera.getMaterias().contains(materia)) {
                JOptionPane.showMessageDialog(this, "La materia ya se encuentra agregada a la carrera.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int opcion = JOptionPane.showOptionDialog(this, "Tiene correlativas?", "Agregar Correlativas",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "No");

            java.util.List<Materia> correlativasSeleccionadas = new java.util.ArrayList<>();
            if (opcion == JOptionPane.YES_OPTION) {

                java.util.List<Materia> todasMaterias = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaMaterias();
                java.util.List<Materia> materiasFiltradas = todasMaterias.stream()
                        .filter(m -> !m.getNombre().equals(materiaSeleccionada)
                                && m.getCuatrimestre() < materia.getCuatrimestre())
                        .collect(java.util.stream.Collectors.toList());

                if (materiasFiltradas.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay materias disponibles de cuatrimestres anteriores", "Información", JOptionPane.INFORMATION_MESSAGE);
                    carrera.getPlanEstudio().grafoMaterias(materia, null);
                } else {
                    final String[] nombresMaterias = new String[materiasFiltradas.size()];
                    for (int i = 0; i < materiasFiltradas.size(); i++) {
                        nombresMaterias[i] = materiasFiltradas.get(i).getNombre();
                    }

                    JPanel panelCheckboxes = new JPanel();
                    panelCheckboxes.setLayout(new BoxLayout(panelCheckboxes, BoxLayout.Y_AXIS));

                    JCheckBox[] checkboxes = new JCheckBox[nombresMaterias.length];
                    for (int i = 0; i < nombresMaterias.length; i++) {
                        checkboxes[i] = new JCheckBox(nombresMaterias[i]);
                        panelCheckboxes.add(checkboxes[i]);
                    }

                    JScrollPane scrollPane = new JScrollPane(panelCheckboxes);
                    scrollPane.setPreferredSize(new Dimension(250, 150));

                    int result = JOptionPane.showConfirmDialog(this, scrollPane, "Seleccione la/s correlativas", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        for (int i = 0; i < checkboxes.length; i++) {
                            if (checkboxes[i].isSelected()) {
                                correlativasSeleccionadas.add(materiasFiltradas.get(i));
                            }
                        }
                    }

                    for (Materia m : correlativasSeleccionadas) {
                        carrera.getPlanEstudio().grafoMaterias(materia, m);
                    }
                }

                String correlativasText = obtenerCorrelativas(carrera.getPlanEstudio().getGrafo());
                textAreaPlanEstudio.setText(correlativasText);
                textAreaPlanEstudio.revalidate();
                textAreaPlanEstudio.repaint();
            } else if (opcion == JOptionPane.NO_OPTION) {
                carrera.getPlanEstudio().grafoMaterias(materia, null);
                String correlativasText = obtenerCorrelativas(carrera.getPlanEstudio().getGrafo());
                textAreaPlanEstudio.setText(correlativasText);
                textAreaPlanEstudio.revalidate();
                textAreaPlanEstudio.repaint();
            }

            carrera.getMaterias().add(materia);
            labelCantidadMaterias.setText("Cantidad de materias: " + carrera.getMaterias().size());
            actualizarListaMaterias(carrera);

            String mensaje = "Materia agregada a la carrera.";
            if (!correlativasSeleccionadas.isEmpty()) {
                StringBuilder sb = new StringBuilder("\nCorrelativas asignadas: ");
                for (Materia corr : correlativasSeleccionadas) {
                    sb.append(corr.getNombre()).append(", ");
                }
                mensaje += sb.substring(0, sb.length() - 2);
            }


            JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });

        listaAgregarMaterias.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                Font fontNormal = new Font("Arial", Font.PLAIN, 14);
                Font fontBold = new Font("Arial", Font.BOLD, 14);
                if (value.toString().startsWith("Cuatrimestre")) {
                    label.setFont(fontBold);
                } else {
                    label.setFont(fontNormal);
                }
                return label;
            }
        });


        listaAgregarMaterias.setCellRenderer(rendererMaterias);
        listaAgregarMaterias.setFont(new Font("Arial", Font.PLAIN, 14));;
        panelAgregarMaterias.add(btnAgregarMateria, BorderLayout.SOUTH);
        tabbedPane.addTab("Agregar Materias", panelAgregarMaterias);

        // Pestaña 4: Ver Plan de estudio con las materias y sus correlativas
        JPanel panelPlanEstudio = new JPanel(new BorderLayout());
        textAreaPlanEstudio = new JTextArea();
        textAreaPlanEstudio.setEditable(false);
        textAreaPlanEstudio.setFont(new Font("Arial", Font.PLAIN, 14));

        panelPlanEstudio.add(new JScrollPane(textAreaPlanEstudio), BorderLayout.CENTER);
        tabbedPane.addTab("Plan de estudio", panelPlanEstudio);

        panelInfoCarrera.add(labelNombre);
        panelInfoCarrera.add(Box.createVerticalStrut(5));
        panelInfoCarrera.add(labelPlanEstudio);
        panelInfoCarrera.add(Box.createVerticalStrut(5));
        panelInfoCarrera.add(labelDuracion);
        panelInfoCarrera.add(Box.createVerticalStrut(5));
        panelInfoCarrera.add(labelCantidadAlumnos);
        panelInfoCarrera.add(Box.createVerticalStrut(5));
        panelInfoCarrera.add(labelCantidadMaterias);
        panelInfoCarrera.add(Box.createVerticalStrut(10));
        panelInfoCarrera.add(tabbedPane);

        add(Box.createVerticalStrut(10));
        add(labelTitulo);
        add(Box.createVerticalStrut(10));
        add(comboCarreras);
        add(Box.createVerticalStrut(20));
        add(panelInfoCarrera);
        add(Box.createVerticalGlue());

        panelInfoCarrera.setVisible(false);
        tabbedPane.setVisible(false);

        comboCarreras.addActionListener(e -> {
            String carreraSeleccionada = (String) comboCarreras.getSelectedItem();
            if (carreraSeleccionada != null) {
                Carrera carrera = listaCarreras.stream()
                        .filter(c -> c.getNombre().equals(carreraSeleccionada))
                        .findFirst()
                        .orElse(null);
                if (carrera != null) {
                    panelInfoCarrera.setVisible(true);
                    tabbedPane.setVisible(true);
                    panelInfoCarrera.revalidate();
                    panelInfoCarrera.repaint();

                    labelNombre.setText("Carrera: " + carrera.getNombre());
                    labelPlanEstudio.setText("Plan de estudio: " + carrera.getPlanEstudio().getTipoPlan());
                    labelDuracion.setText("Duración: " + carrera.getDuracion() + " años");
                    labelCantidadAlumnos.setText("Cantidad de alumnos: " + carrera.getAlumnosInscriptos().size());
                    labelCantidadMaterias.setText("Cantidad de materias: " + carrera.getMaterias().size());

                    modeloAlumnos.clear();
                    for (Alumno alumno : carrera.getAlumnosInscriptos()) {
                        modeloAlumnos.addElement(alumno.getNombre() + " " + alumno.getApellido());
                    }

                    modeloMaterias.clear();
                    Map<Integer, List<Materia>> materiasPorCuatrimestre = new TreeMap<>();
                    for (Materia materia : carrera.getMaterias()) {
                        int cuatrimestre = materia.getCuatrimestre();
                        materiasPorCuatrimestre.putIfAbsent(cuatrimestre, new ArrayList<>());
                        materiasPorCuatrimestre.get(cuatrimestre).add(materia);
                    }
                    for (Map.Entry<Integer, List<Materia>> entry : materiasPorCuatrimestre.entrySet()) {
                        modeloMaterias.addElement("Cuatrimestre " + entry.getKey() + ":");
                        for (Materia m : entry.getValue()) {
                            modeloMaterias.addElement(" - " + m.getNombre());
                        }
                    }

                    listaTodasMateriasCompleta = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaMaterias();
                    actualizarModeloAgregarMaterias("");

                    String correlativas = obtenerCorrelativas(carrera.getPlanEstudio().getGrafo());
                    textAreaPlanEstudio.setText(correlativas);


                }
            }
        });

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { actualizar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { actualizar(); }
            @Override
            public void changedUpdate(DocumentEvent e) { actualizar(); }
            private void actualizar() {
                String filtro = searchField.getText().toLowerCase();
                actualizarModeloAgregarMaterias(filtro);
            }
        });

    }

    private void actualizarListaMaterias(Carrera carrera) {
        modeloMaterias.clear();
        Map<Integer, List<Materia>> materiasPorCuatrimestre = new TreeMap<>();
        for (Materia m : carrera.getMaterias()) {
            int cuatrimestre = m.getCuatrimestre();
            materiasPorCuatrimestre.putIfAbsent(cuatrimestre, new ArrayList<>());
            materiasPorCuatrimestre.get(cuatrimestre).add(m);
        }
        for (Map.Entry<Integer, List<Materia>> entry : materiasPorCuatrimestre.entrySet()) {
            modeloMaterias.addElement("Cuatrimestre " + entry.getKey() + ":");
            for (Materia m : entry.getValue()) {
                modeloMaterias.addElement(" - " + m.getNombre());
            }
        }
    }

    private void actualizarModeloAgregarMaterias(String filtro) {
        modeloAgregarMaterias.clear();
        Map<Integer, List<Materia>> materiasPorCuatrimestre = new TreeMap<>();
        for (Materia materia : listaTodasMateriasCompleta) {
            if (materia.getNombre().toLowerCase().contains(filtro)) {
                int cuatrimestre = materia.getCuatrimestre();
                materiasPorCuatrimestre.putIfAbsent(cuatrimestre, new ArrayList<>());
                materiasPorCuatrimestre.get(cuatrimestre).add(materia);
            }
        }

        for (Map.Entry<Integer, List<Materia>> entry : materiasPorCuatrimestre.entrySet()) {
            modeloAgregarMaterias.addElement("Cuatrimestre " + entry.getKey() + ":");
            for (Materia m : entry.getValue()) {
                modeloAgregarMaterias.addElement(" - " + m.getNombre());
            }
        }
    }

    private String obtenerCorrelativas(Grafo grafo) {
        StringBuilder sb = new StringBuilder();
        for (Nodo n : grafo.getNodoMateria()) {
            if (n.getAristas().isEmpty()) {
                sb.append(n.getmateria()).append(" --> no tiene correlativas\n\n");
            } else {
                String mensaje = "";
                for (int i = 0; i < n.getAristas().size(); i++) {
                    if (i == 0) {
                        mensaje += n.getAristas().get(i).getInicio().getmateria() + " --> ";
                    }
                    mensaje += n.getAristas().get(i).getFin().getmateria() + " -->";
                    if (i != n.getAristas().size() - 1) {
                        mensaje += ", " + n.getAristas().get(i).getInicio().getmateria() + " -->";
                    }
                }
                sb.append(mensaje).append("\n\n");
            }
        }
        return sb.toString();
    }
}
