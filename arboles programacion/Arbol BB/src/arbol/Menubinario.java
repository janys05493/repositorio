package arbol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import arbol.Arbol;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class Menubinario extends JFrame {

	
	  	
	    Arbol raizAux = new Arbol();
	    
	private JPanel contentPane;
	private JTextField txtinsertar;
	private JButton btnSalir;
	private JButton btnRecorrerPreorden;
	private JTextField txtbuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menubinario frame = new Menubinario();
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
	public Menubinario() {
		setTitle("ARBOL BINARIO DE BUSQUEDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtinsertar = new JTextField();
		txtinsertar.setBounds(38, 43, 226, 20);
		contentPane.add(txtinsertar);
		txtinsertar.setColumns(10);
		
		JButton btninsertar = new JButton("Insertar");
		btninsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		int nuevo;
		nuevo=Integer.parseInt(txtinsertar.getText());
		raizAux.insertar(nuevo);
		txtinsertar.setText(""); 		
			}
		});
		btninsertar.setBounds(274, 42, 119, 23);
		contentPane.add(btninsertar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(163, 215, 119, 23);
		contentPane.add(btnSalir);
		
		btnRecorrerPreorden = new JButton("preorden");
		btnRecorrerPreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 System.out.println(" ");
				System.out.println("impresion pre-orden");
				raizAux.preorden(raizAux.getRaiz());
			 
			}
		});
		btnRecorrerPreorden.setBounds(38, 108, 119, 23);
		contentPane.add(btnRecorrerPreorden);
		
		JButton btnpostorden = new JButton("postorden");
		btnpostorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println(" ");
				System.out.println("impresion post-orden");
				raizAux.postorden(raizAux.getRaiz());
			
			}
		});
		btnpostorden.setBounds(38, 142, 119, 23);
		contentPane.add(btnpostorden);
		
		JButton btnintorden = new JButton("inorden");
		btnintorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println(" ");
				System.out.println("impresion in-orden");
				raizAux.inorden(raizAux.getRaiz());
				
			}
		});
		btnintorden.setBounds(38, 175, 119, 23);
		contentPane.add(btnintorden);
		
		JButton btnbuscar = new JButton("buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int aux;
		aux=Integer.parseInt(txtbuscar.getText());
		
			
			if(raizAux.existe(aux))
			{
				System.out.println("el numero existe");
			}
			else
			{
				System.out.println("el numero no existe");
			}
			txtbuscar.setText("");
		
		}
	
				 
			
		});
		btnbuscar.setBounds(274, 142, 119, 23);
		contentPane.add(btnbuscar);
		
		JButton btnvacio = new JButton("vacio");
		btnvacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(raizAux.vacio()){
					System.out.println("el arbol esta vacio");
				}
				else{
					System.out.println("el arbol esta lleno");
				}
			}
		});
		btnvacio.setBounds(274, 181, 119, 23);
		contentPane.add(btnvacio);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(273, 109, 120, 20);
		contentPane.add(txtbuscar);
		txtbuscar.setColumns(10);
	}
}
