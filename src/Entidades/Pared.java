package Entidades;


public class Pared extends Entidad{
	
	public Pared(int posY, int posX) {
		pos = new Posicion( posX, posY, 25, 25);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(4, pos);

	}

	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		System.out.println("Colisioneste con una pared");	
		return true;
	}

	@Override
	public boolean colisionasteConEnemigo(Personaje personaje) {
		
		return false;
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
