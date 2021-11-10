package Logica;

import Laberinto.*;
import Entidades.*;
import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;
import GUI.GUI;
import GUI.Tematica;
import Hilos.HiloEnemigo;
import Hilos.HiloJugador;

public class Logica {
	private Laberinto laberinto;
	private Jugador personajePrincipal;
	private Enemigo[] enemigos;
	private Nivel nivel;
	private GUI interfaz;
	private Thread hilo;
	private HiloEnemigo hiloEnemigos;
	private Tematica tematica;
	
	public Logica() { //Lo que hacia el constructor ahora lo hace iniciarLogica() pq necesito crear una logica antes de crear la gui
		//personajePrincipal = new Jugador();
		/*enemigos[0] = new Blinky();
		 *enemigos[1] = new Inky();
		 *enemigos[2] = new Pinky();
		 *enemigos[3] = new Clyde();
		 */
		
		
	}
	
	public void setTematica(Tematica t) {
		this.tematica = t;
	}
	
	public void iniciarLogica(GUI interfaz) {
		this.interfaz = interfaz;
		laberinto = new Laberinto();
		generarNivel(3);
		personajePrincipal = new Jugador(250, 350,'r',laberinto);
		hiloEnemigos = new HiloEnemigo();
		hilo = new Thread(this.hiloEnemigos);
		enemigos = new Enemigo[4];
		enemigos[0] = new Blinky(250, 225, 'u',laberinto, hiloEnemigos, personajePrincipal);
		hilo.start();
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
