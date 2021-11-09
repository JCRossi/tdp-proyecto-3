package Entidades;

import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;

public abstract class Enemigo extends Personaje{

	protected EstadoEnemigo estadoActual;
	
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
	public ListaSimplementeEnlazada chequearMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
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
