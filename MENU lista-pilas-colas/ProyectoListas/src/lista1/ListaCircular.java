package lista1;

public class ListaCircular {
	public Nodo inicio=null;
	public Nodo fin=null;

	public boolean estavacia()
	{
		if(inicio==null)
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
			fin.siguiente=nuevo;
		}
		else
		{
			fin.siguiente=nuevo;
			nuevo.siguiente=inicio;
			inicio=nuevo;
			
		}
	}
	public void insertarfin(String nombre,int dato)
	{Nodo nuevo=new Nodo(nombre,dato);
	
	if(estavacia())
	{
		inicio=fin=nuevo;
		fin.siguiente=nuevo;
	}
	else
	{
		fin.siguiente=nuevo;
		nuevo.siguiente=inicio;
		fin=nuevo;
	}
	}
	public void mostrar()
	{Nodo aux=new Nodo();
	aux=inicio;
	if(estavacia())
	{
		System.out.println("la lista esta vacia");
	}
	else
	{   boolean continuar=true;
		while(continuar)
		{
			System.out.println(aux.getNombre()+": "+aux.getDato());
			
			if(aux==fin)
			{
				continuar=false;
			}
			aux=aux.siguiente;
		}
		}}
	public void eliminarinicio()
	{Nodo temporal=new Nodo();
	
		if(estavacia())
		{
			System.out.println("la lista esta vacia");
		}
		else
		{
			if(inicio==fin){
				inicio=fin=null;
			}
			else
			{ temporal=inicio;
			  inicio=inicio.siguiente;
			  fin.siguiente=inicio;
			  temporal=null;
				
			}
		}
	}
	public void eliminarfinal()
	{
		Nodo temporal=new Nodo();
		
		if(estavacia())
		{
			System.out.println("la lista esta vacia");
		}
		else
		{
			if(inicio==fin){
				inicio=fin=null;
			}
			else{
				boolean continuar=true;
				temporal=inicio;
				while(continuar)
				{
				if(temporal.siguiente==fin)
				{Nodo aux=fin;
				fin=temporal;
				fin.siguiente=inicio;
				aux=null;
				continuar=false;
				}
				else
				{
					temporal=temporal.siguiente;
				}
				}
			}
	}
	}

}
