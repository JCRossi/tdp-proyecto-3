package Entidades;


public class Pared extends Entidad{
	
	public Pared(int posY, int posX) {
		pos = new Posicion( posX, posY, 25, 25);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(5, pos);

	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		
		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
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
