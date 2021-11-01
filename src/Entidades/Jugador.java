package Entidades;

import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;
import Laberinto.Laberinto;

public class Jugador extends Personaje {
	
	private EstadoJugador[] estados;
	private EstadoJugador estadoActual;
	
	public Jugador(int posX, int posY, char direcc, Laberinto milaberinto) {
		this.posicionX = posX;
		this.posicionY = posY;
		this.direccion = direcc;
		estados = new EstadoJugador[3];
		estados[0] = new Normal();
		estados[1] = new Rapido();
		estados[2] = new Inmune();
		estadoActual = estados[0];
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
		
		return miLaberinto.chequearColision(posicionX, posicionY, estadoActual.getMovimiento(), direccion);
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
	}

	@Override
	public int[] getPosicion() {
		
		return null;
	}

}
