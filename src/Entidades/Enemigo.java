package Entidades;

import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;

public abstract class Enemigo extends Personaje{

	protected EstadoEnemigo estadoActual;
	protected Jugador jugador;
	protected int[] ultimaZona;
	
	
	@Override
	public void mover() {
			int posX = pos.getX();
			int posY = pos.getY();
			if(posX%25>0 && posX%25<3 && posY%25>2 && posY%25<5 && (ultimaZona[0]!=posX/25 || ultimaZona[1]!=posY/25)) {
				actualizarDireccion();
				ultimaZona[0] = posX/25;
				ultimaZona[1] = posY/25;
			} else {
				ListaSimplementeEnlazada<Entidad> listaEntidadesColision = chequearMovimiento(direccion, estadoActual.getMovimiento());
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
		while (!puedeCaminar || esVuelta) {
			puedeCaminar = true;
			esVuelta = false;
			procesarColisiones(chequearMovimiento(prioridadDireccion[i], calcularMovimiento(prioridadDireccion[i])));
			esVuelta = checkearVuelta(prioridadDireccion[i]);
			i++;
		}
		if (prioridadDireccion[i-1] != direccion) {
			cambiarDireccion(prioridadDireccion[i-1]);
		} 
	}

	private int calcularMovimiento(char c) {
		int mov = 0;
		switch(c) {
		case 'l':
			mov = (pos.getX()%10); 
			break;
		case'r':
			mov = 3-(pos.getX()%10); 
			break;
		case 'u':
			mov = (pos.getY()%10); 
			break;
		case 'd':
			mov = 7-(pos.getY()%10); 
			break;
		}
		return mov+10; // le agregue un +10 pq falla en las colisiones con las paredes, no comprendo porque ya que en el jugador funciona
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
		return entidad.colisionasteConEnemigo(this);
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
		System.out.println("colision con jugador");
		return false;
	}

	public ListaSimplementeEnlazada<Entidad> chequearMovimiento(char direc, int mov) {
		return miLaberinto.chequearColision(pos, mov, direc);
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

	public abstract void cambiarEstado(int estado);
}
