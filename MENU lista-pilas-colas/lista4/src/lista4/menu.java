package lista4;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		circulardoble dato= new circulardoble();
		int num,opcion;
		String nombre;
		do
		{  
			System.out.println(" ");
			
			System.out.println("Menu");
			System.out.println("1.ingresar inicio");
			System.out.println("2. mostrar");
			System.out.println("3.ingresar final");
			System.out.println("4. borrar inicio");
			System.out.println("5. borrar final");
			System.out.println("7. salir");
			opcion=entrada.nextInt();
			switch(opcion)
			{
			case 1: 
				System.out.println("ingrese un nombre");
				nombre=entrada.next();
				System.out.println("ingrese un numero");
				num=entrada.nextInt();
				dato.insertarinicio(nombre,num);
						break;
			case 2:
				dato.mostrar();
				break;
			case 3:
				System.out.println("ingrese un nombre");
				nombre=entrada.next();
				System.out.println("ingrese un numero");
				num=entrada.nextInt();
				dato.insertarfinal(nombre,num);
				break;
			case 4:
				dato.borrarinicio();
				break;
			case 5:
				dato.borrarfinal();
				break;
			}
		}while(opcion!=7);

	}

}
