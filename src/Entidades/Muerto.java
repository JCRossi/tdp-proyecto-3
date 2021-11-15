package Entidades;

public class Muerto implements EstadoEnemigo {

	@Override
	public int getMovimiento() {
		return 4;
	}

	@Override
	public char estadoActual() {
		return 'm';
	}

	@Override
	public char[] calcularProximaPosicion(int posX, int posY, Posicion pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndiceArreglo(char direccion) {
		return 0;
	}



}
