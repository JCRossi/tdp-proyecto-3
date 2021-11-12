package Entidades;

import Logica.Logica;

public class PacDot extends Consumible {

	public PacDot(int posY, int posX, Logica juegoActual) {
		puntaje = 10;
		pos = new Posicion( posX+((25-10)/2), posY+((25-11)/2), 10, 11);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(3, pos);
		juego = juegoActual;
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		serComido();
		entGrafica.setIcon(null);
		//Falta desenlistar del laberinto
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serComido() {
		juego.actualizarPuntaje(puntaje);
	}

}
