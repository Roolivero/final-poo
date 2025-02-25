package interfazGrafica;

import alumno.Alumno;
import carrera.Carrera;
import grafoMaterias.Nodo;
import materia.Materia;
import universidad.Universidad;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class VerMateria extends JPanel {

    private MainFrame mainFrame;
    private JPanel panelInfoMateria;
    private JLabel labelNombreMateria;
    private JLabel labelCuatrimestre;
    private JLabel labelEsObligatoria;
    private JTabbedPane tabbedPane;
    private DefaultListModel<String> modeloMaterias;
    private JList<String> listaMaterias;
    private DefaultListModel<String> modeloCarreras;
    private JList<String> listaCarreras;
    private List<Materia> listaTodasMaterias;
    private JTextArea textAreaCorrelativas;


    public VerMateria(MainFrame mainFrame) {
        this.mainFrame =mainFrame;

        Universidad universidad = Universidad.getInstancia("Universidad Nacional Tierra del Fuego");
        listaTodasMaterias = universidad.getListaMaterias();

        setBackground(new Color(229, 224, 243));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Panel boton Volver
        JPanel panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonVolver.setBackground(new Color(229, 224, 243));
        JButton botonVolver = new JButton("Volver");
        mainFrame.personalizarBoton(botonVolver, new Color(166, 144, 246), new Color(10, 2, 43), 14);
        botonVolver.setAlignmentX(Component.RIGHT_ALIGNMENT);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarPanel("materia");
            }
        });

        panelBotonVolver.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonVolver.getPreferredSize().height));
        panelBotonVolver.add(botonVolver);
        add(panelBotonVolver);

        //Panel con info materia
        panelInfoMateria = new JPanel();
        panelInfoMateria.setLayout(new BoxLayout(panelInfoMateria, BoxLayout.Y_AXIS));
        panelInfoMateria.setBackground(new Color(229, 224, 243));
        panelInfoMateria.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        labelNombreMateria = new JLabel("Materia: ");
        labelNombreMateria.setFont(new Font("Arial", Font.PLAIN, 16));

        labelCuatrimestre = new JLabel("Cuatrimestre: ");
        labelCuatrimestre.setFont(new Font("Arial", Font.PLAIN, 16));

        labelEsObligatoria = new JLabel("Es obligatoria: ");
        labelEsObligatoria.setFont(new Font("Arial", Font.PLAIN, 16));

        panelInfoMateria.add(labelNombreMateria);
        panelInfoMateria.add(Box.createVerticalStrut(5));
        panelInfoMateria.add(labelCuatrimestre);
        panelInfoMateria.add(Box.createVerticalStrut(5));
        panelInfoMateria.add(labelEsObligatoria);
        panelInfoMateria.add(Box.createVerticalStrut(30));

        add(panelInfoMateria);

        JPanel contenedorTabbedPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contenedorTabbedPane.setBackground(new Color(229, 224, 243));
        contenedorTabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(550, 300));

        contenedorTabbedPane.add(tabbedPane);


        // Pestaña 1: Lista de materias con búsqueda
        JPanel panelMaterias = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(250, 30));
        panelMaterias.add(searchField, BorderLayout.NORTH);

        modeloMaterias = new DefaultListModel<>();
        listaMaterias = new JList<>(modeloMaterias);
        listaMaterias.setFont(new Font("Arial", Font.PLAIN, 14));
        panelMaterias.add(new JScrollPane(listaMaterias), BorderLayout.CENTER);

        JButton btnVerMateria = new JButton("Ver materia");
        btnVerMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String materiaSeleccionada = listaMaterias.getSelectedValue();
                if (materiaSeleccionada != null) {
                    mostrarInformacionMateria(materiaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(panelMaterias,
                            "Por favor, seleccione una materia de la lista.",
                            "Aviso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                searchField.setText("");
                actualizarListaMaterias("");
            }
        });
        panelMaterias.add(btnVerMateria,BorderLayout.SOUTH);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarListaMaterias(searchField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarListaMaterias(searchField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarListaMaterias(searchField.getText());
            }
        });

        actualizarListaMaterias("");
        tabbedPane.addTab("Todas las materias", panelMaterias);

        // Pestaña 2: Carreras de la materia seleccionada
        JPanel panelCarreras = new JPanel(new BorderLayout());
        modeloCarreras = new DefaultListModel<>();
        listaCarreras = new JList<>(modeloCarreras);
        listaCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
        panelCarreras.add(new JScrollPane(listaCarreras), BorderLayout.CENTER);
        tabbedPane.addTab("Carrera/s a la que pertenece", panelCarreras);


        // Pestaña 3: Correlativas de una materia
        JPanel panelCorrelativas = new JPanel(new BorderLayout());
        textAreaCorrelativas = new JTextArea();
        textAreaCorrelativas.setEditable(false);
        textAreaCorrelativas.setFont(new Font("Arial", Font.PLAIN, 14));
        panelCorrelativas.add(new JScrollPane(textAreaCorrelativas), BorderLayout.CENTER);
        tabbedPane.addTab("Correlativas de una materia", panelCorrelativas);


        add(contenedorTabbedPane);
    }

    private void actualizarListaMaterias(String filtro) {
        modeloMaterias.clear();
        for (Materia materia : listaTodasMaterias) {
            if (materia.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                modeloMaterias.addElement(materia.getNombre());
            }
        }
    }

    private void mostrarInformacionMateria(String nombreMateria) {
        Materia materia = listaTodasMaterias.stream()
                .filter(m -> m.getNombre().equals(nombreMateria))
                .findFirst()
                .orElse(null);

        if (materia != null) {
            labelNombreMateria.setText("Materia: " + materia.getNombre());
            labelCuatrimestre.setText("Cuatrimestre: " + materia.getCuatrimestre());
            if(materia.getEsObligatoria()){
                labelEsObligatoria.setText("Tipo de materia: obligatoria ");
            } else {
                labelEsObligatoria.setText("Tipo de materia: optativa ");
            }

            modeloCarreras.clear();
            for (Carrera carrera : Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras()) {
                if (carrera.getMaterias().contains(materia)) {
                    modeloCarreras.addElement(carrera.getNombre());
                }
            }
        }
        actualizarCorrelativas(materia);
    }

    private void actualizarCorrelativas(Materia materia) {
        textAreaCorrelativas.setText("");
        for (Carrera carrera : Universidad.getInstancia("Universidad Nacional Tierra del Fuego").getListaCarreras()) {
            if (carrera.getMaterias().contains(materia)) {
                if (carrera.getPlanEstudio() != null && carrera.getPlanEstudio().getGrafo() != null) {
                    List<Nodo> correlativas = carrera.getPlanEstudio().getGrafo().correlativasDirectas(materia);
                    textAreaCorrelativas.append(carrera.getNombre() + ":\n");
                    if (correlativas.isEmpty()) {
                        textAreaCorrelativas.append(" - No tiene correlativas directas.\n");
                    } else {
                        for (Nodo nodo : correlativas) {
                            textAreaCorrelativas.append(" - " + nodo.getmateria().getNombre() + "\n");
                        }
                    }
                    textAreaCorrelativas.append("\n");
                }
            }
        }
    }
}
