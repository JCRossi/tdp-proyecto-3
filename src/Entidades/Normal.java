package Entidades;

public class Normal implements EstadoJugador {
	private int movimiento;
	
	public char estadoActual() {
		return 'n';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
