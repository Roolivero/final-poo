package interfazGrafica;

import sistemaUniversitario.SistemaUniversitario;
import universidad.Universidad;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AgregarUniversidad extends JPanel {
    private MainFrame mainFrame;
    private SistemaUniversitario sistemaUniversitario;

    public AgregarUniversidad(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        //Inicializar sistema universitario.
        sistemaUniversitario = SistemaUniversitario.getInstancia();

        // Top panel with "Volver" button
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        //Panel para el inpur, subbit y el label principal
        JPanel mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createTopPanel() {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panel.setBackground(new Color(251, 230, 236, 255));
            panel.setBorder(new LineBorder(new Color(156, 64, 83), 2));
            JButton volverButton = new JButton("Volver");
            mainFrame.personalizarBoton(volverButton, new Color(156, 64, 83), Color.WHITE,10);
            volverButton.addActionListener(e -> mainFrame.showCard("Main"));
            panel.add(volverButton);
            return panel;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(155, 63, 82)));

        // Añadir glue antes del primer componente para empujar todo hacia el centro
        panel.add(Box.createVerticalGlue());

        JLabel labelPrincipal = new JLabel("Ingrese el nombre de la universidad");
        labelPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
        labelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelPrincipal);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField nombreUniversidad = new JTextField();
        nombreUniversidad.setPreferredSize(new Dimension(300, 30));
        nombreUniversidad.setMaximumSize(nombreUniversidad.getPreferredSize());
        nombreUniversidad.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nombreUniversidad);

        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Panel para los botones
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        botonesPanel.setBackground(new Color(251, 240, 242));

        JButton VerUniversidadButton = new JButton();
        mainFrame.personalizarBoton(VerUniversidadButton, new Color(156, 64, 83), Color.WHITE, 10);
        VerUniversidadButton.setText("Ver universidades");
        VerUniversidadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        VerUniversidadButton.addActionListener(e -> {
            nombreUniversidad.setText("");  // Vacía el campo de texto
            mainFrame.showCard("BuscarUniversidad");
        });

        JButton AgregarButton = new JButton();
        mainFrame.personalizarBoton(AgregarButton, new Color(156, 64, 83), Color.WHITE, 10);
        AgregarButton.setText("Agregar");
        AgregarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        AgregarButton.addActionListener(e -> {
            String nombre = nombreUniversidad.getText();
            if (!nombre.isEmpty()) {
                sistemaUniversitario.agregarUniversidad(new Universidad(nombre));
                JOptionPane.showMessageDialog(null, "Universidad agregada correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de universidad.");
            }
        });

        botonesPanel.add(VerUniversidadButton);
        botonesPanel.add(AgregarButton);
        panel.add(botonesPanel);

        panel.add(Box.createVerticalGlue());

        return panel;
    }


}
