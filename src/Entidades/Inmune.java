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

	@Override
	public int getIndiceArreglo(char c) {
		int retorno = 0;
		
		switch(c) {
		case 'l':
			retorno = 16;
		break;
		case'r':
			retorno = 14;
		break;
		case 'u':
			retorno = 13;
		break;
		case 'd':
			retorno = 15;
		break;
		
		}
		return retorno;
	}

}
