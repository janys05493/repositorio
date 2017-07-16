package arbolB;
import java.util.*;

public class ListaB
{
   
    public static ArrayList<Integer> INSERTADOSARRAY;


    public ListaB()
    {
    	INSERTADOSARRAY = new ArrayList<Integer>();
    }
    public boolean buscar(int valor){
        boolean ENCONTRADO= false;
        for (int i = 0; i < INSERTADOSARRAY.size() && !ENCONTRADO; i++){
            if (INSERTADOSARRAY.get(i) == valor){
                 ENCONTRADO = true;
                
            }
        }
        return ENCONTRADO;
        
    }
}