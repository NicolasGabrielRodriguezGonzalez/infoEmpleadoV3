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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


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
        lblTitulo.setForeground(SystemColor.desktop);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(96, 21, 400, 25);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 16));  // Tamaño de fuente ajustado
        panel.add(lblTitulo);

        // Campos de entrada
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNombre.setBounds(19, 79, 80, 20);
        panel.add(lblNombre);

        textFieldName = new JTextField();
        textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textFieldName.setToolTipText("Escriba su Nombre Completo");
        textFieldName.setBounds(109, 74, 220, 25);
        panel.add(textFieldName);

        JLabel lblDireccion = new JLabel("Dirección");
        lblDireccion.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblDireccion.setBounds(19, 115, 80, 20);
        panel.add(lblDireccion);

        textFieldDirec = new JTextField();
        textFieldDirec.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textFieldDirec.setBounds(109, 149, 220, 25);
        panel.add(textFieldDirec);
        
        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblTelefono.setBounds(19, 154, 80, 20);
        panel.add(lblTelefono);

        textFieldTel = new JTextField();
        textFieldTel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textFieldTel.setBounds(109, 110, 220, 25);
        panel.add(textFieldTel);

        JLabel lblSalario = new JLabel("Salario actual");
        lblSalario.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblSalario.setBounds(19, 190, 89, 20);
        panel.add(lblSalario);

        textFieldSalario = new JTextField();
        textFieldSalario.setToolTipText("");
        textFieldSalario.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textFieldSalario.setText(" ");
        textFieldSalario.setBounds(109, 185, 220, 25);
        panel.add(textFieldSalario);

        // Botón de cálculo
        btnAceptar = new JButton("Calcular");
        btnAceptar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnAceptar.addActionListener(this);
        btnAceptar.setBounds(19, 334, 100, 30);
        panel.add(btnAceptar);

        // Estrato y número
        JLabel lblEstrato = new JLabel("ESTRATO");
        lblEstrato.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblEstrato.setBounds(19, 239, 80, 20);
        panel.add(lblEstrato);

        BoxNum = new JComboBox<>(new String[] {"1", "2", "3", "4", "5", "6"});
        BoxNum.setFont(new Font("Times New Roman", Font.BOLD, 15));
        BoxNum.setBounds(105, 234, 50, 25);
        panel.add(BoxNum);

        BoxEstracto = new JComboBox<>(new String[] {"Bajo - Bajo", "Bajo - Medio", "Bajo - Alto", "Medio - Bajo", "Medio - Medio ", "Medio - Alto"});
        BoxEstracto.setModel(new DefaultComboBoxModel(new String[] {"Bajo - Bajo", "Bajo - Medio", "Bajo - Alto", "Medio - Bajo", "Medio - Medio", "Medio - Alto"}));
        BoxEstracto.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        BoxEstracto.setBounds(290, 234, 113, 25);
        panel.add(BoxEstracto);

        JLabel lblNivel = new JLabel("Nivel Estrato");
        lblNivel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNivel.setBounds(182, 239, 100, 20);
        panel.add(lblNivel);

        // Área de texto para mostrar información
        textAreaInfo = new JTextArea();
        textAreaInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textAreaInfo.setBounds(257, 299, 251, 90);
        panel.add(textAreaInfo);
        textAreaInfo.setEditable(false);
        textAreaInfo.setLineWrap(true);
        textAreaInfo.setWrapStyleWord(true);
        //Imagen
     // Imagen
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        try {
            // URL de la imagen
            URL url = new URL("http://blog.orientaronline.com.ar/wp-content/uploads/2010/02/community.jpg");
            
            // Cargar la imagen desde la URL
            ImageIcon icon = new ImageIcon(url);
            
            // Escalar la imagen al tamaño deseado (224 x 142)
            Image img = icon.getImage().getScaledInstance(224, 142, Image.SCALE_SMOOTH);
            
            // Asignar la imagen escalada al JLabel
            lblNewLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Establecer la posición y tamaño del JLabel
        lblNewLabel.setBounds(344, 79, 224, 142);
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
                
         
                JLabel lblSuResultaadoEs = new JLabel("Su resultado es");
                lblSuResultaadoEs.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                lblSuResultaadoEs.setBounds(139, 338, 108, 20);
                panel.add(lblSuResultaadoEs);
            }
        });
    }

    private String determinarNivelEstrato(int numero) {
        switch (numero) {
            case 1: return "Bajo - Bajo";
            case 2: return "Bajo - Medio";
            case 3: return "Bajo - Alto";
            case 4: return "Medio - Bajo";
            case 5: return "Medio - Medio";
            case 6: return "Medio - Alto";
            default: return "Desconocido";
        }
    }

    private int determinarNumeroEstrato(String nivel) {
        switch (nivel) {
            case "Bajo - Bajo": return 1;
            case "Bajo - Medio": return 2;
            case "Bajo - Alto": return 3;
            case "Medio - Bajo": return 4;
            case "Medio - Medio": return 5;
            case "Medio - Alto": return 6;
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
