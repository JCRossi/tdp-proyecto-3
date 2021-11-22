package Entidades;

import Hilos.HiloPowerUp;
import Logica.Logica;

public class Inmunidad extends Pocion {
	
	public Inmunidad(int posY, int posX, Logica juegoActual,String[] img) {
		pos = new Posicion( posX+((25-19)/2), posY+((25-22)/2), 19, 21); 
		entGrafica = new EntidadGrafica(0, pos,img);
		juego = juegoActual;
		duracion = 5000;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
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
		return 'I';
	}
	
	public char getQuitarEfecto() {
		return 'J';
	}
}
