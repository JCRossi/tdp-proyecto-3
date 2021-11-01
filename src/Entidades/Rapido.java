package Entidades;

public class Rapido implements EstadoJugador {
	private int movimiento;
	
	public char estadoActual() {
		return 'r';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
