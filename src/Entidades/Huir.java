package Entidades;

public class Huir implements EstadoEnemigo {

	@Override
	public int getMovimiento() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public char estadoActual() {
		// TODO Auto-generated method stub
		return 'h';
	}

	@Override
	public char[] calcularProximaPosicion(int posX, int posY, Posicion pos) {
		int movVertical = pos.getY() - posY;
		int movHorizontal = pos.getX() - posX;
		char[] prioridades = new char[4];
		if(Math.abs(movVertical) >= Math.abs(movHorizontal)) {
			if (movVertical > 0) {
				prioridades[3] = 'u';
				prioridades[0] = 'd';
			} else {
				prioridades[0] = 'u';
				prioridades[3] = 'd';
			}
			if (movHorizontal > 0) {
				prioridades[2] = 'l';
				prioridades[1] = 'r';
			} else {
				prioridades[1] = 'l';
				prioridades[2] = 'r';
			}
		} else {
			if (movVertical > 0) {
				prioridades[2] = 'u';
				prioridades[1] = 'd';
			} else {
				prioridades[1] = 'u';
				prioridades[2] = 'd';
			}
			if (movHorizontal > 0) {
				prioridades[3] = 'l';
				prioridades[0] = 'r';
			} else {
				prioridades[0] = 'l';
				prioridades[3] = 'r';
			}
		}
		return prioridades;
	}

	@Override
	public int getIndiceArreglo(char direccion) {
		int retorno = 0;
		
		switch(direccion) {
		case 'l':
			retorno = 8;
		break;
		case'r':
			retorno = 6;
		break;
		case 'u':
			retorno = 5;
		break;
		case 'd':
			retorno = 7;
		break;
		
		}
		return retorno;
	}

}
