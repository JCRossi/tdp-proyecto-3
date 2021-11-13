package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Entidades.Bomba;
import Entidades.Entidad;
import Entidades.Fruta;
import Entidades.Inmunidad;
import Entidades.PacDot;
import Entidades.Pared;
import Entidades.PowerPellet;
import Entidades.Puerta;
import Entidades.x2Velocidad;

public class Nivel {
	private int numeroNivel;
	private long movimientoEnemigos;
	private long movimientoJugador;
	public Nivel(int numNivel) {
		switch(numNivel) {
			case 1:
				movimientoEnemigos = 1000;
				movimientoJugador = 1250;
				break;
			case 2:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				break;
			case 3:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				break;
		}
	}
	
	
	
	public int getNumeroNivel() {
		return numeroNivel;
	}
	
	public long getMovimientoJugador() {
		return movimientoJugador;
	}
	
	public long getMovimientoEnemigos() {
		return movimientoEnemigos;
	}

	public Entidad[][] GenerarLaberinto(int nivel, Logica logica) {
		Entidad[][] entidadesEstaticas = new Entidad[21][21];
		switch(nivel) {
		case 1 :
			entidadesEstaticas = generarNivelUno(logica);
			break;
			
		case 2:
			entidadesEstaticas = generarNivelDos(logica);
			break;
			
		case 3:
			entidadesEstaticas = generarNivelTres(logica);
			break;
		}
		return entidadesEstaticas;		
	}

	private Entidad[][] generarNivelUno(Logica logica) {
		Entidad[][] entidadesEstaticas = new Entidad[21][21];
		try{
			File arch = new File("Laberinto_11.txt");
			
			BufferedReader archiv = new BufferedReader(new FileReader(arch));
		
			String linea;
			for(int i = 0; i < 21; i++) {
				linea = archiv.readLine();
				for(int j = 0; j < linea.length(); j++) {
					char caracter = linea.charAt(j);
	
					switch(caracter) {
						case 'P':
							entidadesEstaticas[i][j] = new Pared(i*25, j*25);
							break;
						case 'M':
							entidadesEstaticas[i][j] = new PacDot(i*25, j*25, logica);
							break;
						case 'W':
							entidadesEstaticas[i][j] = new PowerPellet(i*25, j*25, logica);
							break;
						case 'F':
							entidadesEstaticas[i][j] = new Fruta(i*25, j*25, logica);
							break;
						case 'I':
							entidadesEstaticas[i][j] = new Inmunidad(i*25, j*25, logica);
							break;
						case 'B':
							entidadesEstaticas[i][j] = new Bomba(i*25, j*25, logica);
							break;
						case 'V':
							entidadesEstaticas[i][j] = new x2Velocidad(i*25, j*25, logica);
							break;
						case ' ':
							entidadesEstaticas[i][j] = new PacDot(i*25, j*25, logica);
							break;
						case 'D':
							entidadesEstaticas[i][j] = new Puerta(i*25, j*25);
							break;
							}				
						}
					}
			archiv.close();
	
			}catch(Exception e){
				e.printStackTrace();
				}
		return entidadesEstaticas;
		}


	private Entidad[][] generarNivelDos(Logica logica) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	private Entidad[][] generarNivelTres(Logica logica) {
		return null;
		// TODO Auto-generated method stub
		
	}




}
