package interfazGrafica;

import carrera.Carrera;
import sistemaUniversitario.SistemaUniversitario;
import universidad.Universidad;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

import static java.awt.Color.black;

public class BuscarUniversidad extends JPanel {
    private MainFrame mainFrame;
    private JPanel mainPanel;
    private boolean initialized = false;
    private SistemaUniversitario sistemaUniversitario;
    private JComboBox<String> dropBox;

    public BuscarUniversidad(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        // Add ComponentListener
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (initialized) {
                    remove(mainPanel); // Remove the old mainPanel
                    mainPanel = createMainPanel(); // Recreate the mainPanel with a new JComboBox
                    add(mainPanel, BorderLayout.CENTER); // Add the new mainPanel
                } else {
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

        mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
    }



    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(new Color(251, 230, 236, 255));
        panel.setBorder(new LineBorder(new Color(156, 64, 83), 2));
        JButton volverButton = new JButton("Volver");
        mainFrame.personalizarBoton(volverButton, new Color(156, 64, 83), Color.WHITE,12);
        volverButton.addActionListener(e -> {
            resetPanel();
            mainFrame.showCard("Main");
        });
        panel.add(volverButton);
        return panel;
    }

    private void resetPanel() {
        if (mainPanel != null) {
            for (Component comp : mainPanel.getComponents()) {
                if (comp instanceof JLabel && ((JLabel) comp).getForeground().equals(Color.RED)) {
                    mainPanel.remove(comp);
                }
            }
            // Reset the dropBox selection
            if (dropBox != null) {
                dropBox.removeAllItems(); // Clear all items
                String[] universidades = getUniversidades(sistemaUniversitario.getListaUniversidades());
                dropBox.setSelectedIndex(-1);
                for (String universidad : universidades) {
                    dropBox.addItem(universidad);
                }
            }
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(251, 240, 242));
        panel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(155, 63, 82)));

        // Add vertical glue at the top
        panel.add(Box.createVerticalGlue());

        JLabel labelPrincipal = new JLabel("Seleccione una universidad");
        labelPrincipal.setFont(new Font("Arial", Font.BOLD,20));
        labelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(labelPrincipal);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Inicializar sistema universitario
        sistemaUniversitario = SistemaUniversitario.getInstancia();

        JPanel dropPanel = new JPanel();
        dropPanel.setBackground(new Color(251, 240, 242));
        dropPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (sistemaUniversitario != null && sistemaUniversitario.getListaUniversidades() != null) {
            String[] universidades = getUniversidades(sistemaUniversitario.getListaUniversidades());

            JComboBox<String> dropBox = new JComboBox<>(universidades);
            dropBox.setSelectedIndex(-1);

            Font dropBoxFont = new Font("Arial", Font.PLAIN, 16);
            dropBox.setFont(dropBoxFont);

            Object popupComponent = dropBox.getUI().getAccessibleChild(dropBox, 0);
            if (popupComponent instanceof JPopupMenu) {
                JPopupMenu popup = (JPopupMenu) popupComponent;
                popup.setFont(dropBoxFont);
            }

            dropBox.addActionListener(e -> {
                String universidad = (String) dropBox.getSelectedItem();
                Universidad universidadSeleccionada = getNombreUniversidad(universidad);
                if (universidadSeleccionada != null) {
                    mainFrame.showVerUniversidad(universidadSeleccionada);
                }
            });

            dropPanel.add(dropBox);
        } else {
            dropPanel.add(new JLabel("No hay universidades disponibles"));
        }

        panel.add(dropPanel);

        // Add vertical glue at the bottom
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private String[] getUniversidades(List<Universidad> lista) {
        if (lista == null || lista.isEmpty()) {
            return new String[]{"No hay universidades"};
        }

        String[] nombreUniversidades = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            nombreUniversidades[i] = lista.get(i).getNombre();
        }
        return nombreUniversidades;
    }

    private Universidad getNombreUniversidad(String name) {
        if (sistemaUniversitario != null) {
            for (Universidad uni : sistemaUniversitario.getListaUniversidades()) {
                if (uni.getNombre().equals(name)) {
                    return uni;
                }
            }
        }
        return null;
    }

}