package Entidades;

public class Pared extends Entidad{
	
	public Pared() {}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		
		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
	}

}
