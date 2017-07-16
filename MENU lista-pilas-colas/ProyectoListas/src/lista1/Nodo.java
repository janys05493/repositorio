package lista1;

public class Nodo {
	public String nombre;
	public int dato;
	public Nodo siguiente;
    public Nodo anterior;
    
	public Nodo(String nombre,int dato){
		this.nombre=nombre;
		this.dato=dato;
		this.siguiente=null;
		this.anterior=null;
       
	}
	public Nodo(){}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDato(int dato)
	{
		this.dato=dato;
	}
	public int getDato()
	{
		return dato;
	}
}
