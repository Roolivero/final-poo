package interfazGrafica;

import carrera.Carrera;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class VerCarrera extends JPanel {
    private MainFrame mainFrame;
    private Carrera carrera;
    private CardLayout cardLayout;
    private JPanel panelCentral;

    public VerCarrera(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        add(panelPrincipal(), BorderLayout.CENTER);

        // Agregar la vista de VerMateria al cardPanel
        VerMateria verMateriaPanel = new VerMateria(carrera, mainFrame);
        panelCentral.add(verMateriaPanel, "Materias");

    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
        actualizarDisplay();
    }

    private void actualizarDisplay(){
        panelCentral.removeAll();

        if (carrera != null) {
            VerMateria verMateriaPanel = new VerMateria(carrera, mainFrame);
            panelCentral.add(verMateriaPanel, "Materias");
            System.out.println("Carrera seleccionada: " + carrera.getNombre());
        } else {
            System.out.println("No se ha seleccionado ninguna carrera.");
        }

        panelCentral.revalidate();
        panelCentral.repaint();
    }

    private JPanel panelPrincipal(){
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(topPanel(), BorderLayout.NORTH);
        panel.add(panelIzquierdo(), BorderLayout.WEST);
        panel.add(panelCentral(), BorderLayout.CENTER);

        return panel;
    }

    private JPanel topPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(new Color(251, 230, 236, 255));
        panel.setBorder(new LineBorder(new Color(156, 64, 83), 2));

        JButton volverButton = new JButton("Volver");
        mainFrame.personalizarBoton(volverButton, new Color(156, 64, 83), Color.WHITE,12);
        volverButton.addActionListener(e -> mainFrame.showCard("VerUniversidad"));

        panel.add(volverButton);

        return panel;
    }

    private JPanel panelIzquierdo(){
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

            button.addActionListener(e ->  cardLayout.show(panelCentral, label));

            panel.add(button);
            panel.add(Box.createVerticalStrut(15));
        }

        return panel;

    }

    private JPanel panelCentral(){
        panelCentral = new JPanel();
        cardLayout = new CardLayout();
        panelCentral.setLayout(cardLayout);

        JPanel panelMaterias = new JPanel();
        panelMaterias.setBackground(new Color(251, 240, 242));
        panelMaterias.add(new JLabel("Panel de Materias"));

        JPanel panelAlumnos = new JPanel();
        panelMaterias.setBackground(new Color(251, 240, 242));
        panelAlumnos.add(new JLabel("Panel de Alumnos"));

        JPanel panelLibreta = new JPanel();
        panelLibreta.setBackground(new Color(251, 240, 242));
        panelLibreta.add(new JLabel("Panel de Libreta Universitaria"));

        // Agregar los paneles al panelCentral usando el CardLayout
        panelCentral.add(panelMaterias, "Materias");
        panelCentral.add(panelAlumnos, "Alumnos");
        panelCentral.add(panelLibreta, "Libreta");

        return panelCentral;
    }

}
