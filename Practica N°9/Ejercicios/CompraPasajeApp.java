import javax.swing.*;
import java.awt.*;

public class CompraPasajeApp extends JFrame {
    private JTextField campoNombre, campoDocumento, campoFecha;
    private JRadioButton piso1, piso2;
    private JCheckBox audifonos, manta, revistas;
    private JComboBox<String> comboOrigen, comboDestino;
    private JList<String> listaCalidad;
    private JButton botonReiniciar, botonResumen;

    public CompraPasajeApp() {
        super("Compra de Pasaje");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Etiquetas y campos de texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        campoNombre = new JTextField(15);
        add(campoNombre, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 3;
        add(new JLabel("Documento:"), gbc);
        gbc.gridx = 4;
        campoDocumento = new JTextField(15);
        add(campoDocumento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Fecha de viaje:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        campoFecha = new JTextField(10);
        add(campoFecha, gbc);
        gbc.gridwidth = 1;

        // Botones de opción para piso
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Piso:"), gbc);
        gbc.gridx = 1;
        JPanel panelPiso = new JPanel();
        piso1 = new JRadioButton("1er Piso");
        piso2 = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(piso1);
        grupoPiso.add(piso2);
        panelPiso.add(piso1);
        panelPiso.add(piso2);
        add(panelPiso, gbc);

        // Casillas de verificación para servicios opcionales
        gbc.gridx = 3;
        add(new JLabel("Servicios opcionales:"), gbc);
        gbc.gridx = 4;
        JPanel panelServicios = new JPanel();
        audifonos = new JCheckBox("Audífonos");
        manta = new JCheckBox("Manta");
        revistas = new JCheckBox("Revistas");
        panelServicios.add(audifonos);
        panelServicios.add(manta);
        panelServicios.add(revistas);
        add(panelServicios, gbc);

        // Cuadros combinados para origen y destino
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Lugar de origen:"), gbc);
        gbc.gridx = 1;
        comboOrigen = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Trujillo"});
        add(comboOrigen, gbc);

        gbc.gridx = 3;
        add(new JLabel("Lugar de destino:"), gbc);
        gbc.gridx = 4;
        comboDestino = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Trujillo"});
        add(comboDestino, gbc);

        // Lista de calidad de servicio
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Calidad de servicio:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        listaCalidad = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaCalidad), gbc);
        gbc.gridwidth = 1;

        // Botones de comando
        gbc.gridx = 1;
        gbc.gridy = 5;
        botonReiniciar = new JButton("Reiniciar");
        botonResumen = new JButton("Mostrar Resumen");
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonReiniciar);
        panelBotones.add(botonResumen);
        gbc.gridwidth = 2;
        add(panelBotones, gbc);

        botonReiniciar.addActionListener(e -> reiniciarFormulario());
        botonResumen.addActionListener(e -> mostrarResumen());
    }

    private void reiniciarFormulario() {
        campoNombre.setText("");
        campoDocumento.setText("");
        campoFecha.setText("");
        piso1.setSelected(false);
        piso2.setSelected(false);
        audifonos.setSelected(false);
        manta.setSelected(false);
        revistas.setSelected(false);
        comboOrigen.setSelectedIndex(0);
        comboDestino.setSelectedIndex(0);
        listaCalidad.clearSelection();
    }

    private void mostrarResumen() {
        String nombre = campoNombre.getText();
        String documento = campoDocumento.getText();
        String fecha = campoFecha.getText();
        String piso = piso1.isSelected() ? "1er Piso" : "2do Piso";
        String origen = (String) comboOrigen.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();
        String calidad = listaCalidad.getSelectedValue() != null ? listaCalidad.getSelectedValue() : "No seleccionado";

        StringBuilder servicios = new StringBuilder();
        if (audifonos.isSelected()) servicios.append("Audífonos ");
        if (manta.isSelected()) servicios.append("Manta ");
        if (revistas.isSelected()) servicios.append("Revistas");

        JOptionPane.showMessageDialog(this,
            "Resumen de la compra:\n" +
            "Nombre: " + nombre + "\n" +
            "Documento: " + documento + "\n" +
            "Fecha de viaje: " + fecha + "\n" +
            "Piso: " + piso + "\n" +
            "Lugar de origen: " + origen + "\n" +
            "Lugar de destino: " + destino + "\n" +
            "Calidad de servicio: " + calidad + "\n" +
            "Servicios opcionales: " + servicios.toString(),
            "Resumen",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompraPasajeApp app = new CompraPasajeApp();
            app.setVisible(true);
        });
    }
}
