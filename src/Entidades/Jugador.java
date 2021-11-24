package Entidades;

import java.util.LinkedHashSet;

import Hilos.HiloJugador;
import Laberinto.Laberinto;
import Logica.Logica;

public class Jugador extends Personaje {
	
	private EstadoJugador[] estados;
	private EstadoJugador estadoActual;
	private Thread hilo;
	private HiloJugador hiloMovimiento;
	private int cantBombas;
	private int vidas;
	private char direccionProhibida;
	private boolean modoInvencible;
	
	public Jugador(int posX, int posY, char direcc, Laberinto milaberinto, Logica juegoActual,String[] imagenes) {
		
		pos = new Posicion( posX+((25-22)/2), posY+((25-18)/2), 22, 18); 		
		
		entGrafica = new EntidadGrafica(2 ,pos,imagenes); 
		this.direccion = direcc;
		estados = new EstadoJugador[3];
		estados[0] = new Normal();
		estados[1] = new Rapido(estados[0].getMovimiento() * 2); 
		estados[2] = new Inmune(estados[0].getMovimiento());
		estadoActual = estados[0];
		puedeCaminar = true;
		miLaberinto = milaberinto;
		juego = juegoActual;
		vidas = 3;
		modoInvencible=false;
		hiloMovimiento = new HiloJugador(this);
		hilo = new Thread(this.hiloMovimiento);
	
		hilo.start();
	}

	@Override
	public void mover() {
		
		
		if(puedeCaminar && (this.direccion != this.direccionProhibida)) {
			LinkedHashSet<Entidad> listaEntidadesColision = chequearMovimiento(direccion, estadoActual.getMovimiento());
		
		if(!listaEntidadesColision.isEmpty()) {
			
			for(Entidad e: listaEntidadesColision) {
				colision(e);
			}
			
		}
		if(puedeCaminar) {
			actualizarPos();
			actualizarPosGrafica();
		}

		miLaberinto.desenlistarYEnlistarPersonaje(pos, direccion, estadoActual.getMovimiento(), this);
		this.direccionProhibida = 'ñ';//Uso ñ para que luego de moverme se "resetee" la direccion prohibida
		}
			
	}

	@Override
	public boolean colision(Entidad entidad) {
		
		return entidad.colisionasteConJugador(this);
	}

	public void morir() {
		boolean condicion = false;
		
		if(estadoActual.estadoActual() != 'i' && !modoInvencible) {
			vidas--;
			condicion = juego.chequearFinalizacionJuego(1);
			
			if(condicion) {
				
				juego.reseteoEnNivel();
			}
			else {
				juego.finalizarJuego(1);
			}

		}
	}
	
	public void noPuedeCaminar(char c) {
		puedeCaminar = false;
		if(c == 'w') {
			this.direccionProhibida = this.direccion;
		}
	}

	public boolean colisionasteConJugador(Personaje personaje) {
		return false;
	}

	@Override
	public LinkedHashSet<Entidad> chequearMovimiento(char direc, int mov) {
		return miLaberinto.chequearColision(pos, mov, direc);
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
        char estadoJugador = estadoActual.estadoActual();
        if(estadoJugador == 'n' || estadoJugador == 'r') {
            if(personaje.puedeMatar()) {
                this.morir();
            }
        }

        if(personaje.esComible())
            personaje.morir();

        return false;
    }

	public void actualizarPosGrafica() {
		entGrafica.actualizarPos(pos);
	}
	
	public void cambiarDireccion(char c) {
		direccion = c;
		puedeCaminar = true;
		
		if(this.estadoActual.estadoActual()=='n' && this.tieneBomba()) { //Controlamos esto ya que no hay estado TieneBomba
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
		estadoActual = estados[estado];
		
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
	
	public void setVidas(int cantVidas) {
		vidas = cantVidas;
	}
	
	public int getVidas() {
		return vidas;
	}

	public char getDireccion() {
		return direccion;
	}
	
	public void setDireccion(char dir) {
		direccion = dir;
	}
	
	public void setPuedeCaminar(boolean b) {
		puedeCaminar = b;
	}
	
	public HiloJugador obtenerHilo() {
		return hiloMovimiento;
	}

	public void pausar() {
		hiloMovimiento.pausar();
	}
	
	public void seguir() {
		hiloMovimiento.seguir();	
	}
	
	public void invencible() {
		modoInvencible = true;
	}
		
	public boolean esInvencible() {
		return modoInvencible;
	}

	public void comerX2Velocidad() {
		estadoActual = estados[1];
	}
	
	public void setEstadoNormal() {
		this.estadoActual = estados[0];
	}

	public void comerInmunidad() {
		this.estadoActual = estados[2];
	}
	
	public boolean esComible() {
        return (estadoActual.estadoActual() == 'n' || estadoActual.estadoActual() == 'r');
    }

    public boolean puedeMatar() {
        return false;
    }
}
