package GUI;

public class TematicaParte5 extends Tematica{
	
	@Override
	public String[] getImagenesPacman() {
		return new String[] {"/images/pacman/muerto/giorno_muerto.gif","/images/pacman/normal/giorno_arriba.gif","/images/pacman/normal/giorno_derecha.gif","/images/pacman/normal/giorno_abajo.gif","/images/pacman/normal/giorno_izquierda.gif","/images/pacman/bomba/giorno_arriba_bomba.gif","/images/pacman/bomba/giorno_derecha_bomba.gif","/images/pacman/bomba/giorno_abajo_bomba.gif","/images/pacman/bomba/giorno_izquierda_bomba.gif","/images/pacman/x2velocidad/giorno_arriba_x2.gif","/images/pacman/x2velocidad/giorno_derecha_x2.gif","/images/pacman/x2velocidad/giorno_abajo_x2.gif","/images/pacman/x2velocidad/giorno_izquierda_x2.gif","/images/pacman/inmunidad/giorno_arriba_inmune.png","/images/pacman/inmunidad/giorno_derecha_inmune.png","/images/pacman/inmunidad/giorno_abajo_inmune.png","/images/pacman/inmunidad/giorno_izquierda_inmune.png"};
	}

	@Override
	public String[] getImagenesFantasma1() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Blinky/normal/diavolo_arriba.png","/images/Blinky/normal/diavolo_derecha.png","/images/Blinky/normal/diavolo_abajo.png","/images/Blinky/normal/diavolo_izquierda.png","/images/Blinky/vulnerable/diavolo_vulnerable_arriba.png","/images/Blinky/vulnerable/diavolo_vulnerable_derecha.png","/images/Blinky/vulnerable/diavolo_vulnerable_abajo.png","/images/Blinky/vulnerable/diavolo_vulnerable_izquierda.png"};
	}

	@Override
	public String[] getImagenesFantasma2() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Pinky/normal/nero_arriba.png","/images/Pinky/normal/nero_derecha.png","/images/Pinky/normal/nero_abajo.png","/images/Pinky/normal/nero_izquierda.png","/images/Pinky/vulnerable/nero_arriba_huyendo.png","/images/Pinky/vulnerable/nero_derecha_huyendo.png","/images/Pinky/vulnerable/nero_abajo_huyendo.png","/images/Pinky/vulnerable/nero_izquierda_huyendo.png"};
	}

	@Override
	public String[] getImagenesFantasma3() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Inky/normal/cioccolata_arriba.png","/images/Inky/normal/cioccolata_derecha.png","/images/Inky/normal/cioccolata_abajo.png","/images/Inky/normal/cioccolata_izquierda.png","/images/Inky/vulnerable/cioccolata_vulnerable_arriba.png","/images/Inky/vulnerable/cioccolata_vulnerable_derecha.png","/images/Inky/vulnerable/cioccolata_vulnerable_abajo.png","/images/Inky/vulnerable/cioccolata_vulnerable_izquierda.png"};
	}

	@Override
	public String[] getImagenesFantasma4() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Clyde/normal/ghiaccio_arriba.png","/images/Clyde/normal/ghiaccio_derecha.png","/images/Clyde/normal/ghiaccio_abajo.png","/images/Clyde/normal/ghiaccio_izquierda.png","/images/Clyde/vulnerable/ghiaccio_arriba_vulnerable.png","/images/Clyde/vulnerable/ghiaccio_derecha_vulnerable.png","/images/Clyde/vulnerable/ghiaccio_abajo_vulnerable.png","/images/Clyde/vulnerable/ghiaccio_izquierda_vulnerable.png"};
	}

	@Override
	public String[] getImagenPared() {
		return new String[] {"/images/pared/pared5.png"};
	}

	@Override
	public String[] getImagenPacDot() {
		return new String[] {"/images/pacdot/pacdot25px.gif"};
	}

	@Override
	public String[] getImagenPowerPellet() {
		return  new String[] {"/images/powerpellet/powerpellet25px.png"};
	}

	@Override
	public String[] getImagenx2Velocidad() {
		return new String[] {"/images/x2 speed/x2speed25px.png"};
	}

	@Override
	public String[] getImagenInmunidad() {
		return new String[] {"/images/inmune/inmune_1.gif"};
	}

	@Override
	public String[] getImagenFruta() {
		return new String[] {"/images/fruta/fruit25px.png"};
	}

	@Override
	public String[] getImagenBomba() {
		return new String[] {"/images/bomba/bomb25px.gif","/images/bomba/explosion.png"};
	}

	@Override
	public String pathDeMusica() {
		return "src/Musica/parte5.wav";
	}
	
	public String[] niveles() {
		return new String [] {"/images/nivel_1/nivel1Parte5.png","/images/nivel_2/nivel2Parte5.png","/images/nivel_3/nivel3Parte5.png"};
	}
	
	public String[] getPuerta() {
		return new String[] {"/images/pared/Puerta.png"};
	}
}
