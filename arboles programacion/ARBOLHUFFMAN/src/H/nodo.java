package H;



class nodo extends arbolhuffman {
    public final arbolhuffman izquierda, derecha;
 
    public nodo(arbolhuffman J, arbolhuffman L) {
        super(J.frecuencia + L.frecuencia);
        izquierda = J;
        derecha = L;
    }
}