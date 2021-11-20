package IA;

import Entidades.Jugador;
import Entidades.Posicion;

public class IAClyde extends IA {
	
	public IAClyde(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public char[] calcularProximaPosicion(Posicion pos) {
		char[] prioridades = new char[4];
		int dentroDeAreaJugador = 1;
		
		dentroDeAreaJugador = chequearSiEstaEnAreaJugador(pos.getX(), pos.getY());
		
		switch(dentroDeAreaJugador) {
			case 0:
				prioridades = proxPosicion(pos, jugador.getPosicion().getX(), jugador.getPosicion().getY());
				break;
			case 1:
				prioridades = proxPosicion(pos, 50, 425);
				break;
		}
		
		return prioridades;
	}

	@Override
	public int getMovimiento() {
		return 2;
	}
	
	private int chequearSiEstaEnAreaJugador(int posX, int posY) {
		int estaEnArea = 0;
		int distEnX = (jugador.getPosicion().getX() + 22/2) - (posX + 23/2);
		int distEnY = (jugador.getPosicion().getY() + 18/2) - (posY + 23/2);
		int calculoChequeo = (int) Math.sqrt(cuadradoDeNumero(distEnX) + cuadradoDeNumero(distEnY));
		
		if(calculoChequeo <= 200)
			estaEnArea = 1;
		else
			estaEnArea = 0;
		
		return estaEnArea;
	}
	
	private int cuadradoDeNumero(int numero) {
		return numero*numero;
	}
	
	private char[] proxPosicion(Posicion pos, int posObjetivoX, int posObjetivoY) {
		int movVertical = pos.getY() - posObjetivoY;
		int movHorizontal = pos.getX() - posObjetivoX;
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
}
