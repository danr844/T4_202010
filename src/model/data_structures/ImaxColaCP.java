package model.data_structures;

public interface ImaxColaCP<T> {
	 
	int darNumElementos();
	
	void agregar(T elemento);
	
	T sacarMax();
	
	T darMax();
	
	boolean esVacia();
	
	
	

}
