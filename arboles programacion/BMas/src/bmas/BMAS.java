package bmas;
public class BMAS{
    class Node{
        
    	public boolean eshoja;/*Determina si una página es hoja o no lo es*/
    	public Object[] objetosarbol = new Object[2 * T - 1]; /*Objetos dentro del árbol B+*/
        public Node[] vectorpaghijas = new Node[2 * T];/*Vector de páginas hijas*/
      
        public Node nodosiguiente;/*Página siguiente para hacer el enlace respectivo*/
        public int numerodeclaves = 0;/*Número de claves permitido*/
        public int[] vectorclaves = new int[2 * T - 1];/*Vector de claves*/
 
    }
    private Node Nodoraiz;/*Página raíz dentro del árbol B+*/
    private static final int T = 512;

    /*
     * Constructor del árbol B+
     */
    public BMAS() {
    	Nodoraiz = new Node();
    	Nodoraiz.eshoja = true;/*La página raíaz es una página hoja*/
    }
    
    /*
     * Método para adicionar un dato (objeto) al árbol B+
     */

    public void añadir(int clave, Object object){
        Node nodoraiz=Nodoraiz;
        if (nodoraiz.numerodeclaves == (2 * T - 1)){
            Node nuevonodoraiz = new Node();
            Nodoraiz= nuevonodoraiz;
            nuevonodoraiz.eshoja = false;
            Nodoraiz.vectorpaghijas[0] = nodoraiz;
            dividirnodohijo(nuevonodoraiz, 0, nodoraiz);
            insertarnodolleno(nuevonodoraiz,clave, object);
        }else{
        	insertarnodolleno(nodoraiz, clave, object);
        }
    }
    
    /*
     * Método para dividir una página cuando se encuentra completa
     */

    
    void dividirnodohijo(Node parentNode, int i, Node node){
        Node nuevonodo = new Node();
        nuevonodo.eshoja = node.eshoja;
        nuevonodo.numerodeclaves = T;
        for (int j = 0; j < T; j++){
        	nuevonodo.vectorclaves[j] = node.vectorclaves[j + T - 1];
        	nuevonodo.objetosarbol[j] = node.objetosarbol[j + T - 1];
        }if (!nuevonodo.eshoja){
            for(int j = 0; j < T + 1; j++){
            	nuevonodo.vectorpaghijas[j] = node.vectorpaghijas[j + T - 1];
            }for(int j = T; j <= node.numerodeclaves; j++){
                node.vectorpaghijas[j] = null;
            }
        }else{
        	nuevonodo.nodosiguiente = node.nodosiguiente;
            node.nodosiguiente = nuevonodo;
        }for(int j = T - 1; j < node.numerodeclaves; j++){
            node.vectorclaves[j] = 0;
            node.objetosarbol[j] = null;
        }
        node.numerodeclaves = T - 1;
        for(int j = parentNode.numerodeclaves; j >= i + 1; j--){
            parentNode.vectorpaghijas[j + 1] = parentNode.vectorpaghijas[j];
        }
        parentNode.vectorpaghijas[i + 1] = nuevonodo;
        for(int j = parentNode.numerodeclaves - 1; j >= i; j--){
            parentNode.vectorclaves[j + 1] = parentNode.vectorclaves[j];
            parentNode.objetosarbol[j + 1] = parentNode.objetosarbol[j];
        }
        parentNode.vectorclaves[i] = nuevonodo.vectorclaves[0];
        parentNode.objetosarbol[i] = nuevonodo.objetosarbol[0];
        parentNode.numerodeclaves++;
    }

    /*
     * Método para insertar un dato en una página no llena
     */
    
    void insertarnodolleno(Node node, int key, Object object){
        int i = node.numerodeclaves - 1;
        if (node.eshoja){
            while (i >= 0 && key < node.vectorclaves[i]){
                node.vectorclaves[i + 1] = node.vectorclaves[i];
                node.objetosarbol[i + 1] = node.objetosarbol[i];
                i--;
            }
            i++;
            node.vectorclaves[i] = key;
            node.objetosarbol[i] = object;
            node.numerodeclaves++;
        }else{
            while(i >= 0 && key < node.vectorclaves[i]){
                i--;
            }
            i++;
            if(node.vectorpaghijas[i].numerodeclaves == (2 * T - 1)){
            	dividirnodohijo(node, i, node.vectorpaghijas[i]);
                if(key > node.vectorclaves[i]){
                    i++;
                }
            }
            insertarnodolleno(node.vectorpaghijas[i], key, object);
        }
    }

    /*
     * Método que hace una búsqueda recursiva de una clave dentro del árbol B+
     */
    
    public Object buscar(Node node, int key){
        int i = 0;
        while (i < node.numerodeclaves && key > node.vectorclaves[i]){
            i++;
        }if(i < node.numerodeclaves && key == node.vectorclaves[i]){
            return node.objetosarbol[i];
        }if (node.eshoja){
            return null;
        }else{
            return buscar(node.vectorpaghijas[i], key);
        }
    }
    
    /*
     * Método para hacer una búsqueda de una clave dentro del árbol B+
     */

    public Object search(int key) {
        return buscar(Nodoraiz, key);
    }

    /*
     * Método de búsqueda de una clave dentro del arból B+ no recursivo
     */
    
    public Object search2(Node node, int key){
        while(node != null){
            int i = 0;
            while(i < node.numerodeclaves && key > node.vectorclaves[i]){
                i++;
            }if(i < node.numerodeclaves && key == node.vectorclaves[i]){
                return node.objetosarbol[i];
            }if(node.eshoja){
                return null;}
            else{
                node = node.vectorpaghijas[i];
            }
        }
        return null;
    }
    
    /*
     * Método que busca un objeto en un árbol B+ según su clave
     */

    public Object search2(int key) {
        return search2(Nodoraiz, key);
    }

    /*
     * Método que implementa la impresión como String del árbol B+
     */
    
    @Override
    public String toString() {
        String string = "";
        Node node = Nodoraiz;
        while (!node.eshoja) {
            node = node.vectorpaghijas[0];
        }
        while (node != null) {
            for (int i = 0; i < node.numerodeclaves; i++) {
                string += node.objetosarbol[i] + ", ";
            }
            node = node.nodosiguiente;
        }
        return string;
    }

    /*
     * Método que imprime un árbol B+ entre dos rangos de claves dados
     */
    
    public String toString(int fromKey, int toKey) {
        String string = "";
        Node node = getclavenodohoja(fromKey);
        while (node != null) {
            for (int j = 0; j < node.numerodeclaves; j++) {
                string += node.objetosarbol[j] + ", ";
                if (node.vectorclaves[j] == toKey) {
                    return string;
                }
            }
            node = node.nodosiguiente;
        }
        return string;
    }
    
    /*
     * Método que obtiene una hoja para una clave dentro del árbol B+
     */

    Node getclavenodohoja(int key) {
        Node node = Nodoraiz;
        while (node != null) {
            int i = 0;
            while (i < node.numerodeclaves && key > node.vectorclaves[i]) {
                i++;
            }
            if (i < node.numerodeclaves && key == node.vectorclaves[i]) {
                node = node.vectorpaghijas[i + 1];
                while (!node.eshoja) {
                    node = node.vectorpaghijas[0];
                }
                return node;
            }
            if (node.eshoja) {
                return null;
            } else {
                node = node.vectorpaghijas[i];
            }
        }
        return null;
    }
    
    
}