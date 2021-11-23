package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Entidades.Bomba;
import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.Fruta;
import Entidades.Inmunidad;
import Entidades.Jugador;
import Entidades.PacDot;
import Entidades.Pared;
import Entidades.PowerPellet;
import Entidades.Puerta;
import Entidades.x2Velocidad;
import GUI.Tematica;
import Laberinto.Zona;

public class Nivel {
	private int numeroNivel;
	private int cantPacDots;
	private Tematica tematica;
	
	public Nivel(int numNivel,Tematica tem) {
		numeroNivel = numNivel;
		cantPacDots = 0;
		this.tematica = tem;
	}
	
	public void establecerNumeroNivel(int numNivel) {
		switch(numNivel) {
			case 1:
				numeroNivel = 1;
				break;
			case 2:
				numeroNivel = 2;
				break;
			case 3:
				numeroNivel = 3;
				break;
		}
	}
	
	public int getNumeroNivel() {
		return numeroNivel;
	}
	
	public Zona[][] GenerarLaberinto(Logica logica, Enemigo[] enemigos, Jugador personajePrincipal) {
		Zona[][] entidadesEstaticas = new Zona[21][21];
		switch(numeroNivel) {
		case 1 :
			entidadesEstaticas = generarNivel(logica, "Laberinto_11.txt", enemigos, personajePrincipal);
			break;
			
		case 2:
			entidadesEstaticas = generarNivel(logica, "Laberinto_22.txt", enemigos, personajePrincipal);
			break;
			
		case 3:
			entidadesEstaticas = generarNivel(logica, "Laberinto_33.txt", enemigos, personajePrincipal);
			break;
		}
		return entidadesEstaticas;		
	}

	private Zona[][] generarNivel(Logica logica, String direccion, Enemigo[] enemigos, Jugador personajePrincipal) {
		Zona[][] entidadesEstaticas = new Zona[21][21];
		boolean enlistar = true;
		Entidad entidad = null;
		
		try{
			File arch = new File(direccion);
			
			BufferedReader archiv = new BufferedReader(new FileReader(arch));
		
			String linea;
			for(int i = 0; i < 21; i++) {
				linea = archiv.readLine();
				for(int j = 0; j < linea.length(); j++) {
					char caracter = linea.charAt(j);
					entidadesEstaticas[i][j]= new Zona(i*25,j*25);
	
					switch(caracter) {
						case 'P':
							entidad = new Pared(i*25, j*25,tematica.getImagenPared());
							enlistar = true;
							break;
						case ' ':
							enlistar = false;
							break;
						case 'M':
							entidad = new PacDot(i*25, j*25, logica,tematica.getImagenPacDot());
							cantPacDots++;
							enlistar = true;
							break;
						case 'W':
							entidad = new PowerPellet(i*25, j*25, logica,tematica.getImagenPowerPellet());
							enlistar = true;
							break;
						case 'F':
							entidad = new Fruta(i*25, j*25, logica,tematica.getImagenFruta());
							enlistar = true;
							break;
						case 'I':
							entidad = new Inmunidad(i*25, j*25, logica,tematica.getImagenInmunidad());
							enlistar = true;
							break;
						case 'B':
							entidad = new Bomba(i*25, j*25, logica,tematica.getImagenBomba());
							enlistar = true;
							break;
						case 'V':
							entidad = new x2Velocidad(i*25, j*25, logica,tematica.getImagenx2Velocidad());
							enlistar = true;
							break;
						case 'D':
							entidad = new Puerta(i*25, j*25,tematica.getPuerta());
							enlistar = true;
							break;
						case '1':
							entidad = enemigos[0];
							enlistar = true;
							break;
						case '2':
							entidad = enemigos[1];
							enlistar = true;
							break;
						case '3':
							entidad = enemigos[2];
							enlistar = true;
							break;
						case '4':
							entidad = enemigos[3];
							enlistar = true;
							break;
						case 'J':
							entidad = personajePrincipal;
							enlistar = true;
							break;
					}	
					
					if(enlistar) {
						entidadesEstaticas[i][j].enlistarEntidad(entidad);
						logica.enlistarEntidadGrafica(entidad);
					}
				}
			}
			archiv.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return entidadesEstaticas;
	}

	public void decrementarCantidadPacDots() {
		cantPacDots--;
	}
	
	public int obtenerCantidadPacDots() {
		return cantPacDots;
	}
}
