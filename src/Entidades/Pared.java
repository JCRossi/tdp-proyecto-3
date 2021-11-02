package Entidades;

public class Pared extends Entidad{
	
	public Pared(String imagen) {
		entGrafica = new EntidadGrafica(imagen);
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		
		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
	}
}
