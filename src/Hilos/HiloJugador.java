package Hilos;

import Entidades.Jugador;

public class HiloJugador implements Runnable {
	
	private static final long intervaloDeMovimientoNivelUno = 250; 

	private long intervaloDeMovimiento;
	private boolean continuar;
	private Jugador miJugador;
	
	public HiloJugador(Jugador miJugador) {
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
	
}
