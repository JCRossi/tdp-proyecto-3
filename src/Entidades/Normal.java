package Entidades;

public class Normal implements EstadoJugador {
	private int movimiento;
	
	public Normal() {
		this.movimiento = 2;
	}
	
	public char estadoActual() {
		return 'n';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
