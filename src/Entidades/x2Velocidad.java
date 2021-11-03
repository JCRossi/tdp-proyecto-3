package Entidades;

public class x2Velocidad extends Pocion {
	
	public x2Velocidad(int posY, int posX) {
		pos = new Posicion( posX, posY, 19, 20);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(6, pos);
		
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
		return entGrafica;
	}

}
