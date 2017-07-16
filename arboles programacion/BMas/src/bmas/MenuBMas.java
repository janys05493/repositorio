package bmas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import bmas.AVL;
import bmas.Auxiliar;
import bmas.BMAS;
import bmas.Nodo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class MenuBMas extends JFrame {
	 AVL t = new AVL( ); /*Creamos un árbol AVL*/
     AVL s = new AVL(); 
     BMAS arbol = new BMAS(); /*Creamos un nuevo árbol B+*/
     Scanner sc;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static class Auxiliar{
	    public static int letra2Num(String palabra){
	        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
	        "r","s","t","u","v","w","x","y","z"};
	        LinkedList<String> lista = new LinkedList<String>();//tiene cabeza y cola es como una lista doblemente enlazada
	        lista.addAll(Arrays.asList(alfabeto));//convierte un arreglo en una lista
	        return lista.indexOf(palabra.charAt(0)+"");/*Retorna el índice dentro de la lista alfabética*/
	    }
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBMas frame = new MenuBMas();
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
	public MenuBMas() {
		setTitle("ARBOL B+");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMostrar = new JButton("MOSTRAR CONTENIDO DEL FICHERO");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Este es un árbol AVL auxiliar*/
			        RandomAccessFile raf=null;
					try {
						raf = new RandomAccessFile("lemario.txt","r");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} /*ramdon me permite escribir y leer de un fichero*/
			        String linea; /*Creamos una línea vacía*/
			        long i = 0; /*Variable que indica el número de línea*/
			        try {
						while((linea=raf.readLine())!=null){
						    s.insertar(linea);/*Insertamos cada línea en el árbol AVL auxiliar*/
						    Nodo qq = s.encuentra(linea,s.raiz);
						    if(qq!=null){
						        qq.listaOcurrencias = qq.listaOcurrencias + "," + i;
						    }
						    i++;/*Avanzamos dentro del contador de líneas*/
						    raf.getFilePointer();/*Actualizamos el puntero dentro del fichero de acceso aleatorio*/
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        try {
						raf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}/*Cerramos el flujo de lectura desde el archivo*/
			       try{
			        System.out.println("Parte a. de la práctica. El archivo contiene: " + i + " palabras");
			        System.out.println("**************************************");
			        s.imprimiendoarbol();/*Imprimimos el árbol AVL obtenido*/
			       }catch (Exception e){ System.out.println(" ");  }
			       /*He aquí la parte b de la práctica requerida*/
			        System.out.println("***************************************");
			       
					try {
						sc = new Scanner(new FileInputStream("diccionario.txt"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}/*Fichero de lectura (diccionario)*/
			        String line;/* Creamos una línea vacía*/
			        /*Definimos un alfabeto castellano compuesto por 27 letras*/
			        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
			        "r","s","t","u","v","w","x","y","z"};
			        /*Vector de conteo que permite registrar la primera ocurrencia de una palabra que comienza
			         * con una determinada letra del alfabeto usado (compuesto por 27 letras únicamente).
			         */
			        int[] conteo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			        int j = 0;/*Variable auxiliar para el conteo de líneas dentro del archivo*/
			        while (sc.hasNextLine()){ /*Leemos dentro del archivo diccionario.txt*/
			            line = sc.nextLine();
			            arbol.añadir(j, (String) line);/*Añadimos cada línea al árbol B+ respectivo*/
			            int w = 0;/*Variable auxiliar que permite realizar un conteo*/
			            for(String aux:alfabeto){/*Determinamos dónde es la primera ocurrencia de una palabra con determinada inicial*/
			                if(line.startsWith(aux) && conteo[w] == 0){
			                    conteo[w] = j;
			                }
			                w++;/*Actualizamos el contador interno auxiliar*/
			            }
			            j++;/*Variable que cuenta el número de línea donde está una palabra*/
			        }
			        sc.close();/*Cerramos el flujo de lectura del archivo leído anteriormente*/
			        System.out.print("INGRESE UNA PALABRA:");
			        Scanner readText = new Scanner(System.in);/*Creamos un nuevo Scanner de lectura por consola*/
			        String palabra = readText.nextLine();/*Leemos una palabra*/
			        boolean mostrado = false;/*Variable auxiliar para saber si un mensaje fue mostrado*/
			        if(palabra.length()>=4){/*La palabra debe de tener al menos 4 carácteres*/
			            String p = "" + palabra.charAt(0)+palabra.charAt(1)+palabra.charAt(2)+palabra.charAt(3);
			            StringBuilder q = new StringBuilder();
			            q = q.append(palabra).reverse();/*Invertimos el orden de la palabra*/
			            String f = "" + q.charAt(2)+q.charAt(1)+q.charAt(0);
			            if(s.encontrar(palabra)!=null){/*Se verifica que la palabra este en el listado anterior*/
			                for(int z = conteo[(Auxiliar.letra2Num(palabra))%27];z<=conteo[(Auxiliar.letra2Num(palabra)+1)%27];z++){
			                    if(arbol.search(z).toString().startsWith(p) && arbol.search(z).toString().endsWith(f)){
			                        System.out.println("Coincidencia: " + arbol.search(z));/*Buscamos en el árbol B+*/
			                        mostrado = true;/*Efectivamente el mensaje se mostró*/
			                        return;
			                    }
			                }
			                if(!mostrado){
			                    System.out.println("LA PALABRA INGRESADA EXISTE EN LA LISTA");
			                }
			                
			                
			            }
			            else{/*Si no está entonces presentamos el siguiente mensaje por pantalla*/
			                System.out.println("LA PALABRA: <" + palabra + "> NO SE ENCUENTRA EN LA LISTA");
			            }
			        }
			        else{
			            System.out.println("LA PALABRA NO TIENE LA LONGITUD MINIMA NECESARIA");
			        }
			        readText.close();
			}
		});
		btnMostrar.setBounds(167, 63, 240, 130);
		contentPane.add(btnMostrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(38, 63, 119, 130);
		contentPane.add(btnSalir);
	}
}
