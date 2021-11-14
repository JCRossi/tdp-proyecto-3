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

	@Override
	public int getIndiceArreglo(char c) {
		int retorno = 0;
		
		switch(c) {
		case 'l':
			retorno = 12;
		break;
		case'r':
			retorno = 10;
		break;
		case 'u':
			retorno = 9;
		break;
		case 'd':
			retorno = 11;
		break;
		
		}
		return retorno;
	}

}
