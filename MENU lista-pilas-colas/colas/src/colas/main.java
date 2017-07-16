package colas;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		 cola colita=new cola();
int opcion, nuevo;
String nombre;




		do
		{System.out.println(" ");
			System.out.println("--------------Menu Cola--------------------");
		System.out.println("1. insertar cola");
		System.out.println("2. mostrar");
		System.out.println("3. borrar cola");
		System.out.println("4. verificar si esta vacia");
		System.out.println("5. destruir");
		System.out.println("0. salir");
		System.out.println("ingrese su opcion");
		opcion=entrada.nextInt();
		switch(opcion)
		{
		case 1:
			System.out.println("ingrese un nombre");
			nombre=entrada.next();
			System.out.println("ingrese un numero");
			nuevo=entrada.nextInt();
			colita.insertarcola(nombre,nuevo);
			break;
		case 2:
			 colita.mostrar();
			 break;
		case 3:
			colita.borrarcola();
			break;
		case 4:
			if(colita.estavacia()){
				System.out.println("la cola esta vacia");
			}
			else{
				System.out.println("la cola esta llena");
			}
			break;
		case 5:
			colita.destruircola();
			break;
		}
		}while(opcion!=0);
		}
	
}
