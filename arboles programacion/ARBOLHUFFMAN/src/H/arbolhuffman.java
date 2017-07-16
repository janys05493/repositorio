package H;

abstract class arbolhuffman implements Comparable<arbolhuffman> {
    public final int frecuencia;
    //
    public arbolhuffman(int freq) { 
    	frecuencia = freq; 
    }
    
    
    public int compareTo(arbolhuffman tree) {
        return frecuencia - tree.frecuencia;
    }
}