package arbolB;

public class NodoB {
	int n=2;
	public int []NUMEROS;
	public NodoB PADRE;
	int y=1;
    public int ocupados = 0;
    public NodoB []NODO;
    int x=3;
    public static int numValores;
    public boolean CONHIJOS = false;
    
    public NodoB(){
       NODO = new NodoB [Metodos.ORDEN *n + x];
       NUMEROS = new int [Metodos.ORDEN *n + y];
}
}
