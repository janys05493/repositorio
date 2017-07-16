package H;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import H.Huffman;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
public class interfazHuffman extends JFrame {
	Huffman ArbolH=new Huffman();

	private JPanel contentPane;
	private JTextField txtinsertar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazHuffman frame = new interfazHuffman();
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
	public interfazHuffman() {
		setTitle("ARBOL HUFFMAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtinsertar = new JTextField();
		txtinsertar.setBounds(54, 91, 185, 39);
		contentPane.add(txtinsertar);
		txtinsertar.setColumns(10);
		
		JButton btnInsertar = new JButton("AGREGAR Y MOSTRAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena=txtinsertar.getText();
				 int[] charFreqs = new int[256];
			        for (char c : cadena.toCharArray())
			            charFreqs[c]++;
			        
			        
			        arbolhuffman arbol = ArbolH.construirarbol(charFreqs);
			        System.out.println("Tabla de Codigos");
			        System.out.println("Simbolo\tCantidades\tCodigo Huffman");
			        ArbolH.printCodes(arbol, new StringBuffer());
			        
			        
			        String encode = ArbolH.codificar(arbol,cadena);
			        
			        System.out.println("\nTexto Comprimido");
			        System.out.println(encode); 
			        
			        
			        System.out.println("\n\nTexto Descodificado");
			        System.out.println(ArbolH.descodificar(arbol,encode));
			        txtinsertar.setText(""); 
				
			}
		});
		btnInsertar.setBounds(54, 141, 185, 44);
		contentPane.add(btnInsertar);
		
		JLabel lblIngreseUnaPalabra = new JLabel("INGRESE UNA PALABRA");
		lblIngreseUnaPalabra.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblIngreseUnaPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseUnaPalabra.setBounds(54, 11, 334, 29);
		contentPane.add(lblIngreseUnaPalabra);
		
		JLabel lblNoMayorA = new JLabel("NO > A 256 CARACTERES");
		lblNoMayorA.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNoMayorA.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoMayorA.setBounds(103, 51, 247, 14);
		contentPane.add(lblNoMayorA);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(271, 91, 129, 94);
		contentPane.add(btnSalir);
	}
}
