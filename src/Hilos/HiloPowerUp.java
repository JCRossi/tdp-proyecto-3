package Hilos;

import Entidades.PowerUp;
import Logica.Logica;

public class HiloPowerUp implements Runnable {
	
	private long duracion;
	private PowerUp miPowerUp;
	private Logica miJuego;
	
	public HiloPowerUp(PowerUp miPowUp,Logica Juego) {
		this.miPowerUp = miPowUp;
		this.duracion = miPowUp.getDuracion();
		this.miJuego = Juego;
	}
	
	@Override
	public void run() {
		
			try {
				miJuego.enemigosGuardanEstado();
				miJuego.cambiarEstados(miPowerUp.getEfecto());
				Thread.sleep(this.duracion);
				
				miJuego.cambiarEstados(miPowerUp.getQuitarEfecto());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		
	}
}