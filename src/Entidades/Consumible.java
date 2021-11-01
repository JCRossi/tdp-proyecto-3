package Entidades;

public abstract class Consumible extends Entidad {
	protected int posicionX;
	protected int posicionY;
	protected int puntaje;
	
	public abstract boolean colisionasteConJugador(Personaje personaje);
	
	public abstract boolean colisionasteConEnemigo(Personaje personaje);
	
	public abstract void serComido();

}
