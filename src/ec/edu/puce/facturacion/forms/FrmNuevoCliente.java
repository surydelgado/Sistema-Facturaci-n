package ec.edu.puce.facturacion.forms;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmNuevoCliente extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private boolean esNuevoCliente;
    
    
    public FrmNuevoCliente(FrmListaClientes frmListaClientes) {
        this(frmListaClientes, "", "", "", "", "", "", -1);
    }

    public FrmNuevoCliente(FrmListaClientes frmListaClientes, String cedula, String nombres, String apellidos, String direccion, String telefono, String email, int filaSeleccionada) {
        this.esNuevoCliente = (filaSeleccionada == -1);

        setTitle(esNuevoCliente ? "Nuevo Cliente" : "Editar Cliente");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 434, 228);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        JLabel lblCedula = new JLabel("Cédula");
        lblCedula.setBounds(27, 48, 81, 14);
        contentPanel.add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(133, 42, 174, 20);
        contentPanel.add(txtCedula);
        txtCedula.setColumns(10);
        txtCedula.setText(cedula);

        JLabel lblNombres = new JLabel("Nombres");
        lblNombres.setBounds(27, 73, 81, 14);
        contentPanel.add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setColumns(10);
        txtNombres.setBounds(133, 67, 174, 20);
        contentPanel.add(txtNombres);
        txtNombres.setText(nombres);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(27, 98, 81, 14);
        contentPanel.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setColumns(10);
        txtApellidos.setBounds(133, 92, 174, 20);
        contentPanel.add(txtApellidos);
        txtApellidos.setText(apellidos);

        JLabel lblDireccion = new JLabel("Dirección");
        lblDireccion.setBounds(27, 123, 81, 14);
        contentPanel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(133, 117, 174, 20);
        contentPanel.add(txtDireccion);
        txtDireccion.setText(direccion);

        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setBounds(27, 148, 81, 14);
        contentPanel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(133, 145, 174, 20);
        contentPanel.add(txtTelefono);
        txtTelefono.setText(telefono);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(27, 173, 81, 14);
        contentPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(133, 170, 174, 20);
        contentPanel.add(txtEmail);
        txtEmail.setText(email);

        JPanel buttonPane = new JPanel();
        buttonPane.setBounds(0, 228, 434, 33);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane);

        JButton okButton = new JButton("Guardar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(camposVacios()) {
            		String cedula = txtCedula.getText();
            		String nombres = txtNombres.getText();
            		String apellidos = txtApellidos.getText();
            		String direccion = txtDireccion.getText();
            		String telefono = txtTelefono.getText();
            		String email = txtEmail.getText();

            		if (esNuevoCliente) {
            			frmListaClientes.agregarCliente(cedula, nombres, apellidos, direccion, telefono, email);
            		} else {
            			frmListaClientes.actualizarCliente(filaSeleccionada, cedula, nombres, apellidos, direccion, telefono, email);
            		}
            		dispose();
            		
            }
           }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
    private boolean camposVacios() {
    	if(txtCedula.getText().trim().isEmpty() ||
    			txtNombres.getText().trim().isEmpty() ||
    			txtApellidos.getText().trim().isEmpty() ||
    			txtDireccion.getText().trim().isEmpty() ||
    			txtTelefono.getText().trim().isEmpty() ||
    			txtEmail.getText().trim().isEmpty()) {
    		JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error de validación", JOptionPane.WARNING_MESSAGE);
    		return false;
    	}
    	return true;
    }
}