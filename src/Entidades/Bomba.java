package Entidades;

import Logica.Logica;

public class Bomba extends Pocion {
	
	public Bomba(int posY, int posX, Logica juegoActual) {
		puntaje = 0;
		pos = new Posicion( posX+((25-19)/2), posY+((25-19)/2), 19, 19);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(0, pos);
		juego = juegoActual;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		serComido();
		juego.quitarEntidadGrafica(entGrafica);
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		return false;
	}
	
	public void serComido() {
		juego.cambiarEstados('B', 15);
	}

}
