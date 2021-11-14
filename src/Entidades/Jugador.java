package Entidades;

import java.awt.Rectangle;

import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;
import Hilos.HiloJugador;
import Laberinto.Laberinto;
import Logica.Logica;

public class Jugador extends Personaje {
	
	private EstadoJugador[] estados;
	private EstadoJugador estadoActual;
	private Thread hilo;
	private HiloJugador hiloMovimiento;
	private int cantBombas;
	private boolean powerUp;
	
	public Jugador(int posX, int posY, char direcc, Laberinto milaberinto, Logica juegoActual,String[] imagenes) {
		
		pos = new Posicion( posX+((25-22)/2), posY+((25-18)/2), 22, 18);  //250 - 350     		
		
		entGrafica = new EntidadGrafica(2 ,pos,imagenes); 
		this.direccion = direcc;
		estados = new EstadoJugador[3];
		estados[0] = new Normal();
		estados[1] = new Rapido(estados[0].getMovimiento() * 2); 
		estados[2] = new Inmune(estados[0].getMovimiento());
		estadoActual = estados[0];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		miLaberinto.incorporarEntidad(this);
		juego = juegoActual;
		
		hiloMovimiento = new HiloJugador(this);
		hilo = new Thread(this.hiloMovimiento);
	
		powerUp = false;

		hilo.start();

	}

	@Override
	public void mover() {
		
		
		if(puedeCaminar) {
			ListaSimplementeEnlazada<Entidad> listaEntidadesColision = chequearMovimiento(direccion, estadoActual.getMovimiento());
		
		Position<Entidad> actualLeida = null;
		try {
			if(!listaEntidadesColision.isEmpty()) {
				actualLeida = listaEntidadesColision.first();
				colision(actualLeida.element());
				while (actualLeida != listaEntidadesColision.last()) {
					actualLeida = listaEntidadesColision.next(actualLeida);
					colision(actualLeida.element());
				}	
			}
			if(puedeCaminar) {
				actualizarPos();
				actualizarPosGrafica();
			}
		
			miLaberinto.desenlistarYEnlistarPersonaje(pos, direccion, estadoActual.getMovimiento(), this);
		
		} catch(EmptyListException | InvalidPositionException | BoundaryViolationException exc) {
			exc.printStackTrace();
		}
		}
			
	}

	@Override
	public boolean colision(Entidad entidad) {
		
		return entidad.colisionasteConJugador(this);
	}

	public void morir() {//FALTA IMPLEMENTAR FALTA IMPLEMENTAR FALTA IMPLEMENTAR
		if(this.estadoActual.estadoActual() != 'i') {
			System.out.println("MURIO EL PJ");
			juego.quitarEntidadGrafica(this.getEntidadGrafica());
		}
		
		
	}
	public void noPuedeCaminar(char c) {
		puedeCaminar = false;
	}

	public boolean colisionasteConJugador(Personaje personaje) {

		return false;
	}

	@Override
	public ListaSimplementeEnlazada<Entidad> chequearMovimiento(char direc, int mov) {
		return miLaberinto.chequearColision(pos, mov, direc);
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
	}

	public void actualizarPosGrafica() {
		entGrafica.actualizarPos(pos);
	}
	
	public void cambiarDireccion(char c) {
		direccion = c;
		puedeCaminar = true;
		
		if(this.estadoActual.estadoActual()=='n' && this.tieneBomba()) { //NO TENEMOS ESTADO TIENEBOMBA
			switch(direccion) {
			case 'l':
				entGrafica.actualizarImagen(8, pos);
			break;
			case'r':
				entGrafica.actualizarImagen(6, pos);
			break;
			case 'u':
				entGrafica.actualizarImagen(5, pos);
			break;
			case 'd':
				entGrafica.actualizarImagen(7, pos);
			break;
			
			}
			
		}else {
			entGrafica.actualizarImagen(this.estadoActual.getIndiceArreglo(direccion), pos);
			
		}
		
	}
	
	private void actualizarPos() {
		int posx = pos.getX();
		int posy = pos.getY();
		int velocidad = estadoActual.getMovimiento();
		
		switch(direccion) {
			case 'l':
				pos.setX(posx-velocidad);
			break;
			case'r':
				pos.setX(posx+velocidad);
			break;
			case 'u':
				pos.setY(posy-velocidad);
			break;
			case 'd':
				pos.setY(posy+velocidad);
			break;
		}
	}

	@Override
	public char getEstado() {
		return estadoActual.estadoActual();
	}
	
	public void cambiarEstado(int estado) {
		//Se comio un power-pellet

		estadoActual = estados[estado];
		
		powerUp = true;
		
		entGrafica.actualizarImagen(this.estadoActual.getIndiceArreglo(this.direccion), pos);
	}
	
	public boolean tieneBomba() {
		return(cantBombas >0);
	}
	
	public void aumentarBomba() {
		cantBombas++;
	}
	
	public void disminuirBomba() {
		cantBombas--;
	}
	
}
