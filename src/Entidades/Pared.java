package Entidades;


public class Pared extends Entidad{
	
	public Pared(int posY, int posX, String[] img) {
		pos = new Posicion( posX, posY, 25, 25);  
		entGrafica = new EntidadGrafica(0, pos,img);

	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		System.out.println("Colisionaste con una pared: Jugador");
		personaje.noPuedeCaminar('w');

		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		//System.out.println("Colisionaste con una pared: Enemigo");
		personaje.noPuedeCaminar('w');

		return true;
	}

}
