package Entidades;

public class PowerPellet extends PowerUp {
	
	public PowerPellet(int posY, int posX) {
		pos = new Posicion( posX, posY, 18, 19);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(5, pos);
		
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
