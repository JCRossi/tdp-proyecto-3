package Hilos;

import Entidades.Enemigo;
import Entidades.Jugador;

public class HiloEnemigo implements Runnable {
	
	private static final long intervaloDeMovimientoNivelUno = 20; 

	private long intervaloDeMovimiento;
	private boolean continuar;
	private Jugador miJugador;
	
	public HiloEnemigo(Jugador miJugador) {
		this.miJugador = miJugador;
		this.continuar = true;
		intervaloDeMovimiento = intervaloDeMovimientoNivelUno;
	}
	
	@Override
	public void run() {
		while(this.continuar) {
			try {
				Thread.sleep(this.intervaloDeMovimiento);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			avisarMovimientoJugador();
			
		}
		
	}

	
	private void avisarMovimientoJugador() {
		miJugador.mover();
	}

	public void set(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}
	
}
