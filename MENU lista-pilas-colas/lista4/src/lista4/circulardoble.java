package lista4;

public class circulardoble {
public Nodo inicio=null;
public Nodo fin=null;
public boolean estavacia()
{if(inicio==null)
{
	return true;
}
else
{
	return false;
}
}
public void insertarinicio(String nombre,int dato)
{Nodo nuevo=new Nodo(nombre,dato);
	if(estavacia())
	{
	inicio=fin=nuevo;	
	fin.siguiente=nuevo;
	inicio.anterior=nuevo;
	}else
	{	nuevo.siguiente=inicio;
		inicio.anterior=nuevo;
		inicio=nuevo;
		fin.siguiente=inicio;
		
	}
}
public void insertarfinal(String nombre,int dato){
	
	Nodo nuevo=new Nodo(nombre,dato);
	if(estavacia()){
		inicio=fin=nuevo;	
		fin.siguiente=nuevo;
		inicio.anterior=fin;
	}
	else
	{
	nuevo.anterior=fin;
	fin.siguiente=nuevo;
	inicio.anterior=nuevo;
	nuevo.siguiente=inicio;
	fin=nuevo;
	}
}
public void mostrar()
{Nodo actual=new Nodo();
actual=inicio;
if(estavacia())
{
	System.out.println("la lista esta vacia");
	
}
else
{
	 boolean continuar=true;
		while(continuar)
		{
			System.out.print(actual.getDato()+"-->");
			if(actual==fin)
			{
				continuar=false;
			}
			actual=actual.siguiente;
		}
		}
}
public void borrarinicio(){
	Nodo aux=new Nodo();
	if(estavacia()){
		System.out.println("la lista esta vacia");
	}
	else 
	{if(inicio==fin){
		inicio=fin=null;
	}else{
		aux=inicio;
		inicio=inicio.siguiente;
		fin.siguiente=inicio;
		aux=null;
	}}
}
public void borrarfinal()
{
	Nodo aux=inicio;
	Nodo aux2;
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
		{
		boolean continuar=true;
		while(continuar)
		{
		if(aux.siguiente==fin){

			/*aux2=aux;
			aux.siguiente=null;
			fin=aux2;
			continuar=false;
			
		
		fin.siguiente=inicio;
	*/
			//forma dos de eliminar las dos funcionan
			aux2=fin;
			fin=aux;
			inicio.anterior=fin;
			fin.siguiente=inicio;
			aux2=null;
			continuar=false;
			
		}
		else{
			aux=aux.siguiente;
		}
		}
		}
	}
}

}

