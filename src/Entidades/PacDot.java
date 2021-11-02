package Entidades;

public class PacDot extends Consumible {

	public PacDot(String imagen) {
		
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serComido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
