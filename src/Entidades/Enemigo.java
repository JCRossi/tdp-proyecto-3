package Entidades;

import Estructuras.ListaSimplementeEnlazada;

public class Enemigo extends Personaje{

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean colision(Entidad entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getEstado() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListaSimplementeEnlazada chequearMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		// TODO Auto-generated method stub
		return null;
	}

}
