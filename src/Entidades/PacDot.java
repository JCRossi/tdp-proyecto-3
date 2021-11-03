package Entidades;

public class PacDot extends Consumible {

	public PacDot(int posY, int posX) {
		pos = new Posicion( posX, posY, 10, 11);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(3, pos);
		
		
	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		entGrafica.setIcon(null);
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
		return entGrafica;
	}
	
}
