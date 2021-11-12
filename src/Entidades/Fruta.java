package Entidades;

import Logica.Logica;

public class Fruta extends Consumible {
	
	public Fruta(int posY, int posX, Logica juegoActual) {
		puntaje = 150;
		pos = new Posicion( posX+((25-15)/2), posY+((25-22)/2), 15, 22);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(1, pos);
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
