package Logica;

public class Puntaje {
	private int puntos;
	
	public Puntaje() {
		puntos = 0;
	}
	
	public void sumarPuntaje(int puntos) {
		this.puntos = puntos;
	}
	
	public int obtenerPuntaje() {
		return puntos;
	}


}
