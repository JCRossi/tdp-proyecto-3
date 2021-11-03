package Entidades;

import java.awt.Rectangle;

import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;
import Laberinto.Laberinto;

public class Jugador extends Personaje {
	
	private EstadoJugador[] estados;
	private EstadoJugador estadoActual;
	private Posicion pos;
	
	public Jugador(int posX, int posY, char direcc, Laberinto milaberinto) {
		
		pos = new Posicion( posX, posY, 25, 25);  //250 - 350     		
		
		entGrafica = new EntidadGrafica(3,pos); 
		this.direccion = direcc;
		estados = new EstadoJugador[3];
		estados[0] = new Normal();
		estados[1] = new Rapido(); 
		estados[2] = new Inmune();
		estadoActual = estados[0];
		
		milaberinto.incorporarEntidad(this);
	}

	@Override
	public void mover() {
		ListaSimplementeEnlazada<Entidad> listaEntidadesColision = chequearMovimiento();
		Position<Entidad> actualLeida = null;
		boolean noSePuedeMover = false;
		try {
			if(!listaEntidadesColision.isEmpty()) {
				actualLeida = listaEntidadesColision.first();
				
				while(actualLeida != null && !noSePuedeMover) {
					noSePuedeMover = colision(actualLeida.element());
				}
				if(!noSePuedeMover)
					actualizarPos();
			}
		
		} catch(EmptyListException exc) {
			exc.printStackTrace();
		}
			
			
	}

	@Override
	public boolean colision(Entidad entidad) {
		
		return entidad.colisionasteConJugador(this);
	}

	@Override
	public void morir() {
		
		
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
			pos.setX(posx+velocidad);
		break;
	
	
	}
	}

}
