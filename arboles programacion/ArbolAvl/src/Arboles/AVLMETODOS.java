package Arboles;
class Arbolavl
{
	
	//Atributos
	NODOAVL aux, aux2,nuevo, raiz;
	int altura=0; 
	int altura2=0;
	public Arbolavl()
	{
		nuevo = null;
		raiz = null;
	}
	//Constructor Vacio lo utilizo porque necesito inicializar mis variables despues
	
	public boolean arbolvacio()
	{
		if(raiz==null)
			return true;
		else
			return false;
	}
	//Metodo de Alta de Nodos, se encarga de dar de alta los nuevos datos que ingrese el usuario
	public void ingresarelemento(int dato) //Se le envia un dato entero 
	{
		if(raiz==null)					//Verificamos si no existe aun un arbol
		{
			raiz=new NODOAVL();
			raiz.dato=dato;
			raiz.derecha=raiz.izquierda=raiz.padre=null;
			raiz.balance=0;
		}
		else						//Caso contrario si ya existe
		{
			aux=raiz;
			while(aux!=null)
			{
			//si el dato es mayor y hay espacio
			if((dato>aux.dato)&&(aux.derecha==null))	
			{
				nuevo=new NODOAVL();
				nuevo.dato=dato;
				nuevo.izquierda=nuevo.derecha=null;
				aux.derecha=nuevo;
				nuevo.padre=aux;
				nuevo.balance=0;
				balanceingreso(nuevo.padre,1);
				break;
			}
			//si el dato es menor y hay espacio
			else if ((dato<aux.dato)&&(aux.izquierda==null))	
			{
				nuevo=new NODOAVL();
				nuevo.dato=dato;
				nuevo.izquierda=nuevo.derecha=null;
				aux.izquierda=nuevo;
				nuevo.padre=aux;
				nuevo.balance=0;
				balanceingreso(nuevo.padre,-1);
				break;
			}
			//si el dato es igual a otro ya agregado
			else if (dato==aux.dato)
			{
				//Ya existe ese dato en el arbol
				break;
			}
				
			//si hay mas datos  a la derecha
			else if(dato>aux.dato)
				aux=aux.derecha;
			//si hay mas datos  a la izquierda
			else
				aux=aux.izquierda;
			}
		}
	}//end alta

	public void balanceingreso(NODOAVL N, int inc)
	{	
		int tipo=-1;
		while(N!=null)
		{
			N.balance=N.balance+inc; //Reajusta balances
			if(N.balance==0) //Si es igual a 0 se detiene
				break;
			else
			{
				tipo=tipoRotacion(N); //llamamos al metodo tipoRotacion
				if(tipo==0) //No hay necesidad de rotar
				{
					if(N.padre!=null)
					{
						if(N.dato<N.padre.dato)
						{
							inc=-1;
						}
						else
						{
							inc=1;
						}
					}
					N=N.padre;
				}
				if(tipo==1)	//Rotacion sencilla izquierda
					{		
						rotacionSI(N,N.derecha);
						break;
					}
				if(tipo==2) //Rotacion doble derecha-izquierda
					{
						rotacionSD(N.derecha,N.derecha.izquierda);
						rotacionSI(N,N.derecha);
						break;
					}
				if(tipo==3) //Rotacion sencilla derecha
					{
						rotacionSD(N,N.izquierda);


						break;
					}
				if(tipo==4) //Rotacion doble izquierda-derecha
					{
					rotacionSI(N.izquierda,N.izquierda.derecha);
					rotacionSD(N,N.izquierda);
					
						break;
					}
			
			}
			
			
		}
	}

	
	public int tipoRotacion(NODOAVL R)
	{
		if(R.balance==2)		//Positivo
		{
			if((R.derecha.balance==0)||(R.derecha.balance==1))
				return 1;
			else if(R.derecha.balance==-1)
				return 2;
		}
		else if(R.balance==-2)		//Negativo
		{
			if((R.izquierda.balance==0)||(R.izquierda.balance==-1))
				return 3;
			else if(R.izquierda.balance==1)
				return 4;
		}
		return 0;
	}
	
//	El metodo rotacionSI se encarga de realizar la rotacion Sencilla a la izquierda
//	recibe como datos el nodo del problema y su hijo derecho
		
		public void rotacionSI(NODOAVL R, NODOAVL hderecho)
		{		
			int a, b;
			aux=hderecho.izquierda;
			if(R==raiz)
			{
				raiz=hderecho;
				hderecho.padre=null;
			}
			else
			{
				if(R.dato>R.padre.dato)
				{
					R.padre.derecha=hderecho;
				}
				else
				{
					R.padre.izquierda=hderecho;
				}
				hderecho.padre=R.padre;
			}
			hderecho.izquierda=R;
			R.derecha=aux;
			R.padre=hderecho;
			if(aux!=null)
			{
				aux.padre=R;
			}
			a=R.balance;
			R.balance=(a-1)-Math.max(hderecho.balance,0);
			b=Math.min((a-2),(a+hderecho.balance-2));
			hderecho.balance=Math.min(b,(hderecho.balance-1));
			
		}

//	El metodo rotacionSD se encarga de realizar la rotacion Sencilla a la derecha
//	recibe como datos el nodo del problema y su hijo izquierdo
		
		public void rotacionSD(NODOAVL R, NODOAVL hizquierdo)
		{
			
			int c, d;
			aux=hizquierdo.derecha;
			if(R==raiz)
			{
				raiz=hizquierdo;
				hizquierdo.padre=null;
			}
			else
			{
				if(R.dato>R.padre.dato)
				{
					R.padre.derecha=hizquierdo;
				}
				else
				{
					R.padre.izquierda=hizquierdo;
				}
			}
				hizquierdo.padre=R.padre;
				hizquierdo.derecha=R;
				R.izquierda=aux;
				R.padre=hizquierdo;
				if(aux!=null)
				{
					aux.padre=R;
				}
				c=R.balance;
				R.balance=(c+1)-Math.min(hizquierdo.balance,0);
				d=Math.min((c+2),(c-hizquierdo.balance+2));
				hizquierdo.balance=Math.max(d,(hizquierdo.balance+1));
			
		}
	public void eliminar(int numero)
	{

		if(raiz!=null)
		{
			aux = raiz;
			if(aux.dato ==numero)
			{

				raiz = remplazar(raiz);
	
			}
			else
			{
				NODOAVL actual, Par_1 = raiz;
				boolean f = false;
				if(numero < aux.dato)
					actual = raiz.izquierda;
				else
					actual = raiz.derecha;
				while(actual != null && !f)
				{
					if(numero==actual.dato)
					{
						f = true;

						if(actual ==Par_1.izquierda)
						{
							Par_1.izquierda = remplazar(actual);
						}
						else
						{
							Par_1.derecha = remplazar(actual);
						}
					}
					else
					{
						Par_1= actual;
						if(numero < actual.dato)
							actual = actual.izquierda;
						else
							actual = actual.derecha;
					}
					
				}
				if(!f)
					System.out.println("Elemento no encontrado");
			}

		}
	}
	public NODOAVL remplazar (NODOAVL num_1)
	{
		NODOAVL result = null;
		if ((num_1.izquierda ==null)&& (num_1.derecha == null))
			result = null;
		else if ((num_1.izquierda!=null)&& (num_1.derecha==null))
			result = num_1.izquierda;
		else if ((num_1.izquierda ==null)&& (num_1.derecha != null))
			result = num_1.derecha;
		else
		{
			NODOAVL actual = num_1.derecha;
			NODOAVL pa = num_1;
			while (actual.izquierda != null)
			{
				pa = actual;
				actual = actual.izquierda;
			}
			if(num_1.derecha==actual)
				actual.izquierda = num_1.izquierda;
			else
			{
				pa.izquierda= actual.derecha;
				actual.derecha = num_1.derecha;
				actual.izquierda = num_1.izquierda;
			}
			result = actual;
		}
		return result;
	}
	

	public void inordenimprimir()
	{
		if (raiz != null)
		{
			
			System.out.println("recorrido Inorden\n");
			raiz.inorden();
		}
	}
	public void preordenimprimir()
	{
		if (raiz != null)
		{
			System.out.println("\nrecorrido Preorden\n");
			raiz.preorden();
			
		}
	}
	public void postordenimprimir()
	{
		if (raiz != null)
		{
			System.out.println("\nrecorrido Postorden\n");
			raiz.postorden();
			
		}
	}

	public void eliminaArbol()
	{
		if(raiz != null)
			eliminArbol(raiz);
	}
	private void eliminArbol(NODOAVL raiz)
	{
		if(raiz != null)
		{
			eliminArbol(raiz.izquierda);
			eliminArbol(raiz.derecha);
			raiz = null;
		}
	}
	public boolean buscar(int buscado)
	{
		if (raiz != null)
			return (raiz.buscarNodo(buscado)!= null);
		else
			return false;
	}
}