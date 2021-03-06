package Entidades;

import Hilos.HiloEnemigo;
import IA.IAClyde;
import Laberinto.Laberinto;
import Logica.Logica;

public class Clyde extends Enemigo {
	
	public Clyde(int posX, int posY, char direcc, Laberinto milaberinto, HiloEnemigo hiloEnemigo, Jugador personajePrincipal,Logica miJuego,String[] img) {
		pos = new Posicion( posX+1, posY+1, 23, 23);	
		ultimaZona = new int[2];
		ultimaZona[0] = posX/25;
		ultimaZona[1] = posY/25;
		entGrafica = new EntidadGrafica(8 ,pos,img); 
		this.direccion = direcc;
		posicionInicialY = 425; 
		posicionInicialX = 50; 
		estados = new EstadoEnemigo[4];
		estados[0] = new Perseguir(new IAClyde(personajePrincipal));
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
