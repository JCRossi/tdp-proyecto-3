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
import Hilos.HiloEnemigo;
import Laberinto.Laberinto;
import Laberinto.Zona;

public class Nivel {
	private int numeroNivel;
	private long movimientoEnemigos;
	private long movimientoJugador;
	private int cantPacDots;
	
	/*public Nivel(int numNivel) {
		switch(numNivel) {
			case 1:
				movimientoEnemigos = 1000;
				movimientoJugador = 1250;
				numeroNivel = 1;
				break;
			case 2:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				numeroNivel = 2;
				break;
			case 3:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				numeroNivel = 3;
				break;
		}
		
		cantPacDots = 0;
	}*/
	
	
	public Nivel(int numNivel) {
		numeroNivel = numNivel;
		cantPacDots = 0;
	}
	
	public void establecerVelocidadesNivel(int numNivel) {
		switch(numNivel) {
			case 1:
				movimientoEnemigos = 1000;
				movimientoJugador = 1250;
				numeroNivel = 1;
				break;
			case 2:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				numeroNivel = 2;
				break;
			case 3:
				movimientoEnemigos = 750;
				movimientoJugador = 1250;
				numeroNivel = 3;
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
							entidad = new Pared(i*25, j*25);
							enlistar = true;
							break;
						case ' ':
							enlistar = false;
							break;
						case 'M':
							entidad = new PacDot(i*25, j*25, logica);
							cantPacDots++;
							enlistar = true;
							break;
						case 'W':
							entidad = new PowerPellet(i*25, j*25, logica);
							enlistar = true;
							break;
						case 'F':
							entidad = new Fruta(i*25, j*25, logica);
							enlistar = true;
							break;
						case 'I':
							entidad = new Inmunidad(i*25, j*25, logica);
							enlistar = true;
							break;
						case 'B':
							entidad = new Bomba(i*25, j*25, logica);
							enlistar = true;
							break;
						case 'V':
							entidad = new x2Velocidad(i*25, j*25, logica);
							enlistar = true;
							break;
						case 'D':
							entidad = new Puerta(i*25, j*25);
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


	private Entidad[][] generarNivelDos(Logica logica) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	private Entidad[][] generarNivelTres(Logica logica) {
		return null;
		// TODO Auto-generated method stub
		
	}


	public void decrementarCantidadPacDots() {
		cantPacDots--;
	}
	
	public int obtenerCantidadPacDots() {
		return cantPacDots;
	}
}
