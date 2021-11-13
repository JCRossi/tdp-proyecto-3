package Hilos;

import Entidades.Enemigo;
import Estructuras.ListaSimplementeEnlazada;

public class HiloEnemigo implements Runnable {
	
	private static final long intervaloDeMovimientoNivelUno = 20; 

	private long intervaloDeMovimiento;
	private boolean continuar;
	private ListaSimplementeEnlazada<Enemigo> enemigos;
	
	public HiloEnemigo() {
		this.continuar = true;
		intervaloDeMovimiento = intervaloDeMovimientoNivelUno;
		enemigos = new ListaSimplementeEnlazada<Enemigo>();
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			while(this.continuar) {
				
				Thread.sleep(this.intervaloDeMovimiento);	
				avisarMovimientoEnemigos();	
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
