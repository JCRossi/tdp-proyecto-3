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

	@Override
	public int getIndiceArreglo(char c) {
		int retorno = 0;
		
		switch(c) {
		case 'l':
			retorno = 4;
		break;
		case'r':
			retorno = 2;
		break;
		case 'u':
			retorno = 1;
		break;
		case 'd':
			retorno = 3;
		break;
		
		}
		return retorno;
	}

}
