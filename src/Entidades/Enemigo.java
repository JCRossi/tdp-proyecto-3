package Entidades;

import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;

public abstract class Enemigo extends Personaje{

	protected EstadoEnemigo estadoActual;
	protected Jugador jugador;
	
	
	@Override
	public void mover() {

			if(pos.getX()%25<3 && pos.getY()%25<3) {
				actualizarDireccion();
			} else {
				ListaSimplementeEnlazada<Entidad> listaEntidadesColision = chequearMovimiento(direccion);
				procesarColisiones(listaEntidadesColision);
			}
			
			
			actualizarPos();
			actualizarPosGrafica();
		
	}

	private void procesarColisiones(ListaSimplementeEnlazada<Entidad> listaEntidadesColision) {
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
		
		} catch(EmptyListException | InvalidPositionException | BoundaryViolationException exc) {
			exc.printStackTrace();
		}
	}

	private void actualizarDireccion() {
		char[] prioridadDireccion = estadoActual.calcularProximaPosicion(jugador.getPosicion().getX(),jugador.getPosicion().getY(), pos);
		puedeCaminar = false;
		boolean esVuelta = true;
		int i = 0;
		while (puedeCaminar && !esVuelta) {
			puedeCaminar = true;
			procesarColisiones(chequearMovimiento(prioridadDireccion[i]));
			esVuelta = checkearVuelta(prioridadDireccion[i]);
			i++;
		}
		if (prioridadDireccion[i-1] != direccion) {
			cambiarDireccion(prioridadDireccion[i-1]);
		} 
	}

	private boolean checkearVuelta(char direc) {
		boolean esVuelta = true;
		switch(direccion) {
		case 'l':
			if (direc != 'r')
				esVuelta = false; 
			break;
		case'r':
			if (direc != 'l')
				esVuelta = false;  
			break;
		case 'u':
			if (direc != 'd')
				esVuelta = false; 
			break;
		case 'd':
			if (direc != 'u')
				esVuelta = false; 
			break;
		}
		return esVuelta;
	}

	@Override
	public boolean colision(Entidad entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getEstado() {
		return 'c';
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListaSimplementeEnlazada<Entidad> chequearMovimiento(char direc) {
		return miLaberinto.chequearColision(pos, estadoActual.getMovimiento(), direc);
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void noPuedeCaminar() {
		puedeCaminar = false;
		
	}
	
	private void actualizarPosGrafica() {
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
