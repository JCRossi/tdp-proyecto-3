package Entidades;

public class Inmunidad extends Pocion {
	
	public Inmunidad(int posX, int posY) {
		pos = new Posicion( posX, posY, 25, 25);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(3, pos);
		
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
