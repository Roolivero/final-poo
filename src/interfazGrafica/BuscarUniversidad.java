package interfazGrafica;

import sistemaUniversitario.SistemaUniversitario;
import universidad.Universidad;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class BuscarUniversidad extends JPanel {
    private MainFrame mainFrame;
    private JTextField universityNameField;
    private JPanel mainPanel;
    private boolean initialized = false;
    //private SistemaUniversitario sistema;

    public BuscarUniversidad(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        //this.sistema = sistema;
        setLayout(new BorderLayout());

        // Add ComponentListener
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (!initialized) {
                    initComponents();
                    initialized = true;
                }
                resetPanel();
            }
        });
    }

    private void initComponents() {
        // Top panel with "Volver" button
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Panel para el input, submit y el label principal
        mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
    }

    private void resetPanel() {
        if (universityNameField != null) {
            universityNameField.setText("");
        }
        if (mainPanel != null) {
            for (Component comp : mainPanel.getComponents()) {
                if (comp instanceof JLabel && ((JLabel) comp).getForeground().equals(Color.RED)) {
                    mainPanel.remove(comp);
                }
            }
            mainPanel.revalidate();
            mainPanel.repaint();
        }
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

        JLabel labelPrincipal = new JLabel("Ingrese el nombre de la Universidad que desea buscar");
        labelPrincipal.setFont(new Font("Arial", Font.BOLD, 20));

        universityNameField = new JTextField(20);
        universityNameField.setPreferredSize(new Dimension(350, 40));
        universityNameField.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton agregarButton = new JButton("Buscar");
        mainFrame.personalizarBoton(agregarButton, new Color(148, 13, 53), Color.WHITE, 15);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(agregarButton);

        agregarButton.addActionListener(e -> {
            String universityName = universityNameField.getText();
            verificarUniversidad(universityName, panel);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 20, 1, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(labelPrincipal, gbc);
        panel.add(Box.createVerticalStrut(5), gbc);
        panel.add(universityNameField, gbc);
        panel.add(Box.createVerticalStrut(5), gbc);
        panel.add(buttonPanel, gbc);

        return panel;
    }

    private void verificarUniversidad(String nombreUniversidad, JPanel panel){
        SistemaUniversitario sistema = SistemaUniversitario.getInstancia();
        List<Universidad> listaUniversidades = sistema.getListaUniversidades();
        Universidad universidadEncontrada = null;

        for (Universidad uni : listaUniversidades) {
            if (uni.getNombre().equals(nombreUniversidad)) {
                universidadEncontrada = uni;
                break;
            }
        }
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JLabel && ((JLabel) comp).getForeground().equals(Color.RED)) {
                panel.remove(comp);
            }
        }

        if (universidadEncontrada != null ) {
            mainFrame.showVerUniversidad(universidadEncontrada);
        } else {
            JLabel errorLabel = new JLabel("Universidad no encontrada.");
            errorLabel.setForeground(Color.RED);
            errorLabel.setFont(new Font("Arial", Font.BOLD, 16));

            // Add the error message to the panel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 20, 10, 20);
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(errorLabel, gbc);
        }

        panel.revalidate();
        panel.repaint();

    }


}
