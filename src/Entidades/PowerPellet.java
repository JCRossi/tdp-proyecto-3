package Entidades;

public class PowerPellet extends PowerUp {
	
	public PowerPellet(int posY, int posX) {
		pos = new Posicion( posX+((25-18)/2), posY+((25-19)/2), 18, 19);  //999999 = ancho        111111111 = alto
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

}
