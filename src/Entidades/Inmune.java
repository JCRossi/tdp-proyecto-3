package Entidades;

public class Inmune implements EstadoJugador {
	private int movimiento;
	
	public char estadoActual() {
		return 'i';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
