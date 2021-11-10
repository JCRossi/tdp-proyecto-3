package GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Launcher.Launcher;

public class FondoST extends JPanel {
	private Image fondo;
	
	public void paint(Graphics g) {
		fondo = new ImageIcon(Launcher.class.getResource("/images/maxresdefault.png")).getImage();
		g.drawImage(fondo, 0, 0, 300, 500, this);
		setOpaque(false);
		super.paint(g);
	}
}