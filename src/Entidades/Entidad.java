package Entidades;

import Logica.Logica;

public abstract class Entidad {
	protected Logica juego;
	protected EntidadGrafica entGrafica;
	protected Posicion pos;
	
	public abstract boolean colisionasteConJugador(Personaje personaje);
	
	public abstract boolean colisionasteConEnemigo(Personaje personaje);
	
	public Posicion getPosicion() {
		return pos;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entGrafica;
	}

}
