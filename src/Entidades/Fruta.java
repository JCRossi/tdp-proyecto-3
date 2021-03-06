package Entidades;

import Logica.Logica;

public class Fruta extends Consumible {
	
	public Fruta(int posY, int posX, Logica juegoActual,String[] img) {
		puntaje = 150;
		pos = new Posicion( posX+((25-15)/2), posY+((25-22)/2), 15, 22);  
		entGrafica = new EntidadGrafica(0, pos,img);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serComido() {
		juego.actualizarPuntaje(puntaje);
	}

}
