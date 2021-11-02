package Entidades;

public class Pared extends Entidad{
	
	public Pared(int posX, int posY, String imagen) {
		pos = new Posicion( posX, posY, 99999999, 11111111);  //999999 = ancho        111111111 = alto
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
