package Entidades;

public class x2Velocidad extends Pocion {
	
	public x2Velocidad(int posY, int posX) {
		pos = new Posicion( posX+((25-19)/2), posY+((25-20)/2), 19, 20);  //999999 = ancho        111111111 = alto
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
		return pos;
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		// TODO Auto-generated method stub
		return entGrafica;
	}

}
