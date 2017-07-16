package Arboles;

//import java.io.*;

public class NODOAVL
{
	
	NODOAVL izquierda;
	NODOAVL derecha;
	int dato;
	int balance;
	NODOAVL padre;
	public NODOAVL()
	{
		this.izquierda = this.derecha= null;
	}
	public NODOAVL (int dato)
	{
		this.dato =dato;
		this.izquierda = this.derecha = null;
	}
	public NODOAVL buscarNodo(int nodito)
	{
		if (nodito == dato)
			return this;
		else if (nodito < dato)
			if (izquierda != null)
				return izquierda.buscarNodo(nodito);
			else
				return null;
		else if (nodito > dato)
			if (derecha != null)
				return derecha.buscarNodo(nodito);
			else
				return null;
		return this;
	}
	public void postorden()
	{
		if(izquierda != null)
			izquierda.postorden();
		if(derecha !=null)
			derecha.postorden();
		System.out.print("\t" + dato);
	}

	public void preorden()
	{
		System.out.print("\t"+ dato);
		if (izquierda != null)
			izquierda.preorden();
		if(derecha != null)
			derecha.preorden();
	}
		public void inorden()
	{
		if (izquierda != null)
			izquierda.inorden();
		System.out.print("\t" + dato);
		if (derecha != null)
			derecha.inorden();
	}
}


