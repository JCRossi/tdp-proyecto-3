package Entidades;

public class x2Velocidad extends Pocion {
	
	public x2Velocidad(String imagen) {
		
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
	
	public void serComido() {
		
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
