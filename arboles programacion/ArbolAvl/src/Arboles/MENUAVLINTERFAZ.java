package Arboles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Arboles.Arbolavl;

public class MENUAVLINTERFAZ extends JFrame {
	Arbolavl avl=new Arbolavl();

	private JPanel contentPane;
	private JTextField txtingresar;
	private JTextField txtbuscar;
	private JTextField txteliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENUAVLINTERFAZ frame = new MENUAVLINTERFAZ();
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
	public MENUAVLINTERFAZ() {
		setTitle("ARBOL AVL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtingresar = new JTextField();
		txtingresar.setBounds(136, 34, 75, 20);
		contentPane.add(txtingresar);
		txtingresar.setColumns(10);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int nuevo;
		nuevo=Integer.parseInt(txtingresar.getText());
		avl.ingresarelemento(nuevo);
		txtingresar.setText(""); 	
				
			}
		});
		btnIngresar.setBounds(21, 33, 100, 23);
		contentPane.add(btnIngresar);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dato;
				 
					dato=Integer.parseInt(txtbuscar.getText());
					if(avl.buscar(dato))
					{
						System.out.println("El elemento se encuentra en el arbol ");
					}
					else
						System.out.println("El elemento NO se encuentra en el arbol ");
				 
			}
		});
		btnBuscar.setBounds(224, 33, 100, 23);
		contentPane.add(btnBuscar);
		
		txtbuscar = new JTextField();
		txtbuscar.setColumns(10);
		txtbuscar.setBounds(332, 34, 75, 20);
		contentPane.add(txtbuscar);
		
		JButton btnpreorden = new JButton("PREORDEN");
		btnpreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				 avl.preordenimprimir();
				 System.out.println("\n");
				 
				
			}
		});
		btnpreorden.setBounds(66, 107, 100, 23);
		contentPane.add(btnpreorden);
		
		JButton btnpostorden = new JButton("POSTORDEN");
		btnpostorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		
				 avl.postordenimprimir();;
				 System.out.println("\n");
				
			}
		});
		btnpostorden.setBounds(66, 141, 100, 23);
		contentPane.add(btnpostorden);
		
		JButton btninorden = new JButton("INORDEN");
		btninorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 avl.inordenimprimir();
				 System.out.println("\n");
			}
		});
		btninorden.setBounds(66, 175, 100, 23);
		contentPane.add(btninorden);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int  dato;
				dato=Integer.parseInt(txteliminar.getText());
				avl.eliminar(dato);
				 
			}
		});
		btnEliminar.setBounds(269, 141, 100, 23);
		contentPane.add(btnEliminar);
		
		JButton btnVacio = new JButton("VACIO");
		btnVacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(avl.arbolvacio())
				{
					System.out.println("El arbol esta vacio");
				}
				else
				{
					System.out.println("El arbol esta lleno");
				}
					
			}
		});
		btnVacio.setBounds(269, 175, 100, 23);
		contentPane.add(btnVacio);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(165, 209, 100, 23);
		contentPane.add(btnSalir);
		
		txteliminar = new JTextField();
		txteliminar.setColumns(10);
		txteliminar.setBounds(269, 108, 100, 20);
		contentPane.add(txteliminar);
	}
}
