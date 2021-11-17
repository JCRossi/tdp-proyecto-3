package Logica;

import Laberinto.*;

import javax.swing.JLabel;

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
	
	public Logica() { 
		laberinto = new Laberinto();
		hiloEnemigos = new HiloEnemigo();
		hilo = new Thread(this.hiloEnemigos);
		enemigos = new Enemigo[2];
		puntajePartida = new Puntaje();
	}
	
	public void setTematica(Tematica t) {
		this.tematica = t;
	}
	
	/*public void iniciarLogica(GUI interfaz) {
		this.interfaz = interfaz;
		laberinto = new Laberinto();
		
		personajePrincipal = new Jugador(250, 350,'r',laberinto, this,tematica.getImagenesPacman());

		
		hiloEnemigos = new HiloEnemigo();
		hilo = new Thread(this.hiloEnemigos);
		enemigos = new Enemigo[1];
		enemigos[0] = new Blinky(225, 250, 'r',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma1());
		puntajePartida = new Puntaje();
		avisarActualizacionVidaGrafica(personajePrincipal.getVidas());
		generarNivel(1);
		hilo.start();
	}
	
	public void generarNivel(int numero) {
		nivel = new Nivel(numero);
		laberinto.establecerNivel(nivel.GenerarLaberinto(this, enemigos, personajePrincipal));
	}*/
	
	public void iniciarLogica(GUI interfaz) {
		this.interfaz = interfaz;
		
		personajePrincipal = new Jugador(250, 350,'r',laberinto, this,tematica.getImagenesPacman());
		avisarActualizacionVidaGrafica(personajePrincipal.getVidas());
		
		enemigos[0] = new Blinky(225, 250, 'r',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma1());
		enemigos[1] = new Pinky(275, 250, 'l',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma2());
		nivel = new Nivel(1);
		generarNivel(nivel.getNumeroNivel());
		hilo.start();
	}
	
	public void generarNivel(int numero) {
		nivel.establecerVelocidadesNivel(numero);
		laberinto.establecerNivel(nivel.GenerarLaberinto(this, enemigos, personajePrincipal));
	}
	
	public void establecerPersonajePrincipal(Jugador personajeP) {
		personajePrincipal = personajeP;
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
	
	public void enlistarEntidadGrafica(Entidad entidad) {
		interfaz.agregarEntidad(entidad.getEntidadGrafica());
	}
	
	public void avisarActualizacionJugadorGrafico() {
		
	}
	
	public void avisarActualizacionEnemigosGraficos() {
		
	}
	
	public void avisarActualizacionPuntajeGrafico(int puntos) {
		interfaz.actualizarPuntajeGrafico(puntos);
	}
	
	public void avisarActualizacionVidaGrafica(int cantVidas) {
		interfaz.actualizarVidaGrafica(cantVidas);
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
	/*public boolean chequearFinalizacionJuego(int vidasJugador) {
		boolean continuaJuego = true;
		
		if(vidasJugador == 0)
			continuaJuego = false;
		else
			avisarActualizacionVidaGrafica(vidasJugador);
		
		return continuaJuego;
	}*/
	
	public boolean chequearFinalizacionJuego(int condicionDeLlamado) {
		boolean continuaJuego = true;
		boolean cambiarNivel = false;
		
		switch(condicionDeLlamado) {
			case 1:
				if(personajePrincipal.getVidas() == 0)
					continuaJuego = false;
				else
					avisarActualizacionVidaGrafica(personajePrincipal.getVidas());
				break;
			case 2:
				if(nivel.obtenerCantidadPacDots() == 0)
					generarNivel(nivel.getNumeroNivel());
				break;
		}
		
		return continuaJuego;
	}
	
	public void finalizarJuego() {
		//Avisar finalizacion juego
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
	
	public void seComioPacDot() {
		nivel.decrementarCantidadPacDots();
		chequearFinalizacionJuego(2);
	}
}
