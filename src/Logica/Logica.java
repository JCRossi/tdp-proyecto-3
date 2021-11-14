package Logica;

import Laberinto.*;
import Entidades.*;
import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;
import GUI.GUI;
import GUI.Tematica;
import Hilos.HiloBomba;
import Hilos.HiloEnemigo;
import Hilos.HiloJugador;

public class Logica {
	private Puntaje puntajePartida;
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
		laberinto = new Laberinto(this);
		
		personajePrincipal = new Jugador(250, 350,'r',laberinto, this,tematica.getImagenesPacman());

		
		hiloEnemigos = new HiloEnemigo();
		hilo = new Thread(this.hiloEnemigos);
		enemigos = new Enemigo[1];
		enemigos[0] = new Blinky(225, 250, 'r',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma1());
		puntajePartida = new Puntaje();
		
		generarNivel(1);	
		hilo.start();
	}
	
	public void generarNivel(int numero) {
		nivel = new Nivel(numero);
		laberinto.agregarObjetosLaberinto(nivel.GenerarLaberinto(numero, this));
	}
	
	public void cambiarEstados(char efecto) {
		switch(efecto) {
			case 'P':
				personajePrincipal.cambiarEstado(0);
				
				for(int i = 0; i < enemigos.length; i++)
					enemigos[i].cambiarEstado(1);
				break;
			case '2':
				personajePrincipal.cambiarEstado(1);
				break;
			case 'I':
				personajePrincipal.cambiarEstado(2);
				break;
			case 'B':
				personajePrincipal.cambiarEstado(3);
				break;
			case 'N':
				personajePrincipal.cambiarEstado(0);
				
				for(int i = 0; i < enemigos.length; i++)
					enemigos[i].cambiarEstado(0);
				break;
		}
	}
	
	public void chequearEstadoJugador() {
		boolean noPersiguiendoOMuerto = true;
		
		for(int i = 0; i < enemigos.length && noPersiguiendoOMuerto; i++) {
			if(enemigos[i].getEstado() != 'p' || enemigos[i].getEstado() != 'm') {
				noPersiguiendoOMuerto = true;
			}
		}
			
		if(noPersiguiendoOMuerto == true)
			cambiarEstados('N');
	}
	
	public void cambiarDireccionJugador(char c) {
		personajePrincipal.cambiarDireccion(c);
	}
	
	public void actualizarPuntaje(int puntos) {
		puntajePartida.sumarPuntaje(puntajePartida.obtenerPuntaje() + puntos);
		avisarActualizacionPuntajeGrafico(puntajePartida.obtenerPuntaje());
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
	
	public void avisarActualizacionPuntajeGrafico(int puntos) {
		
	}
	public void aumentarBombas() {
		this.personajePrincipal.aumentarBomba();
	}
	
	public void plantarBomba(){
		if(personajePrincipal.tieneBomba()){
			Posicion pos = personajePrincipal.getPosicion();
			Bomba bomba = new Bomba(pos.getY(),pos.getX(),this);
			interfaz.agregarEntidad(bomba.getEntidadGrafica());
			
			System.out.println("Plantaste la bomba");
			HiloBomba hbomba = new HiloBomba(bomba);
			Thread hilo = new Thread(hbomba);
			hilo.start();
			personajePrincipal.disminuirBomba();
		}


	}
	
	public void estallido(Posicion pos) {
		Personaje[] personajes = new Personaje[5];
		ListaSimplementeEnlazada<Personaje> listaEntidades;
		System.out.println("EXPLOTO LA BOMBA");
		
		personajes[0] = this.personajePrincipal;
		
		for(int i=1; i<=enemigos.length;i++) {
			personajes[i] = enemigos[i-1];
		}
		
		listaEntidades = laberinto.chequeoColisionMasivoRIPSeresVivos(pos, personajes);
		
		for(Personaje ent: listaEntidades) {
			if(ent !=null) {
				System.out.println("SE MURIO ALGUIEN");
				ent.morir();
			}
		}
		
	}
	
	//Chequear si se esta en el ultimo nivel o no tambien chequear si pacman perdio todas las vidas cuando muere
	public void chequerFinalizacionJuego() {
		
	}
	
	public void finalizarJuego() {
		
	}

	public void desenlistarEntidad(int posX, int posY, Entidad entidad) {
		laberinto.desenlistarEntidad(entidad, posX, posY);
	}
	
	public void agregarEntidadGrafica(EntidadGrafica entGraf) {
		interfaz.agregarEntidad(entGraf);
	}

	public void quitarEntidadGrafica(EntidadGrafica entGrafica) {
		interfaz.quitarEntidad(entGrafica);	
	}
	
}
