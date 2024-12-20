import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReproductorSonidoApp {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Reproductor de Efectos de Sonido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(1, 3));

        // Crear instancias de los sonidos
        Sonido aplausos = new Sonido("sonidos/aplausos.wav");
        Sonido campana = new Sonido("sonidos/campana.wav");
        Sonido explosion = new Sonido("sonidos/explosion.wav");

        // Crear botones
        JButton botonAplausos = new JButton("Aplausos");
        JButton botonCampana = new JButton("Campana");
        JButton botonExplosion = new JButton("Explosión");

        // Añadir acción a los botones
        botonAplausos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplausos.reproducir();
            }
        });

        botonCampana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campana.reproducir();
            }
        });

        botonExplosion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                explosion.reproducir();
            }
        });

        // Añadir botones al frame
        frame.add(botonAplausos);
        frame.add(botonCampana);
        frame.add(botonExplosion);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
