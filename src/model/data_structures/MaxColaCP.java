package model.data_structures;

public class MaxColaCP< T extends Comparable <T>> implements ImaxColaCP<T>{


	private int tamanoCola;
	private ArregloDinamico<T>array;
	private static final int  CAPACIDAD=10000; 



	public MaxColaCP(){

		array = new ArregloDinamico<>(CAPACIDAD);
	}

	public int darNumElementos() {
		// TODO Auto-generated method stub
		return tamanoCola;
	}

  static boolean   less(Comparable v, Comparable w)  
	{  
		return v.compareTo(w) < 0;  
	} 
	
	
	public void agregar(T k) {
		// TODO Auto-generated method stub
		{ 
			int i = array.darTamano()-1;
			while (i >= 0 && less(k, array.darElemento(i)))
			{
				//recorre arreglo hacia atrás mientras el nuevo key sea menor
				array.exch(i+1, i);
				//mueve una posición hacia adelante elementos mayores al
				i--;
				//decrementa apuntador i 
			}
			array.cambiarElementoEnPosicion(i+1, k);
			//asigna k en su correcta posición 
			tamanoCola++;
			//incrementa tamaNo 
		} 
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

}
