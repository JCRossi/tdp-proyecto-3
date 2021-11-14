package Entidades;

public interface EstadoEnemigo {

	char estadoActual();
	
	int getMovimiento();

	char[] calcularProximaPosicion(int posX, int posY, Posicion pos);
	
	public int getIndiceArreglo(char direccion);

	

	


}
