package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class AgregarUniversidad extends JPanel {
    public AgregarUniversidad(MainFrame mainFrame) {
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

        JLabel label = new JLabel("Ingrese el nombre de la universidad:");
        label.setFont(new Font("Open Sans", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel horizontalmente
        label.setAlignmentY(Component.CENTER_ALIGNMENT);

        JTextField nombre = new JTextField(20);
        Dimension preferredSize = new Dimension(200, nombre.getPreferredSize().height); // Adjust width as needed
        nombre.setFont(new Font("Open Sans", Font.PLAIN, 16));
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JTextField horizontalmente
        nombre.setAlignmentY(Component.CENTER_ALIGNMENT);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JButton horizontalmente
        submitButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Agregar componentes al panel central
        centerPanel.add(label);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre el JLabel y el JTextField
        centerPanel.add(nombre);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre el JTextField y el JButton
        centerPanel.add(submitButton);

        // Agregar el panel superior y el panel central al panel principal
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
}
