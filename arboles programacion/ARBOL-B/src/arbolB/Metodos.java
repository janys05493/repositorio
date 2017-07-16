package arbolB;
import java.util.*;

public class Metodos
{
	public static boolean RAIZ;
	public static int ORDEN;
	public static int MOSTRANDO = 1;
    
	public static String TREE = "";
    public NodoB NUEVO;
    public static int LEVEL = 1;
    
    public Metodos(int orden)
    {
        this.ORDEN = orden;
        NUEVO = new NodoB ();
        ListaB llevarIngresos = new ListaB();
        RAIZ = true;
    }
    public void INGRESAR1 (int valor) {
        int x=0;
        int y=2;
    	if (NUEVO.CONHIJOS==false) {
            int aux = 0;
            for (int i = 0; i<NUEVO.NUMEROS.length; i++) {
                if (NUEVO.NUMEROS[i] == x) {
                	NUEVO.NUMEROS[i] = valor;
                    ListaB.INSERTADOSARRAY.add(valor);
                    aux = i;
                    ORGANIZAR(NUEVO.NUMEROS,6);
                    break;
                }
            }
            if (aux == y*ORDEN) {
            	DIVIDIR(NUEVO);
            }
        } else {
        	NHIJOS(NUEVO);
        	IHIJOS(NUEVO, valor);
            
        }
    }
      public void ORGANIZAR(int arreglo[], int longi){
       longi = 0;
       for(int i = 0; i < arreglo.length; i++){
           if(arreglo[i] != 0){
               longi++;
            }else{
            break;
            }
        }
             for(int A = 0; A < longi; A++){
            for(int B = 0; B < longi - 1 ; B++){
             if(arreglo[B] > arreglo[B + 1]){
                        int tmp = arreglo[B];
                        arreglo[B] = arreglo[B+1];
                        arreglo[B+1] = tmp;
                      
              }
           }
       }
    }
    public void  NHIJOS(NodoB L) {
        if (L == NUEVO) {
            if (NUEVO.NODO[0]!= null) {
            	NUEVO.CONHIJOS = true;
            } 
        }
        for (int i = 0; i<L.NODO.length; i++) {
            if (L.NODO[i] != null) {
                L.CONHIJOS = true;
                NHIJOS(L.NODO[i]);
            }
        }
    }
    public void IHIJOS(NodoB TIENEHIJOS, int valor) {
        boolean INGR = false;
        if(TIENEHIJOS != null && !TIENEHIJOS.CONHIJOS){
        	COLOCARVALOR(TIENEHIJOS, valor);
        	INGR = true;
        }
        for(int i = 0; TIENEHIJOS != null && i < 2*ORDEN + 1  && !INGR; i++){
            if(valor < TIENEHIJOS.NUMEROS[i] || TIENEHIJOS.NUMEROS[i] == 0){
            	INGR = true;
                IHIJOS(TIENEHIJOS.NODO[i], valor);
                i = 2*ORDEN;
            }
        } 
    }
    public void COLOCARVALOR(NodoB NODITO, int valor){
        int C = 0;
        while(C <= 2*ORDEN){
            if (NODITO.NUMEROS[C]==0) { 
            	NODITO.NUMEROS[C]=valor;
                ORGANIZAR(NODITO.NUMEROS, 5);
                ListaB.INSERTADOSARRAY.add(valor);
                if (C == 2*ORDEN) {
                	DIVIDIR(NODITO);
                }
                break;
            }
            C++;
        }
    }
     public void ACOMODARn(NodoB ORD){
       int i,j;
       i = 0;
       NodoB tmp;
       
       while(i < 2 * ORDEN + 3 && ORD.NODO[i] != null){
           j = 0;
           while(j < 2 * ORDEN +2  && ORD.NODO[j] != null && ORD.NODO[j+1] != null){
               if(ORD.NODO[j].NUMEROS[0] > ORD.NODO[j+1].NUMEROS[0] ){
                   tmp = ORD.NODO[j];
                   ORD.NODO[j] = ORD.NODO[j+1];
                   ORD.NODO[j+1] = tmp;
                }
                j++;
            }
            i++;
        }   
    }
    public void DIVIDIR (NodoB J) {
    	NodoB HI,HD;
        HI = new NodoB();
        HD = new NodoB();
        
        //split general 
        if (J.NODO[0]!=null) {
            for (int i = 0; i <ORDEN+1; i++) { 
                HI.NODO[i] = J.NODO[i];
                HI.NODO[i].PADRE = HI;
                J.NODO[i] = null;
                HD.NODO[i] = J.NODO[ORDEN+1+i];
                HD.NODO[i].PADRE = HD;
                J.NODO[ORDEN+1+i] = null;
            }
        }

        for (int i =0; i<ORDEN; i++){
            HI.NUMEROS[i] = J.NUMEROS[i];
            J.NUMEROS[i] = 0;
            HD.NUMEROS[i] = J.NUMEROS[ORDEN+1+i];
            J.NUMEROS[ORDEN+1+i] = 0;
        }
        J.NUMEROS[0] = J.NUMEROS[ORDEN];
        J.NUMEROS[ORDEN] = 0; 
        
        J.NODO[0] = HI; 
        J.NODO[0].PADRE = J; 
        J.NODO[1] = HD; 
        J.NODO[1].PADRE = J;         
        NHIJOS(NUEVO);
        ACOMODARn(J);
        

        if (J.PADRE!=null) { 
            boolean subido = false;
            for (int i = 0; i<J.PADRE.NUMEROS.length && subido==false; i++) {
                if (J.PADRE.NUMEROS[i] == 0) {
                    J.PADRE.NUMEROS[i] = J.NUMEROS[0];
                    subido = true;
                    J.NUMEROS[0] = 0;
                    ORGANIZAR(J.PADRE.NUMEROS, 5);
                }
            }
            int posHijos = 0;
            for (int i = 0; i<2*ORDEN+3 ; i++) {
                if (J.PADRE.NODO[i]!=null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            J.PADRE.NODO[posHijos] = J.NODO[0];
            J.PADRE.NODO[posHijos+1] = J.NODO[1];
            J.PADRE.NODO[posHijos].PADRE = J.PADRE;
            J.PADRE.NODO[posHijos+1].PADRE = J.PADRE;
            int aqui = 0;
            for (int i =0; i<2*ORDEN+3 && J.PADRE.NODO[i]!=null; i++) {
                if (J.PADRE.NODO[i].NUMEROS[0] == J.NUMEROS[0]) {
                    aqui = i;
                    break;
                }
            }
            NodoB papa = J.PADRE;
            J = null;
            int j = aqui;
            while (j<2*ORDEN+2 && papa.NODO[j]!=null && papa.NODO[j+1]!=null) {
                papa.NODO[j] = papa.NODO[j+1];
                j++;
            }
            papa.NODO[j] = null;
            ORGANIZAR(papa.NUMEROS,5);
            ACOMODARn(papa);
            if (papa.NUMEROS[2*ORDEN]!=0) {
            	DIVIDIR(papa);
            }
        }
    }
    public boolean COMPROBARENTERO(String NUMERO){
        try{
           Integer.parseInt(NUMERO);
           return true;
        }catch(NumberFormatException e){
            return false;
        }
        }
        
       public void BORRAR(int valor) { 
        boolean SIESTA = false;
        int j = 0;
        for (int i=0; i<ListaB.INSERTADOSARRAY.size() && !SIESTA; i++) {
            if (ListaB.INSERTADOSARRAY.get(i) == valor) {
            	SIESTA = true;
                j = i;
            }
        }
        if (SIESTA==true) {
            ListaB.INSERTADOSARRAY.remove(j);
        } else {
            System.out.println("El valor a eliminar no se encuentra en el arbol B");
        }
        ArrayList<Integer> auxiliar = ListaB.INSERTADOSARRAY;
        ListaB.INSERTADOSARRAY = new ArrayList<Integer>();
        NUEVO = new NodoB();
        NUEVO.CONHIJOS = false;
        for(int k = 0; k < auxiliar.size(); k++){
            Integer y = auxiliar.get(k);
            int o = y.intValue();
            INGRESAR1(o);
        }
    }
   
    public String REC(NodoB nodo) {
        int n=1;
    	TREE += "  ";
        for (int i =0; i<2*ORDEN+1; i++) {
            if (nodo.NODO[i] != null) {
                if (i == 0) {
                    LEVEL++;
                    MOSTRANDO = n;
                } else {
                	MOSTRANDO ++;
                }
                REC(nodo.NODO[i]);
            }
            
            for (int j = 0; nodo.NODO[i]!=null && j<nodo.NODO[i].NUMEROS.length; j++) {
                if (nodo.NODO[i].NUMEROS[j] != 0) {
                	TREE += "[ ";
                	TREE += nodo.NODO[i].NUMEROS[j] + " ";
                	TREE += "] ";
                }
            }
           
        }
        if (TREE.length() > (2*ORDEN+3)*4) {
            System.out.println (TREE);
            return TREE;
        }
        return TREE;
    }
    public String IMPRIMIR() {
        String mostrar = REC(NUEVO);
        LEVEL = 1;
        MOSTRANDO = 1;
        return TREE;
    }
    public boolean BUSCARNUMERO(int N){
        boolean esta = false;
        for(int i = 0; i < ListaB.INSERTADOSARRAY.size() && !esta; i++){
            if(ListaB.INSERTADOSARRAY.get(i) == N){
                esta = true;
                System.out.println("El elemento buscado si se encuentra en el arbol B");
                return esta;
            }
        }
        System.out.println("El elemento buscado no se encuentra en el arbol B");
        return false;
    }
  
}
