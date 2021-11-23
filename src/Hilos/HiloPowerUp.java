package Hilos;

import Entidades.PowerUp;

public class HiloPowerUp implements Runnable {
	
	private long duracion;
	private PowerUp miPowerUp;
	public HiloPowerUp(PowerUp miPowUp) {
		this.miPowerUp = miPowUp;
		this.duracion = miPowUp.getDuracion();
	}
	
	@Override
	public void run() {
		
			try {
				Thread.sleep(this.duracion);
				miPowerUp.terminaEfecto();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		
	}
}