import javax.swing.*;
import java.awt.*;

public class EjemploBorderLayout extends JFrame {
    public EjemploBorderLayout() {
        super("BorderLayout - Integrantes: Nombre1, Nombre2, Nombre3");
        setLayout(new BorderLayout()); 

        add(new JButton("NORTE"), BorderLayout.NORTH);
        add(new JButton("SUR"), BorderLayout.SOUTH);
        add(new JButton("ESTE"), BorderLayout.EAST);
        add(new JButton("OESTE"), BorderLayout.WEST);
        add(new JButton("CENTRO"), BorderLayout.CENTER);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploBorderLayout();
    }
}
