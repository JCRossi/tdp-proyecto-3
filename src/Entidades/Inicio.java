package Entidades;

public class Inicio implements EstadoEnemigo {
	private int posicionX;
	private int posicionY;
	
	public Inicio(int x, int y) {
		posicionX = x;
		posicionY = y;
	}
	@Override
	public char estadoActual() {
		return 'i';
	}

	@Override
	public int getMovimiento() {
		return 2;
	}

	@Override
	public char[] calcularProximaPosicion(Posicion pos) {
		int movVertical = pos.getY();
		int movHorizontal = pos.getX();
		char[] prioridades = new char[4];
		if (movVertical/10 == 25 && movHorizontal/10 == 25) {
			prioridades[0] = 'u';
		} else {
			movVertical -= posicionY;
			movHorizontal -= posicionX;
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
		}
		return prioridades;
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
