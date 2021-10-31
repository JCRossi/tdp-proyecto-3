package Estructuras;

import java.util.Iterator;

public class ListaSimplementeEnlazada<E> implements PositionList<E> {
	protected Nodo<E> head;
	protected int tama�o;
	
	public ListaSimplementeEnlazada() {
		head = null;
		tama�o = 0;
	}
	
	public Position<E> first() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("Lista vacia");
		
		return head;
	}
	
	public Position<E> last() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("Lista vacia");
		
		Nodo<E> p = head;
			
		while(p.getSiguiente() != null)
			p = p.getSiguiente();
			
		return p;
		
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		Nodo<E> elem = checkPosition(p);
		
		if(isEmpty())
			throw new InvalidPositionException("La lista esta vacia");
		
		Nodo<E> elemPrev = head;
		
		if(elem == head)
			throw new BoundaryViolationException("La posicion pasada por parametro es la primera");
		
		while(elemPrev.getSiguiente() != elem) 
			elemPrev = elemPrev.getSiguiente();
		
		return elemPrev;
	} 
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{ 
		Nodo<E> elem = checkPosition(p);
		
		if(isEmpty())
			throw new InvalidPositionException("La lista esta vacia");
		
		if(elem.getSiguiente() == null)
			throw new BoundaryViolationException("La posicion parametrizada es la ultima");
		
		return elem.getSiguiente();
	}
	
	public E set(Position<E> p, E elem) throws InvalidPositionException{
		Nodo<E> n = checkPosition(p);
		
		if(isEmpty())
			throw new InvalidPositionException("Lista vacia");
		
		E reemplazado = n.element();
		n.setElemento(elem);
		
		return reemplazado;
	}
	
	public void addFirst(E elem) {
		Nodo<E> elemento = new Nodo<E>(elem, head);
		head = elemento;
		tama�o++;
	}
	
	public void addLast(E elem) {
		if(isEmpty())
			addFirst(elem);
		else {
			Nodo<E> recorrido = head;
			
			while(recorrido.getSiguiente() != null)
				recorrido = recorrido.getSiguiente();
				
			recorrido.setSiguiente(new Nodo<E>(elem));
			tama�o++;
		}
	}
	
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException{
		Nodo<E> elemento = checkPosition(p);
		Nodo<E> buscador = head;
 		
		if(isEmpty())
			throw new InvalidPositionException("La lista esta vacia");
		try {
			if(elemento == head)
				addFirst(elem);
			else {
				addAfter(prev(p), elem);
			}
		} catch(InvalidPositionException|BoundaryViolationException e) {
			e.printStackTrace();
		}
	}
	
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException{
		Nodo<E> elemento = checkPosition(p);
		
		if(isEmpty())
			throw new InvalidPositionException("La lista esta vacia");
		
		Nodo<E> nuevo = new Nodo<E>(elem);
		nuevo.setSiguiente(elemento.getSiguiente());
		elemento.setSiguiente(nuevo);
		tama�o++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		Nodo<E> elemento = checkPosition(p);
		Nodo<E> recorrido = null;;
		E removido = null;
		
		if(isEmpty())
			throw new InvalidPositionException("La lista esta vacia");
		
		if(elemento == head) {
			head = elemento.getSiguiente();
			tama�o--;
		}
		else {
			recorrido = head;
			
			while(recorrido.getSiguiente() != elemento) 
				recorrido = recorrido .getSiguiente();
			
			recorrido.setSiguiente(elemento.getSiguiente());
			elemento.setElemento(null);
			elemento.setSiguiente(null);
			p = null;
			tama�o--;
		}
		
		return removido;
	}
	
	public boolean isEmpty() {
		return tama�o == 0;
	}
	
	public int size() {
		return tama�o;
	}
	
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> l = new ListaSimplementeEnlazada<Position<E>>();
		Nodo<E> actual = head;
		
		while(actual != null) {
			l.addLast(actual);
			actual = actual.getSiguiente();
		}
		
		return l;
	}
	
	protected Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null)
			throw new InvalidPositionException("Posicion nula");
			
		if(p.element() == null)
			throw new InvalidPositionException("La posicion fue eliminada previamente");
		
		try {	
			return (Nodo<E>) p;
		} catch(ClassCastException e) {
			throw new InvalidPositionException("La posicion p no pertenece a la lista");
		}
	}
	
	public ListaSimplementeEnlazada<E> clone() {
		ListaSimplementeEnlazada<E> res = new ListaSimplementeEnlazada<E>();
		Nodo<E> n = head;
		
		for(int i = 0; i < tama�o; i++) {
			res.addLast(n.element());
			n = n.getSiguiente();
		}
		
		return res;
	}
}
