package arbol;
public class Arbol 
{
	public Nodo raiz;
    public int Nnodos;
   
 
    public Arbol() {
        raiz = null;
        Nnodos = 0;
      
    }
 
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux!=null) {
            if (dato==aux.getDato())
                return true;
            else
                if (dato>aux.getDato())
                    aux=aux.getDerecho();
                else
                    aux=aux.getIzquierdo();
        }
        return false;
    }
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(int dato){
       if(existe(dato))return;
       Nodo nuevo = new Nodo(dato);
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null;
              Nodo tmp = raiz;
              while (tmp != null)
              {
                  anterior = tmp;
                  if (dato < tmp.getDato())
                      tmp = tmp.getIzquierdo();
                  else
                      tmp = tmp.getDerecho();
              }
              if (dato < anterior.getDato())
                  anterior.setIzquierdo(nuevo);
              else
                  anterior.setDerecho(nuevo);
          }
          Nnodos++;
    }
 
    public Nodo getRaiz() {
        return raiz;
    }
 
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
 
    public int getNumNodos() {
        return Nnodos;
    }
 
    //Recorrido preorden, recibe el nodo a empezar (raiz)
    public void preorden(Nodo aux){
          if (aux != null)
          {
           
        	  System.out.print(aux.getDato()+" ");
        	  preorden(aux.getIzquierdo());
  			  preorden(aux.getDerecho());
          }
    }
    //Recorrido inorden, recibe el nodo a empezar (raiz)
    public void inorden(Nodo aux){
          if (aux != null)
          {
              inorden (aux.getIzquierdo());
              System.out.print(aux.getDato()+" ");
              inorden (aux.getDerecho());
          }
    }
    //Recorrido postorden, recibe el nodo a empezar (raiz) 
    public void postorden(Nodo aux){
          if (aux != null)
          {
              postorden (aux.getIzquierdo());
              postorden (aux.getDerecho());
              System.out.print(aux.getDato()+" ");
          }
    }
    public boolean vacio()
    {
    	if(raiz==null)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
 



    
    public boolean esNumero(String s){
        try{
           Integer.parseInt(s);
           return true;
        }catch(NumberFormatException e){
            return false;
        }
        }
        
}

