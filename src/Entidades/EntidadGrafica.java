package Entidades;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EntidadGrafica extends JLabel {
	
	private ImageIcon grafico;
	private String[] imagenes = new String[] {"/images/bomb25px.gif", "/images/fruit25px.png", "/images/inmune25px.gif", "/images/pacdot25px.png", "/images/pared25px.png", "/images/powerpellet25px.png","/images/x2speed25px.png", "/images/zaWarudo25px.png","/images/pacman/normal/jotaro_abajo.gif","/images/pacman/normal/jotaro_arriba.gif","/images/pacman/normal/jotaro_derecha.gif","/images/pacman/normal/jotaro_izquierda.gif","/images/explosion.png", "/images/PuertaProv.png"};
	
	public EntidadGrafica(int index, Posicion pos,String[] img) {
		imagenes = img;
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[index]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto()+1,Image.SCALE_DEFAULT) );
		this.setIcon(grafico);
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
		this.setBackground(null);
	}
	public EntidadGrafica(int index, Posicion pos) {
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[index]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto()+1,Image.SCALE_DEFAULT) );
		this.setIcon(grafico);
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
		this.setBackground(null);
	}
	
	public void actualizarPos(Posicion pos) {
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
	}
	
	public void actualizarImagen(int i, Posicion pos) {
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[i]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto()+1,Image.SCALE_DEFAULT) );
		this.setIcon(grafico);
	}
	
	public void actualizarExplosion(int i, Posicion pos) {
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[i]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto()+1,Image.SCALE_DEFAULT) );
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
		this.setIcon(grafico);
	}
	
}
