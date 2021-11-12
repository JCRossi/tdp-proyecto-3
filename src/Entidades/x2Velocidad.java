package Entidades;

import Logica.Logica;

public class x2Velocidad extends Pocion {
	
	public x2Velocidad(int posY, int posX, Logica juegoActual) {
		pos = new Posicion( posX+((25-19)/2), posY+((25-20)/2), 19, 20);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(6, pos);
		juego = juegoActual;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		entGrafica.setIcon(null);
		serComido();
		juego.quitarEntidadGrafica(entGrafica);
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void serComido() {
		juego.cambiarEstados('2', 10);
	}

}
