package Entidades;

public class Normal implements EstadoJugador {
	private int movimiento;
	
	public Normal() {
		this.movimiento = 1;
	}
	
	public char estadoActual() {
		return 'n';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
