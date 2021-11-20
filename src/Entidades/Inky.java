package Entidades;

import Hilos.HiloEnemigo;
import IA.IAInky;
import Laberinto.Laberinto;
import Logica.Logica;

public class Inky extends Enemigo {
	
	
	private EstadoEnemigo[] estados;

	public Inky(int posX, int posY, char direcc, Laberinto milaberinto, HiloEnemigo hiloEnemigo, Jugador personajePrincipal,Logica miJuego,String[] img, Enemigo Blinky) {
		pos = new Posicion( posX+1, posY+1, 23, 23);	
		ultimaZona = new int[2];
		ultimaZona[0] = posX/25;
		ultimaZona[1] = posY/25;
		entGrafica = new EntidadGrafica(8 ,pos,img); 
		this.direccion = direcc;
		posicionInicialY = 375; 
		posicionInicialX = 450; 
		estados = new EstadoEnemigo[4];
		estados[0] = new Perseguir(new IAInky(personajePrincipal,Blinky));
		estados[1] = new Huir(personajePrincipal.getPosicion()); 
		estados[2] = new Muerto();
		estados[3] = new Inicio(posicionInicialX , posicionInicialY);
		estadoActual = estados[3];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		this.juego = miJuego;
		hiloEnemigo.set(this);
		
		
	}
	
	
	
	
	@Override
	public void reseteo(int posX, int posY, char direc) {
		this.direccion = direc;
		pos.setX(posX+1);
		pos.setY(posY+1);
		ultimaZona[0] = posX/25;
		ultimaZona[1] = posY/25;
		cambiarEstado(3);
		entGrafica.actualizarPos(pos);
	}

	@Override
	public void cambiarEstado(int estado) {
		if(estadoActual != estados[2])
			estadoActual = estados[estado];
		else if ((pos.getX()/25==10)&&(pos.getY()/25==10)) {
			estadoActual = estados[estado];
			direccion = 'u';
		}
			
		entGrafica.actualizarImagen(this.estadoActual.getIndiceArreglo(this.direccion), pos);
	}

}
