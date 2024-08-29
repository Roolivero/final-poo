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
    private JPanel mainPanel;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    //Layouts para carreras
    private CardLayout carrerasCardLayout;
    private JPanel carrerasCardPanel;

    //Layouts para materias
    private CardLayout materiasCardLayout;
    private JPanel materiasCardPanel;

    //Layouts para alumnos
    private CardLayout alumnosCardLayout;
    private JPanel alumnosCardPanel;

    //Layouts para la libreta
    private CardLayout libretaCardLayout;
    private JPanel libretaCardPanel;


    public VerCarrera (MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Top panel with "Volver" button
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Left panel with navigation buttons
        JPanel leftPanel = createLeftPanel();
        add(leftPanel, BorderLayout.WEST);

        // Main content panel with cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel, BorderLayout.CENTER);


        // Add cards to the cardPanel
        cardPanel.add(createMateriasPanel(), "Materias");
        cardPanel.add(createAlumnosPanel(), "Alumnos");
        cardPanel.add(createLibretaUniversitariaPanel(), "Libreta");

    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    private void updateDisplay() {

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
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(new Color(225, 192, 199));
        panel.setBorder(new LineBorder(new Color(156, 64, 83), 2));
        JButton volverButton = new JButton("Volver");
        mainFrame.personalizarBoton(volverButton, new Color(156, 64, 83), Color.WHITE,10);
        volverButton.addActionListener(e -> mainFrame.showCard("Main"));
        panel.add(volverButton);
        return panel;
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(223, 190, 197));
        panel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(155, 63, 82)));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(50));


        String[] buttonLabels = {"Materias", "Alumnos", "Libreta"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE,12);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(150, 30));
            button.addActionListener(e -> cardLayout.show(cardPanel, label));
            panel.add(button);
            panel.add(Box.createVerticalStrut(15));
        }

        return panel;
    }

    private JPanel createPanelVacio() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        return panel;
    }

    private JPanel createMateriasPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 245, 248));

        materiasCardLayout = new CardLayout();
        materiasCardPanel = new JPanel(materiasCardLayout);
        materiasCardPanel.setBackground(new Color(251, 245, 248));
        panel.add(materiasCardPanel,BorderLayout.CENTER);

        materiasCardPanel.add(createPanelVacio(),"Vacio");
        materiasCardLayout.show(materiasCardPanel,"Vacio");

        String[] materiasLabels = {"Ver listado", "Agregar"};
        for (String label : materiasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);

            button.addActionListener(e -> {
                if (label.equals("Ver listado")) {
                    materiasCardPanel.removeAll();
                    materiasCardPanel.add(verMateriasPanel(), label);
                } else {
                    materiasCardPanel.removeAll();
                    materiasCardPanel.add(agregarMateriasPanel(), label);
                }
                materiasCardLayout.show(materiasCardPanel, label);
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
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para agregar materias"));

        JLabel nombre = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(15);
        JLabel esObligatoria = new JLabel("Es obligatoria? :");
        String[] opciones1 = {"Si", "No"};
        JComboBox<String> opciones1Box = new JComboBox<>(opciones1);
        opciones1Box.setSelectedIndex(-1);
        JLabel cuatrimestre = new JLabel("Cuatrimestre en el que se dicta :");
        String[] opciones2 = {"1", "2","3","4","5","6","7", "8","9","10","11","12"};
        JComboBox<String> opciones2Box = new JComboBox<>(opciones2);
        opciones2Box.setSelectedIndex(-1);

        JButton submitButton = new JButton("Agregar");
        submitButton.addActionListener(e -> {
            nombreField.setText("");
            opciones1Box.setSelectedIndex(-1);
            opciones2Box.setSelectedIndex(-1);
            String nombreMateria = nombreField.getText();
            if (!nombreMateria.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Universidad agregada correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de universidad.");
            }
        });
        mainFrame.personalizarBoton(submitButton,new Color(156, 64, 83), Color.WHITE, 10);

        panel.add(nombre);
        panel.add(nombreField);
        panel.add(esObligatoria);
        panel.add(opciones1Box);
        panel.add(cuatrimestre);
        panel.add(opciones2Box);
        panel.add(submitButton);

        return panel;
    }

    private JPanel verMateriasPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Listado de materias: ");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel dropPanel = new JPanel();
        dropPanel.setBackground(new Color(251, 245, 248));

        JPanel materiasPanel = new JPanel();
        materiasPanel.setLayout(new BoxLayout(materiasPanel, BoxLayout.Y_AXIS));
        panel.add(materiasPanel);

        if (carrera != null && carrera.getMaterias() != null) {
            displaySubjectsForMateria(materiasPanel);
        } else {
            dropPanel.add(new JLabel("No hay materias disponibles"));
        }
        panel.add(dropPanel);

        return panel;
    }

    private void displaySubjectsForMateria(JPanel subjectsPanel) {
        subjectsPanel.removeAll();

        if (carrera != null && carrera.getPlanEstudio() != null) {
            List<Materia> materias = carrera.getMaterias();
            for (Materia mat : materias) {
                JLabel materiaLabel = new JLabel("* " + mat.getNombre());
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
        panel.setBackground(new Color(251, 245, 248));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 245, 248));

        alumnosCardLayout = new CardLayout();
        alumnosCardPanel = new JPanel(alumnosCardLayout);
        alumnosCardPanel.setBackground(new Color(251, 245, 248));
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
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para inscribir un alumno a una carrera"));
        return panel;
    }

    private JPanel verAlumnosPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Contenido del listado de alumnos");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel dropPanel = new JPanel();
        dropPanel.setBackground(new Color(251, 245, 248));

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
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para inscribir a un alumo a una materia"));
        return panel;
    }


    private JPanel createLibretaUniversitariaPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 245, 248));

        libretaCardLayout = new CardLayout();
        libretaCardPanel = new JPanel(libretaCardLayout);
        libretaCardPanel.setBackground(new Color(251, 245, 248));
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
        panel.setBackground(new Color(251, 245, 248));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Libreta universitaria");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel dropPanel = new JPanel();
        dropPanel.setBackground(new Color(251, 245, 248));
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
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para agregar materias a la libreta de un alumno"));
        return panel;
    }




}
