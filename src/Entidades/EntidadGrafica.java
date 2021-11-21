package Entidades;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EntidadGrafica extends JLabel {
	
	private ImageIcon grafico;
	private String[] imagenes;
	
	public EntidadGrafica(int index, Posicion pos,String[] img) {
		imagenes = img;
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
	
	public void actualizarExplosion(Posicion pos) {
		grafico = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(EntidadGrafica.class.getResource(imagenes[1]))).getImage().getScaledInstance(pos.getAncho(),pos.getAlto()+1,Image.SCALE_DEFAULT) );
		this.setBounds(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
		this.setIcon(grafico);
	}
	
}
