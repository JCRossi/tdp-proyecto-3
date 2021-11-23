package GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoLat extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fondo;
	private String direccion;
	
	public FondoLat(String direccion) {
		this.direccion = direccion;
	}
	
	public void paint(Graphics g) {
		fondo = new ImageIcon(GUI.class.getResource(direccion)).getImage();
		g.drawImage(fondo, 0, 0, 115, 564, this); 
		setOpaque(false);
		super.paint(g);
	}
	
	public void setFondo(String direccion) {
		this.direccion = direccion;
	}
}