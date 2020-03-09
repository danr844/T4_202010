package model.data_structures;

public interface IMaxHeapCP<T> {

	int darNumElementos();

	void agregar(T elemento);

	T sacarMax();

	T darMax();

	boolean esVacia();


}
