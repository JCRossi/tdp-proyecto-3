package Laberinto;

import java.awt.Rectangle;
import java.util.LinkedHashSet;

import Entidades.Entidad;
import Estructuras.ListaSimplementeEnlazada;

public class Zona {
	
	private LinkedHashSet<Entidad> listaEntidades ;
	
	public Zona(int posx, int posy) {
		this.listaEntidades = new LinkedHashSet<Entidad>();
		
	}
	
	
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
	
	public void checkearColisiones (Rectangle R, LinkedHashSet<Entidad> lista){
        Rectangle rectanguloActual;
        for(Entidad e : listaEntidades) {
        	if (e!=null) {
        		rectanguloActual = e.getPosicion().getRectangulo();
                if (R.intersects(rectanguloActual))
                    lista.add(e);
        	}
        		
        }
	}
	
	public void desenlistarEntidad(Entidad e) {
		listaEntidades.remove(e);
	}

	
}
