package IA;

import Entidades.Jugador;
import Entidades.Posicion;
import Entidades.Enemigo;
public class IAInky extends IA{
	
	private Enemigo Blinky;
	
	public IAInky(Jugador jugador, Enemigo blinky) {
		this.jugador = jugador;
		this.Blinky = blinky;
	}

	@Override
	public char[] calcularProximaPosicion(Posicion pos) {
		
		int ejeY = 2*Math.abs(Blinky.getPosicion().getY() - jugador.getPosicion().getY());
		int ejeX = 2*Math.abs(Blinky.getPosicion().getX() - jugador.getPosicion().getX());
		
		
		int movVertical = pos.getY() - ejeY;
		int movHorizontal = pos.getX() - ejeX;
		
		char[] prioridades = new char[4];
		
		if(Math.abs(movVertical) >= Math.abs(movHorizontal)) {
			if (movVertical > 0) {
				prioridades[0] = 'u';
				prioridades[3] = 'd';
			} else {
				prioridades[3] = 'u';
				prioridades[0] = 'd';
			}
			if (movHorizontal > 0) {
				prioridades[1] = 'l';
				prioridades[2] = 'r';
			} else {
				prioridades[2] = 'l';
				prioridades[1] = 'r';
			}
		} else {
			if (movVertical > 0) {
				prioridades[1] = 'u';
				prioridades[2] = 'd';
			} else {
				prioridades[2] = 'u';
				prioridades[1] = 'd';
			}
			if (movHorizontal > 0) {
				prioridades[0] = 'l';
				prioridades[3] = 'r';
			} else {
				prioridades[3] = 'l';
				prioridades[0] = 'r';
			}
		}
		

		return prioridades;
	}

	@Override
	public int getMovimiento() {
		return 1;
	}
	

}
