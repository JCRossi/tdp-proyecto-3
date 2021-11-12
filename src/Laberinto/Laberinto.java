package Laberinto;

import Entidades.Entidad;

import java.awt.Rectangle;
import java.util.LinkedHashSet;

import Entidades.*;
import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;
import Logica.Logica;

public class Laberinto {
	
	protected Zona[][] zonas;
	
	public Laberinto(Logica juego) {
		
		this.zonas = new Zona[21][21];
		
		generarMatrizZonas();
		generarParedes();
	}
	
	public void generarConsumiblesLaberinto(int nivel, Logica juego) {
		switch(nivel) {
		case 1 :
			generarNivelUno(juego);
			break;
			
		case 2:
			generarNivelDos(juego);
			break;
			
		case 3:
			generarNivelTres(juego);
			break;
		}
	}
	
	private void generarNivelUno(Logica juego) {
		//Frutas
        zonas[1][10].enlistarEntidad(new Fruta(1*25, 10*25, juego));
        zonas[12][10].enlistarEntidad(new Fruta(12*25, 10*25, juego));

        //PowerPellets
        zonas[3][5].enlistarEntidad(new PowerPellet(3*25, 5*25, juego));
        zonas[5][19].enlistarEntidad(new PowerPellet(5*25, 19*25, juego));
        zonas[15][3].enlistarEntidad(new PowerPellet(15*25, 3*25, juego));
        zonas[18][17].enlistarEntidad(new PowerPellet(18*25, 17*25, juego));

        //x2Velocidad
        zonas[12][19].enlistarEntidad(new x2Velocidad(12*25, 19*25, juego));

        //Inmunidad
        zonas[8][10].enlistarEntidad(new Inmunidad(8*25, 10*25, juego));

        //Bomba
        zonas[9][1].enlistarEntidad(new Bomba(9*25, 1*25, juego));
        
		rellenarPacDots(juego);
	}
	
	private void generarNivelDos(Logica juego) {
		//Frutas
        zonas[1][10].enlistarEntidad(new Fruta(1*25, 10*25, juego));
        zonas[12][10].enlistarEntidad(new Fruta(12*25, 10*25, juego));

        //PowerPellets
        zonas[3][5].enlistarEntidad(new PowerPellet(3*25, 5*25, juego));
        zonas[5][19].enlistarEntidad(new PowerPellet(5*25, 19*25, juego));
        zonas[15][3].enlistarEntidad(new PowerPellet(15*25, 3*25, juego));
        zonas[18][17].enlistarEntidad(new PowerPellet(18*25, 17*25, juego));

        //x2Velocidad
        zonas[12][19].enlistarEntidad(new x2Velocidad(12*25, 19*25, juego));

        //Bomba
        zonas[9][1].enlistarEntidad(new Bomba(9*25, 1*25, juego));
        
		rellenarPacDots(juego);
	}
	
	private void generarNivelTres(Logica juego) {
		//Frutas
        zonas[1][10].enlistarEntidad(new Fruta(1*25, 10*25, juego));
        zonas[12][10].enlistarEntidad(new Fruta(12*25, 10*25, juego));

        //PowerPellets
        zonas[3][5].enlistarEntidad(new PowerPellet(3*25, 5*25, juego));
        zonas[5][19].enlistarEntidad(new PowerPellet(5*25, 19*25, juego));
        zonas[15][3].enlistarEntidad(new PowerPellet(15*25, 3*25, juego));
        zonas[18][17].enlistarEntidad(new PowerPellet(18*25, 17*25, juego));

        //Bomba
        zonas[9][1].enlistarEntidad(new Bomba(9*25, 1*25, juego));
        
		rellenarPacDots(juego);
	}
	
	private void rellenarPacDots(Logica juego) {
		
		for(int i = 0; i<21;i++) {
			
			for(int j = 0; j<21;j++) {
				
				//Si no es la pos en la que spawnean los personajes 
				if( !((i == 10 && j ==9) || (i == 10 && j == 10) || (i == 10 && j == 11) || (i == 9 && j ==10) || (i == 14 && j ==10) )) {
					
					if(zonas[i][j].getListaEntidades().size() == 0) {
						zonas[i][j].enlistarEntidad(new PacDot(i*25, j*25, juego));
						
					}
					
				}
	
			}
			
		}
	}
	
	private void generarMatrizZonas() {
		int posx;
		int posy;
		
		posx = 0;
		posy = 0;
				
		for(int i = 0; i<21 ; i++) {
			
			posy = 0;
			for(int j = 0; j<21 ; j++) {
				zonas[i][j] = new Zona(posx,posy);
				
				posy += 25;
			}
			
			posx += 25;
		}
		
	}
	
	
	public void generarParedes() {
		
		for(int i = 0; i<21;i++) {
			zonas[0][i].enlistarEntidad(new Pared(0, i*25));
			
			zonas[i][0].enlistarEntidad(new Pared(i*25, 0));
			
			zonas[i][20].enlistarEntidad(new Pared(i*25, 25*20));
			
			zonas[20][i].enlistarEntidad(new Pared(20*25, i*25));
		}
		
		
		int x = 1;
		
		//Fila 1
		zonas[1][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[1][12].enlistarEntidad(new Pared(x*25, 12*25));
		
		x = 2;
		//Fila 2
		zonas[2][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[2][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[2][7].enlistarEntidad(new Pared(x*25, 7*25));
		zonas[2][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[2][9].enlistarEntidad(new Pared(x*25, 9*25));
		zonas[2][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[2][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[2][15].enlistarEntidad(new Pared(x*25, 15*25));
		zonas[2][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[2][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[2][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 3;
		//Fila 3
		zonas[3][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[3][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[3][12].enlistarEntidad(new Pared(x*25, 12*25));
		
		x = 4;
		//Fila 4
		zonas[4][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[4][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[4][5].enlistarEntidad(new Pared(x*25, 5*25));
		zonas[4][7].enlistarEntidad(new Pared(x*25, 7*25));
		zonas[4][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[4][9].enlistarEntidad(new Pared(x*25, 9*25));
		zonas[4][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[4][12].enlistarEntidad(new Pared(x*25, 12*25));
		zonas[4][13].enlistarEntidad(new Pared(x*25, 13*25));
		zonas[4][15].enlistarEntidad(new Pared(x*25, 15*25));
		zonas[4][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[4][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[4][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 5;
		//Fila 5
		zonas[5][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[5][12].enlistarEntidad(new Pared(x*25, 12*25));
		
		x = 6;
		//Fila 6
		zonas[6][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[6][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[6][5].enlistarEntidad(new Pared(x*25, 5*25));
		zonas[6][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[6][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[6][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[6][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[6][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[6][19].enlistarEntidad(new Pared(x*25, 19*25));
		
		x = 7;
		//Fila 7
		zonas[7][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[7][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[7][7].enlistarEntidad(new Pared(x*25, 7*25));
		zonas[7][9].enlistarEntidad(new Pared(x*25, 9*25));
		zonas[7][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[7][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[7][13].enlistarEntidad(new Pared(x*25, 13*25));
		zonas[7][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[7][19].enlistarEntidad(new Pared(x*25, 19*25));
		
		x = 8;
		//Fila 8
		zonas[8][1].enlistarEntidad(new Pared(x*25, 1*25));
		zonas[8][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[8][3].enlistarEntidad(new Pared(x*25, 3*25));
		zonas[8][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[8][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[8][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[8][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[8][17].enlistarEntidad(new Pared(x*25, 17*25));
		
		x = 9;
		//Fila 9
		zonas[9][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[9][9].enlistarEntidad(new Pared(x*25, 9*25));
		zonas[9][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[9][12].enlistarEntidad(new Pared(x*25, 12*25));
		zonas[9][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[9][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 10;
		//Fila 10
		zonas[10][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[10][3].enlistarEntidad(new Pared(x*25, 3*25));
		zonas[10][5].enlistarEntidad(new Pared(x*25, 5*25));
		zonas[10][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[10][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[10][12].enlistarEntidad(new Pared(x*25, 12*25));
		zonas[10][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[10][15].enlistarEntidad(new Pared(x*25, 15*25));
		
		x = 11;
		//Columna 11
		zonas[11][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[11][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[11][9].enlistarEntidad(new Pared(x*25, 9*25));
		zonas[11][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[11][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[11][12].enlistarEntidad(new Pared(x*25, 12*25));
		zonas[11][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[11][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[11][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 12;
		//Fila 12
		zonas[12][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[12][3].enlistarEntidad(new Pared(x*25, 3*25));
		zonas[12][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[12][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[12][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[12][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[12][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 13;
		//Fila 13
		zonas[13][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[13][5].enlistarEntidad(new Pared(x*25, 5*25));
		zonas[13][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[13][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[13][9].enlistarEntidad(new Pared(x*25, 9*25));
		zonas[13][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[13][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[13][12].enlistarEntidad(new Pared(x*25, 12*25));
		
		x = 14;
		//Fila 14
		zonas[14][1].enlistarEntidad(new Pared(x*25, 1*25));
		zonas[14][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[14][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[14][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[14][12].enlistarEntidad(new Pared(x*25, 12*25));
		zonas[14][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[14][15].enlistarEntidad(new Pared(x*25, 15*25));
		zonas[14][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[14][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[14][18].enlistarEntidad(new Pared(x*25, 18*25));
		zonas[14][19].enlistarEntidad(new Pared(x*25, 19*25));
		
		x = 15;
		//Fila 15
		zonas[15][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[15][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[15][15].enlistarEntidad(new Pared(x*25, 15*25));
		zonas[15][19].enlistarEntidad(new Pared(x*25, 19*25));
		
		x = 16;
		//Fila 16
		zonas[16][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[16][3].enlistarEntidad(new Pared(x*25, 3*25));
		zonas[16][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[16][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[16][7].enlistarEntidad(new Pared(x*25, 7*25));
		zonas[16][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[16][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[16][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[16][13].enlistarEntidad(new Pared(x*25, 13*25));
		zonas[16][17].enlistarEntidad(new Pared(x*25, 17*25));
		
		x = 17;
		//Fila 17
		zonas[17][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[17][13].enlistarEntidad(new Pared(x*25, 13*25));
		zonas[17][14].enlistarEntidad(new Pared(x*25, 14*25));
		zonas[17][16].enlistarEntidad(new Pared(x*25, 16*25));
		zonas[17][17].enlistarEntidad(new Pared(x*25, 17*25));
		zonas[17][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 18;
		//Fila 18
		zonas[18][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[18][4].enlistarEntidad(new Pared(x*25, 4*25));
		zonas[18][5].enlistarEntidad(new Pared(x*25, 5*25));
		zonas[18][6].enlistarEntidad(new Pared(x*25, 6*25));
		zonas[18][10].enlistarEntidad(new Pared(x*25, 10*25));
		zonas[18][11].enlistarEntidad(new Pared(x*25, 11*25));
		zonas[18][12].enlistarEntidad(new Pared(x*25, 12*25));
		zonas[18][13].enlistarEntidad(new Pared(x*25, 13*25));
		zonas[18][18].enlistarEntidad(new Pared(x*25, 18*25));
		
		x = 19;
		//Fila 19
		zonas[19][2].enlistarEntidad(new Pared(x*25, 2*25));
		zonas[19][8].enlistarEntidad(new Pared(x*25, 8*25));
		zonas[19][15].enlistarEntidad(new Pared(x*25, 15*25));
		zonas[19][16].enlistarEntidad(new Pared(x*25, 16*25));
		
}
	
	public void chequearObjetoPosicion(int[] posicion) {
		
	}
	
	public ListaSimplementeEnlazada<Entidad> chequearColision(Posicion pos, int velocidad, char direccion){
		ListaSimplementeEnlazada<Entidad> listaEntidades = new ListaSimplementeEnlazada<Entidad>();
		LinkedHashSet<Zona> listaZonas = new LinkedHashSet<Zona>();
		Rectangle rectanguloActual = calcularRectanguloHipotetico(pos,velocidad,direccion);
		//listaEntidades = zonas[identificarZona(posx)][identificarZona(posy)].getListaEntidades();
		
		listaZonas = calcularZonasOcupadas(pos, direccion,velocidad);
		
		for(Zona zon: listaZonas) {
			zon.checkearColisiones(rectanguloActual, listaEntidades);	
		}
		
			
		return listaEntidades;
	}
	
	private int identificarZona(int posicion) {
		
		return posicion / 25;
	}
	
	public ListaSimplementeEnlazada<Entidad>[][] recuperarEntidades() {
		ListaSimplementeEnlazada<Entidad>[][] entidades =  new ListaSimplementeEnlazada [21][21];
		
		for(int i = 0; i < 21; i++)
			for(int j = 0; j < 21; j++)
				entidades[i][j] = zonas[i][j].getListaEntidades();
		
		return entidades;
	}
	
	
	private Rectangle calcularRectanguloHipotetico(Posicion pos, int velocidad, char direccion) {
		Rectangle r = null;
		int posx = pos.getX();
		int posy = pos.getY();
		int ancho = pos.getAncho();
		int alto = pos.getAlto();
		
		switch(direccion) {
			case 'l':
				r = new Rectangle(posx-velocidad,posy,ancho,alto);
			break;
			case'r':
				r = new Rectangle(posx+velocidad,posy,ancho,alto);
			break;
			case 'u':
				r = new Rectangle(posx,posy-velocidad,ancho,alto);
			break;
			case 'd':
				r = new Rectangle(posx,posy+velocidad,ancho,alto);
			break;
		
		
		}
		
		return r;
	}
	
	
	
	//Esto se podria hacer con listas que no repiten elementos
	private LinkedHashSet<Zona> calcularZonasOcupadas(Posicion pos, char direccion, int velocidad){
		LinkedHashSet<Zona> listaZonas = new LinkedHashSet<Zona>();
		int posx = pos.getX();
		int posy = pos.getY();
		int ancho = pos.getAncho();
		int alto = pos.getAlto();
		
		switch(direccion) {
		case 'l':
			posx-= velocidad;
			break;
		case 'r':
			posx+= velocidad;
			break;
		case 'u':
			posy-= velocidad;
			break;
		case 'd':
			posy+= velocidad;
		}
		
		
		listaZonas.add(zonas[identificarZona(posy)][identificarZona(posx)]);
		listaZonas.add(zonas[identificarZona(posy+alto)][identificarZona(posx)]);
		listaZonas.add(zonas[identificarZona(posy)][identificarZona(posx+ancho)]);
		listaZonas.add(zonas[identificarZona(posy+alto)][identificarZona(posx+ancho)]);
		
		
		return listaZonas;
		
	}
	
	public void desenlistarYEnlistarPersonaje(Posicion pos, char direccion, int velocidad, Entidad e) {
		int posx = pos.getX();
		int posy = pos.getY();
		int ancho = pos.getAncho();
		int alto = pos.getAlto();
		
		
		switch(direccion) {
		case 'l':
			
			//ENLISTAMIENTOS
			if(identificarZona(posx) != identificarZona(posx-velocidad) ) {
				zonas[identificarZona(posy)][identificarZona(posx-velocidad)].enlistarEntidad(e);
				
				if(identificarZona(posy) != identificarZona(posy+alto) )
					zonas[identificarZona(posy+alto)][identificarZona(posx-velocidad)].enlistarEntidad(e);
					
			}
			
			
			
			//DESENLISTAMIENTOS
			
			if(identificarZona(posx+ancho) != identificarZona(posx-velocidad+ancho) ) {
				zonas[identificarZona(posy)][identificarZona(posx+ancho)].desenlistarEntidad(e);
				
				if(identificarZona(posy) != identificarZona(posy+alto) )
					zonas[identificarZona(posy+alto)][identificarZona(posx+ancho)].desenlistarEntidad(e);
					
			}
			
			
			
			
			break;
		case 'r':
			//ENLISTAMIENTOS
			if(identificarZona(posx+ancho) != identificarZona(posx+velocidad+ancho) ) {
				zonas[identificarZona(posy)][identificarZona(posx+velocidad+ancho)].enlistarEntidad(e);
				
				if(identificarZona(posy) != identificarZona(posy+alto) )
					zonas[identificarZona(posy+alto)][identificarZona(posx+velocidad+ancho)].enlistarEntidad(e);
					
			}
			
			//DESENLISTAMIENTOS
			
			if(identificarZona(posx) != identificarZona(posx+velocidad) ) {
				zonas[identificarZona(posy)][identificarZona(posx)].desenlistarEntidad(e);
				
				if(identificarZona(posy) != identificarZona(posy+alto) )
					zonas[identificarZona(posy+alto)][identificarZona(posx)].desenlistarEntidad(e);
					
			}
			
			break;
		case 'u':
			//ENLISTAMIENTOS
			if(identificarZona(posy) != identificarZona(posy-velocidad) ) {
				zonas[identificarZona(posy-velocidad)][identificarZona(posx)].enlistarEntidad(e);
				
				if(identificarZona(posx) != identificarZona(posx+ancho) )
					zonas[identificarZona(posy-velocidad)][identificarZona(posx+ancho)].enlistarEntidad(e);
					
			}
			
			
			//DESENLISTAMIENTOS
			if(identificarZona(posy+alto) != identificarZona(posy-velocidad+alto) ) {
				zonas[identificarZona(posy+alto)][identificarZona(posx)].desenlistarEntidad(e);
				
				if(identificarZona(posx) != identificarZona(posx+ancho) )
					zonas[identificarZona(posy+alto)][identificarZona(posx+ancho)].desenlistarEntidad(e);
					
			}
			
			
			break;
		case 'd':
			
			//ENLISTAMIENTOS
			if(identificarZona(posy+alto) != identificarZona(posy+velocidad) ) {
				zonas[identificarZona(posy+alto+velocidad)][identificarZona(posx)].enlistarEntidad(e);
				
				if(identificarZona(posx) != identificarZona(posx+ancho) )
					zonas[identificarZona(posy+alto+velocidad)][identificarZona(posx+ancho)].enlistarEntidad(e);
					
			}
			
			
			//DESENLISTAMIENTOS
			if(identificarZona(posy) != identificarZona(posy+velocidad) ) {
				zonas[identificarZona(posy)][identificarZona(posx)].desenlistarEntidad(e);
				
				if(identificarZona(posx) != identificarZona(posx+ancho) )
					zonas[identificarZona(posy)][identificarZona(posx+ancho)].desenlistarEntidad(e);
					
			}
			
		}
		
	}
	
	public void incorporarEntidad(Entidad e) { 
		zonas[identificarZona(e.getPosicion().getY())][identificarZona(e.getPosicion().getX())].enlistarEntidad(e);
		
	}
	
	public void desenlistarEntidad(Entidad e, int posX, int posY) {
		zonas[posY][posX].desenlistarEntidad(e);
	}
}
