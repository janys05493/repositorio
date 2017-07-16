package lista1;
import java.util.Scanner;
public class ListaSimple {
	public Nodo inicio=null;
	public Nodo fin=null;

	public boolean estavacia(){
		if(inicio==null){
			return true;
		}
		else
			return false;
		
	}
	public void agregarinicio(String nombre,int dato){
	Nodo nuevo=new Nodo(nombre,dato);
	if(estavacia()){
		inicio=fin=nuevo;
	}
	else
	{
	nuevo.siguiente=inicio;
	inicio=nuevo;

	}
	}

	public void borrarinicio(){
	Nodo aux=new Nodo();
	if(estavacia()){
		System.out.println("la lista no contiene ningun elemento");
		System.out.println(" ");
	}
	else
	{
		if(inicio==fin){
			inicio=fin=null;
		}else
		{
	aux=inicio;
	inicio=inicio.siguiente;
	aux=null;

	}}
	}

	public void agregarfinal(String nombre,int dato)
	{
		Nodo nuevo=new Nodo(nombre,dato);
	if(estavacia())
	{
	inicio=fin=nuevo;
	}
	else
	{
	    fin.siguiente=nuevo;
		nuevo.siguiente=null;
		fin=nuevo;
	}
	}
  
    
	public void mostrar(){

		Nodo actual = inicio;
		if(estavacia())
		{
			System.out.println("la lista esta vacia");
		}
		else
		{  System.out.println("SU LISTA DE CONTACTOS ES :  ");
	    while (actual != null) {
	    	
	        System.out.println(actual.getNombre()+": "+actual.getDato());
	        actual =actual.siguiente;
	    }}
		
	}
	public void borrarfinal()
	{
		Nodo aux=new Nodo();
		Nodo aux2=new Nodo();
	if(estavacia())
	{
	System.out.println("La lista esta vacia");
	}
	else
	{	
		aux=inicio;
		if(inicio==fin){
			inicio=fin=null;
		
		}else{
		while(aux.siguiente!=null){ 
			
		aux2=aux;
		aux=aux.siguiente;
		aux2.siguiente=null;
	}
	}}}
   

	public void Buscar(int numero){
		Nodo aux=new Nodo();
		aux=inicio;
		if(estavacia()){
			System.out.println("lista vacia");
		}
		else{
			while(aux!=null)
			{
			if(aux.dato==numero){
				System.out.println("El contacto:" +" " +numero+ " existe");
				mostrar();
				break;
			}
			else{
				aux=aux.siguiente;
			}

			}
		}
		
	}

}
