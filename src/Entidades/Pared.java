package Entidades;


public class Pared extends Entidad{
	
	public Pared(int posY, int posX, String[] img) {
		pos = new Posicion( posX, posY, 25, 25);  
		entGrafica = new EntidadGrafica(0, pos,img);

	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		personaje.noPuedeCaminar('w');

		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		personaje.noPuedeCaminar('w');

		return true;
	}

}
