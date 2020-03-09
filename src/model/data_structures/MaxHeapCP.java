package model.data_structures;

public class MaxHeapCP <T extends Comparable<T>>implements IMaxHeapCP<T>{
	private int tamanoCola;



	public MaxHeapCP(){

	}

	public int darNumElementos() {
		// TODO Auto-generated method stub
		return tamanoCola;
	}

	public void agregar(T elemento) {
		// TODO Auto-generated method stub

	}

	public T sacarMax() {
		// TODO Auto-generated method stub
		return null;
	}

	public T darMax() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean esVacia() {
		// TODO Auto-generated method stub

		return tamanoCola==0;
	}
	public void swim(int k) 
	{  
		while (k > 1 && less(k/2, k))

		{   
			exch(k/2, k);
			k = k/2;  
		} 
	}
	private void sink(int k)
	{  
		while (2*k <= N) 
		{      
			int j = 2*k; 
			if (j < N && less(j, j+1)) 
				j++;
			if (!less(k, j))
				break;
			exch(k, j);  
			k = j;  
		}
	}

	private boolean  less(int i, int j) 
	{  
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void 
	exch(int i, int j) 
	{ 
		Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; 
	}




}


