package ec.edu.puce.facturacion.forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import facturacion.domain.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCliente extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTable table;
	private Cliente cliente=new Cliente();
	private DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setTitle("Clientes");
		setBounds(100, 100, 450, 558);
		getContentPane().setLayout(null);
		
		JLabel lblCdula = new JLabel("Cédula");
		lblCdula.setBounds(12, 24, 70, 15);
		getContentPane().add(lblCdula);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(12, 51, 70, 15);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 78, 70, 15);
		getContentPane().add(lblApellidos);
		
		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(12, 105, 70, 15);
		getContentPane().add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(12, 132, 70, 15);
		getContentPane().add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 159, 70, 15);
		getContentPane().add(lblEmail);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(105, 22, 114, 19);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(105, 49, 114, 19);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(105, 76, 114, 19);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(105, 103, 114, 19);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 130, 114, 19);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(105, 157, 114, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCedula.setText("");
				txtNombres.setText("");
				txtApellidos.setText("");
				txtDireccion.setText("");
				txtEmail.setText("");
				txtTelefono.setText("");
			}
		});
		btnNuevo.setBounds(23, 206, 117, 25);
		getContentPane().add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnGuardar.setBounds(152, 206, 117, 25);
		getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(281, 206, 117, 25);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 257, 375, 237);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula", "Nombres", "Apellidos", "Direcci\u00F3n", "Tel\u00E9fono", "Email"
			}
		));
		scrollPane.setViewportView(table);
		model=(DefaultTableModel) table.getModel();
	}
	private void crearCliente() {
		cliente.setCedula(txtCedula.getText());
		cliente.setNombre(txtNombres.getText());
		cliente.setApellido(txtApellidos.getText());
		cliente.setDireccion(txtDireccion.getText());
		cliente.setTelefono(txtTelefono.getText());
		cliente.setEmail(txtEmail.getText());
		agregarFila();
	}

	private void agregarFila() {
		Object[] fila=new Object[6];
		fila[0]=cliente.getCedula();
		fila[1]=cliente.getNombre();
		fila[2]=cliente.getApellido();
		fila[3]=cliente.getDireccion();
		fila[4]=cliente.getTelefono();
		fila[5]=cliente.getEmail();
		model.addRow(fila);
		
	}
}