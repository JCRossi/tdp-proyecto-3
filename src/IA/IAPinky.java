package IA;

import Entidades.Jugador;
import Entidades.Posicion;

public class IAPinky extends IA{

	public IAPinky(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public char[] calcularProximaPosicion(Posicion pos) {
		int movVertical = pos.getY() - jugador.getPosicion().getX();
		int movHorizontal = pos.getX() - jugador.getPosicion().getY();
		char[] prioridades = new char[4];
		switch(jugador.getDireccion()) {
		case 'r':
			movHorizontal -=25;
			break;
		case 'l':
			movHorizontal +=25;
			break;
		case 'u':
			movVertical +=25;
			break;
		case 'd':
			movVertical -=25;
			break;
		}
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
