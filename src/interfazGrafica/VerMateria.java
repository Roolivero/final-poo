package interfazGrafica;

import alumno.Alumno;
import carrera.Carrera;
import materia.Materia;
import universidad.Universidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class VerMateria extends JPanel {

    public VerMateria(MainFrame mainFrame) {

        Universidad universidad = Universidad.getInstancia("Universidad Nacional Tierra del Fuego");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver, new Color(166, 144, 246), new Color(10, 2, 43), 14);
        botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("materia");
            }
        });

        panelBotonVolver.add(botonVolver);
        add(panelBotonVolver);

        JLabel labelTitulo = new JLabel("Seleccione una materia ");
        Font fuenteTitulo = new Font("Arial", Font.BOLD, 18);
        labelTitulo.setFont(fuenteTitulo);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<Materia> listaMaterias = Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaMaterias();
        JComboBox comboMaterias = new JComboBox<>();
        for (Materia m : listaMaterias) {
            comboMaterias.addItem(m.getNombre());
        }
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    setBackground(new Color(187, 169, 250));
                    setForeground(Color.WHITE);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Color.BLACK);
                }
                return this;
            }
        };
        comboMaterias.setRenderer(renderer);
        comboMaterias.setBackground(Color.WHITE);
        comboMaterias.setSelectedIndex(-1);
        Font fuenteCombo = new Font("Arial", Font.PLAIN, 16);
        comboMaterias.setFont(fuenteCombo);
        comboMaterias.setPreferredSize(new Dimension(400, 30));
        comboMaterias.setMaximumSize(new Dimension(400, 30));
        comboMaterias.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelInfoMaterias = new JPanel();
        panelInfoMaterias.setLayout(new BoxLayout(panelInfoMaterias, BoxLayout.Y_AXIS));
        panelInfoMaterias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Dimension maxSize = new Dimension(650, panelInfoMaterias.getMaximumSize().height);
        panelInfoMaterias.setMaximumSize(maxSize);

        JLabel labelNombre = new JLabel("Nombre de la materia: ");
        labelNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelTipo = new JLabel("Tipo de materia: ");
        labelTipo.setFont(new Font("Arial", Font.PLAIN, 16));
        labelTipo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelCuatrimestre = new JLabel("Cuatrimestre: ");
        labelCuatrimestre.setFont(new Font("Arial", Font.PLAIN, 16));
        labelCuatrimestre.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panelCarreras = new JPanel(new BorderLayout());
        DefaultListModel modeloCarreras = new DefaultListModel<>();
        JList listaCarreras = new JList<>(modeloCarreras);
        listaCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
        panelCarreras.add(new JScrollPane(listaCarreras), BorderLayout.CENTER);

        tabbedPane.addTab("Carrera/s a la que pertenece", panelCarreras);

        panelInfoMaterias.add(labelNombre);
        panelInfoMaterias.add(Box.createVerticalStrut(5));
        panelInfoMaterias.add(labelTipo);
        panelInfoMaterias.add(Box.createVerticalStrut(5));
        panelInfoMaterias.add(labelCuatrimestre);
        panelInfoMaterias.add(Box.createVerticalStrut(5));
        panelInfoMaterias.add(tabbedPane);
        panelInfoMaterias.add(Box.createVerticalStrut(5));

        add(Box.createVerticalStrut(10));
        add(labelTitulo);
        add(Box.createVerticalStrut(10));
        add(comboMaterias);
        add(Box.createVerticalStrut(20));
        add(panelInfoMaterias);
        add(Box.createVerticalGlue());

        panelInfoMaterias.setVisible(false);

        comboMaterias.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            if (materiaSeleccionada != null) {
                Materia materia = listaMaterias.stream()
                        .filter(c -> c.getNombre().equals(materiaSeleccionada))
                        .findFirst()
                        .orElse(null);
                if (materia != null) {
                    panelInfoMaterias.setVisible(true);

                    labelNombre.setText("Materia: " + materia.getNombre());
                    if(materia.getEsObligatoria()){
                        labelTipo.setText("Tipo de materia: obligatoria ");
                    } else {
                        labelTipo.setText("Tipo de materia: optativa ");
                    }
                    labelCuatrimestre.setText("Cuatrimestre en la que se dicta: " + materia.getCuatrimestre() + "°" );

                    modeloCarreras.clear();
                    for(Carrera carrera : universidad.getListaCarreras()){
                        if (carrera.getMaterias().contains(materia)){
                           modeloCarreras.addElement("*" + carrera.getNombre() + "\n");
                        }
                    }

                }
            }
        });
    }
}
