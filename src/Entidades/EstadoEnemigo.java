package Entidades;

public interface EstadoEnemigo {

	char estadoActual();
	
	int getMovimiento();

	char[] calcularProximaPosicion(Posicion pos);
	
	public int getIndiceArreglo(char direccion);

	

	


}
