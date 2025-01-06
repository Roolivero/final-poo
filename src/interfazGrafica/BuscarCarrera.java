package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class BuscarCarrera extends JPanel {

    private JPanel panelPrincipal;
    private MainFrame mainFrame;

    public BuscarCarrera(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(251, 240, 242));

        mostrarPanel();

        add(panelPrincipal);

    }

    private void mostrarPanel(){
        panelPrincipal.removeAll();

        JLabel welcomeLabel = new JLabel("CARRERA", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(200, 0, 20, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        JButton buscarCarreraButton = new JButton("Materias");
        buscarCarreraButton.setPreferredSize(new Dimension(200, 50));
        getMainFrame().personalizarBoton(buscarCarreraButton,new Color(156, 64, 83), Color.WHITE,16);

        JButton agregarCarreraButton = new JButton("Alumnos");
        agregarCarreraButton.setPreferredSize(new Dimension(200, 50));
        getMainFrame().personalizarBoton(agregarCarreraButton,new Color(156, 64, 83), Color.WHITE,16);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        buttonPanel.add(buscarCarreraButton);
        buttonPanel.add(agregarCarreraButton);

        panelPrincipal.add(welcomeLabel, BorderLayout.NORTH);
        panelPrincipal.add(buttonPanel, BorderLayout.CENTER);

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
