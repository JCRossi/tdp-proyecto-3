package Entidades;

public class Perseguir implements EstadoEnemigo {

	public Perseguir(char enemigo) {
		
	}

	@Override
	public int getMovimiento() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public char estadoActual() {
		// TODO Auto-generated method stub
		return 'p';
	}

	@Override
	public char[] calcularProximaPosicion(int posX, int posY, Posicion pos) {
		int movVertical = pos.getY() - posY;
		int movHorizontal = pos.getX() - posX;
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

}
