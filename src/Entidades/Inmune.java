package Entidades;

public class Inmune implements EstadoJugador {
	private int movimiento;
	
	public Inmune(int velocidad) {
		movimiento = velocidad;
	}
	
	public char estadoActual() {
		return 'i';
	}
	
	public int getMovimiento() {
		return movimiento;
	}

}
