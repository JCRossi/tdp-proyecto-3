package Entidades;


public class Pared extends Entidad{
	
	public Pared(int posY, int posX) {
		pos = new Posicion( posX, posY, 25, 25);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(4, pos);

	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		System.out.println("Colisionaste con una pared: Jugador");
		personaje.noPuedeCaminar();

		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		System.out.println("Colisionaste con una pared: Enemigo");
		personaje.noPuedeCaminar();

		return true;
	}

}
