package Entidades;

import java.util.LinkedHashSet;

public abstract class Enemigo extends Personaje{

	protected EstadoEnemigo estadoActual;
	protected int[] ultimaZona;
	protected int posicionInicialX;
	protected int posicionInicialY;
	protected boolean acabaDeSerTeletransportado;
	
	
	@Override
	public synchronized void mover() {
		acabaDeSerTeletransportado = false;
		if( puedeCaminar) { 
			int posX = pos.getX();
			int posY = pos.getY();
			char estado = estadoActual.estadoActual();
			//System.out.println(estado + " pos x: " + posX + " pos y:" + posY);
			if(posX/25 == 10 && posY/25  == 10  && estado=='m') {
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
			
			if(puedeCaminar) 
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
		char[] prioridadDireccion = estadoActual.calcularProximaPosicion(pos);
		puedeCaminar = false;
		boolean esVuelta = true;
		int i = 0;
		while (!puedeCaminar || esVuelta) {
			puedeCaminar = true;
			esVuelta = false;
			procesarColisiones(chequearMovimiento(prioridadDireccion[i], calcularMovimiento(prioridadDireccion[i])));
			if(!acabaDeSerTeletransportado) {
				esVuelta = checkearVuelta(prioridadDireccion[i]);
				i++;
			}
			
		}
		if (!acabaDeSerTeletransportado && prioridadDireccion[i-1] != direccion) {
			cambiarDireccion(prioridadDireccion[i-1]);
		} 
	}

	private int calcularMovimiento(char c) {
        int mov = 0;
        switch(c) {
        case 'l':
            mov = (pos.getX()%25); 
            break;
        case'r':
            mov = 25-((pos.getX()%25) + pos.getAncho()); 
            break;
        case 'u':
            mov = (pos.getY()%25); 
            break;
        case 'd':
            mov = 25-((pos.getY()%25) + pos.getAlto()); 
            break;
        }
        return mov+1;
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
	
	public void setPuedeCaminar(boolean b) {
		puedeCaminar = b;
	}
	
	public void setDireccion(char c) {
		direccion = c;
	}
	
	public void setAcabaDeSerTeletransportado(boolean b) {
		this.acabaDeSerTeletransportado = b;
	}
	
	public boolean estaHuyendo() {
		boolean estaMuerto = false;
		if(estadoActual.estadoActual() == 'h') 
			estaMuerto = true;
		
		return estaMuerto;
		
	}
	
	public boolean estaMuerto() {
		boolean estaMuerto = false;
		if(estadoActual.estadoActual() == 'm') 
			estaMuerto = true;
		
		return estaMuerto;
		
	}
	
	
}
