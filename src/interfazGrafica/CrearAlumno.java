package interfazGrafica;
import alumno.Alumno;
import libretaUniversitaria.Libreta;
import universidad.Universidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class CrearAlumno extends JPanel {
    private MainFrame mainFrame;
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoDni;
    private JTextField fechaNacimiento;
    private JButton botonCrear;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CrearAlumno(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setBackground(new Color(229, 224, 243));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver, new Color(166, 144, 246), new Color(10, 2, 43), 14);
        botonVolver.addActionListener(e -> mainFrame.mostrarPanel("alumno"));
        panelBotonVolver.add(botonVolver);
        panelBotonVolver.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonVolver.getPreferredSize().height));
        panelBotonVolver.setBackground(new Color(229, 224, 243));

        add(panelBotonVolver);


        JPanel panelFormulario = new JPanel();
        panelFormulario.setBackground(new Color(229, 224, 243));
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelFormulario.setAlignmentY(Component.TOP_ALIGNMENT);

        Dimension dim = new Dimension(200, 30);

        JPanel panelNombre = new JPanel();
        panelNombre.setBackground(new Color(229, 224, 243));
        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        campoNombre = new JTextField(20);
        campoNombre.setPreferredSize(dim);
        campoNombre.setMaximumSize(dim);

        panelNombre.add(labelNombre);
        panelNombre.add(Box.createHorizontalStrut(5));
        panelNombre.add(campoNombre);
        panelNombre.setMaximumSize(panelNombre.getPreferredSize());
        panelFormulario.add(panelNombre);
        panelFormulario.add(Box.createVerticalStrut(10));

        JPanel panelApellido = new JPanel();
        panelApellido.setBackground(new Color(229, 224, 243));
        panelApellido.setLayout(new BoxLayout(panelApellido, BoxLayout.X_AXIS));
        JLabel labelApellido = new JLabel("Apellido:");
        labelApellido.setFont(new Font("Arial", Font.PLAIN, 16));
        campoApellido = new JTextField(20);
        campoApellido.setPreferredSize(dim);
        campoApellido.setMaximumSize(dim);

        panelApellido.add(labelApellido);
        panelApellido.add(Box.createHorizontalStrut(5));
        panelApellido.add(campoApellido);
        panelApellido.setMaximumSize(panelApellido.getPreferredSize());
        panelFormulario.add(panelApellido);
        panelFormulario.add(Box.createVerticalStrut(10));

        JPanel panelDNI = new JPanel();
        panelDNI.setBackground(new Color(229, 224, 243));
        panelDNI.setLayout(new BoxLayout(panelDNI, BoxLayout.X_AXIS));
        JLabel labelDni = new JLabel("DNI:");
        labelDni.setFont(new Font("Arial", Font.PLAIN, 16));
        campoDni = new JTextField(20);
        campoDni.setPreferredSize(dim);
        campoDni.setMaximumSize(dim);

        panelDNI.add(labelDni);
        panelDNI.add(Box.createHorizontalStrut(5));
        panelDNI.add(campoDni);
        panelDNI.setMaximumSize(panelDNI.getPreferredSize());
        panelFormulario.add(panelDNI);
        panelFormulario.add(Box.createVerticalStrut(10));


        JPanel panelFechaNacimiento = new JPanel();
        panelFechaNacimiento.setBackground(new Color(229, 224, 243));
        panelFechaNacimiento.setLayout(new BoxLayout(panelFechaNacimiento, BoxLayout.X_AXIS));
        JLabel labelFecha = new JLabel("Fecha de nacimiento:");
        labelFecha.setFont(new Font("Arial", Font.PLAIN, 16));
        fechaNacimiento = new JTextField(20);
        fechaNacimiento.setBackground(Color.white);
        fechaNacimiento.setPreferredSize(dim);
        fechaNacimiento.setMaximumSize(dim);
        fechaNacimiento.setEditable(false);

        JButton botonCalendario = new JButton("📅");

        botonCalendario.addActionListener(e -> mostrarSelectorFecha());

        panelFechaNacimiento.add(labelFecha);
        panelFechaNacimiento.add(Box.createHorizontalStrut(5));
        panelFechaNacimiento.add(fechaNacimiento);
        panelFechaNacimiento.setMaximumSize(panelFechaNacimiento.getPreferredSize());
        panelFormulario.add(panelDNI);
        panelFormulario.add(Box.createVerticalStrut(10));
        panelFechaNacimiento.add(botonCalendario);

        panelFormulario.add(panelFechaNacimiento);
        panelFormulario.add(Box.createVerticalStrut(10));

        botonCrear = new JButton("Inscribir Alumno");
        mainFrame.personalizarBoton(botonCrear, new Color(129, 91, 165),new Color(255, 255, 255), 16);
        botonCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearAlumno();
            }
        });
        panelFormulario.add(botonCrear);

        add(panelFormulario);
    }


    private void mostrarSelectorFecha() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Seleccionar Fecha", true);
        dialog.setLayout(new FlowLayout());

        JComboBox<Integer> comboDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) comboDia.addItem(i);

        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        JComboBox<String> comboMes = new JComboBox<>(meses);

        JComboBox<Integer> comboAnio = new JComboBox<>();
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = anioActual; i >= 1900; i--) comboAnio.addItem(i);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            int dia = (int) comboDia.getSelectedItem();
            int mes = comboMes.getSelectedIndex() + 1;
            int anio = (int) comboAnio.getSelectedItem();
            String fechaFormateada = String.format("%02d/%02d/%d", dia, mes, anio);
            fechaNacimiento.setText(fechaFormateada);

            dialog.dispose();
        });

        dialog.add(new JLabel("Día:"));
        dialog.add(comboDia);
        dialog.add(new JLabel("Mes:"));
        dialog.add(comboMes);
        dialog.add(new JLabel("Año:"));
        dialog.add(comboAnio);
        dialog.add(btnAceptar);

        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void crearAlumno() {
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();
        String dni = campoDni.getText();
        String fechaTexto = fechaNacimiento.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate fechaNacimientoLocalDate;
        try {
            fechaNacimientoLocalDate = LocalDate.parse(fechaTexto, FORMATTER);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. Usa el formato dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Alumno nuevoAlumno = new Alumno(nombre, apellido, dni, fechaNacimientoLocalDate,new Libreta());

        Universidad universidad = Universidad.getInstancia("Universidad Nacional Tierra del Fuego");
        universidad.agregarAlumno(nuevoAlumno);

        JOptionPane.showMessageDialog(this,
                "¡Alumno inscripto!\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellido: " + apellido + " \n" +
                        "DNI: " + dni + " \n" +
                        "Fecha de nacimiento: " + fechaTexto,
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);

        campoNombre.setText("");
        campoApellido.setText("");
        campoDni.setText("");
        fechaNacimiento.setText("");
    }
}
