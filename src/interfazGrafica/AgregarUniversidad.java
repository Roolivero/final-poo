package interfazGrafica;

import javax.lang.model.element.VariableElement;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AgregarUniversidad extends JPanel {

    private MainFrame mainFrame;

    public AgregarUniversidad(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

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
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(155, 63, 82)));

        JLabel labelPrincipal = new JLabel("Ingrese el nombre de la Universidad que desea registrar");
        labelPrincipal.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField universityNameField = new JTextField(20);
        universityNameField.setPreferredSize(new Dimension(350, 40));
        universityNameField.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton agregarButton = new JButton("Agregar");
        mainFrame.personalizarBoton(agregarButton, new Color(148, 13, 53), Color.WHITE, 15);
        agregarButton.addActionListener(e -> mainFrame.showCard("VerUniversidad"));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(agregarButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 20, 1, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(labelPrincipal, gbc);
        panel.add(Box.createVerticalStrut(5), gbc); // Add some spacing between the label and text field
        panel.add(universityNameField, gbc);
        panel.add(Box.createVerticalStrut(5), gbc); // Add some spacing between the text field and button
        panel.add(buttonPanel, gbc);

        return panel;
    }

}
