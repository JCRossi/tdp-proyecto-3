package Entidades;

import Logica.Logica;

public class PowerPellet extends PowerUp {
	
	public PowerPellet(int posY, int posX, Logica juegoActual) {
		puntaje = 50;
		pos = new Posicion( posX+((25-18)/2), posY+((25-19)/2), 18, 19);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(5, pos);
		juego = juegoActual;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		serComido();
		entGrafica.setIcon(null);
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void serComido() {
		juego.actualizarPuntaje(puntaje);
		juego.cambiarEstados('P', 13);
	}

}
