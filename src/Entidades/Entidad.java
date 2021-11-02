package Entidades;

public abstract class Entidad {
	protected EntidadGrafica entGrafica;
	
	public abstract boolean colisionasteConJugador(Personaje personaje);
	
	public abstract boolean colisionasteConEnemigo(Personaje personaje);

}
