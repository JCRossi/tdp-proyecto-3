package Laberinto;

import Entidades.PacDot;
import Entidades.Pared;

public class Laberinto {
	
	protected Zona[][] zonas;
	
	public Laberinto(int nivel) {
		
		this.zonas = new Zona[20][20];
		
		generarMatrizZonas();
		
		switch(nivel) {
			case 1 :
				generarNivelUno();
				break;
				
			case 2:
				generarNivelDos();
				break;
				
			case 3:
				generarNivelTres();
				break;
				
		}
		
		
		
	}
	
	
	private void generarNivelUno() {
		
		
		for(int i = 0; i<19 ; i++) {
					
			if(i != 10) {
				for(int j = 0; j<19 ; j++) {
					zonas[i][j].enlistarEntidad(new PacDot());
					
				}	
			}
			
		}
		
		
	}
	private void generarNivelDos() {}
	private void generarNivelTres() {}
	
	
	
	private void generarMatrizZonas() {
		int posx;
		int posy;
		
		posx = 0;
		posy = 0;
				
		
		for(int i = 0; i<19 ; i++) {
			
			
			posy = 0;
			for(int j = 0; j<19 ; j++) {
				zonas[i][j] = new Zona(posx,posy,i,j);
				
				if(posy == 0)
					posy+=9;
				else
					posy+=10;
			}
			
			if(posx == 0)
				posx+=9;
			else
				posx+=10;
			
			
		}
		
	}
	
	
	public void generarParedes() {
		
		for(int i = 1; i<19;i++) {
			zonas[10][i].enlistarEntidad(new Pared()); 
		}
		
		
		
	}
	
	
	
	
}
