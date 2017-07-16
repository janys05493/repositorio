package H;



import java.util.*;

public class Huffman {
	  public static arbolhuffman construirarbol(int[] charF) {
	    	
		    
	        PriorityQueue<arbolhuffman> arboles = new PriorityQueue<arbolhuffman>();
	     
	        for (int i = 0; i < charF.length; i++){
	            if (charF[i] > 0)
	            	arboles.offer(new hoja(charF[i], (char)i)); 
	        }
	       
	        
	        while (arboles.size() > 1) {
	        
	            arbolhuffman a = arboles.poll(); 
	            arbolhuffman b = arboles.poll(); 
	 
	      
	            arboles.offer(new nodo(a, b)); 
	        }
	       
	        return arboles.poll();
	    }
	 
	   
	    public static String codificar(arbolhuffman arbol1, String codificar1){
	    	assert arbol1 != null;
	    	
	    	String codificarText = "";
	        for (char c : codificar1.toCharArray()){
	        	codificarText+=(getCodigos(arbol1, new StringBuffer(),c));
	        }
	    	return codificarText; 
	    }
	    
	    

	    
	    public static String descodificar(arbolhuffman arbol2, String codificar2) {
	    	assert arbol2 != null;
	    	
	    	String descodificarText="";
	    	nodo node = (nodo)arbol2;
	    	for (char code : codificar2.toCharArray()){
	    		if (code == '0'){ 
	    		    if (node.izquierda instanceof hoja) { 
	    		    	descodificarText += ((hoja)node.izquierda).valor;  
		                node = (nodo)arbol2;
		    		}else{
		    			node = (nodo) node.izquierda; 
		    		}
	    		}else if (code == '1'){ 
	    		    if (node.derecha instanceof hoja) {
	    		    	descodificarText += ((hoja)node.derecha).valor; 
		                node = (nodo)arbol2; 
		    		}else{
		    			node = (nodo) node.derecha; 
		    		}
	    		}
	    	} // End for
	    	return descodificarText; 
	    }    
	    
	   
	    public static void printCodes(arbolhuffman tree, StringBuffer prefix) {
	        assert tree != null;
	        
	        if (tree instanceof hoja) {
	            hoja leaf = (hoja)tree;
	            
	            
	            System.out.println(leaf.valor + "\t" + leaf.frecuencia + "\t\t" + prefix);
	 
	        } else if (tree instanceof nodo) {
	            nodo node = (nodo)tree;
	 
	      
	            prefix.append('0');
	            printCodes(node.izquierda, prefix);
	            prefix.deleteCharAt(prefix.length()-1);
	 
	          
	            prefix.append('1');
	            printCodes(node.derecha, prefix);
	            prefix.deleteCharAt(prefix.length()-1);
	        }
	    }
	    
	  
	    public static String getCodigos(arbolhuffman arbolito, StringBuffer prefijo, char w) {
	        assert arbolito != null;
	        
	        if (arbolito instanceof hoja) {
	            hoja izq = (hoja)arbolito;
	            
	          
	            if (izq.valor == w ){
	            	return prefijo.toString();
	            }
	            
	        } else if (arbolito instanceof nodo) {
	            nodo node = (nodo)arbolito;
	 
	        
	            prefijo.append('0');
	            String izquierdita = getCodigos(node.izquierda, prefijo, w);
	            prefijo.deleteCharAt(prefijo.length()-1);
	 
	          
	            prefijo.append('1');
	            String derechita = getCodigos(node.derecha, prefijo,w);
	            prefijo.deleteCharAt(prefijo.length()-1);
	            
	            if (izquierdita==null) return derechita; else return izquierdita;
	        }
			return null;
	    }

	}
