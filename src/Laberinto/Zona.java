package Laberinto;

import java.awt.Rectangle;
import java.util.HashSet;

import Entidades.Entidad;
import Estructuras.BoundaryViolationException;
import Estructuras.EmptyListException;
import Estructuras.InvalidPositionException;
import Estructuras.ListaSimplementeEnlazada;
import Estructuras.Position;

public class Zona {
	
	protected int posX;
	protected int posY;
	protected ListaSimplementeEnlazada<Entidad> listaEntidades;
	
	public Zona(int posx, int posy) {
		this.posX = posx;
		this.posY = posy;
			
		this.listaEntidades = new ListaSimplementeEnlazada<Entidad>();
		
		
	}
	
	//private void actualizarListaEntidades() {}
	
	
	public ListaSimplementeEnlazada<Entidad> getListaEntidades(){
		return listaEntidades;
	}
	
	public void enlistarEntidad(Entidad EntidadAEnlistar) {
		listaEntidades.addLast(EntidadAEnlistar);
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
	
	
	public void desenlistarEntidad (Entidad e) {
        Position<Entidad> posicionActual = null;
        try {
            posicionActual = listaEntidades.first();
        } catch (EmptyListException e1) {
           
        }
        if(posicionActual != null) {
            Entidad entidadActual = posicionActual.element();
            int i = 1;
            int tama�o = listaEntidades.size();
            while (entidadActual != e && i<tama�o) {
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
	
	
	
	
	
	
}
