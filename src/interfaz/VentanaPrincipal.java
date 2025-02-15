package interfaz;

import mundo.infoEmpleado;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.net.URL;
import java.awt.Image;


public class VentanaPrincipal extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton btnAceptar;
    private JTextField textFieldName, textFieldDirec, textFieldTel, textFieldSalario;
    private JTextArea textAreaInfo;
    private infoEmpleado miInfoEmpleado;
    private JComboBox<String> BoxNum, BoxEstracto;

    public VentanaPrincipal() {
        setTitle("Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);  // Aumentado el tamaño de la ventana
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("DATOS PERSONALES DEL EMPLEADO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(100, 20, 400, 25);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));  // Tamaño de fuente ajustado
        panel.add(lblTitulo);

        // Campos de entrada
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNombre.setBounds(30, 70, 80, 20);
        panel.add(lblNombre);

        textFieldName = new JTextField();
        textFieldName.setBounds(110, 70, 60, 25);
        panel.add(textFieldName);

        JLabel lblDireccion = new JLabel("Dirección");
        lblDireccion.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDireccion.setBounds(192, 70, 80, 20);
        panel.add(lblDireccion);

        textFieldDirec = new JTextField();
        textFieldDirec.setBounds(282, 68, 60, 25);
        panel.add(textFieldDirec);

        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTelefono.setBounds(30, 120, 80, 20);
        panel.add(lblTelefono);

        textFieldTel = new JTextField();
        textFieldTel.setBounds(110, 120, 60, 25);
        panel.add(textFieldTel);

        JLabel lblSalario = new JLabel("Salario actual");
        lblSalario.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSalario.setBounds(192, 120, 87, 20);
        panel.add(lblSalario);

        textFieldSalario = new JTextField();
        textFieldSalario.setBounds(283, 118, 60, 25);
        panel.add(textFieldSalario);

        // Botón de cálculo
        btnAceptar = new JButton("Calcular");
        btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAceptar.addActionListener(this);
        btnAceptar.setBounds(30, 363, 120, 30);
        panel.add(btnAceptar);

        // Estrato y número
        JLabel lblEstrato = new JLabel("ESTRATO");
        lblEstrato.setFont(new Font("Arial", Font.BOLD, 15));
        lblEstrato.setBounds(254, 183, 89, 20);
        panel.add(lblEstrato);

        BoxNum = new JComboBox<>(new String[] {"1", "2", "3", "4", "5", "6"});
        BoxNum.setFont(new Font("Arial", Font.PLAIN, 12));
        BoxNum.setBounds(159, 234, 50, 25);
        panel.add(BoxNum);

        BoxEstracto = new JComboBox<>(new String[] {"Bajo Bajo", "Bajo Medio", "Bajo Alto", "Medio Bajo", "Medio", "Medio Alto"});
        BoxEstracto.setFont(new Font("Arial", Font.PLAIN, 12));
        BoxEstracto.setBounds(343, 234, 100, 25);
        panel.add(BoxEstracto);

        JLabel lblNumero = new JLabel("Número");
        lblNumero.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNumero.setBounds(100, 236, 60, 20);
        panel.add(lblNumero);

        JLabel lblNivel = new JLabel("Nivel Estrato");
        lblNivel.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNivel.setBounds(240, 236, 80, 20);
        panel.add(lblNivel);

        // Área de texto para mostrar información
        textAreaInfo = new JTextArea();
        textAreaInfo.setBounds(176, 303, 400, 90);
        panel.add(textAreaInfo);
        textAreaInfo.setEditable(false);
        textAreaInfo.setLineWrap(true);
        textAreaInfo.setWrapStyleWord(true);
        //Imagen
     // Imagen
        JLabel lblNewLabel = new JLabel("");
        try {
            // URL de la imagen
            URL url = new URL("http://blog.orientaronline.com.ar/wp-content/uploads/2010/02/community.jpg");
            
            // Cargar la imagen desde la URL
            ImageIcon icon = new ImageIcon(url);
            
            // Escalar la imagen al tamaño deseado (224 x 142)
            Image img = icon.getImage().getScaledInstance(224, 142, Image.SCALE_SMOOTH);
            
            // Asignar la imagen escalada al JLabel
            lblNewLabel.setIcon(new ImageIcon(img));
            
            // (Opcional) Agregar un borde al JLabel para visualizar el recuadro
            lblNewLabel.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Establecer la posición y tamaño del JLabel
        lblNewLabel.setBounds(352, 56, 224, 142);
        panel.add(lblNewLabel);

        // Agregar eventos para sincronizar estrato y número
        BoxNum.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int numero = Integer.parseInt((String) BoxNum.getSelectedItem());
                String nivel = determinarNivelEstrato(numero);
                BoxEstracto.setSelectedItem(nivel);
            }
        });

        BoxEstracto.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String nivel = (String) BoxEstracto.getSelectedItem();
                int numero = determinarNumeroEstrato(nivel);
                BoxNum.setSelectedItem(String.valueOf(numero));
            }
        });
    }

    private String determinarNivelEstrato(int numero) {
        switch (numero) {
            case 1: return "Bajo Bajo";
            case 2: return "Bajo Medio";
            case 3: return "Bajo Alto";
            case 4: return "Medio Bajo";
            case 5: return "Medio";
            case 6: return "Medio Alto";
            default: return "Desconocido";
        }
    }

    private int determinarNumeroEstrato(String nivel) {
        switch (nivel) {
            case "Bajo Bajo": return 1;
            case "Bajo Medio": return 2;
            case "Bajo Alto": return 3;
            case "Medio Bajo": return 4;
            case "Medio": return 5;
            case "Medio Alto": return 6;
            default: return 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            try {
                String nombre = textFieldName.getText();
                String direccion = textFieldDirec.getText();
                String telefono = textFieldTel.getText();
                double salarioActual = Double.parseDouble(textFieldSalario.getText());
                int estrato = Integer.parseInt((String) BoxNum.getSelectedItem());

                miInfoEmpleado = new infoEmpleado(nombre, direccion, telefono, salarioActual, estrato);
                miInfoEmpleado.incrementarSalario();
                textAreaInfo.setText(miInfoEmpleado.obtenerInformacion());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos para salario y estrato", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal frame = new VentanaPrincipal();
            frame.setVisible(true);
        });
    }
}
