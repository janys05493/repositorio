package lista1;

public class ListaDoble {
	public Nodo inicio=null;
	public Nodo fin=null;
	
	public boolean estavacia()
	{
		if(inicio==null && fin==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void insertarinicio(String nombre,int dato)
	{	Nodo nuevo=new Nodo(nombre,dato);
		if(estavacia())
	{
		inicio=fin=nuevo;
	}	else
	{	nuevo.anterior=null;
		nuevo.siguiente=inicio;
		inicio.anterior=nuevo;
		inicio=nuevo;
		
	}
		
	}
	public void insertarfinal(String nombre,int dato)
	{
		Nodo nuevo=new Nodo(nombre,dato);
		if(estavacia())
		{
			inicio=fin=nuevo;
		}
		else
		{
			nuevo.siguiente=null;
			nuevo.anterior=fin;
			fin.siguiente=nuevo;
			fin=nuevo;
		}
	}
	public void mostrar()
	{	Nodo aux=inicio;
		if(estavacia())
		{
			System.out.println("la lista esta vacia");
		}
		else
		{ System.out.println("SU LISTA DE CONTACTOS ES :  ");
			while(aux!=null)
			{
				System.out.println(aux.getNombre()+": "+aux.getDato());
				aux=aux.siguiente;
			}
			
		}
	}
	public void eliminarinicio()
	{	Nodo actual=new Nodo();
		if(estavacia())
		{
			System.out.println("La lista esta vacia");
		}
		else
			if(inicio==fin){
				inicio=fin=null;
			}else
			{
		{	actual.anterior=null;
			actual.siguiente=inicio;
			inicio.anterior=actual;
			inicio=inicio.siguiente;
			inicio.anterior=null;
		}
		}
	}
	public void eliminarfinal()
	{	Nodo aux=new Nodo();
		Nodo aux2=new Nodo();
		if(estavacia())
		{
			System.out.println("la lista esta vacia");
		}
		else
		{	aux=inicio;
			if(inicio==fin){
			inicio=fin=null;
						   }
				else
					{
					while(aux.siguiente!=null)
					{
						aux2=aux;
						aux=aux.siguiente;
						aux2.siguiente=null;
					}
					}
		}
	}
	public void invertirlista()
	{Nodo primero=new Nodo();
	primero=fin;
		if(estavacia())
		{
		System.out.println("la lista esta vacia");
		}
		else
		{ System.out.println("SU LISTA DE CONTACTOS INVERTIDA ES :  ");
			while(primero!=null)
		{
			System.out.println(primero.getNombre()+": "+primero.getDato());
			primero=primero.anterior;
		}
		}
	}
}
