package interfazGrafica;
import javax.swing.*;
import java.awt.*;

public class VerUniversidad extends JPanel {

    public VerUniversidad(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("aaaaa", SwingConstants.CENTER);
        label.setFont(new Font("Open Sans", Font.BOLD, 24));

        JButton backButton = new JButton("Volver");
        mainFrame.personalizarBoton(backButton, new Color(156, 64, 83), Color.WHITE);
        backButton.addActionListener(e -> mainFrame.showHomePanel());

        add(label, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}

