package Logica;

public class Nivel {
	private int numeroNivel;
	private long movimientoEnemigos;
	private long movimientoJugador;
	
	public Nivel(int numNivel) {
		switch(numNivel) {
			case 1:
				movimientoEnemigos = 1000;
				movimientoJugador = 1250;
				break;
			case 2:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				break;
			case 3:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				break;
		}
	}
	
	public int getNumeroNivel() {
		return numeroNivel;
	}
	
	public long getMovimientoJugador() {
		return movimientoJugador;
	}
	
	public long getMovimientoEnemigos() {
		return movimientoEnemigos;
	}
}
