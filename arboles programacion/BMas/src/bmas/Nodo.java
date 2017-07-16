package bmas;

public class Nodo {
	
	    /* Constructor de un nodo AVL*/
	        public Nodo( String elemento ){
	            this( elemento, null, null );
	        }

	        public Nodo( String elemento, Nodo lt, Nodo rt ){
	            Elemento  = elemento;
	            izquierdo     = lt;
	            derecho    = rt;
	            height   = 0;
	        }
	        public String listaOcurrencias = ""; /*Lista de ocurrencias*/
	        public String Elemento; /*Dato en el nodo*/
	        public Nodo izquierdo;   /*Hijo izquierdo*/
	        public Nodo derecho;  /*Hijo derecho*/
	        public int height;     /*Altura del árbol AVL*/
	}

