package Entidades;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EntidadGrafica extends JLabel {
	
	private ImageIcon grafico;
	private String[] imagenes = new String[] {"/images/bomb25px.png", "/images/fruit25px.png", "/images/Bloque L.png", "/images/inmune25px.png", "/images/pacdot25px.png", "/images/pared25px.png", "/images/powerpellet25px.png","/images/x2speed25px.png", "/images/zaWarudo25px.png"};
	
	public EntidadGrafica(int index, Posicion pos) {
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[index]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto(),Image.SCALE_DEFAULT) );
		this.setIcon(grafico);
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
	}
	
	public void actualizarPos(Posicion pos) {
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
	}
	
	
}
