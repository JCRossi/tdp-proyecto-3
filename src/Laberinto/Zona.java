package Laberinto;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.LinkedHashSet;

import Entidades.Entidad;
import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;

public class Zona {
	
	protected int posX;
	protected int posY;
	//protected ListaSimplementeEnlazada<Entidad> listaEntidades;
	protected LinkedHashSet<Entidad> listaEntidades ;
	
	public Zona(int posx, int posy) {
		this.posX = posx;
		this.posY = posy;
			
		//this.listaEntidades = new ListaSimplementeEnlazada<Entidad>();
		this.listaEntidades = new LinkedHashSet<Entidad>();
		
	}
	
	//private void actualizarListaEntidades() {}
	
	
	public ListaSimplementeEnlazada<Entidad> getListaEntidades(){
		ListaSimplementeEnlazada<Entidad> listaEntRetorno = new ListaSimplementeEnlazada<Entidad>();
		for(Entidad e : listaEntidades) {
			listaEntRetorno.addLast(e);
		}
		return listaEntRetorno;
	}
	
	public void enlistarEntidad(Entidad EntidadAEnlistar) {
		listaEntidades.add(EntidadAEnlistar);
	}
	
	//REEMPLAZAR ListaSimplementeEnlazada POR HASHSET<ENTIDAD>
	public void checkearColisiones (Rectangle R, ListaSimplementeEnlazada<Entidad> lista){
        Rectangle rectanguloActual;
        for(Entidad e : listaEntidades) {
        	if (e!=null) {
        		rectanguloActual = e.getPosicion().getRectangulo();
                if (R.intersects(rectanguloActual))
                    lista.addLast(e);
        	}
        		
        }
	}
	
	/*
	public void desenlistarEntidad (Entidad e) {
        Position<Entidad> posicionActual = null;
        try {
            posicionActual = listaEntidades.first();
        } catch (EmptyListException e1) {
           
        }
        if(posicionActual != null) {
            Entidad entidadActual = posicionActual.element();
            int i = 1;
            int tamaño = listaEntidades.size();
            while (entidadActual != e && i<tamaño) {
                try {
                    posicionActual = listaEntidades.next(posicionActual);
                } catch (BoundaryViolationException | InvalidPositionException e1) {
                    System.out.println("error en desenlistar Entidad 2");
                }
                entidadActual = posicionActual.element(); 
                i++;
            }       	
        try {
            listaEntidades.remove(posicionActual);
        } catch (InvalidPositionException e1) {
            System.out.println("error en desenlistar Entidad 3");
        }
        }
    }
	*/
	
	public void desenlistarEntidad(Entidad e) {
		listaEntidades.remove(e);
	}
	
	
	
	
	
}
