package interfazGrafica;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;


public class VerUniversidad extends JPanel {
    private MainFrame mainFrame;
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

    // Placeholder methods for different card panels
    private JPanel createCarrerasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(221, 189, 195));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // 20 is the horizontal gap, 10 is the vertical gap
        buttonPanel.setBackground(new Color(251, 245, 248)); // Match background color

        String[] carrerasLabels = {"Ver listado", "Agregar"};
        for (String label : carrerasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> carrerasCardLayout.show(carrerasCardPanel, label));
        }

        panel.add(buttonPanel, BorderLayout.NORTH); // Add buttons at the top of the panel

        // Initialize the CardLayout and JPanel for Carreras
        carrerasCardLayout = new CardLayout();
        carrerasCardPanel = new JPanel(carrerasCardLayout);
        panel.add(carrerasCardPanel, BorderLayout.CENTER); // Main content area for the cards

        // Add internal cards for Carreras
        carrerasCardPanel.add(verCarrerasPanel(), "Ver listado");
        carrerasCardPanel.add(agregarCarrerasPanel(), "Agregar");

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
        panel.add(new JLabel("Contenido del listado de carreras"));
        return panel;
    }

    private JPanel createMateriasPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(251, 245, 248));

        String[] materiasLabels = {"Ver listado", "Agregar"};
        for (String label : materiasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> materiasCardLayout.show(materiasCardPanel, label));
        }

        panel.add(buttonPanel, BorderLayout.NORTH);

        // Initialize the CardLayout and JPanel for Materias
        materiasCardLayout = new CardLayout();
        materiasCardPanel = new JPanel(materiasCardLayout);
        panel.add(materiasCardPanel, BorderLayout.CENTER); // Main content area for the cards

        // Add internal cards for Carreras
        materiasCardPanel.add(verMateriasPanel(), "Ver listado");
        materiasCardPanel.add(agregarMateriasPanel(), "Agregar");


        return panel;
    }

    private JPanel agregarMateriasPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para agregar materias"));
        return panel;
    }

    private JPanel verMateriasPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Contenido del listado de materias"));
        return panel;
    }

    private JPanel createAlumnosPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(156, 64, 83)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // 20 is the horizontal gap, 10 is the vertical gap
        buttonPanel.setBackground(new Color(251, 245, 248)); // Match background color

        String[] alumnosLabels = {"Ver listado", "Inscribir carrera","Inscribir materia"};
        for (String label : alumnosLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> alumnosCardLayout.show(alumnosCardPanel, label));
        }

        panel.add(buttonPanel, BorderLayout.NORTH); // Add buttons at the top of the panel

        // Initialize the CardLayout and JPanel for Carreras
        alumnosCardLayout = new CardLayout();
        alumnosCardPanel = new JPanel(alumnosCardLayout);
        panel.add(alumnosCardPanel, BorderLayout.CENTER); // Main content area for the cards

        // Add internal cards for Carreras
        alumnosCardPanel.add(verAlumnosPanel(), "Ver listado");
        alumnosCardPanel.add(inscribirAlumnosPanel(), "Inscribir carrera");
        alumnosCardPanel.add(inscribirAlumnosMateriaPanel(), "Inscribir materia");

        return panel;
    }

    private JPanel verAlumnosPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Contenido del listado de alumnos"));
        return panel;
    }

    private JPanel inscribirAlumnosPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para inscribir un alumno a una carrera"));
        return panel;
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

        String[] carrerasLabels = {"Ver libreta", "Agregar materia"};
        for (String label : carrerasLabels) {
            JButton button = new JButton(label);
            mainFrame.personalizarBoton(button, new Color(156, 64, 83), Color.WHITE, 12);
            buttonPanel.add(button);
            button.addActionListener(e -> libretaCardLayout.show(libretaCardPanel, label));
        }

        panel.add(buttonPanel, BorderLayout.NORTH);

        // Initialize the CardLayout and JPanel for Libreta
        libretaCardLayout = new CardLayout();
        libretaCardPanel = new JPanel(libretaCardLayout);
        panel.add(libretaCardPanel, BorderLayout.CENTER); // Main content area for the cards

        // Add internal cards for Carreras
        libretaCardPanel.add(verListadoPanel(), "Ver libreta");
        libretaCardPanel.add(agregarMateriaLibretaPanel(), "Agregar materia");

        return panel;
    }

    private JPanel verListadoPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Listado de las materias de la libreta de un alumno"));
        return panel;
    }

    private JPanel agregarMateriaLibretaPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 245, 248));
        panel.add(new JLabel("Formulario para agregar materias a la libreta de un alumno"));
        return panel;
    }


}