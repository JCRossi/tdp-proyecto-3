package Entidades;

public abstract class Entidad {
	
	public abstract boolean colisionasteConJugador(Personaje personaje);
	
	public abstract boolean colisionasteConEnemigo(Personaje personaje);

}
