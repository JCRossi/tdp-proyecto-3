package Entidades;

import java.util.LinkedHashSet;

import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;

public abstract class Enemigo extends Personaje{

	protected EstadoEnemigo estadoActual;
	protected int[] ultimaZona;
	protected int posicionInicialX;
	protected int posicionInicialY;
	protected boolean debeFrenar;
	
	
	@Override
	public synchronized void mover() {
		if(!debeFrenar) {
			int posX = pos.getX();
			int posY = pos.getY();
			char estado = estadoActual.estadoActual();
			System.out.println(estado + " pos x: " + posX + " pos y:" + posY);
			if(posX/25 == 10  && posY/25  == 10  && estado=='m') {
				cambiarEstado(3);
			}
			
			if(posX/25 == posicionInicialX/25  && posY/25  == posicionInicialY/25  && estado=='i') {
				cambiarEstado(0);
			}
			
			if(posX%25>=0 && posX%25<=2 && posY%25>=0 && posY%25<=2 && (ultimaZona[0]!=posX/25 || ultimaZona[1]!=posY/25)) {
				actualizarDireccion();
				ultimaZona[0] = posX/25;
				ultimaZona[1] = posY/25;
			} else {
				LinkedHashSet<Entidad> listaEntidadesColision = chequearMovimiento(direccion, estadoActual.getMovimiento());
				procesarColisiones(listaEntidadesColision);
			}
			
			
			actualizarPos();
			actualizarPosGrafica();
			entGrafica.actualizarImagen(estadoActual.getIndiceArreglo(direccion), pos); //////////
	}
	}

	private void procesarColisiones(LinkedHashSet<Entidad> listaEntidadesColision) {
		if(!listaEntidadesColision.isEmpty()) {
			for(Entidad e : listaEntidadesColision) {
				colision(e);
			}
			
		}
	}

	private void actualizarDireccion() {
		int posObjetivoX = 0;
		int posObjetivoY = 0;
		char[] prioridadDireccion = estadoActual.calcularProximaPosicion(pos);
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
		System.out.println("MURIO UN ENEMIGO");
		this.cambiarEstado(2);
		//juego.quitarEntidadGrafica(this.getEntidadGrafica());
	}

	@Override
	public char getEstado() {
		return estadoActual.estadoActual();
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		char estado = estadoActual.estadoActual();
		if((estado == 'p' || estado == 'i') && (personaje.getEstado() == 'n' || personaje.getEstado() == 'r')) {
			personaje.morir();
		}
		
		if(this.getEstado() == 'h') {
			this.morir();
		}
		
		return false;
	}

	public LinkedHashSet<Entidad> chequearMovimiento(char direc, int mov) {
		return miLaberinto.chequearColision(pos, mov, direc);
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		return false;
	}

	@Override
	public void noPuedeCaminar(char c) {
		char estadoAhora = estadoActual.estadoActual();
		if ((c == 'd' && (estadoAhora!='i' && estadoAhora !='m' )) || c=='w')
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
	
	
	public abstract void reseteo(int posX, int posY, char direc);

	public abstract void cambiarEstado(int estado);
	
	public boolean getDebeFrenar() {
		return debeFrenar;
	}
	
	public void setDebeFrenar(boolean b) {
		debeFrenar = b;
	}
}
