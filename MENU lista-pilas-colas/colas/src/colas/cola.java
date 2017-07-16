package colas;

public class cola {
public Nodo frente=null;
public Nodo fin=null;
public boolean estavacia()
{
	if(frente==null)
	{
		return true;
	}
	else
	{
		return false;
	}
}
public void insertarcola(String nombre,int numero)
{
	Nodo nuevo=new Nodo(nombre, numero);
	if(estavacia())
	{
	frente=fin=nuevo;	
	}
	else
	{	
		fin.siguiente=nuevo;
		fin=nuevo;
	}
}

public void borrarcola()
{
	Nodo aux=new Nodo();
	aux=frente;
	if(estavacia()){
	System.out.println("la cola esta vacia");
					}
	else
	{	if(frente==fin)
		{
		frente=fin=null;
		}
			else
			{	aux=frente;
				frente=frente.siguiente;
				aux=null;
				
				
				}
			}
		}
public void destruircola()
{
	if(estavacia())
	{
		System.out.println("la cola esta vacia");
	}
	else
	{
		Nodo destruir=new Nodo();
		
		while(frente!=null)
		{
			destruir=frente;
			frente=destruir.siguiente;
			frente=null;
		}
	}
}

public void mostrar()
{Nodo nuevo= new Nodo();
		nuevo=frente;
	if(estavacia())
	{
		System.out.println("la cola esta vacia");
	}
	else
	{
		while(nuevo!=null)
		{
			System.out.print(nuevo.getNombre()+": "+nuevo.getNumero()+"  ");
			nuevo=nuevo.siguiente;
		}
	}
}}
