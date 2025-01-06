package interfazGrafica;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    private JPanel panelPrincipal;

    public MainFrame() {

        setTitle("Universidad Nacional Tierra del Fuego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(251, 240, 242));

        panelBienvenida();

        add(panelPrincipal);

    }

    private void panelBienvenida(){
        panelPrincipal.removeAll();

        JLabel welcomeLabel = new JLabel("Bienvenido a la Universidad Nacional Tierra del Fuego", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(200, 0, 20, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        JButton buscarCarreraButton = new JButton("Buscar carrera");
        buscarCarreraButton.setPreferredSize(new Dimension(200, 50));
        personalizarBoton(buscarCarreraButton,new Color(156, 64, 83), Color.WHITE,16);

        JButton agregarCarreraButton = new JButton("Agregar carrera");
        agregarCarreraButton.setPreferredSize(new Dimension(200, 50));
        personalizarBoton(agregarCarreraButton,new Color(156, 64, 83), Color.WHITE,16);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        buttonPanel.add(buscarCarreraButton);
        buttonPanel.add(agregarCarreraButton);
        buttonPanel.setBackground(new Color(251, 240, 242));

        panelPrincipal.add(welcomeLabel, BorderLayout.NORTH);
        panelPrincipal.add(buttonPanel, BorderLayout.CENTER);

        buscarCarreraButton.addActionListener(e -> mostrarPanelBuscarCarrera());
        agregarCarreraButton.addActionListener(e -> System.out.println("Agregar carrera presionado"));

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private void mostrarPanelBuscarCarrera(){
        panelPrincipal.removeAll();

        BuscarCarrera buscarCarrera = new BuscarCarrera(this);
        panelPrincipal.add(buscarCarrera, BorderLayout.CENTER);

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public void personalizarBoton(JButton boton, Color colorFondo, Color colorTexto, int size) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
