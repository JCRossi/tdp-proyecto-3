package Entidades;

import Logica.Logica;

public class Bomba extends Pocion {
	
	public Bomba(int posY, int posX, Logica juegoActual,String[] img) {
		puntaje = 0;
		pos = new Posicion( posX+((25-19)/2), posY+((25-19)/2), 19, 19); 
		entGrafica = new EntidadGrafica(0, pos,img);
		juego = juegoActual;
		duracion = 5000;
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		serComido();
		juego.quitarEntidadGrafica(entGrafica);
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		return false;
	}
	
	public void explotar() {
		pos.setAlto(200);
		pos.setAncho(200);
		pos.setX(pos.getX()-(pos.getAncho()/2));
		pos.setY(pos.getY()-(pos.getAlto()/2));
		this.entGrafica.actualizarExplosion(pos);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		juego.estallido(pos);
		juego.quitarEntidadGrafica(this.getEntidadGrafica());
	}
	
	public void serComido() {
		juego.aumentarBombas();
		juego.quitarEntidadGrafica(this.getEntidadGrafica());
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
		
	}

	@Override
	public long getDuracion() {
		return duracion;
	}

	@Override
	public char getEfecto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getQuitarEfecto() {
		// TODO Auto-generated method stub
		return 0;
	}

}
