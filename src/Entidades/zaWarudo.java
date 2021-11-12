package Entidades;

public class zaWarudo extends Pocion {
	
	public zaWarudo(int posY, int posX) {
		pos = new Posicion( posX+((25-23)/2), posY+((25-23)/2), 23, 23);  //999999 = ancho        111111111 = alto
		entGrafica = new EntidadGrafica(7, pos);
		
		
	}
	
	@Override
	public boolean colisionasteConJugador(Personaje personaje) {
		serComido();
		juego.quitarEntidadGrafica(entGrafica);
		juego.desenlistarEntidad(pos.getX()/25, pos.getY()/25, this);
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
