package lista4;

public class Nodo {
public String nombre;	
public int dato;
public Nodo anterior;
public Nodo siguiente;
 
public Nodo(String nombre,int dato)
{
this.nombre=nombre;	
this.dato=dato;
this.anterior=null;
this.siguiente=null;
}
public Nodo(){}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getDato() {
	return dato;
}
public void setDato(int dato) {
	this.dato = dato;
}

}
