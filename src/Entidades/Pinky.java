package Entidades;

import Hilos.HiloEnemigo;
import IA.IAPinky;
import Laberinto.Laberinto;
import Logica.Logica;

public class Pinky extends Enemigo{
	
		public Pinky(int posX, int posY, char direcc, Laberinto milaberinto, HiloEnemigo hiloEnemigo, Jugador personajePrincipal,Logica miJuego,String[] img) {
		
		pos = new Posicion( posX+1, posY+1, 23, 23);	
		ultimaZona = new int[2];
		ultimaZona[0] = posX/25;
		ultimaZona[1] = posY/25;
		entGrafica = new EntidadGrafica(8 ,pos,img); 
		posicionInicialY = 75; 
		posicionInicialX = 475;
		this.direccion = direcc;
		estados = new EstadoEnemigo[4];
		estados[0] = new Perseguir(new IAPinky(personajePrincipal));
		estados[1] = new Huir(personajePrincipal.getPosicion()); 
		estados[2] = new Muerto();
		estados[3] = new Inicio(posicionInicialX , posicionInicialY);
		estadoActual = estados[3];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		this.juego = miJuego;
		hiloEnemigo.set(this);
		 
	}
	
}
