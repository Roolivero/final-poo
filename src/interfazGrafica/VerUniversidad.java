package interfazGrafica;
import javax.swing.*;
import java.awt.*;

public class VerUniversidad extends JPanel {

    public VerUniversidad(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        // Crear un JPanel para el botón de volver y agregarlo al BorderLayout.NORTH
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Panel con FlowLayout para alinear a la derecha
        topPanel.setBackground(new Color(251, 245, 248));
        JButton backButton = new JButton("Volver");
        mainFrame.personalizarBoton(backButton, new Color(156, 64, 83), Color.WHITE);
        backButton.addActionListener(e -> mainFrame.showHomePanel());
        topPanel.add(backButton);

        // Crear el contenido principal del panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(251, 245, 248));

        JButton carreras = new JButton("Agregar carreras");
        mainFrame.personalizarBoton(carreras, new Color(156, 64, 83), Color.WHITE);
        carreras.setAlignmentX(Component.LEFT_ALIGNMENT); // Centrar el JButton horizontalmente
        carreras.setAlignmentY(Component.LEFT_ALIGNMENT);

        JButton materias = new JButton("Agregar materias");
        mainFrame.personalizarBoton(materias, new Color(156, 64, 83), Color.WHITE);
        materias.setAlignmentX(Component.LEFT_ALIGNMENT);
        materias.setAlignmentY(Component.LEFT_ALIGNMENT);

        JButton alumnos = new JButton("Inscribir alumnos");
        mainFrame.personalizarBoton(alumnos, new Color(156, 64, 83), Color.WHITE);
        alumnos.setAlignmentX(Component.LEFT_ALIGNMENT);
        alumnos.setAlignmentY(Component.LEFT_ALIGNMENT);

        JButton alumnosMateria = new JButton("Inscribir materia");
        mainFrame.personalizarBoton(alumnosMateria, new Color(156, 64, 83), Color.WHITE);
        alumnosMateria.setAlignmentX(Component.LEFT_ALIGNMENT);
        alumnosMateria.setAlignmentY(Component.LEFT_ALIGNMENT);

        JButton libretaUniversitaria = new JButton("Ver libreta");
        mainFrame.personalizarBoton(libretaUniversitaria, new Color(156, 64, 83), Color.WHITE);
        libretaUniversitaria.setAlignmentX(Component.LEFT_ALIGNMENT);
        libretaUniversitaria.setAlignmentY(Component.LEFT_ALIGNMENT);

        centerPanel.add(carreras);
        centerPanel.add(materias);
        centerPanel.add(alumnos);
        centerPanel.add(alumnosMateria);
        centerPanel.add(libretaUniversitaria);


        centerPanel.add(carreras);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(materias);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(alumnos);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(alumnosMateria);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(libretaUniversitaria);

        // Agregar el panel superior y el panel central al panel principal
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
}

