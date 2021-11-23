package Entidades;

import Hilos.HiloPowerUp;
import Logica.Logica;

public class x2Velocidad extends PowerUp {
	
	public x2Velocidad(int posY, int posX, Logica juegoActual,String[] img) {
		pos = new Posicion( posX+((25-19)/2), posY+((25-20)/2), 19, 20);  
		entGrafica = new EntidadGrafica(0, pos,img);
		juego = juegoActual;
		duracion = 5000;
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
	
	public void serComido() {
		juego.seComioX2Velocidad();
		HiloPowerUp hiloPowUp = new HiloPowerUp(this);
		Thread hilo = new Thread(hiloPowUp);
		hilo.start();
	}
	
	@Override
	public long getDuracion() {
		return duracion;
	}


	@Override
	public void terminaEfecto() {
		juego.terminoEfectoX2Velocidad();
		
	}


}
