package Entidades;

import java.awt.Rectangle;

public class Posicion {
	
	private int posx;
	private int posy;
	private int ancho;
	private int alto;
	
	
	public Posicion(int posx, int posy,int ancho, int alto) {
		this.posx = posx;
		this.posy = posy;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public Rectangle getRectangulo() {
		return new Rectangle(posx,posy,ancho,alto);
	}
	
	public int getX() {
		return this.posx;
	}
	
	public int getY() {
		return this.posy;
	}
	
	public int getAncho() {
		return this.ancho;
	}
	
	public int getAlto() {
		return this.ancho;
	}
	
	public void setX(int x) {
		posx = x;
	}
	
	public void setY(int y) {
		posy = y;
	}
	
	

}
