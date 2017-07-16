package bmas;

public class AVL{
    
    /*
     * Construimos el �rbol AVL
     */
    public AVL( ){
            raiz = null;
        }
    
    /*
     * M�todo que permite la inserci�n de un String
     */
    
    public void insertar( String x ){
        raiz = insertando( x, raiz );
    }
    
    /*
     * M�todo que encuentra el menor dato contenido en el �rbol ABVL
     */
    public Comparable encontrarminimo( ){
        return Eelemento( encontrandoelmenor( raiz ) );
    }
    
    /*
     * M�todo que encuentra el mayor dato contenido en el �rbol AVL
     */
    public Comparable encontrarmaximo( ){
        return Eelemento( encontrandoelmayor( raiz ) );
    }
    
    /*
     * M�todo que busca un dato en el �rbol AVL
     */
    public Comparable encontrar( String x ){
        return Eelemento( encuentra( x, raiz ) );
    }
    
    /*
     * M�todo que hace vac�o el �rbol AVL
     */
    public void haciendovacio( ){
            raiz = null;
    }
    
    /*
     * M�todo que verifica si el �rbol AVL est� vac�o
     */
    public boolean estavacio( ){
        return raiz == null;
    }
    
    /*
     * M�todo que imprime el �rbol AVL en orden
     */
    public void imprimiendoarbol( ){
        if( estavacio( ) ) {
                System.out.println( "El �rbol AVL est� vac�o" );
        }
        else {
            imprimirarbol( raiz );
        }
    }
    
    /*
     * M�todo que permite obtener el dato contenido en un nodo del �rbol AVL
     */
    
    private String Eelemento( Nodo t ){
        return t == null ? null : t.Elemento;
    }
    
    /*
     * M�todo para insertar un dato en un �rbol AVL
     */
    
    public Nodo insertando( String x, Nodo t ){
            if( t == null ) {
                t = new Nodo( x, null, null );
            }
            else if( x.compareTo(t.Elemento) < 0 )
            {
                t.izquierdo = insertando( x, t.izquierdo );
                if( altura( t.izquierdo ) - altura( t.derecho ) == 2 ) {
                    if( x.compareTo(t.izquierdo.Elemento) < 0 ) {
                        t = rotarizq( t );
                    }
                    else {
                        t = doblerotacionizquierda( t );
                    }
                }
            }
            else if( x.compareTo(t.Elemento) > 0 )
            {
                t.derecho = insertando( x, t.derecho );
                if( altura( t.derecho ) - altura( t.izquierdo ) == 2 ) {
                    if( x.compareTo(t.derecho.Elemento) > 0 ) {
                        t = rotarderech( t );
                    }
                    else {
                        t = doblerotacionderecha( t );
                    }
                }
            }
            else
                ;  // Si hay un elemento repetido no hacemos nada
            t.height = max( altura( t.izquierdo ), altura( t.derecho ) ) + 1;
            return t;
        }
    
    /*
     * M�todo que obtiene el nodo con el menor dato contenido en el �rbol AVL
     */
    
    private Nodo encontrandoelmenor( Nodo t ){
            if( t == null ) {
                return t;
            }
            while( t.izquierdo != null ) {
                t = t.izquierdo;
            }
            return t;
        }
    
    /*
     * M�todo que obtiene el nodo con el mayor dato contenido en el �rbol AVL
     */
    
    private Nodo encontrandoelmayor( Nodo t ){
            if( t == null ) {
                return t;
            }
            while( t.derecho != null ) {
                t = t.derecho;
            }
            return t;
        }
    
    /*
     * M�todo que obtiene el nodo cuyo dato es el buscado o null si no est� en el �rbol AVL
     */
    
    public Nodo encuentra( String x, Nodo t ){ /****/
            while( t != null ) {
                if( x.compareTo( t.Elemento ) < 0 ) {
                    t = t.izquierdo;
                }
                else if( x.compareTo( t.Elemento ) > 0 ) {
                    t = t.derecho;
                }
                else {
                    return t;
                }
            }    // Aqu� hubo una coincidencia

            return null;   // No se encontr� coincidencia alguna
        }
    
    /*
     * M�todo que imprime un �rbol AVL de forma ordenada
     */
    private void imprimirarbol( Nodo t ){            
            if( t != null ){
           imprimirarbol( t.izquierdo );
                System.out.println( t.Elemento + t.listaOcurrencias); /****/
              imprimirarbol( t.derecho );
            }
    }
    
    /*
     * M�todo que retorna la altura de un �rbol AVL
     */
    
    private static int altura( Nodo t ){
            return t == null ? -1 : t.height;
        }
    /*
     * M�todo que retorna el m�ximo entre dos enteros dados
     */
    
    private static int max( int lhs, int rhs ){
            return lhs > rhs ? lhs : rhs;
        }
    
    /*
     * M�todo que genera una rotaci�n simple (Caso No 1)
     */
    
    private static Nodo rotarizq( Nodo k2 ){
        Nodo k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.height = max( altura( k2.izquierdo ), altura( k2.derecho ) ) + 1;
        k1.height = max( altura( k1.izquierdo ), k2.height ) + 1;
        return k1;
    }
    
    /*
     * M�todo que genera una roraci�n simple (Caso No 4)
     */
    
    private static Nodo rotarderech( Nodo k1 ){
        Nodo k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.height = max( altura( k1.izquierdo ), altura( k1.derecho ) ) + 1;
        k2.height = max( altura( k2.derecho ), k1.height ) + 1;
        return k2;
    }
    
    /*
     * M�todo que genera una doble rotaci�n (Caso No 2)
     */
    
    private static Nodo doblerotacionizquierda( Nodo k3 ){
        k3.izquierdo = rotarderech( k3.izquierdo );
        return rotarizq( k3 );
    }
    
    /*
     * M�todo que genera una doble rotaci�n (Caso No 3)
     */
    private static Nodo doblerotacionderecha( Nodo k1 ){
        k1.derecho = rotarizq( k1.derecho );
        return rotarderech( k1 );
    }
    
    /** La ra�z de nuestro �rbol AVL**/
    public Nodo raiz;
}