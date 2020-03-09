package controller;

import java.util.Scanner;

import com.sun.glass.events.ViewEvent;

import model.data_structures.ArregloDinamico;
import model.data_structures.Comparendo;
import model.data_structures.Node;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(10000);
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();
			int option = lector.nextInt();
			switch(option)
			{
			case 1:
				view.printMessage("------------------------------------------------------------------------\n Se esta cargando la informacion \n------------------------------------------------------------------------");
				modelo.cargarInfo();
				if(modelo.darTamano()!=0)
				{
					Comparendo encontrado = modelo.dardatos().darElemento(0);
					view.printMessage(""+ encontrado.darID()+","+encontrado.darFecha()+","+ encontrado.darClaseVehiculo()+","+encontrado.darTipoServicio()+","+encontrado.darLocalidad()+"\n---------------------------");
					encontrado=modelo.dardatos().darElemento(modelo.darTamano()-1);
					view.printMessage(""+ encontrado.darID()+","+encontrado.darFecha()+","+ encontrado.darClaseVehiculo()+","+encontrado.darTipoServicio()+","+encontrado.darLocalidad()+"\n---------------------------");
					view.printMessage("Total de comparendos leidos: "+modelo.darTamano()+"");
					view.printMessage("------------------------------------------------------------------------");

				}
				break;

			case 2:
				view.printMessage("------------------------------------------------------------------------\n Se esta copiando el arreglo: \n------------------------------------------------------------------------");
				ArregloDinamico<Comparendo> copiados=modelo.copiarComparendos();
				int numeroDeDatosCargados=copiados.darTamano();
				view.printMessage("Numero de datos de cargados:"+numeroDeDatosCargados +"\n---------------------------");

				break;
			case 3:
				view.printMessage("------------------------------------------------------------------------\n Se esta ordenando el arreglo: \n------------------------------------------------------------------------");
				// Copiar los comparendos originales en un arreglo de objetos Comparables � Requerimiento 1
				ArregloDinamico<Comparendo>copia_Comparendos  = modelo.copiarComparendos();
				long startTime = System.currentTimeMillis(); // medici�n tiempo actual
				// solucion Requerimiento 2, 3 o 4
				modelo.ordenarShellSort( copia_Comparendos );
				long endTime = System.currentTimeMillis(); // medici�n tiempo actual
				long duration = endTime - startTime; // duracion de ejecucion del algoritmo
				view.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos");
				view.printMessage("------------------------------------------------------------------------\n Primeros 10 elementos: \n------------------------------------------------------------------------");

				for(int i=0; i<10; i++)
				{
					Comparendo actual=copia_Comparendos.darElemento(i);
					view.printMessage(""+ actual.darID()+","+actual.darFecha()+","+ actual.darClaseVehiculo()+","+actual.darTipoServicio()+","+actual.darLocalidad()+"\n---------------------------");
				}
				view.printMessage("------------------------------------------------------------------------\n Ultimos 10 elementos: \n------------------------------------------------------------------------");

				for(int i=1; i<11; i++)
				{
					Comparendo actual=copia_Comparendos.darElemento(copia_Comparendos.darTamano()-i);
					view.printMessage(""+ actual.darID()+","+actual.darFecha()+","+ actual.darClaseVehiculo()+","+actual.darTipoServicio()+","+actual.darLocalidad()+"\n---------------------------");
				}
				// mostrar los resultados del algoritmo xxxxxSort que quedaron en el arreglo
				// copia_Comparendos: los 10 primeros y los 10 �ltimos comparendos resultantes
				view.printMessage("------------------------------------------------------------------------");

				break;

			case 4:

				view.printMessage("------------------------------------------------------------------------\n Se esta ordenando el arreglo: \n------------------------------------------------------------------------");
				ArregloDinamico<Comparendo>copia_Comparendos_Merge  = modelo.copiarComparendos();
				long startTime1 = System.currentTimeMillis(); 
				modelo.ordenarPorMergeSort(copia_Comparendos_Merge, 0, modelo.copiarComparendos().darTamano()-1);
				long endTime1 = System.currentTimeMillis(); // medici�n tiempo actual
				long duration1 = endTime1 - startTime1; // duracion de ejecucion del algoritmo
				view.printMessage("Tiempo de ordenamiento: " + duration1 + " milisegundos");

				view.printMessage("------------------------------------------------------------------------\n Primeros 10 elementos: \n------------------------------------------------------------------------");

				for(int i=0; i<10; i++)
				{
					Comparendo actual=copia_Comparendos_Merge.darElemento(i);
					view.printMessage(""+ actual.darID()+","+actual.darFecha()+","+ actual.darClaseVehiculo()+","+actual.darTipoServicio()+","+actual.darLocalidad()+"\n---------------------------");
				}
				view.printMessage("------------------------------------------------------------------------\n Ultimos 10 elementos: \n------------------------------------------------------------------------");

				for(int i=1; i<11; i++)
				{
					Comparendo actual=copia_Comparendos_Merge.darElemento(copia_Comparendos_Merge.darTamano()-i);
					view.printMessage(""+ actual.darID()+","+actual.darFecha()+","+ actual.darClaseVehiculo()+","+actual.darTipoServicio()+","+actual.darLocalidad()+"\n---------------------------");
				}
				// mostrar los resultados del algoritmo xxxxxSort que quedaron en el arreglo
				// copia_Comparendos: los 10 primeros y los 10 �ltimos comparendos resultantes
				view.printMessage("------------------------------------------------------------------------");
				break;

			case 5:
				
				view.printMessage("------------------------------------------------------------------------\n Se esta ordenando el arreglo: \n------------------------------------------------------------------------");
				ArregloDinamico<Comparendo>copia_Comparendos_Quick  = modelo.copiarComparendos();
				long startTime2 = System.currentTimeMillis(); 
				modelo.ordenarPorQuick(copia_Comparendos_Quick);
				long endTime2 = System.currentTimeMillis(); // medici�n tiempo actual
				long duration2 = endTime2 - startTime2; // duracion de ejecucion del algoritmo
				view.printMessage("Tiempo de ordenamiento: " + duration2 + " milisegundos");

				view.printMessage("------------------------------------------------------------------------\n Primeros 10 elementos: \n------------------------------------------------------------------------");

				for(int i=0; i<10; i++)
				{
					Comparendo actual=copia_Comparendos_Quick.darElemento(i);
					view.printMessage(""+ actual.darID()+","+actual.darFecha()+","+ actual.darClaseVehiculo()+","+actual.darTipoServicio()+","+actual.darLocalidad()+"\n---------------------------");
				}
				view.printMessage("------------------------------------------------------------------------\n Ultimos 10 elementos: \n------------------------------------------------------------------------");

				for(int i=1; i<11; i++)
				{
					Comparendo actual=copia_Comparendos_Quick.darElemento(copia_Comparendos_Quick.darTamano()-i);
					view.printMessage(""+ actual.darID()+","+actual.darFecha()+","+ actual.darClaseVehiculo()+","+actual.darTipoServicio()+","+actual.darLocalidad()+"\n---------------------------");
				}
				// mostrar los resultados del algoritmo xxxxxSort que quedaron en el arreglo
				// copia_Comparendos: los 10 primeros y los 10 �ltimos comparendos resultantes
				view.printMessage("------------------------------------------------------------------------");
				break;

			default: 
				view.printMessage("--------------------------------------------------------------- \n Opcion Invalida !! \n---------------------------------------------------------------");
				break;
			}
		}




	}	
}
