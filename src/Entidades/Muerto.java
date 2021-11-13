package Entidades;

public class Muerto implements EstadoEnemigo {

	@Override
	public int getMovimiento() {
		return 4;
	}

	@Override
	public char estadoActual() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char[] calcularProximaPosicion(int posX, int posY, Posicion pos) {
		// TODO Auto-generated method stub
		return null;
	}



}
