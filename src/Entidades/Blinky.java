package Entidades;

import Hilos.HiloEnemigo;
import Laberinto.Laberinto;

public class Blinky extends Enemigo{
	
		private EstadoEnemigo[] estados;
		private Thread hilo;

		public Blinky(int posX, int posY, char direcc, Laberinto milaberinto, HiloEnemigo hiloEnemigo) {
		
		pos = new Posicion( posX+((25-22)/2), posY+((25-18)/2), 22, 18);		
		
		entGrafica = new EntidadGrafica(8 ,pos); 
		this.direccion = direcc;
		estados = new EstadoEnemigo[4];
		estados[0] = new Perseguir('b');
		estados[1] = new Huir(); 
		estados[2] = new Muerto();
		estados[3] = new Inicio();
		estadoActual = estados[0];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		miLaberinto.incorporarEntidad(this);
		
		hiloEnemigo.set(this);
	

		hilo.start();

	}
}
