package colas;

public class Nodo {
public String nombre;	
public int numero;
public Nodo siguiente;

public Nodo(String nombre,int numero)
{	this.nombre=nombre;
	this.numero=numero;
	this.siguiente=null;
}
public Nodo(){}//sirve para instanciar(crear objetos vacios
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}

}
