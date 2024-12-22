package ec.edu.puce.facturacion.forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;

public class FrmMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrmCliente frmCliente;
	private JDesktopPane desktopPane;
	private FrmListaClientes frmListaClientes;
	private boolean frmClienteAbierto = false;
	private boolean frmListaClientesAbierto = false;

	
	public FrmMenuPrincipal() {
		setTitle("SISTEMA DE FACTURACIÓN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 509);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 190, 111));
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Archivo");
		mnFile.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnFile);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmSalir.setFont(new Font("Dialog", Font.BOLD, 16));
		mnFile.add(mntmSalir);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCrearClientes = new JMenuItem("Crear Clientes");
		mntmCrearClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!frmClienteAbierto) {
					frmCliente = new FrmCliente();
					desktopPane.add(frmCliente);
					frmCliente.setVisible(true);
					frmClienteAbierto = true;
				}else {
					JOptionPane.showMessageDialog(FrmMenuPrincipal.this, "Ya hay una ventana abierta de Crear Cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		mntmCrearClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		mnClientes.add(mntmCrearClientes);
		
		JMenuItem mntmListaDeClientes = new JMenuItem("Lista de Clientes");
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!frmListaClientesAbierto) {
					FrmListaClientes frmListaClientes = new FrmListaClientes();
					frmListaClientes.setVisible(true);
					desktopPane.add(frmListaClientes);
					frmListaClientesAbierto = true;
				} else {
					JOptionPane.showMessageDialog(FrmMenuPrincipal.this, "Ya hay una ventana abierta de Lista Clientes", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mntmListaDeClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		mnClientes.add(mntmListaDeClientes);
		
		
		
		JMenu mnRedesSociales = new JMenu("Redes sociales");
		mnRedesSociales.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/puce/facturacion/imagenes/facebook.png")));
		mnRedesSociales.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnRedesSociales);
		
		JMenuItem mntmFacebook = new JMenuItem("Facebook");
		mntmFacebook.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/puce/facturacion/imagenes/facebook.png")));
		mntmFacebook.setFont(new Font("Dialog", Font.BOLD, 16));
		mnRedesSociales.add(mntmFacebook);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(119, 118, 123));
		contentPane.add(desktopPane, "name_250806999939613");
	}


	public FrmListaClientes getFrmListaClientes() {
		return frmListaClientes;
	}


	public void setFrmListaClientes(FrmListaClientes frmListaClientes) {
		this.frmListaClientes = frmListaClientes;
	}
}