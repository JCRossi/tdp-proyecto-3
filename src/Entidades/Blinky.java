package Entidades;

import Hilos.HiloEnemigo;
import Laberinto.Laberinto;
import Logica.Logica;

public class Blinky extends Enemigo{
	
		private EstadoEnemigo[] estados;

		public Blinky(int posX, int posY, char direcc, Laberinto milaberinto, HiloEnemigo hiloEnemigo, Jugador personajePrincipal,Logica miJuego,String[] img) {
		
		pos = new Posicion( posX+1, posY+1, 23, 23);	
		ultimaZona = new int[2];
		ultimaZona[0] = posX/25;
		ultimaZona[1] = posY/25;
		entGrafica = new EntidadGrafica(8 ,pos,img); 
		this.direccion = direcc;
		estados = new EstadoEnemigo[4];
		estados[0] = new Perseguir('b');
		estados[1] = new Huir(); 
		estados[2] = new Muerto();
		estados[3] = new Inicio();
		estadoActual = estados[3];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		miLaberinto.incorporarEntidad(this);
		jugador = personajePrincipal;
		this.juego = miJuego;
		hiloEnemigo.set(this);
		posicionInicialY = 375; 
		posicionInicialX = 450; 
	}
		
	public void cambiarEstado(int estado) {
		if(estadoActual != estados[2])
			estadoActual = estados[estado];
		//Falta cambiar la EntidadGrafica correspondiente al estado
		entGrafica.actualizarImagen(this.estadoActual.getIndiceArreglo(this.direccion), pos);
	}
	
	

	
}
