package utilidades;

import java.util.Arrays;

public class ListaInt {
	private final Integer[] lista;
	private int numElementos;

	public ListaInt(int size){
		if (size <= 0) throw new IllegalArgumentException("El tama�o tiene que ser mayor que cero");
		
		lista = new Integer[size]; //el array se inicializa a null todas las posiciones
		numElementos = 0;
	}
	
	/**
	 * Comprueba si una posici�n est� dentro de la lista. 
	 * @param index indice que se quiere consultar si est� dentro de la lista
	 * @return true si el �ndice es positivo y menor que el tama�o de la lista 
	 */
	public boolean isValido (int index) {
		return (index >= 0 && index < lista.length);
	}
	
	/**
	 * Permite consultar si la lista est� vac�a.
	 * @return true si la lista est� vac�a y false en caso contrario
	 */
	public boolean isEmpty(){
		return numElementos == 0;
	}
	
	/**
	 * A�ade un elemento en una posici�n. Reemplaza el valor que hubiera en esa posici�n.
	 * @param index posici�n en la que se va a insertar el nuevo valor
	 * @param valor valor a insertar 
	 */
	public void setAt(int index, int valor){
		if (!isValido(index)) 
			throw new IllegalArgumentException("posici�n no v�lida");
		
		lista[index] = valor;
		++numElementos;
	}
	
	/**
	 * Devuelve el elemento de la posici�n que se pasa como par�metro.
	 * @param index posici�n en la que est� el elemento que se quiere recuperar
	 * @return elemento en la posici�n index
	 */
	public int get(int index){
		if (!isValido(index)) 
			throw new IllegalArgumentException("posici�n no v�lida");
		
		return lista[index];
	}
	
	/**
	 * Ordena la lista de menor a mayor.
	 */
	public void ordenar() {
		int size = lista.length;
		for (int i = 0; i < size; i++){
			for (int j = size - 1; j > i; j--){
				if (lista[j] < lista[j - 1]){ //intercambiar
					int aux = lista[j];
					lista[j] = lista[j-1];
					lista[j-1] = aux;
				}
			}
		}
	}
	
	
	/**
	 * Calcula el valor m�ximo de la colecci�n. 
	 * Es un requisito que la colecci�n no est� vac�a.
	 * 
	 * @return devuelve el valor del entero de la colecci�n m�s alto.
	 */
	public int maximo(){
		if (isEmpty())
			throw new IllegalStateException("La lista est� vac�a");
		
		int max = lista[0];
		for (int i = 1 ; i < lista.length; i++){
			if (lista[i] > max){
				max = lista[i];
			}
		}
		
		return max;
	}
	
	/** Elimina todas las ocurrencias del valor que se pasa como par�metro.
	 *  Eliminar un valor significa dejar su posici�n a null.
	 * 
	 * @param valor valor que se va a eliminar de la lista
	 * @return int devuelve el n�mero de ocurrencias que ha borrado
	 */
	public int removeAll (int valor) {
	/*1*/	if (isEmpty())
	/*2*/		throw new IllegalStateException("No se puede borrar de una lista vac�a");
		
	/*3*/	int contador = 0;
		
	/*4*/	for (int i = 0; i < lista.length; ++i){
	/*5*/		if (lista[i] == valor){
	/*6*/			lista[i] = null;
	/*7*/			++contador;
	/*8*/		}
	/*9*/	}
		
	/*10*/		numElementos -= contador;
		
	/*11*/		return contador;
	/*12*/	}
	
	
	
	/** Devuelve true si existe un elemento de la lista que sea igual
	 *  a la suma de los anteriores y false en caso contrario.
	 */
	public boolean existeAcumulado(){
	/*1*/	switch (lista.length){
	/*2*/	case 1: return false;
	/*3*/	case 2: if (lista[0] == lista[1])
	/*4*/		     return true;
	/*5*/        else 
	/*6*/	         return false;
	/*7*/default:{
	/*8*/	int suma = lista[0];
	/*9*/		for (int i = 1; i < lista.length; i++){
	/*10*/			if (suma == lista[i])
	/*11*/				return true;
	/*12*/		else{
	/*13*/			suma = suma + lista[i];
	/*14*/		}
	/*15*/	}
    /*16*/	return false;
	/*17*/	}
/*18*/}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(lista);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ListaInt other = (ListaInt) obj;
		
		return Arrays.equals(lista, other.lista);
	}
	

}

