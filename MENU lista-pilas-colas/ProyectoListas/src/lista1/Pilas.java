package lista1;

public class Pilas {

	public Nodo cima=null;
	public boolean estavacia()
	{
		if(cima==null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void insertarpila(String nombre,int dato)
	{Nodo nuevo=new Nodo(nombre, dato);
		if(estavacia())
		{
			nuevo.siguiente=cima;
			cima=nuevo;
			
		}
		else
		{
			nuevo.siguiente=cima;
			cima=nuevo;
		}
		}
	public void mostrar()
	{
	Nodo aux=cima;
	if(estavacia())
	{
		System.out.println("la pila esta vacia");
	}
	else
	{
		while(aux!=null)
		{
			System.out.println(aux.getNombre()+": "+aux.getDato());
			aux=aux.siguiente;
			
		}
	}
	}
	public void borrar()
	{ Nodo aux=new Nodo();
		if(estavacia())
		{
			System.out.println("esta vacia");
		}
		else
		{
			aux=cima;
			cima=cima.siguiente;
			aux=null;
			
		}
	}
	public void destruir(){
		if(estavacia()){
			System.out.println("esta vacia");
		}
		else
		{
			
			Nodo aux2=new Nodo();
		
			while(cima!=null)
			{
			aux2=cima;
			cima=aux2.siguiente;
			cima=null;
			}
		}
	}
}
