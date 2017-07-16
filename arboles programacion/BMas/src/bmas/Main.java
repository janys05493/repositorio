package bmas;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Clase Auxiliar que contiene un m�todo auxiliar que permite
 * retornar el numero de letra de una letra dentro del alfabeto
 * 
 * Se asumi� un alfabeto castellano compuesto por 27 letras
 */

class Auxiliar{
    public static int letra2Num(String palabra){
        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
        "r","s","t","u","v","w","x","y","z"};
        LinkedList<String> lista = new LinkedList<String>();//tiene cabeza y cola es como una lista doblemente enlazada
        lista.addAll(Arrays.asList(alfabeto));//convierte un arreglo en una lista
        return lista.indexOf(palabra.charAt(0)+"");/*Retorna el �ndice dentro de la lista alfab�tica*/
    }
}
//lo que hace este programa es imprimir un arreglo y contar la pocicion de cada cadena 
public class Main {
    /** He aqu� el programa principal*/
    public static void main( String [ ] args ) throws FileNotFoundException, IOException{
        AVL t = new AVL( ); /*Creamos un �rbol AVL*/
        AVL s = new AVL(); /*Este es un �rbol AVL auxiliar*/
        RandomAccessFile raf = new RandomAccessFile("lemario.txt","r"); /*ramdon me permite escribir y leer de un fichero*/
        String linea; /*Creamos una l�nea vac�a*/
        long i = 0; /*Variable que indica el n�mero de l�nea*/
        while((linea=raf.readLine())!=null){
            s.insertar(linea);/*Insertamos cada l�nea en el �rbol AVL auxiliar*/
            Nodo qq = s.encuentra(linea,s.raiz);
            if(qq!=null){
                qq.listaOcurrencias = qq.listaOcurrencias + "," + i;
            }
            i++;/*Avanzamos dentro del contador de l�neas*/
            raf.getFilePointer();/*Actualizamos el puntero dentro del fichero de acceso aleatorio*/
        }
        raf.close();/*Cerramos el flujo de lectura desde el archivo*/
        System.out.println("Parte a. de la pr�ctica. El archivo contiene: " + i + " palabras");
        System.out.println("**************************************");
        s.imprimiendoarbol();/*Imprimimos el �rbol AVL obtenido*/
        /*He aqu� la parte b de la pr�ctica requerida*/
        System.out.println("***************************************");
        BMAS arbol = new BMAS(); /*Creamos un nuevo �rbol B+*/
        Scanner sc = new Scanner(new FileInputStream("diccionario.txt"));/*Fichero de lectura (diccionario)*/
        String line;/* Creamos una l�nea vac�a*/
        /*Definimos un alfabeto castellano compuesto por 27 letras*/
        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
        "r","s","t","u","v","w","x","y","z"};
        /*Vector de conteo que permite registrar la primera ocurrencia de una palabra que comienza
         * con una determinada letra del alfabeto usado (compuesto por 27 letras �nicamente).
         */
        int[] conteo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int j = 0;/*Variable auxiliar para el conteo de l�neas dentro del archivo*/
        while (sc.hasNextLine()){ /*Leemos dentro del archivo diccionario.txt*/
            line = sc.nextLine();
            arbol.a�adir(j, (String) line);/*A�adimos cada l�nea al �rbol B+ respectivo*/
            int w = 0;/*Variable auxiliar que permite realizar un conteo*/
            for(String aux:alfabeto){/*Determinamos d�nde es la primera ocurrencia de una palabra con determinada inicial*/
                if(line.startsWith(aux) && conteo[w] == 0){
                    conteo[w] = j;
                }
                w++;/*Actualizamos el contador interno auxiliar*/
            }
            j++;/*Variable que cuenta el n�mero de l�nea donde est� una palabra*/
        }
        sc.close();/*Cerramos el flujo de lectura del archivo le�do anteriormente*/
        System.out.print("INGRESE UNA PALABRA:");
        Scanner readText = new Scanner(System.in);/*Creamos un nuevo Scanner de lectura por consola*/
        String palabra = readText.nextLine();/*Leemos una palabra*/
        boolean mostrado = false;/*Variable auxiliar para saber si un mensaje fue mostrado*/
        if(palabra.length()>=4){/*La palabra debe de tener al menos 4 car�cteres*/
            String p = "" + palabra.charAt(0)+palabra.charAt(1)+palabra.charAt(2)+palabra.charAt(3);
            StringBuilder q = new StringBuilder();
            q = q.append(palabra).reverse();/*Invertimos el orden de la palabra*/
            String f = "" + q.charAt(2)+q.charAt(1)+q.charAt(0);
            if(s.encontrar(palabra)!=null){/*Se verifica que la palabra este en el listado anterior*/
                for(int z = conteo[(Auxiliar.letra2Num(palabra))%27];z<=conteo[(Auxiliar.letra2Num(palabra)+1)%27];z++){
                    if(arbol.search(z).toString().startsWith(p) && arbol.search(z).toString().endsWith(f)){
                        System.out.println("Coincidencia: " + arbol.search(z));/*Buscamos en el �rbol B+*/
                        mostrado = true;/*Efectivamente el mensaje se mostr�*/
                        return;
                    }
                }
                if(!mostrado){
                    System.out.println("LA PALABRA INGRESADA EXISTE EN LA LISTA");
                }
                
                
            }
            else{/*Si no est� entonces presentamos el siguiente mensaje por pantalla*/
                System.out.println("LA PALABRA: <" + palabra + "> NO SE ENCUENTRA EN LA LISTA");
            }
        }
        else{
            System.out.println("LA PALABRA NO TIENE LA LONGITUD MINIMA NECESARIA");
        }
        readText.close();
    }
}