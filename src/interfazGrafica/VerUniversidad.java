package interfazGrafica;

import alumno.Alumno;
import carrera.Carrera;
import libretaUniversitaria.Libreta;
import materia.Materia;
import materia.MateriaLibreta;
import universidad.Universidad;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;


public class VerUniversidad extends JPanel {
    private MainFrame mainFrame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private Universidad universidad;

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

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
        updateDisplay();
    }

    private void updateDisplay() {
        // Panel para las carreras
        carrerasCardPanel.removeAll();
        carrerasCardPanel.add(createPanelVacio(), "Vacio");
        carrerasCardLayout.show(carrerasCardPanel, "Vacio");

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

        carrerasCardPanel.revalidate();
        carrerasCardPanel.repaint();
        materiasCardPanel.revalidate();
        materiasCardPanel.repaint();
        alumnosCardPanel.revalidate();
        alumnosCardPanel.repaint();
        libretaCardPanel.revalidate();
        libretaCardPanel.repaint();
    }

    public VerUniversidad(MainFrame mainFrame) {
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
        cardPanel.add(createCarrerasPanel(), "Carreras");
        cardPanel.add(createMateriasPanel(), "Materias");
        cardPanel.add(createAlumnosPanel(), "Alumnos");
        cardPanel.add(createLibretaUniversitariaPanel(), "Libreta");

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


        String[] buttonLabels = {"Carreras", "Materias", "Alumnos", "Libreta"};
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

    private JPanel createCarrerasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(221, 189, 195));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 245, 248));

        carrerasCardLayout = new CardLayout();
        carrerasCardPanel = new JPanel(carrerasCardLayout);
        carrerasCardPanel.setBackground(new Color(251, 245, 248));
        panel.add(carrerasCardPanel, BorderLayout.CENTER);
        
        carrerasCardPanel.add(createPanelVacio(),"Vacio");
        carrerasCardLayout.show(carrerasCardPanel, "Vacio");

        String[] carrerasLabels = {"Ver listado", "Agregar"};
        for (String label : carrerasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> {
                if (label.equals("Ver listado")) {
                    carrerasCardPanel.removeAll();
                    carrerasCardPanel.add(verCarrerasPanel(), label);
                } else {
                    carrerasCardPanel.removeAll();
                    carrerasCardPanel.add(agregarCarrerasPanel(), label);
                }
                carrerasCardLayout.show(carrerasCardPanel, label);
                carrerasCardPanel.revalidate();
                carrerasCardPanel.repaint();
            });
        }

        panel.add(buttonPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel createPanelVacio() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        return panel;
    }

    private JPanel agregarCarrerasPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para agregar carreras"));
        return panel;
    }

    private JPanel verCarrerasPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usar BoxLayout en eje Y

        JLabel tituloLabel = new JLabel("Listado de carreras: ");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinear en el centro
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio debajo del título

        // Mostrar la lista de carreras
        if(universidad != null && universidad.getListaCarreras() != null){
            for(Carrera carrera : universidad.getListaCarreras()){
                JLabel carreraLabel = new JLabel("* "+carrera.getNombre());
                carreraLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(carreraLabel);
                panel.add(Box.createVerticalStrut(10));
            }
        } else {
            JLabel noCarrerasLabel = new JLabel("No hay carreras disponibles.");
            noCarrerasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(noCarrerasLabel);
        }

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
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para agregar materias"));
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
        if (universidad != null && universidad.getListaCarreras() != null) {
            String[] nombres = getNombresCarreras(universidad.getListaCarreras());

            JComboBox<String> dropBox = new JComboBox<>(nombres);
            dropBox.setSelectedIndex(-1);

            JPanel materiasPanel = new JPanel();
            materiasPanel.setLayout(new BoxLayout(materiasPanel, BoxLayout.Y_AXIS));
            panel.add(materiasPanel);

            dropBox.addActionListener(e -> {
                String carrera = (String) dropBox.getSelectedItem();
                Carrera carreraSeleccionada = getCarreraByName(carrera);
                if(carreraSeleccionada != null){
                    displaySubjectsForCareer(materiasPanel, carreraSeleccionada);
                }
            });
        } else {
            dropPanel.add(new JLabel("No hay carreras disponibles"));
        }
        panel.add(dropPanel);

        return panel;
    }

    private String[] getNombresCarreras(List<Carrera> lista) {
        if (lista == null || lista.isEmpty()) {
            return new String[]{"No hay carreras"};
        }

        String[] nombresCarreras = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            nombresCarreras[i] = lista.get(i).getNombre();
        }
        return nombresCarreras;
    }

    private void displaySubjectsForCareer(JPanel subjectsPanel, Carrera carrera) {
        subjectsPanel.removeAll();  // Clear previous subjects

        if (carrera != null && carrera.getPlanEstudio() != null) {
            List<Materia> materias = carrera.getMaterias();
            for (Materia materia : materias) {
                JLabel materiaLabel = new JLabel("* " + materia.getNombre());
                materiaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                subjectsPanel.add(materiaLabel);
                subjectsPanel.add(Box.createVerticalStrut(5)); // Add spacing between subjects
            }
        } else {
            subjectsPanel.add(new JLabel("No hay materias disponibles."));
        }

        subjectsPanel.revalidate();
        subjectsPanel.repaint();
    }

    private Carrera getCarreraByName(String name) {
        if (universidad != null) {
            for (Carrera carrera : universidad.getListaCarreras()) {
                if (carrera.getNombre().equals(name)) {
                    return carrera;
                }
            }
        }
        return null;
    }

    private JPanel createAlumnosPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // 20 is the horizontal gap, 10 is the vertical gap
        buttonPanel.setBackground(new Color(251, 245, 248)); // Match background color

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
        if (universidad != null && universidad.getListaCarreras() != null) {
            String[] nombres = getNombresCarreras(universidad.getListaCarreras());
            JComboBox<String> dropBox = new JComboBox<>(nombres);
            dropPanel.add(dropBox);

            JPanel alumnosPanel = new JPanel();
            alumnosPanel.setLayout(new BoxLayout(alumnosPanel, BoxLayout.Y_AXIS));
            panel.add(alumnosPanel);

            dropBox.addActionListener(e -> {
                String carrera = (String) dropBox.getSelectedItem();
                Carrera carreraSeleccionada = getCarreraByName(carrera);
                displaySubjectsForCareerAlumnos(alumnosPanel, carreraSeleccionada);
            });
        } else {
            dropPanel.add(new JLabel("No hay carreras disponibles"));
        }
        panel.add(dropPanel);

        return panel;
    }

    private void displaySubjectsForCareerAlumnos (JPanel alumnosPanel, Carrera carrera) {
        alumnosPanel.removeAll();

        if (carrera != null && carrera.getPlanEstudio() != null) {
            List<Alumno> alumnos = carrera.getAlumnosInscriptos();
            for (Alumno alumno : alumnos) {
                JLabel alumnosLabel = new JLabel("* " + alumno.getNombre());
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


    private JPanel verLibretaPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Libreta universitaria");
        tituloLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel dropPanel = new JPanel();
        dropPanel.setLayout(new FlowLayout());


        if (universidad != null && universidad.getListaCarreras() != null) {
            String[] nombresCarreras = getNombresCarreras(universidad.getListaCarreras());
            JComboBox<String> carrerasDropBox = new JComboBox<>(nombresCarreras);
            JComboBox<String> alumnosDropBox = new JComboBox<>();

            dropPanel.add(new JLabel("Carrera: "));
            dropPanel.add(carrerasDropBox);
            dropPanel.add(new JLabel("Alumno: "));
            dropPanel.add(alumnosDropBox);

            JPanel libretaPanel = new JPanel();
            libretaPanel.setLayout(new BoxLayout(libretaPanel, BoxLayout.Y_AXIS));
            panel.add(libretaPanel);

            carrerasDropBox.addActionListener(e -> {
                String carreraNombre = (String) carrerasDropBox.getSelectedItem();
                Carrera carreraSeleccionada = getCarreraByName(carreraNombre);
                displaySubjectsForAlumnos(alumnosDropBox, carreraSeleccionada);
            });

            alumnosDropBox.addActionListener(e -> {
                String carreraNombre = (String) carrerasDropBox.getSelectedItem();
                String alumnoNombre = (String) alumnosDropBox.getSelectedItem();
                Carrera carrera = getCarreraByName(carreraNombre);
                Alumno alumno = getAlumnoByName(carrera, alumnoNombre);
                displayLibreta(libretaPanel, alumno);
            });

        } else {
            dropPanel.add(new JLabel("No hay carreras disponibles"));
        }
        panel.add(dropPanel);

        return panel;
    }

    private void displaySubjectsForAlumnos (JComboBox<String> alumnosDropBox, Carrera carrera) {
        alumnosDropBox.removeAllItems();

        if (carrera != null && carrera.getPlanEstudio() != null) {
            List<Alumno> alumnos = carrera.getAlumnosInscriptos();
            for (Alumno alumno : alumnos) {
                alumnosDropBox.addItem(alumno.getNombre());
            }
        }
    }

    private Alumno getAlumnoByName(Carrera carrera, String nombre) {
        if (carrera != null && carrera.getAlumnosInscriptos() != null) {
            for (Alumno alumno : carrera.getAlumnosInscriptos()) {
                if (alumno.getNombre().equals(nombre)) {
                    return alumno;
                }
            }
        }
        return null;
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