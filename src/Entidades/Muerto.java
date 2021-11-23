package Entidades;

public class Muerto implements EstadoEnemigo {

	@Override
	public int getMovimiento() {
		return 3;
	}

	@Override
	public char estadoActual() {
		return 'm';
	}

	@Override
	public char[] calcularProximaPosicion(Posicion pos) { 
		int movVertical = pos.getY() - 250;
		int movHorizontal = pos.getX() - 250;
		char[] prioridades = new char[4];
		
		if(Math.abs(movVertical) >= Math.abs(movHorizontal)) {
			if (movVertical > 0) {
				prioridades[0] = 'u';
				prioridades[3] = 'd';
			} else {
				prioridades[3] = 'u';
				prioridades[0] = 'd';
			}
			if (movHorizontal > 0) {
				prioridades[1] = 'l';
				prioridades[2] = 'r';
			} else {
				prioridades[2] = 'l';
				prioridades[1] = 'r';
			}
		} else {
			if (movVertical > 0) {
				prioridades[1] = 'u';
				prioridades[2] = 'd';
			} else {
				prioridades[2] = 'u';
				prioridades[1] = 'd';
			}
			if (movHorizontal > 0) {
				prioridades[0] = 'l';
				prioridades[3] = 'r';
			} else {
				prioridades[3] = 'l';
				prioridades[0] = 'r';
			}
		}
		return prioridades;
	}

	@Override
	public int getIndiceArreglo(char direccion) {
			
		return 0;
	}



}
