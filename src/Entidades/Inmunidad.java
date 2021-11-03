package Entidades;

public class Inmunidad extends Pocion {
	
	public Inmunidad(int posY, int posX) {
		pos = new Posicion( posX, posY, 19, 22);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(2, pos);
		
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
		return pos;
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return entGrafica;
	}
}
