package interfazGrafica;

import cargaDeDatos.Datos;
import carrera.Carrera;
import materia.Materia;
import sistemaUniversitario.SistemaUniversitario;
import universidad.Universidad;


import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainFrame extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private VerUniversidad verUniversidad;
    private VerCarrera verCarrera;

    public MainFrame() {
        setTitle("Sistema Universitario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        //Para visualizar los datos ya cargados en el sistema
        Datos datos = new Datos();
        datos.cargarDatos();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Fijar el tamaño del cardPanel
        Dimension fixedSize = new Dimension(500, 400);
        cardPanel.setPreferredSize(fixedSize);
        cardPanel.setMinimumSize(fixedSize);
        cardPanel.setMaximumSize(fixedSize);

        // Crear y agregar los paneles al cardPanel
        cardPanel.add(createMainPanel(), "Main");
        cardPanel.add(new BuscarUniversidad(this), "BuscarUniversidad");
        cardPanel.add(new AgregarUniversidad(this), "AgregarUniversidad");

        verUniversidad = new VerUniversidad(this);
        cardPanel.add(verUniversidad, "VerUniversidad");

        verCarrera = new VerCarrera(this);
        cardPanel.add(verCarrera, "VerCarrera");

        // Agregar el card panel al frame
        add(cardPanel);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(251, 240, 242));

        JLabel bienvenidaLabel = new JLabel("Bienvenido al sistema universitario");
        bienvenidaLabel.setFont((new Font("Arial",Font.BOLD,22)));
        bienvenidaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalStrut(40 ));

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(251, 240, 242));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buscarUniversidadButton = new JButton("Buscar universidad");
        personalizarBoton(buscarUniversidadButton, new Color(156, 64, 83), Color.WHITE,16);
        buscarUniversidadButton.addActionListener(e -> cardLayout.show(cardPanel, "BuscarUniversidad"));

        JButton agregarUniversidadButton = new JButton("Agregar universidad");
        personalizarBoton(agregarUniversidadButton, new Color(156, 64, 83), Color.WHITE,16);
        agregarUniversidadButton.addActionListener(e -> cardLayout.show(cardPanel, "AgregarUniversidad"));

        buttonPanel.add(buscarUniversidadButton);
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

    public void showVerUniversidad(Universidad universidad) {
        verUniversidad.setUniversidad(universidad);
        System.out.println("universidad: " + universidad.getNombre());
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, "VerUniversidad");
    }

    public void showVerCarrera(Carrera carrera) {
        verCarrera.setCarrera(carrera);
        System.out.println("Carrera: " + carrera.getNombre());
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, "VerCarrera");
    }

    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}