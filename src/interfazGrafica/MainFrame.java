package interfazGrafica;

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Sistema Universitario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        AgregarUniversidad agregarUniversidadPanel = new AgregarUniversidad(this);
        VerUniversidad verUniversidadPanel = new VerUniversidad(this);


        // Panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(251, 245, 248));

        //Agregar el panel al inicio del cardLayout
        mainPanel.add(panel,"home");

        // Agregar los paneles al CardLayout
        mainPanel.add(agregarUniversidadPanel, "AgregarUniversidad");
        mainPanel.add(verUniversidadPanel, "VerUniversidad");

        // JLabel
        JLabel label = new JLabel("Bienvenido al sistema universitario ");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Open Sans", Font.BOLD, 20);
        label.setFont(customFont);

        //JButtons
        JButton agregarUniversidad = new JButton("Agregar Universidad");
        JButton verUniversidad = new JButton("Ver Universidad");

        personalizarBoton(agregarUniversidad, new Color(156, 64, 83), Color.WHITE);
        personalizarBoton(verUniversidad, new Color(156, 64, 83), Color.WHITE);

        agregarUniversidad.addActionListener(e -> cardLayout.show(mainPanel, "AgregarUniversidad"));
        verUniversidad.addActionListener(e -> cardLayout.show(mainPanel, "VerUniversidad"));

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(agregarUniversidad);
        buttonPanel.add(verUniversidad);

        // Agregar componentes al panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        panel.add(label, gbc);

        // Agregar espacio entre el label y los botones
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(buttonPanel,gbc);

        add(mainPanel);

        setVisible(true);
    }

    void personalizarBoton(JButton boton, Color colorFondo, Color colorTexto) {
        boton.setFont(new Font("Open Sans", Font.BOLD, 18));
        boton.setForeground(colorTexto);
        boton.setUI(new CustomButtonUI(colorFondo));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setUI(new CustomButtonUI(colorFondo.darker()));
                boton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setUI(new CustomButtonUI(colorFondo));
                boton.repaint();
            }
        });
    }

    public void showHomePanel() {
        cardLayout.show(mainPanel,"home");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}