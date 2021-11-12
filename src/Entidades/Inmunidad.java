package Entidades;

import Logica.Logica;

public class Inmunidad extends Pocion {
	
	public Inmunidad(int posY, int posX, Logica juegoActual) {
		pos = new Posicion( posX+((25-19)/2), posY+((25-22)/2), 19, 22);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(2, pos);
		juego = juegoActual;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		entGrafica.setIcon(null);
		serComido();
		juego.quitarEntidadGrafica(entGrafica);
		juego.desenlistarEntidad(pos.getX()/25,pos.getY()/25,this);
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		return false;
	}
	
	public void serComido() {
		juego.cambiarEstados('I', 10);
	}

}
