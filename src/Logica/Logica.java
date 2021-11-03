package Logica;

import Laberinto.*;
import Entidades.*;
import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;
import GUI.GUI;

public class Logica {
	private Laberinto laberinto;
	private Jugador personajePrincipal;
	private Enemigo enemigos[];
	private Nivel nivel;
	private GUI interfaz;
	
	public Logica(GUI interfaz) {
		//personajePrincipal = new Jugador();
		/*enemigos[0] = new Blinky();
		 *enemigos[1] = new Inky();
		 *enemigos[2] = new Pinky();
		 *enemigos[3] = new Clyde();
		 */
		this.interfaz = interfaz;
		laberinto = new Laberinto();
		generarNivel(1);
		personajePrincipal = new Jugador(250, 350,'r',laberinto);
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
		ListaSimplementeEnlazada<Entidad>[][] entidades = laberinto.recuperarEntidades();
		for(int i = 0; i < 21; i++)
			for(int j = 0; j < 21; j++)
				try {
					if(entidades[i][j].size()!=0)
						interfaz.agregarEntidad(entidades[i][j].first().element().getEntidadGrafica());
				} catch (EmptyListException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
