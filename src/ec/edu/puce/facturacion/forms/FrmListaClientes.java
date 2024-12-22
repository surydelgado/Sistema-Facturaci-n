package ec.edu.puce.facturacion.forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmListaClientes extends JInternalFrame {

    
	private static final long serialVersionUID = 1L;
	private JTable ttblClientes;
    private DefaultTableModel modelo;
    private boolean nuevoClienteAbierto = false;
    

    public FrmListaClientes() {
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lista de Clientes");
        setClosable(true);
        setBounds(100, 100, 751, 399);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 51, 673, 241);
        getContentPane().add(scrollPane);

        ttblClientes = new JTable();
        modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Email", "Acciones"}
        ) {
        	private static final long serialVersionUID = 1L;


			@Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        ttblClientes.setModel(modelo);
        scrollPane.setViewportView(ttblClientes);

        TableColumn columnaAcciones = ttblClientes.getColumnModel().getColumn(6);
        columnaAcciones.setCellRenderer(new ButtonRenderer());
        columnaAcciones.setCellEditor(new ButtonEditor(new JCheckBox()));

        JButton btnNewButton = new JButton("Agregar Nuevo");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioCliente();
            }
        });
        btnNewButton.setBounds(10, 17, 134, 23);
        getContentPane().add(btnNewButton);
    }
    
    public void formularioCliente() {
    	if (!nuevoClienteAbierto) {
    		FrmNuevoCliente frmNuevoCliente = new FrmNuevoCliente(this);
    		frmNuevoCliente.addWindowListener(new java.awt.event.WindowAdapter() {
    			@Override
    			public void windowClosed(java.awt.event.WindowEvent e) {
    				nuevoClienteAbierto = false;
    			}
    		});
    		frmNuevoCliente.setVisible(true);
    		nuevoClienteAbierto = true;
    	} else {
    		JOptionPane.showMessageDialog(this, "El formulario ya está abierto", "Advertencia", JOptionPane.WARNING_MESSAGE);
    	}
    }

    public void agregarCliente(String cedula, String nombres, String apellidos, String direccion, String telefono, String email) {
        Object[] nuevoCliente = {cedula, nombres, apellidos, direccion, telefono, email, "Editar"};
        modelo.addRow(nuevoCliente);
    }

    public void actualizarCliente(int row, String cedula, String nombres, String apellidos, String direccion, String telefono, String email) {
        modelo.setValueAt(cedula, row, 0);
        modelo.setValueAt(nombres, row, 1);
        modelo.setValueAt(apellidos, row, 2);
        modelo.setValueAt(direccion, row, 3);
        modelo.setValueAt(telefono, row, 4);
        modelo.setValueAt(email, row, 5);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
    	private static final long serialVersionUID = 1L;
    	
        public ButtonRenderer() {
            setText("Editar");
        }

        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
    	private static final long serialVersionUID = 1L;
    	
        protected JButton button;
        private String label;
        private int row;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    row = ttblClientes.getSelectedRow();
                    String cedula = (String) modelo.getValueAt(row, 0);
                    String nombres = (String) modelo.getValueAt(row, 1);
                    String apellidos = (String) modelo.getValueAt(row, 2);
                    String direccion = (String) modelo.getValueAt(row, 3);
                    String telefono = (String) modelo.getValueAt(row, 4);
                    String email = (String) modelo.getValueAt(row, 5);

                    FrmNuevoCliente frmNuevoCliente = new FrmNuevoCliente(FrmListaClientes.this, cedula, nombres, apellidos, direccion, telefono, email, row);
                    frmNuevoCliente.setVisible(true);
                }
            });
        }

        public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return label;
        }
    }
}