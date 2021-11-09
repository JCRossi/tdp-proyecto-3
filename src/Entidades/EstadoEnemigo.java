package Entidades;

public interface EstadoEnemigo {

	char estadoActual();
	
	int getMovimiento();

	char calcularProximaPosicion(int posX, int posY);
	


}
