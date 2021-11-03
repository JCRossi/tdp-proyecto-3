package Entidades;

import Estructuras.ListaSimplementeEnlazada;
import Laberinto.Laberinto;

public abstract class Personaje extends Entidad{
	
	protected char direccion;
	protected Laberinto miLaberinto;
		
	
	public abstract void mover();
	
	public abstract boolean colision(Entidad entidad);
	
	public abstract void morir();
	
	public abstract char getEstado();
	
	public abstract boolean colisionasteConJugador(Personaje personaje);
	
	public abstract ListaSimplementeEnlazada chequearMovimiento();
	
	public abstract boolean colisionasteConEnemigo(Personaje personaje);
	
	public abstract Posicion getPosicion();
	public abstract void noPuedeCaminar();
}
