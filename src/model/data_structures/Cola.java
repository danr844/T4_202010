package model.data_structures;


public class Cola<T> implements ICola<T>
{
	private Node<T> inicioCola;
	private Node<T> finCola;
	private int tamanoCola;

	public Cola(){
		inicioCola = null;
		finCola = null;
	}


	public boolean estavacia(){
		if(inicioCola==null)
			return true;
		else{
			return false;
		}
	}


	public void agregar(T multa)
	{
		Node<T> nuevo = new Node<>();
		nuevo.cambiarDato(multa);
		if(estavacia())
		{
			inicioCola = nuevo;
			finCola = nuevo;
			tamanoCola++;
		}
		else if(inicioCola.darSiguiente()==null)
		{
			inicioCola.cambiarSiguiente(nuevo);
			tamanoCola++;
			finCola=nuevo;
		}
		else
		{
			finCola.cambiarSiguiente(nuevo);
			finCola = nuevo;
			tamanoCola++;
		}
	}
	public T sacarMax()
	{
		int max = 0;
		for (int i = 1; i < tamanoCola; i++)
			if (less(max, i)) // Recorre el arreglo buscando el m�ximo 
				max = i; 
			exch(max, N-1); // Intercambia el m�ximo por el �ltimo.
		return pq[--N]; // Retorna el �ltimo (m�ximo) y decrementa tamaNo }

	}

	public int dartamanoCola(){
		return tamanoCola;
	}


	public Node<T> darPrimerElemento()
	{
		return inicioCola;
	}
	public T darMax()
	{

	}

}
