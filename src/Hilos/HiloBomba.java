package Hilos;

import Entidades.Bomba;

public class HiloBomba implements Runnable {
	
	private long tiempoDeDetonacion;
	private Bomba bomb;

	public HiloBomba(Bomba bomba){
		this.bomb = bomba;
		this.tiempoDeDetonacion = bomb.getDuracion();
	}

	public void run(){
		try {
			Thread.sleep(tiempoDeDetonacion);
			bomb.explotar();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}