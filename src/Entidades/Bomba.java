package Entidades;

public class Bomba extends Pocion {
	
	public Bomba(int posY, int posX) {
		pos = new Posicion( posX, posY, 20, 19);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(0, pos);
		
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
		return entGrafica;
	}

}
