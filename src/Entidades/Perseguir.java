package Entidades;

import IA.IA;

public class Perseguir implements EstadoEnemigo {

	private IA ia;
	
	public Perseguir(IA ia) {
		this.ia = ia;
	}

	@Override
	public int getMovimiento() {
		return 2;
	}

	@Override
	public char estadoActual() {
		return 'p';
	}

	@Override
	public char[] calcularProximaPosicion(Posicion pos) {
		return ia.calcularProximaPosicion(pos);
	}

	@Override
	public int getIndiceArreglo(char direccion) {
		int retorno = 0;
		
		switch(direccion) {
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
