package Laberinto;

import Entidades.Entidad;
import Estructuras.ListaSimplementeEnlazada;

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
}
