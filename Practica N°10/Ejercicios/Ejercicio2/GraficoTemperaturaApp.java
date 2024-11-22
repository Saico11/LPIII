import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficoTemperaturaApp {
    public static void main(String[] args) {
        // Crear el modelo de datos
        TemperaturaSemana temperaturaSemana = new TemperaturaSemana();

        // Crear la ventana principal
        JFrame frame = new JFrame("Gráfico de Temperaturas Semanales");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Panel para ingresar temperaturas
        JPanel inputPanel = new JPanel(new GridLayout(2, 7, 10, 10));
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        JTextField[] temperaturaFields = new JTextField[7];

        for (String dia : dias) {
            inputPanel.add(new JLabel(dia, SwingConstants.CENTER));
        }

        for (int i = 0; i < 7; i++) {
            temperaturaFields[i] = new JTextField("0");
            inputPanel.add(temperaturaFields[i]);
        }

        // Panel para el gráfico
        JPanel graficoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Configurar gráfico
                g.setColor(Color.BLUE);
                int ancho = getWidth();
                int alto = getHeight();
                int margen = 40;

                // Dibujar ejes
                g.drawLine(margen, alto - margen, ancho - margen, alto - margen); // Eje X
                g.drawLine(margen, alto - margen, margen, margen);               // Eje Y

                // Etiquetas en el eje X
                int separacionX = (ancho - 2 * margen) / 6;
                for (int i = 0; i < dias.length; i++) {
                    int x = margen + i * separacionX;
                    g.drawString(dias[i], x - 10, alto - 20);
                }

                // Obtener datos
                int[] temperaturas = temperaturaSemana.getTemperaturas();
                int maxTemperatura = 50; // Rango máximo para escalar

                // Dibujar línea de temperaturas
                int separacionY = alto - 2 * margen;
                int[] puntosX = new int[7];
                int[] puntosY = new int[7];

                for (int i = 0; i < temperaturas.length; i++) {
                    puntosX[i] = margen + i * separacionX;
                    puntosY[i] = alto - margen - (temperaturas[i] * separacionY / maxTemperatura);
                }

                for (int i = 0; i < puntosX.length - 1; i++) {
                    g.drawLine(puntosX[i], puntosY[i], puntosX[i + 1], puntosY[i + 1]);
                }

                // Dibujar puntos
                for (int i = 0; i < puntosX.length; i++) {
                    g.fillOval(puntosX[i] - 3, puntosY[i] - 3, 6, 6);
                }
            }
        };

        // Botón para mostrar el gráfico
        JButton mostrarGraficoButton = new JButton("Mostrar Gráfico");
        mostrarGraficoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 7; i++) {
                        int temperatura = Integer.parseInt(temperaturaFields[i].getText());
                        temperaturaSemana.setTemperatura(i, temperatura);
                    }
                    graficoPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Verifica que las temperaturas sean números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Añadir componentes al frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(graficoPanel, BorderLayout.CENTER);
        frame.add(mostrarGraficoButton, BorderLayout.SOUTH);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
