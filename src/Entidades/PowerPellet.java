package Entidades;

import Hilos.HiloPowerUp;
import Logica.Logica;

public class PowerPellet extends PowerUp {
	
	public PowerPellet(int posY, int posX, Logica juegoActual,String[] img) {
		puntaje = 50;
		pos = new Posicion( posX+((25-18)/2), posY+((25-19)/2), 18, 19);  
		entGrafica = new EntidadGrafica(0, pos,img);
		juego = juegoActual;
		duracion = 5000;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		serComido();
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
		juego.quitarEntidadGrafica(entGrafica);
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void serComido() {
		juego.actualizarPuntaje(puntaje);
		HiloPowerUp hiloPowUp = new HiloPowerUp(this,juego);
		Thread hilo = new Thread(hiloPowUp);
		hilo.start();
	}

	@Override
	public long getDuracion() {
		
		return duracion;
	}

	@Override
	public char getEfecto() {
		return 'P';
	}
	
	public char getQuitarEfecto() {
		return 'E';
	}

}
