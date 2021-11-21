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
	private boolean enTransicion;
	
	public Logica() { 
		laberinto = new Laberinto();
		hiloEnemigos = new HiloEnemigo();
		hilo = new Thread(this.hiloEnemigos);
		enemigos = new Enemigo[2];
		puntajePartida = new Puntaje();
		enTransicion = false;
	}
	
	public void setTematica(Tematica t) {
		this.tematica = t;
	}
	
	public void iniciarLogica(GUI interfaz) {
		this.interfaz = interfaz;
		
		personajePrincipal = new Jugador(250, 350,'r',laberinto, this,tematica.getImagenesPacman());
		avisarActualizacionVidaGrafica(personajePrincipal.getVidas());
		
		enemigos[0] = new Blinky(225, 250, 'r',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma1());
		enemigos[1] = new Pinky(275, 250, 'l',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma2());
		//enemigos[2] = new Inky(275, 250, 'l',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma3(),enemigos[0]);
		//enemigos[3] = new Clyde(250, 250, 'u', laberinto, hiloEnemigos, personajePrincipal, this, this.tematica.getImagenesFantasma4());
		nivel = new Nivel(1,tematica);
		generarNivel(nivel.getNumeroNivel());
		hilo.start();
	}
	
	public void generarNivel(int numero) {
		//nivel.establecerVelocidadesNivel(numero);
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
			case 'J':
				personajePrincipal.cambiarEstado(0);
				break;
				
			case 'E':
				for(int i = 0; i < enemigos.length; i++) {
					if(!enemigos[i].estaMuerto())
						enemigos[i].swapEstadoAuxiliar();
				}
					
					
				break;
				
		}
	}
	
	public void enemigosGuardanEstado() {
		for(int i = 0; i < enemigos.length; i++) 
			if(!enemigos[i].estaMuerto())
				enemigos[i].usarEstadoAuxiliar();
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
		if(!this.enTransicion)
			personajePrincipal.cambiarDireccion(c);
	}
	
	public void actualizarPuntaje(int puntos) {
		puntajePartida.sumarPuntaje(puntajePartida.obtenerPuntaje() + puntos);
		avisarActualizacionPuntajeGrafico(puntajePartida.obtenerPuntaje());
	}
	
	public void enlistarEntidadGrafica(Entidad entidad) {
		interfaz.agregarEntidad(entidad.getEntidadGrafica());
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
			Bomba bomba = new Bomba(pos.getY(),pos.getX(),this,tematica.getImagenBomba());
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
		
		switch(condicionDeLlamado) {
			case 1:
				if(personajePrincipal.getVidas() == 0)
					continuaJuego = false;
				
				avisarActualizacionVidaGrafica(personajePrincipal.getVidas());
				break;
			case 2:
				if(nivel.obtenerCantidadPacDots() == 0)
					if(nivel.getNumeroNivel() < 3) {
						quitarEntidadGrafica(personajePrincipal.getEntidadGrafica());
						for(int i = 0; i < enemigos.length; i++) {
							quitarEntidadGrafica(enemigos[i].getEntidadGrafica());
						}
						resetearMapa();						
						generarNivel(nivel.getNumeroNivel() + 1);
						reseteoEnNivel(false);
						personajePrincipal.setVidas(personajePrincipal.getVidas() + 1);
					}
					else
						finalizarJuego(2);
				break;
		}
		
		return continuaJuego;
	}
	
	public void finalizarJuego(int condicionDeFinalizacion) {
		hiloEnemigos.frenar();
		personajePrincipal.obtenerHilo().frenar();
		
		switch(condicionDeFinalizacion) {
			case 1:
				//Falta mensaje de perder
				break;
			case 2:
				//Falta mensaje ganar
				break;
		}
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
	
	public void reseteoEnNivel(boolean debeEsperar) {
        this.enTransicion = true;
        //enemigos[0] = new Blinky(225, 250, 'r',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma1());
        //enemigos[1] = new Pinky(275, 250, 'l',laberinto, hiloEnemigos, personajePrincipal,this,this.tematica.getImagenesFantasma2());
        this.hiloEnemigos.frenar();

        for(Enemigo enemig : enemigos) {
            enemig.setPuedeCaminar(false);
            this.laberinto.desenlistarEntidad(enemig, laberinto.identificarZona( enemig.getPosicion().getX()),  laberinto.identificarZona(enemig.getPosicion().getY()));
        }



        Posicion posJugador = personajePrincipal.getPosicion();
        this.personajePrincipal.setPuedeCaminar(false);

        this.personajePrincipal.getEntidadGrafica().actualizarImagen(0, posJugador);
        this.laberinto.desenlistarEntidad(personajePrincipal, laberinto.identificarZona(posJugador.getX()),  laberinto.identificarZona(posJugador.getY()));

        //ROMPE LA SALIDA DE LOS FANTASMAS DE LA CASA
        /*try {
        	if(debeEsperar)
        		Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        posJugador.setX(250);
        posJugador.setY(350);
        personajePrincipal.setDireccion('r');
        this.personajePrincipal.getEntidadGrafica().actualizarImagen(2, posJugador);
        this.personajePrincipal.actualizarPosGrafica();


        this.laberinto.incorporarEntidad(personajePrincipal);

        enemigos[0].reseteo(225, 250, 'r');
        enemigos[1].reseteo(275,250,'l');
        //enemigos[2].reseteo(275, 250, 'l');
        //enemigos[3].reseteo(250, 250, 'u');

        for(Enemigo enemig : enemigos) {
            enemig.setPuedeCaminar(true);
            enemig.setAcabaDeSerTeletransportado(true);
            this.laberinto.incorporarEntidad(enemig);
        }

        this.enTransicion = false;
        this.hiloEnemigos.continuar();

		
	}
	
	public void resetearMapa(){
		Entidad entidadRecuperada = null;
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 21; j++) {
				entidadRecuperada = laberinto.recuperarEntidadZona(i, j);
				if(entidadRecuperada != null)
				quitarEntidadGrafica(entidadRecuperada.getEntidadGrafica());
			}
		}
	}
}
