package IA;

import Entidades.Jugador;
import Entidades.Posicion;

public abstract class IA {
	
	protected Jugador jugador;

	public abstract char[] calcularProximaPosicion(Posicion pos);

	public abstract int getMovimiento();
	
}
