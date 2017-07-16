package arbol;

public class Nodo
{
public int dato;
public Nodo izquierdo;
public Nodo derecho;

public Nodo(int dato)
{
	this.dato=dato;
	this.izquierdo=null;
	this.derecho=null;
	
}
public Nodo(){}
public int getDato() {
	return dato;
}
public void setDato(int dato) {
	this.dato = dato;
}
public Nodo getIzquierdo() {
	return izquierdo;
}
public void setIzquierdo(Nodo izquierdo) {
	this.izquierdo = izquierdo;
}
public Nodo getDerecho() {
	return derecho;
}
public void setDerecho(Nodo derecho) {
	this.derecho = derecho;
}

}
