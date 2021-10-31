package Estructuras;

import java.util.*;

/**
 * Modela un iterador de PositionList
 * @author Juan Cruz Rossi
 *
 * @param <E> Tipo de dato de las posiciones
 */
public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Inicializa un iterador a partir de una lista parametrizada
	 * @param L lista de elementos genéricos
	 */
	public ElementIterator(PositionList<E> L) {
		try {
			list = L;
			cursor = (list.isEmpty()) ? null : list.first();
		} catch(EmptyListException e) {
			e.getMessage();
		}
	}
	
	/*
	 * Consulta si hay más elementos
	 * @return Si hay más elementos
	 */
	public boolean hasNext() {
		return cursor != null;
	}
	
	/*
	 * Devuelve el el siguiente elemento
	 * @return El elemento actual del cursor al llamar al método 
	 */
	public E next() throws NoSuchElementException{
		E toReturn = cursor.element();
		
		try {
			if(cursor == null)
				throw new NoSuchElementException("No hay elemento siguiente");
			
			cursor = (cursor == list.last()) ? null : list.next(cursor);
			
		} catch(EmptyListException|InvalidPositionException|BoundaryViolationException e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
}
