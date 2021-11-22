package Hilos;

import Entidades.Jugador;

public class HiloJugador implements Runnable {
	
	private static final long intervaloDeMovimientoNivelUno = 20; 

	private long intervaloDeMovimiento;
	private boolean continuar;
	private Jugador miJugador;
	private boolean pausa;
	
	public HiloJugador(Jugador miJugador) {
		this.miJugador = miJugador;
		this.continuar = true;
		intervaloDeMovimiento = intervaloDeMovimientoNivelUno;
		pausa = false;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			
			while(this.continuar) {
				Thread.sleep(this.intervaloDeMovimiento);
				if(!pausa)
					avisarMovimientoJugador();
			}
				
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
		
	public void frenar() {
		continuar = false;
	}
	
	private void avisarMovimientoJugador() {
		miJugador.mover();
	}
	
	public void pausar() {
		pausa = true;
	}
	
	public void seguir() {
		pausa = false;
	}
}
