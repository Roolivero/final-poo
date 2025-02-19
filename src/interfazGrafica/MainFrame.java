package interfazGrafica;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Stream;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel panelBotones;
    private JPanel panelCentro;

    public MainFrame() {

        setTitle("Sisitema Universitario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Universidad Nacional Tierra del Fuego", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.setBackground(new Color(114, 83, 151, 197));
        mainPanel.add(labelTitulo, BorderLayout.NORTH);

        panelBotones = new JPanel();

        panelBotones.setLayout(new GridLayout(0, 1, 5, 2));
        JButton botonCarreras = new JButton("Carreras");
        personalizarBoton(botonCarreras,new Color(67, 24, 90), Color.WHITE,18);
        JButton botonMaterias = new JButton("Materias");
        personalizarBoton(botonMaterias,new Color(67, 24, 90), Color.WHITE,18);
        JButton botonAlumnos= new JButton("Alumnos");
        personalizarBoton(botonAlumnos,new Color(67, 24, 90), Color.WHITE,18);

        panelBotones.add(botonCarreras);
        panelBotones.add(botonMaterias);
        panelBotones.add(botonAlumnos);
        mainPanel.add(panelBotones, BorderLayout.WEST);

        panelCentro = new JPanel();
        panelCentro.setBackground(new Color(219, 202, 243));
        mainPanel.add(panelCentro, BorderLayout.CENTER);


        botonCarreras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("carrera");
            }
        });

        botonMaterias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("materia");
            }
        });

        botonAlumnos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("alumno");
            }
        });

        // Configurar el content pane del JFrame
        setContentPane(mainPanel);
        setVisible(true);
    }

    public void actualizarPanelCentro() {
        panelCentro.removeAll();
        panelCentro.revalidate();
        panelCentro.repaint();
    }

    public void mostrarPanel(String nombre) {
        panelCentro.removeAll();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.add(Box.createVerticalGlue());

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 180));
        panelBotones.setOpaque(false);

        String botonVer = "Ver " + nombre;
        String botonAgregar = "Agregar " + nombre;

        JButton verCarrera = new JButton(botonVer);
        personalizarBoton(verCarrera, new Color(166, 144, 246),new Color(10, 2, 43), 18);
        verCarrera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelCentro.removeAll();
                panelCentro.setLayout(new BorderLayout());
                if("carrera".equalsIgnoreCase(nombre)){
                    panelCentro.add(new VerCarrera(MainFrame.this), BorderLayout.CENTER);
                } else if ("materia".equalsIgnoreCase(nombre)){
                    panelCentro.add(new VerMateria(MainFrame.this),BorderLayout.CENTER);
                } else if ("alumno".equalsIgnoreCase(nombre)){
                    panelCentro.add(new VerAlumno(MainFrame.this),BorderLayout.CENTER);
                }
                panelCentro.revalidate();
                panelCentro.repaint();
            }
        });
        panelBotones.add(verCarrera);

        JButton agregarCarreras = new JButton(botonAgregar);
        personalizarBoton(agregarCarreras, new Color(166, 144, 246), new Color(10, 2, 43), 18);
        agregarCarreras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelCentro.removeAll();
                panelCentro.setLayout(new BorderLayout());
                if("carrera".equalsIgnoreCase(nombre)){
                    panelCentro.add(new CrearCarrera(MainFrame.this), BorderLayout.CENTER);
                } else if ("materia".equalsIgnoreCase(nombre)){
                    panelCentro.add(new CrearMateria(MainFrame.this),BorderLayout.CENTER);
                } else if ("alumno".equalsIgnoreCase(nombre)){
                    panelCentro.add(new CrearAlumno(),BorderLayout.CENTER);
                }
                panelCentro.revalidate();
                panelCentro.repaint();
            }
        });
        panelBotones.add(agregarCarreras);

        panelCentro.add(panelBotones);
        panelCentro.add(Box.createVerticalGlue());
        panelCentro.revalidate();
        panelCentro.repaint();
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
