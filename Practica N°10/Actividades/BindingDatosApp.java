import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BindingDatosApp {
    public static void main(String[] args) {
        // Crear el modelo de datos
        Producto producto = new Producto("Laptop", 1500.0, 10, "Electrónica");

        // Crear la ventana principal
        JFrame frame = new JFrame("Binding de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Componentes de entrada
        JTextField nombreField = new JTextField(producto.getNombre());
        JTextField precioField = new JTextField(String.valueOf(producto.getPrecio()));
        JTextField stockField = new JTextField(String.valueOf(producto.getCantidadStock()));
        JTextField categoriaField = new JTextField(producto.getCategoria());

        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nombreField);
        inputPanel.add(new JLabel("Precio:"));
        inputPanel.add(precioField);
        inputPanel.add(new JLabel("Cantidad en Stock:"));
        inputPanel.add(stockField);
        inputPanel.add(new JLabel("Categoría:"));
        inputPanel.add(categoriaField);

        // Crear boton para actualizar el producto
        JButton actualizarButton = new JButton("Actualizar Producto");

        // Crear etiqueta para mostrar la información del producto
        JLabel infoLabel = new JLabel(producto.toString());
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar funcionalidad al boton
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    producto.setNombre(nombreField.getText());
                    producto.setPrecio(Double.parseDouble(precioField.getText()));
                    producto.setCantidadStock(Integer.parseInt(stockField.getText()));
                    producto.setCategoria(categoriaField.getText());

                    // Actualizar la etiqueta con la nueva informacion
                    infoLabel.setText(producto.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Verifica los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Añadir componentes al frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(actualizarButton, BorderLayout.SOUTH);
        frame.add(infoLabel, BorderLayout.NORTH);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
