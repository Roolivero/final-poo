package interfazGrafica;

import alumno.Alumno;
import carrera.Carrera;
import libretaUniversitaria.Libreta;
import materia.Materia;
import materia.MateriaLibreta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;


public class VerCarrera extends JPanel {
    private MainFrame mainFrame;
    private Carrera carrera;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    // elementos para el topPanel
    private JLabel nombreCarreraLabelTop;
    private JPanel topPanel;

    //Layout para el mainPanel
    private CardLayout mainCardLayout;
    private JPanel mainCardPanel;
    private JLabel nombreCarreraLabelMain;

    //Layouts para materias
    private CardLayout materiasCardLayout;
    private JPanel materiasCardPanel;

    //Layouts para alumnos
    private CardLayout alumnosCardLayout;
    private JPanel alumnosCardPanel;

    //Layouts para la libreta
    private CardLayout libretaCardLayout;
    private JPanel libretaCardPanel;

    private JPanel buttonPanel;

    public VerCarrera (MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Panel superior con el boton "Volver"
        topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Panel izquierdo con los botones
        JPanel leftPanel = createLeftPanel();
        add(leftPanel, BorderLayout.WEST);

        // Panel principal con las cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel, BorderLayout.CENTER);

        // Add cards to the cardPanel
        cardPanel.add(createMainPanel(),"Principal");
        cardPanel.add(createMateriasPanel(), "Materias");
        cardPanel.add(createAlumnosPanel(), "Alumnos");
        cardPanel.add(createLibretaUniversitariaPanel(), "Libreta");

    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
        updateDisplay();
    }

    private void updateDisplay() {
        // MainPanel
        if (carrera != null) {
            String nombre = "Bienvenido a: " + carrera.getNombre();
            nombreCarreraLabelMain.setText(nombre);
            nombreCarreraLabelTop.setText(nombre);
        } else {
            nombreCarreraLabelMain.setText("Bienvenido");
            nombreCarreraLabelTop.setText("");
        }

        // Panel para las materias
        materiasCardPanel.removeAll();
        materiasCardPanel.add(createPanelVacio(), "Vacio");
        materiasCardLayout.show(materiasCardPanel, "Vacio");

        // Panel para los alumnos
        alumnosCardPanel.removeAll();
        alumnosCardPanel.add(createPanelVacio(), "Vacio");
        alumnosCardLayout.show(alumnosCardPanel, "Vacio");

        // Panel para la libreta universitaria
        libretaCardPanel.removeAll();
        libretaCardPanel.add(createPanelVacio(), "Vacio");
        libretaCardLayout.show(libretaCardPanel, "Vacio");

        materiasCardPanel.revalidate();
        materiasCardPanel.repaint();
        alumnosCardPanel.revalidate();
        alumnosCardPanel.repaint();
        libretaCardPanel.revalidate();
        libretaCardPanel.repaint();
    }

    private JPanel createTopPanel() {
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(251, 230, 236, 255));
        topPanel.setBorder(new LineBorder(new Color(156, 64, 83), 2));

        nombreCarreraLabelTop = new JLabel("");
        nombreCarreraLabelTop.setFont(new Font("Open Sans", Font.BOLD, 16));
        nombreCarreraLabelTop.setVisible(false);
        topPanel.add(nombreCarreraLabelTop, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);

        JButton volverButton = new JButton("Volver");
        mainFrame.personalizarBoton(volverButton, new Color(156, 64, 83), Color.WHITE, 12);
        volverButton.addActionListener(e -> mainFrame.showCard("Main"));

        buttonPanel.add(volverButton);

        topPanel.add(buttonPanel, BorderLayout.EAST);

        return topPanel;
    }

    private JPanel createMainPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(251, 240, 242));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0,10,10,10);
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;

        nombreCarreraLabelMain = new JLabel("Bienvenido a: ");
        nombreCarreraLabelMain.setFont(new Font("Open Sans", Font.BOLD, 20));
        centerPanel.add(nombreCarreraLabelMain, gbc);

        // panel vacío para mover el label
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(10, 60));
        emptyPanel.setBackground(new Color(251, 240, 242)); // Match background

        // Add the empty panel to the NORTH
        panel.add(emptyPanel, BorderLayout.SOUTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }


    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 230, 236, 255));
        panel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(155, 63, 82)));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(50));


        String[] buttonLabels = {"Materias", "Alumnos", "Libreta"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE,12);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(150, 30));
            button.addActionListener(e -> {
                cardLayout.show(cardPanel, label);
                mostrarLabelCarrera();
            });
            panel.add(button);
            panel.add(Box.createVerticalStrut(15));
        }

        return panel;
    }

    private void mostrarLabelCarrera(){
        nombreCarreraLabelMain.setVisible(false);
        nombreCarreraLabelTop.setText(carrera.getNombre());

        nombreCarreraLabelTop.setVisible(true);
        topPanel.revalidate();
        topPanel.repaint();
    }

    private JPanel createPanelVacio() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        return panel;
    }

    private JPanel createMateriasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(111, 0, 255));

        materiasCardLayout = new CardLayout();
        materiasCardPanel = new JPanel(materiasCardLayout);
        materiasCardPanel.setBackground(new Color(251, 240, 242));
        panel.add(materiasCardPanel, BorderLayout.CENTER);

        materiasCardPanel.add(createPanelVacio(), "Vacio");
        materiasCardLayout.show(materiasCardPanel, "Vacio");

        String[] materiasLabels = {"Ver listado", "Agregar"};
        for (String label : materiasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);

            button.addActionListener(e -> {
                if (label.equals("Ver listado")) {
                    materiasCardPanel.removeAll();
                    materiasCardPanel.add(verMateriasPanel(), "verListado");
                    materiasCardLayout.show(materiasCardPanel, "verListado");
                } else {
                    materiasCardPanel.removeAll();
                    materiasCardPanel.add(agregarMateriasPanel(), "agregar");
                    materiasCardLayout.show(materiasCardPanel, "agregar");
                }
                materiasCardPanel.revalidate();
                materiasCardPanel.repaint();
            });
        }

        panel.add(buttonPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel agregarMateriasPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(24, 58, 225));

        JLabel titleLabel = new JLabel("Complete los datos de la materia: ");
        titleLabel.setFont(new Font("Arial",Font.BOLD,18));
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

        JLabel esObligatoria = new JLabel("Es obligatoria? :");
        String[] opciones1 = {"Si", "No"};
        JComboBox<String> opciones1Box = new JComboBox<>(opciones1);
        Dimension box1 = new Dimension(250, 30);
        opciones1Box.setPreferredSize(box1);
        opciones1Box.setMaximumSize(box1);
        opciones1Box.setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones1Box.setBackground(Color.white);
        opciones1Box.setSelectedIndex(-1);

        JLabel cuatrimestre = new JLabel("Cuatrimestre en el que se dicta :");
        cuatrimestre.setBackground(Color.white);
        String[] opciones2 = {"1", "2","3","4","5","6","7", "8","9","10"};
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
        mainFrame.personalizarBoton(submitButton,new Color(156, 64, 83), Color.WHITE, 10);

        JButton verListadoButton = new JButton("Ver materias");
        verListadoButton.addActionListener(e -> {
            materiasCardPanel.removeAll();
            materiasCardPanel.add(verMateriasPanel(), "verListado");
            materiasCardLayout.show(materiasCardPanel, "verListado");
            materiasCardPanel.revalidate();
            materiasCardPanel.repaint();
        });

        mainFrame.personalizarBoton(verListadoButton,new Color(156, 64, 83), Color.WHITE, 10);

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

    private JPanel verMateriasPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(144, 10, 34));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Listado de materias: ");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel materiasPanel = new JPanel();
        materiasPanel.setLayout(new BoxLayout(materiasPanel, BoxLayout.Y_AXIS));
        materiasPanel.setBackground(new Color(239, 223, 227, 225));

        JScrollPane scrollPanel = new JScrollPane(materiasPanel);
        scrollPanel.setPreferredSize(new Dimension(350,180));
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //scrollPanel.setBorder(BorderFactory.createLineBorder(new Color(156, 64, 83), 2));

        panel.add(scrollPanel);

        if (carrera != null && carrera.getMaterias() != null) {
            displaySubjectsForMateria(materiasPanel);
        } else {
            materiasPanel.add(new JLabel("No hay materias disponibles"));
        }

        panel.revalidate();
        panel.repaint();
        scrollPanel.revalidate();
        scrollPanel.repaint();

        return panel;
    }

    private void displaySubjectsForMateria(JPanel subjectsPanel) {
        subjectsPanel.removeAll();

        if (carrera != null && carrera.getPlanEstudio() != null) {
            List<Materia> materias = carrera.getMaterias();
            for (Materia mat : materias) {
                JLabel materiaLabel = new JLabel(mat.getNombre());
                materiaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                subjectsPanel.add(materiaLabel);
                subjectsPanel.add(Box.createVerticalStrut(5));
            }
        } else {
            subjectsPanel.add(new JLabel("No hay materias disponibles."));
        }

        subjectsPanel.revalidate();
        subjectsPanel.repaint();
    }


    private JPanel createAlumnosPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 240, 242));

        alumnosCardLayout = new CardLayout();
        alumnosCardPanel = new JPanel(alumnosCardLayout);
        alumnosCardPanel.setBackground(new Color(251, 240, 242));
        panel.add(alumnosCardPanel, BorderLayout.CENTER);

        alumnosCardPanel.add(createPanelVacio(),"Vacio");
        alumnosCardLayout.show(alumnosCardPanel, "Vacio");


        String[] alumnosLabels = {"Ver listado", "Inscribir carrera","Inscribir materia"};
        for (String label : alumnosLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> {
                if (label.equals("Ver listado")) {
                    alumnosCardPanel.removeAll();
                    alumnosCardPanel.add(verAlumnosPanel(), label);
                } else if (label.equals("Inscribir carrera")){
                    alumnosCardPanel.removeAll();
                    alumnosCardPanel.add(inscribirAlumnosPanel(), label);
                } else if (label.equals("Inscribir materia")){
                    alumnosCardPanel.removeAll();
                    alumnosCardPanel.add(inscribirAlumnosMateriaPanel(), label);
                }
                alumnosCardLayout.show(alumnosCardPanel, label);
                alumnosCardPanel.revalidate();
                alumnosCardPanel.repaint();
            });
        }

        panel.add(buttonPanel, BorderLayout.NORTH); // Add buttons at the top of the panel

        return panel;
    }

    private JPanel inscribirAlumnosPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.add(new JLabel("Formulario para inscribir un alumno a una carrera"));
        return panel;
    }

    private JPanel verAlumnosPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Contenido del listado de alumnos");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel dropPanel = new JPanel();
        dropPanel.setBackground(new Color(251, 240, 242));

        JPanel alumnosPanel = new JPanel();
        alumnosPanel.setLayout(new BoxLayout(alumnosPanel, BoxLayout.Y_AXIS));
        panel.add(alumnosPanel);

        if (carrera != null && carrera.getAlumnosInscriptos() != null) {
            displaySubjectsForAlumnos(alumnosPanel);

        } else {
            dropPanel.add(new JLabel("No hay alumnos inscriptos"));
        }
        panel.add(dropPanel);

        return panel;
    }

    private String[] getAlumnosCarreras(List<Alumno> lista) {
        if (lista == null || lista.isEmpty()) {
            return new String[]{"No hay alumnos inscriptos"};
        }

        String[] alumnos = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            alumnos[i] = lista.get(i).getNombre();
        }
        return alumnos;
    }


    private Alumno getAlumno(String name) {
        if (carrera != null && carrera.getAlumnosInscriptos() != null) {
            for (Alumno alumno : carrera.getAlumnosInscriptos()) {
                if (alumno.getNombre().equals(name)) {
                    return alumno;
                }
            }
        }
        return null;
    }

    private void displaySubjectsForAlumnos (JPanel alumnosPanel) {
        alumnosPanel.removeAll();

        if (carrera != null && carrera.getPlanEstudio() != null) {
            List<Alumno> alumnos = carrera.getAlumnosInscriptos();
            for (Alumno alu : alumnos) {
                JLabel alumnosLabel = new JLabel("* " + alu.getNombre() + " " + alu.getApellido());
                alumnosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                alumnosPanel.add(alumnosLabel);
                alumnosPanel.add(Box.createVerticalStrut(5));
            }
        } else {
            alumnosPanel.add(new JLabel("No hay alumnos inscriptos."));
        }

        alumnosPanel.revalidate();
        alumnosPanel.repaint();
    }


    private JPanel inscribirAlumnosMateriaPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.add(new JLabel("Formulario para inscribir a un alumo a una materia"));
        return panel;
    }


    private JPanel createLibretaUniversitariaPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 240, 242));

        libretaCardLayout = new CardLayout();
        libretaCardPanel = new JPanel(libretaCardLayout);
        libretaCardPanel.setBackground(new Color(251, 240, 242));
        panel.add(libretaCardPanel, BorderLayout.CENTER);

        libretaCardPanel.add(createPanelVacio(),"Vacio");
        libretaCardLayout.show(libretaCardPanel, "Vacio");


        String[] carrerasLabels = {"Ver libreta", "Agregar materia"};
        for (String label : carrerasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> {
                if (label.equals("Ver libreta")) {
                    libretaCardPanel.removeAll();
                    libretaCardPanel.add(verLibretaPanel(), label);
                } else if (label.equals("Agregar materia")){
                    libretaCardPanel.removeAll();
                    libretaCardPanel.add(agregarMateriaLibretaPanel(), label);
                }
                libretaCardLayout.show(libretaCardPanel, label);
                libretaCardPanel.revalidate();
                libretaCardPanel.repaint();
            });
        }

        panel.add(buttonPanel, BorderLayout.NORTH);

        return panel;
    }


    private JPanel verLibretaPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Libreta universitaria");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel dropPanel = new JPanel();
        dropPanel.setBackground(new Color(251, 240, 242));
        dropPanel.setLayout(new FlowLayout());

        JPanel libretaPanel = new JPanel();
        libretaPanel.setLayout(new BoxLayout(libretaPanel, BoxLayout.Y_AXIS));
        panel.add(libretaPanel);

        dropPanel.add(new JLabel("Alumno: "));

        if (carrera != null && carrera.getAlumnosInscriptos() != null) {
            String[] alumnos = getAlumnosCarreras(carrera.getAlumnosInscriptos());

            JComboBox<String> alumnosDropBox = new JComboBox<>(alumnos);
            alumnosDropBox.setSelectedIndex(-1);

            alumnosDropBox.addActionListener(e -> {
                String alumnoNombre = (String) alumnosDropBox.getSelectedItem();
                Alumno alumno = getAlumno(alumnoNombre);
                if (alumno != null) {
                    displayLibreta(libretaPanel, alumno);
                }
            });

            dropPanel.add(alumnosDropBox);
        } else {
            dropPanel.add(new JLabel("No hay alumnos inscriptos, no se puede ver ninguna libreta"));
        }
        panel.add(dropPanel);

        return panel;
    }

    private void displayLibreta(JPanel libretaPanel, Alumno alumno) {
        libretaPanel.removeAll();

        if (alumno != null) {
            JLabel alumnoLabel = new JLabel("Libreta de " + alumno.getNombre() + " " + alumno.getApellido());
            alumnoLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
            libretaPanel.add(alumnoLabel);
            libretaPanel.add(Box.createVerticalStrut(10));

            Libreta libretaAlumno = alumno.getLibretaAlumno();
            if (libretaAlumno != null && libretaAlumno.getLibreta() != null) {
                ArrayList<MateriaLibreta> materias = libretaAlumno.getLibreta();
                if (!materias.isEmpty()) {
                    for (MateriaLibreta materia : materias) {
                        JLabel materiaLabel = new JLabel(materia.getNombre() + ": " + materia.getNotas());
                        materiaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        libretaPanel.add(materiaLabel);
                        libretaPanel.add(Box.createVerticalStrut(5));
                    }
                } else {
                    libretaPanel.add(new JLabel("No hay materias registradas en la libreta."));
                }
            } else {
                libretaPanel.add(new JLabel("La libreta del alumno está vacía."));
            }
        } else {
            libretaPanel.add(new JLabel("No se encontró información del alumno"));
        }

        libretaPanel.revalidate();
        libretaPanel.repaint();
    }

    private JPanel agregarMateriaLibretaPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 240, 242));
        panel.add(new JLabel("Formulario para agregar materias a la libreta de un alumno"));
        return panel;
    }




}
