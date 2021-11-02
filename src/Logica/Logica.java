package Logica;

import Laberinto.*;
import Entidades.*;
import GUI.GUI;

public class Logica {
	private Laberinto laberinto;
	private Jugador personajePrincipal;
	private Enemigo enemigos[];
	private Nivel nivel;
	private GUI interfaz;
	
	public Logica() {
		personajePrincipal = new Jugador();
		/*enemigos[0] = new Blinky();
		 *enemigos[1] = new Inky();
		 *enemigos[2] = new Pinky();
		 *enemigos[3] = new Clyde();
		 */
		laberinto = new Laberinto();
		generarNivel(1);
	}
	
	public void generarNivel(int numero) {
		nivel = new Nivel(numero);
		laberinto.generarConsumiblesLaberinto(numero);
	}
	
	public void chequearEstadoJugador() {
		
	}
	
	public void cambiarDireccionJugador(char c) {
		personajePrincipal.cambiarDireccion(c);
	}
	
	public void actualizarPuntaje(int puntos) {
		
	}
	
	public void avisarActualizacionLaberintoGrafico() {
		laberinto.recuperarEntidades();
		//interfaz.actualizarLaberintoGrafico();
	}
	
	public void avisarActualizacionJugadorGrafico() {
		
	}
	
	public void avisarActualizacionEnemigosGraficos() {
		
	}
	
	//Chequear si se esta en el ultimo nivel o no tambien chequear si pacman perdio todas las vidas cuando muere
	public void chequerFinalizacionJuego() {
		
	}
	
	public void finalizarJuego() {
		
	}
}
