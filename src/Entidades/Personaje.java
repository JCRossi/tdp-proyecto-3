package Entidades;

import java.util.LinkedHashSet;

import Laberinto.Laberinto;

public abstract class Personaje extends Entidad{
	
	protected char direccion;
	protected Laberinto miLaberinto;
	protected boolean puedeCaminar;
	
	public abstract void mover();
	
	public abstract boolean colision(Entidad entidad);
	
	public abstract void morir();
	
	public abstract char getEstado();
	
	public abstract boolean colisionasteConJugador(Personaje personaje);
	
	public abstract boolean colisionasteConEnemigo(Personaje personaje);

	protected abstract void noPuedeCaminar(char c);

	public abstract LinkedHashSet<Entidad> chequearMovimiento(char direc, int movimiento);
	
}
