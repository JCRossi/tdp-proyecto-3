package Entidades;

public class Fruta extends Consumible {
	
	public Fruta(int posY, int posX) {
		pos = new Posicion( posX, posY, 15, 22);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(1, pos);
		
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
		return pos;
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		// TODO Auto-generated method stub
		return entGrafica;
	}

}
