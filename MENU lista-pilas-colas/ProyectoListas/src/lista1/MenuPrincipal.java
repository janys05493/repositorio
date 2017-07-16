package lista1;
import java.util.Scanner;
public class MenuPrincipal {



	public static void main(String[] args) {
		 Scanner entrada  = new Scanner(System.in);	
		 int seleccion=1, opc=1;
		 int numero;
		 String nombre;
		 int valor;
		 do { System.out.println(" ");
		  System.out.println("-----------------MENU PRINCIPAL----------------");
		  System.out.println("-----------------------------------------------");
			  System.out.println("1. LISTA SIMPLE\n"
						+ "2. LISTA DOBLEMENTE ENLAZADA \n"
						+ "3. LISTA CIRCULAR\n"
						+ "4. Pilas \n"
						+ "5. Salir");
						
				System.out.println("Que opcion desea: ");
			   opc=entrada.nextInt();
			   switch(opc){
			   case 1:
				   ListaSimple numeros = new ListaSimple();
				   do{
					   System.out.println(" ");
						  System.out.println("-----------------MENU----------------");
						  System.out.println("-------------LISTA DE CONTACTOS-------------");
							  System.out.println("1.insertar al inicio\n"
										+ "2. insertar al final \n"
										+ "3. mostrar \n"
										+ "4. esta vacia\n"
										+ "5. borrar al inicio\n"
										+ "6. borrar al final\n"
										+ "7. buscar contacto\n"
										+ "8. Salir");
								System.out.println("Que opcion desea: ");
								seleccion = entrada.nextInt();
							
					   
							switch(seleccion){
							case 1:
								System.out.println("ingrese el nombre");
								nombre=entrada.next();
								System.out.println("ingrese el numero");
								valor=entrada.nextInt();
							numeros.agregarinicio(nombre,valor);;
								break;
							case 2:
								System.out.println("ingrese el nombre");
								nombre=entrada.next();
								System.out.println("ingrese el numero");
								valor=entrada.nextInt();
							numeros.agregarfinal(nombre,valor);	
								break;
							case 3:
							numeros.mostrar();
								break;
							case 4:
								
							if(numeros.estavacia())
							{
								System.out.println("la lista esta vacia \n");
							}
							else
							{
								System.out.println("la lista esta llena \n");
							}
							
									break;
					        case 5:
							
							if(numeros.estavacia())
							{
								System.out.println("la lista esta vacia \n");
							}
							else
							{
								numeros.borrarinicio();
							}
							
									break;
						
					        case 6:
							
							if(numeros.estavacia())
							{
								System.out.println("la lista esta vacia \n");
							}
							else
							{
								numeros.borrarfinal();
							}
							
									break;
					        case 7:
							int num;
							System.out.println("por favor ingrese el numero del contacto");
							num=entrada.nextInt();
							numeros.Buscar(num);;
							
									break;
							}
						  
					  }while(seleccion!=8);
				   break;
				   
			  case 2: 
				  ListaDoble contactos=new ListaDoble();
				  do
					{	System.out.println(" ");
						System.out.println("--------------MENU--------------");
						System.out.println("-------CONTACTOS-------");
						System.out.println("1. INSERTAR AL INICIO");
						System.out.println("2. MOSTRAR");
						System.out.println("3. INSERTAR AL FINAL");
						System.out.println("4. BORRAR AL INICIO");
						System.out.println("5. BORRAR AL FINAL");
						System.out.println("6. VERIFICAR SI ESTA VACIA");
						System.out.println("7. INVERTIR LISTA");
						System.out.println("8. SALIR");
						System.out.println("INGRESE SU OPCION");
						seleccion=entrada.nextInt();
						switch(seleccion)
						{
						case 1:
							System.out.println("ingrese el nombre");
							nombre=entrada.next();
							System.out.println("ingrese un numero");
							valor=entrada.nextInt();
							contactos.insertarinicio(nombre,valor);
							break;
						case 2:
							contactos.mostrar();
							break;
						case 3:
							System.out.println("ingrese el nombre");
							nombre=entrada.next();
							System.out.println("ingrese un numero");
							valor=entrada.nextInt();
							contactos.insertarfinal(nombre,valor);
							break;
						case 4:
							contactos.eliminarinicio();
							break;
						case 5:
							contactos.eliminarfinal();
							break;
						
						case 6:
							if(contactos.estavacia())
							{
								System.out.println("la lista esta vacia \n");
							}
							else
							{
								System.out.println("la lista esta llena \n");
							}
							break;
						case 7:
							contactos.invertirlista();
							break;
						}
					}while(seleccion!=8);
						
					break;	
			 case 3:
				 ListaCircular contactos2 = new ListaCircular();
				 do
					{	System.out.println(" ");
						System.out.println("-------MENU LISTA CIRCULAR SIMPLE------");
						System.out.println("1.INSERTAR INICIO");
						System.out.println("2.INSERTAR FINAL");
						System.out.println("3.MOSTRAR");
						System.out.println("4.ELIMINAR INICIO");
						System.out.println("5.ELIMINAR FINAL");
						System.out.println("6.ESTA VACIA");
						System.out.println("8.SALIR");
						System.out.println("INGRESE UNA OPCION");
						seleccion=entrada.nextInt();
						switch(seleccion)
						{
						case 1:
							System.out.println("ingrese el nombre");
							nombre=entrada.next();
							System.out.println("ingrese un numero");
							valor=entrada.nextInt();
							contactos2.insertarinicio(nombre,valor);
							
							break;
						case 2:
							System.out.println("ingrese el nombre");
							nombre=entrada.next();
							System.out.println("ingrese un numero");
							valor=entrada.nextInt();
							contactos2.insertarfin(nombre,valor);
							
							break;	
						case 3:
							contactos2.mostrar();
							break;
						case 4:
							contactos2.eliminarinicio();
							break;
						case 5:
							contactos2.eliminarfinal();
							break;
						case 6:
							if(contactos2.estavacia()){
								System.out.println("la lista esta vacia");
							}
							else{
								System.out.println("la lista esta llena");
							}
							break;
						}
					}while(seleccion!=8);
				 break;
				 
			 case 4:
				 Pilas contactos3 = new Pilas();
				 
				 do
					{System.out.println("------------MENU PILA----------------");
					System.out.println("1. insertar pila");
					System.out.println("2. mostrar");
					System.out.println("3. borrar");
					System.out.println("4. destruir");
					System.out.println("7. salir");
					System.out.println("ingrese su opcion?");
					seleccion=entrada.nextInt();
					switch(seleccion){
					case 1:
						System.out.println("ingrese un nombre");
						nombre=entrada.next();
						System.out.println("ingrese un numero");
						numero=entrada.nextInt();
						contactos3.insertarpila(nombre,numero);
						break;
					case 2:
						contactos3.mostrar();
						break;
					case 3:
						contactos3.borrar();
						break;
					case 4:
						contactos3.destruir();
					}
					}while(seleccion!=7);
                     break;
			 
				 
			   }
		 }while(opc!=5);
	}

}



