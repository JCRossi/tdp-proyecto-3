package Launcher;

import GUI.SeleccionTematica;
import Logica.Logica;


//import entidades.PlayMusic;

public class Launcher {
	
	public static void main(String[] args) {
				try {
					
					Logica juego = new Logica();
					
					SeleccionTematica a = new SeleccionTematica(juego);
					a.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
	}
}


