import javax.swing.*;
import java.awt.*;

public class EjemploFlowLayout extends JFrame {
    public EjemploFlowLayout() {
        super("FlowLayout - Integrantes: Nombre1, Nombre2, Nombre3");
        setLayout(new FlowLayout()); // Establece FlowLayout

        // Agregar botones para observar la organización
        for (int i = 1; i <= 5; i++) {
            add(new JButton("Botón " + i));
        }

        setSize(300, 150); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // Mostrar ventana
    }

    public static void main(String[] args) {
        new EjemploFlowLayout();
    }
}
