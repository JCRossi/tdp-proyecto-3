package Entidades;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EntidadGrafica extends JLabel {
	
	private ImageIcon grafico;
	private String[] imagenes = new String[] {"/images/bomb25px.gif", "/images/fruit25px.png", "/images/inmune25px.gif", "/images/pacdot25px.gif", "/images/pared25px.png", "/images/powerpellet25px.png","/images/x2speed25px.png", "/images/zaWarudo25px.png","/images/jotaro_abajo.gif"};
	
	public EntidadGrafica(int index, Posicion pos) {
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[index]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto()+1,Image.SCALE_DEFAULT) );
		this.setIcon(grafico);
		this.setBounds(pos.getX()+(25-pos.getAncho())/2,pos.getY()+(25-pos.getAlto())/2,pos.getAncho(),pos.getAlto());
		this.setBackground(null);
	}
	
	public void actualizarPos(Posicion pos) {
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
	}
	
	
}
