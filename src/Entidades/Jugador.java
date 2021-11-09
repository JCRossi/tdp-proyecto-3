package Entidades;

import java.awt.Rectangle;

import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;
import Hilos.HiloJugador;
import Laberinto.Laberinto;

public class Jugador extends Personaje {
	
	private EstadoJugador[] estados;
	private EstadoJugador estadoActual;
	private Thread hilo;
	private HiloJugador hiloMovimiento;
	
	public Jugador(int posX, int posY, char direcc, Laberinto milaberinto) {
		
		pos = new Posicion( posX+((25-22)/2), posY+((25-18)/2), 22, 18);  //250 - 350     		
		
		entGrafica = new EntidadGrafica(8 ,pos); 
		this.direccion = direcc;
		estados = new EstadoJugador[3];
		estados[0] = new Normal();
		estados[1] = new Rapido(); 
		estados[2] = new Inmune();
		estadoActual = estados[0];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		miLaberinto.incorporarEntidad(this);
		
		hiloMovimiento = new HiloJugador(this);
		hilo = new Thread(this.hiloMovimiento);
	

		hilo.start();

	}

	@Override
	public void mover() {
		if(puedeCaminar) {
		ListaSimplementeEnlazada<Entidad> listaEntidadesColision = chequearMovimiento();
		
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
		
			
		
		} catch(EmptyListException | InvalidPositionException | BoundaryViolationException exc) {
			exc.printStackTrace();
		}
		}
			
	}

	@Override
	public boolean colision(Entidad entidad) {
		
		return entidad.colisionasteConJugador(this);
	}

	@Override
	public void morir() {
		
		
	}
	public void noPuedeCaminar() {
		puedeCaminar = false;
	}

	@Override
	public char getEstado() {
		
		return 0;
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {

		return false;
	}

	@Override
	public ListaSimplementeEnlazada<Entidad> chequearMovimiento() {
		
		return miLaberinto.chequearColision(pos, estadoActual.getMovimiento(), direccion);
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
	}

	@Override
	public Posicion getPosicion() {
		return pos;
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return entGrafica;
	}
	
	
	public void actualizarPosGrafica() {
		entGrafica.actualizarPos(pos);
	}
	
	public void cambiarDireccion(char c) {
		direccion = c;
		puedeCaminar = true;
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

}
