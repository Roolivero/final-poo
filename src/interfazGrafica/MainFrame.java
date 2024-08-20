package interfazGrafica;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainFrame extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        setTitle("Sistema Universitario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Crear y agregar los paneles al cardPanel
        cardPanel.add(createMainPanel(), "Main");
        cardPanel.add(new VerUniversidad(this), "VerUniversidad");
        cardPanel.add(new AgregarUniversidad(this), "AgregarUniversidad");

        // Agregar el card panel al frame
        add(cardPanel);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(251, 245, 248));

        JLabel bienvenidaLabel = new JLabel("Bienvenidos al sistema universitario");
        bienvenidaLabel.setFont((new Font("Arial",Font.PLAIN,20)));
        bienvenidaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalStrut(40 ));

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(251, 245, 248));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton verUniversidadButton = new JButton("Ver universidad");
        personalizarBoton(verUniversidadButton, new Color(156, 64, 83), Color.WHITE,15);
        verUniversidadButton.addActionListener(e -> cardLayout.show(cardPanel, "VerUniversidad"));

        JButton agregarUniversidadButton = new JButton("Agregar universidad");
        personalizarBoton(agregarUniversidadButton, new Color(156, 64, 83), Color.WHITE,15);
        agregarUniversidadButton.addActionListener(e -> cardLayout.show(cardPanel, "AgregarUniversidad"));

        buttonPanel.add(verUniversidadButton);
        buttonPanel.add(Box.createHorizontalStrut(15));
        buttonPanel.add(agregarUniversidadButton);

        panel.add(bienvenidaLabel);
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    void personalizarBoton(JButton boton, Color colorFondo, Color colorTexto, int size) {
        boton.setFont(new Font("Open Sans", Font.BOLD, size));
        boton.setForeground(colorTexto);
        boton.setUI(new MainFrame.CustomButtonUI(colorFondo));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setUI(new MainFrame.CustomButtonUI(colorFondo.darker()));
                boton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setUI(new MainFrame.CustomButtonUI(colorFondo));
                boton.repaint();
            }
        });
    }


    private class CustomButtonUI extends BasicButtonUI {
        private Color color;

        public CustomButtonUI(Color color) {
            this.color = color;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            ButtonModel model = b.getModel();
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);

            if (model.isPressed()) {
                g2.setColor(color.darker());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);
            }

            g2.dispose();
            super.paint(g, c);
        }
    }

    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}