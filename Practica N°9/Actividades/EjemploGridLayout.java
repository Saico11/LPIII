import javax.swing.*;
import java.awt.*;

public class EjemploGridLayout extends JFrame {
    public EjemploGridLayout() {
        super("GridLayout - Integrantes: Nombre1, Nombre2, Nombre3");
        setLayout(new GridLayout(2, 3)); // Establece GridLayout con 2 filas y 3 columnas

        // Agregar botones para ver la organización en la cuadrícula
        for (int i = 1; i <= 6; i++) {
            add(new JButton("Botón " + i));
        }

        setSize(300, 150); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // Mostrar ventana
    }

    public static void main(String[] args) {
        new EjemploGridLayout();
    }
}
