package Entidades;

public class Rapido implements EstadoJugador {
	private int movimiento;
	
	public Rapido(int velocidad) {
		movimiento = velocidad;
	}
	
	public char estadoActual() {
		return 'r';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
