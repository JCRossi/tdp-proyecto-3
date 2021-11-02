package Entidades;

public class PacDot extends Consumible {

	public PacDot(String imagen) {
		this.pos = new Posicion( posX, posY, 99999999, 11111111);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(imagen);
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
	
}
