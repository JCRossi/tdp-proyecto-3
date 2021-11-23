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
				
				System.out.println("Empieza: "+miPowerUp.getEfecto()+ " duracion:" + duracion);
				Thread.sleep(this.duracion);
				miPowerUp.terminaEfecto();
				//miJuego.cambiarEstados(miPowerUp.getQuitarEfecto());
				System.out.println("Termina: "+miPowerUp.getEfecto());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		
	}
}