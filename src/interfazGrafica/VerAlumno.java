package interfazGrafica;

import alumno.Alumno;
import carrera.Carrera;
import materia.Materia;
import materia.MateriaLibreta;
import universidad.Universidad;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class VerAlumno extends JPanel {
    private MainFrame mainFrame;
    private JPanel panelBotonVolver;
    private DefaultListModel modeloLibreta;
    private DefaultListModel modeloCarrera;
    private DefaultListModel modeloMateria;
    private JList<String> listaMateriasLibreta;
    private JList<String> listaCarreras;
    private JList<String> listaMaterias;
    private Alumno alumnoSeleccionado;
    private Carrera carreraSeleccionada;
    private List<Carrera> listaTodasCarreras;
    private List<Materia> listaTodasMaterias;
    private ArrayList<MateriaLibreta> listaTodasMateriasLibreta;


    public VerAlumno(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver,new Color(166, 144, 246),new Color(10, 2, 43),14);
        botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("alumno");
            }
        });

        panelBotonVolver.add(botonVolver);
        add(panelBotonVolver);


        JLabel labelTitulo = new JLabel("Seleccione un Alumno ");
        Font fuenteTitulo = new Font("Arial", Font.BOLD, 18);
        labelTitulo.setFont(fuenteTitulo);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<Alumno> listaAlumnos = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaAlumnos();
        JComboBox comboAlumnos = new JComboBox<>();
        for (Alumno a : listaAlumnos) {
            comboAlumnos.addItem(a.getNombre() + " " + a.getApellido());
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
        comboAlumnos.setRenderer(renderer);
        comboAlumnos.setBackground(Color.WHITE);
        comboAlumnos.setSelectedIndex(-1);
        Font fuenteCombo = new Font("Arial", Font.PLAIN, 16);
        comboAlumnos.setFont(fuenteCombo);
        comboAlumnos.setPreferredSize(new Dimension(400, 30));
        comboAlumnos.setMaximumSize(new Dimension(400, 30));
        comboAlumnos.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelInfoAlumno = new JPanel();
        panelInfoAlumno.setLayout(new BoxLayout(panelInfoAlumno, BoxLayout.Y_AXIS));
        panelInfoAlumno.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelAlumno = new JLabel("Nombre y Apellido");
        labelAlumno.setFont(new Font("Arial", Font.BOLD, 16));
        labelAlumno.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelDni = new JLabel("DNI:");
        labelDni.setFont(new Font("Arial", Font.PLAIN, 14));
        labelDni.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelFechaNacimiento = new JLabel("Fecha de nacimiento:");
        labelFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 14));
        labelFechaNacimiento.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelCarrera = new JLabel("Carrera:");
        labelCarrera.setFont(new Font("Arial", Font.PLAIN, 14));
        labelCarrera.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTabbedPane tabbedPane = new JTabbedPane();

        //Pestaña 1: Libreta universitaria
        JPanel panelLibreta = new JPanel(new BorderLayout());
        modeloLibreta = new DefaultListModel<>();
        listaMateriasLibreta = new JList<>(modeloLibreta);

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

        listaMateriasLibreta.setCellRenderer(rendererMaterias);
        listaMateriasLibreta.setFont(new Font("Arial", Font.PLAIN, 14));
        panelLibreta.add(new JScrollPane(listaMateriasLibreta), BorderLayout.CENTER);
        tabbedPane.addTab("Libreta Universitaria", panelLibreta);

        //Pestaña 2: Inscripcion carrera

        JPanel panelInscripcionCarrera = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(250, 30));
        panelInscripcionCarrera.add(searchField, BorderLayout.NORTH);

        modeloCarrera = new DefaultListModel<>();
        listaCarreras = new JList<>(modeloCarrera);
        listaCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInscripcionCarrera.add(new JScrollPane(listaCarreras), BorderLayout.CENTER);

        JButton btnInscribirCarrera = new JButton("Inscribirse");
        btnInscribirCarrera.setFont(new Font("Arial", Font.BOLD, 14));

        btnInscribirCarrera.addActionListener(e -> {
            String carreraSeleccionada = listaCarreras.getSelectedValue();
            if (carreraSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una carrera para inscribirse.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Carrera carrera = Universidad.getInstancia("Universidad Nacional Tierra del Fuego")
                    .getListaCarreras()
                    .stream()
                    .filter(c -> c.getNombre().equals(carreraSeleccionada))
                    .findFirst()
                    .orElse(null);
            if (carrera == null) {
                JOptionPane.showMessageDialog(this, "Carrera no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            listaTodasCarreras = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras();

            Boolean estaInscripto = false;

            for(Carrera c: listaTodasCarreras){
                if (c.getAlumnosInscriptos().contains(alumnoSeleccionado)){
                    estaInscripto = true;
                }
            }

            if(carrera.getAlumnosInscriptos().contains(alumnoSeleccionado)){
                JOptionPane.showMessageDialog(this, "El alumno ya se encuentra inscripto en " +carrera.getNombre() + ".", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else if (estaInscripto && !carrera.getAlumnosInscriptos().contains(alumnoSeleccionado)){
                JOptionPane.showMessageDialog(this, "El alumno ya se encuentra inscripto en otra carrera.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                carrera.getAlumnosInscriptos().add(alumnoSeleccionado);
                JOptionPane.showMessageDialog(this, "Inscripción realizada con éxito a la "+ carrera.getNombre() + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        panelInscripcionCarrera.add(btnInscribirCarrera, BorderLayout.SOUTH);
        tabbedPane.addTab("Inscripción carrera", panelInscripcionCarrera);

        //Pestaña 3: Inscripcion materia
        JPanel panelMateria = new JPanel(new BorderLayout());

        JTextField searchField1 = new JTextField();
        searchField1.setPreferredSize(new Dimension(250, 30));
        panelMateria.add(searchField1, BorderLayout.NORTH);

        modeloMateria = new DefaultListModel<>();
        listaMaterias = new JList<>(modeloMateria);
        listaMaterias.setFont(new Font("Arial", Font.PLAIN, 14));
        panelMateria.add(new JScrollPane(listaMaterias), BorderLayout.CENTER);
        tabbedPane.addTab("Inscripcion Materia", panelMateria);

        JButton btnInscribirMateria = new JButton("Inscribirse");
        btnInscribirMateria.setFont(new Font("Arial", Font.BOLD, 14));

        btnInscribirMateria.addActionListener(e -> {
                    String materiaSeleccionada = listaMaterias.getSelectedValue();
                    System.out.println("Materia seleccionada: " + materiaSeleccionada);
                    if (materiaSeleccionada == null) {
                        JOptionPane.showMessageDialog(this, "Por favor, seleccione una materia para inscribirse.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    Materia materia = Universidad.getInstancia("Universidad Nacional Tierra del Fuego")
                            .getListaMaterias()
                            .stream()
                            .filter(m -> m.getNombre().equals(materiaSeleccionada))
                            .findFirst()
                            .orElse(null);

                    if (materia == null) {
                        JOptionPane.showMessageDialog(this, "Materia no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean encontrada = false;
                    List<MateriaLibreta> listaML = alumnoSeleccionado.getLibretaAlumno().getLibreta();
                    for (MateriaLibreta ml : listaML) {
                        if (materia.getNombre().trim().equalsIgnoreCase(ml.getNombre().trim())) {
                            encontrada = true;
                            if ("Aprobada".equalsIgnoreCase(ml.getEstado())) {
                                JOptionPane.showMessageDialog(this, "Está inscripto. Esta materia ya se encuentra aprobada.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else if ("Regular".equalsIgnoreCase(ml.getEstado())) {
                                JOptionPane.showMessageDialog(this, "Está inscripto. Esta materia se encuentra en estado Regular.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        }
                    }
                    if (!encontrada) {
                        boolean inscripcion = carreraSeleccionada.getPlanEstudio().inscribirAlumnoMateria(alumnoSeleccionado, materia);
                        if(inscripcion){
                            JOptionPane.showMessageDialog(this, "Se inscribió a " +materiaSeleccionada +".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            actualizarModeloLibreta("");
                        } else {
                            JOptionPane.showMessageDialog(this, "El alumno no se puede isncribir a " + materiaSeleccionada + ".", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
        });

        panelMateria.add(btnInscribirMateria, BorderLayout.SOUTH);

        panelInfoAlumno.add(labelAlumno);
        panelInfoAlumno.add(Box.createVerticalStrut(10));
        panelInfoAlumno.add(labelDni);
        panelInfoAlumno.add(Box.createVerticalStrut(10));
        panelInfoAlumno.add(labelFechaNacimiento);
        panelInfoAlumno.add(Box.createVerticalStrut(10));
        panelInfoAlumno.add(labelCarrera);
        panelInfoAlumno.add(Box.createVerticalStrut(10));
        panelInfoAlumno.add(tabbedPane);
        panelInfoAlumno.add(Box.createVerticalStrut(10));

        add(Box.createVerticalStrut(10));
        add(labelTitulo);
        add(Box.createVerticalStrut(10));
        add(comboAlumnos);
        add(Box.createVerticalStrut(20));
        add(panelInfoAlumno);
        add(Box.createVerticalGlue());

        panelInfoAlumno.setVisible(false);

        comboAlumnos.addActionListener(e -> {
            String alumnoSeleccionadoStr = (String) comboAlumnos.getSelectedItem();
            if (alumnoSeleccionadoStr != null) {
                Alumno alumno = listaAlumnos.stream()
                        .filter(c -> (c.getNombre() + " " + c.getApellido()).equals(alumnoSeleccionadoStr))
                        .findFirst()
                        .orElse(null);
                if (alumno != null) {
                    listaTodasCarreras = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras();
                    listaTodasMaterias = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaMaterias();
                    listaTodasMateriasLibreta = alumno.getLibretaAlumno().getLibreta();

                    alumnoSeleccionado = alumno;

                    panelInfoAlumno.setVisible(true);
                    tabbedPane.setVisible(true);

                    labelAlumno.setText("Nombre y Apellido: " + alumno.getNombre()+ " " + alumno.getApellido());
                    labelDni.setText("DNI: " + alumno.getDni());
                    labelFechaNacimiento.setText("Fecha de nacimiento: " + alumno.getFechaNacimiento());

                    String nombreCarrera = " ";
                    for(Carrera c: listaTodasCarreras){
                        if (c.getAlumnosInscriptos().contains(alumno)){
                            nombreCarrera = c.getNombre();
                            carreraSeleccionada = c;
                        }
                    }

                    labelCarrera.setText("Carrera: " + nombreCarrera);

                    modeloLibreta.clear();
                    Map<Integer, List<MateriaLibreta>> materiasPorCuatrimestre = new TreeMap<>();
                    for (MateriaLibreta materiaLibreta : alumno.getLibretaAlumno().getLibreta()) {
                        int cuatrimestre = materiaLibreta.getCuatrimestre();
                        materiasPorCuatrimestre.putIfAbsent(cuatrimestre, new ArrayList<>());
                        materiasPorCuatrimestre.get(cuatrimestre).add(materiaLibreta);
                    }
                    for (Map.Entry<Integer, List<MateriaLibreta>> entry : materiasPorCuatrimestre.entrySet()) {
                        modeloLibreta.addElement("Cuatrimestre " + entry.getKey() + ":");
                        for (MateriaLibreta ml : entry.getValue()) {
                            modeloLibreta.addElement(" - " + ml.getNombre() + ": " + ml.getEstado());
                        }
                    }

                    actualizarModeloCarreras("");
                    actualizarModeloMaterias("");
                    actualizarModeloLibreta("");
                }
            }
        });

        searchField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { actualizar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { actualizar(); }
            @Override
            public void changedUpdate(DocumentEvent e) { actualizar(); }
            private void actualizar() {
                String filtro = searchField1.getText().toLowerCase();
                actualizarModeloMaterias(filtro);
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
                actualizarModeloCarreras(filtro);
            }
        });
    }

    private void actualizarModeloCarreras(String filtro){
        modeloCarrera.clear();
        for (Carrera carrera : listaTodasCarreras){
            if (carrera.getNombre().toLowerCase().contains(filtro)) {
                modeloCarrera.addElement(carrera.getNombre());
            }
        }
    }

    private void actualizarModeloMaterias(String filtro) {
        modeloMateria.clear();
        for (Materia materia : listaTodasMaterias) {
            if (materia.getNombre().toLowerCase().contains(filtro)) {
                modeloMateria.addElement(materia.getNombre());
            }
        }
    }

    private void actualizarModeloLibreta(String filtro) {
        modeloLibreta.clear();
        Map<Integer, List<MateriaLibreta>> materiasPorCuatrimestre = new TreeMap<>();
        for (MateriaLibreta materiaLibreta : listaTodasMateriasLibreta) {
            if (materiaLibreta.getNombre().toLowerCase().contains(filtro)) {
                int cuatrimestre = materiaLibreta.getCuatrimestre();
                materiasPorCuatrimestre.putIfAbsent(cuatrimestre, new ArrayList<>());
                materiasPorCuatrimestre.get(cuatrimestre).add(materiaLibreta);
            }
        }

        for (Map.Entry<Integer, List<MateriaLibreta>> entry : materiasPorCuatrimestre.entrySet()) {
            modeloLibreta.addElement("Cuatrimestre " + entry.getKey() + ":");
            for (MateriaLibreta ml : entry.getValue()) {
                modeloLibreta.addElement(" - " + ml.getNombre() + ": " + ml.getEstado());
            }
        }
    }

}
