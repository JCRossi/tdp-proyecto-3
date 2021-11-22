package Hilos;

import Entidades.Enemigo;
import Estructuras.ListaSimplementeEnlazada;

public class HiloEnemigo implements Runnable {
	
	private static final long intervaloDeMovimientoNivelUno = 20; 

	private long intervaloDeMovimiento;
	private boolean continuar;
	private ListaSimplementeEnlazada<Enemigo> enemigos;
	private boolean existe;
	private boolean pausa;
	
	public HiloEnemigo() {
		this.continuar = true;
		existe = true;
		intervaloDeMovimiento = intervaloDeMovimientoNivelUno;
		enemigos = new ListaSimplementeEnlazada<Enemigo>();
		pausa = false;
	}
	
	@Override
	public void run() {
		try {
			while(existe) {
				if(continuar) {
					Thread.sleep(3000);
					while(this.getContinuar()) {
						
						Thread.sleep(this.intervaloDeMovimiento);	
						if(!pausa)
							avisarMovimientoEnemigos();
					}	
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void frenar() {
		continuar = false;
	}
	
	public void continuar() {
		continuar = true;
	}
	
	public void pausar() {
		pausa = true;
	}
	
	public void seguir() {
		pausa = false;
	}
	
	public void eliminar() {
		existe = false;
	}
	
	public boolean getContinuar() {
		return continuar;
	}
	public boolean getExiste(){
		return existe;
	}

	
	private void avisarMovimientoEnemigos() {
		for (Enemigo e: enemigos) {
			e.mover();
		}
	}

	public void set(Enemigo enemigo) {
		enemigos.addLast(enemigo);
	}
	
}
