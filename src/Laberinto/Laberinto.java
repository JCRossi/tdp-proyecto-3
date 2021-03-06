package Laberinto;

import Entidades.Entidad;

import java.awt.Rectangle;
import java.util.LinkedHashSet;

import Entidades.*;
import Estructuras.EmptyListException;
import Estructuras.ListaSimplementeEnlazada;

public class Laberinto {
	
	private Zona[][] zonas;
	
	
	public LinkedHashSet<Entidad> chequearColision(Posicion pos, int velocidad, char direccion){
		LinkedHashSet<Entidad> listaEntidades = new LinkedHashSet<Entidad>();
		LinkedHashSet<Zona> listaZonas = new LinkedHashSet<Zona>();
		Rectangle rectanguloActual = calcularRectanguloHipotetico(pos,velocidad,direccion);
		
		listaZonas = calcularZonasOcupadas(pos, direccion,velocidad);
		
		for(Zona zon: listaZonas) {
			zon.checkearColisiones(rectanguloActual, listaEntidades);	
		}
		
			
		return listaEntidades;
	}
	
	public int identificarZona(int posicion) {
		
		return posicion / 25;
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
	
	public void establecerNivel(Zona[][] zonas2) {
		zonas = zonas2;
	}
	
	
	public ListaSimplementeEnlazada<Personaje> chequeoColisionMasivoRIPSeresVivos(Posicion pos,Personaje[] seres) {
		ListaSimplementeEnlazada<Personaje> listaPersonajes = new ListaSimplementeEnlazada<Personaje>();
		Rectangle rectanguloExplosion = new Rectangle(pos.getX(),pos.getY(),pos.getAncho(),pos.getAlto());
		Rectangle rectanguloEntidad;
		
		for(Personaje e: seres) {
			if (e!=null) {
        		rectanguloEntidad = e.getPosicion().getRectangulo();
                if (rectanguloExplosion.intersects(rectanguloEntidad))
                    listaPersonajes.addLast(e);
        	}
		}
		
		return listaPersonajes;
		
	}

	public Entidad recuperarEntidadZona(int i, int j) {
		Entidad entidadZona = null;
		try {
			if(!zonas[i][j].getListaEntidades().isEmpty())
			
				entidadZona = zonas[i][j].getListaEntidades().first().element();
			
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
		return entidadZona;
	}
	
	
	
	
	
	
}
