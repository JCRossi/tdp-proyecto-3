package GUI;

public class TematicaParte2 extends Tematica {

	@Override
	public String[] getImagenesPacman() {
		return new String[] {"/images/pacman/muerto/joseph_muerto.gif","/images/pacman/normal/joseph_arriba.gif","/images/pacman/normal/joseph_derecha.gif","/images/pacman/normal/joseph_abajo.gif","/images/pacman/normal/joseph_izquierda.gif","/images/pacman/bomba/joseph_arriba_bomba.gif","/images/pacman/bomba/joseph_derecha_bomba.gif","/images/pacman/bomba/joseph_abajo_bomba.gif","/images/pacman/bomba/joseph_izquierda_bomba.gif","/images/pacman/x2velocidad/joseph_arriba_x2.gif","/images/pacman/x2velocidad/joseph_derecha_x2.gif","/images/pacman/x2velocidad/joseph_abajo_x2.gif","/images/pacman/x2velocidad/joseph_izquierda_x2.gif","/images/pacman/inmunidad/joseph_arriba_inmune.gif","/images/pacman/inmunidad/joseph_derecha_inmune.gif","/images/pacman/inmunidad/joseph_abajo_inmune.gif","/images/pacman/inmunidad/joseph_izquierda_inmune.gif"};
	}

	@Override
	public String[] getImagenesFantasma1() {
		return  new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Blinky/normal/kars_arriba.png","/images/Blinky/normal/kars_derecha.png","/images/Blinky/normal/kars_abajo.png","/images/Blinky/normal/kars_izquierda.png","/images/Blinky/vulnerable/kars_arriba_debil.png","/images/Blinky/vulnerable/kars_derecha_debil.png","/images/Blinky/vulnerable/kars_abajo_debil.png","/images/Blinky/vulnerable/kars_izquierda_debil.png"};
	}

	@Override
	public String[] getImagenesFantasma2() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Pinky/normal/wamuu_arriba.png","/images/Pinky/normal/wamuu_derecha.png","/images/Pinky/normal/wamuu_abajo.png","/images/Pinky/normal/wamuu_izquierda.png","/images/Pinky/vulnerable/wamuu_arriba_debil.png","/images/Pinky/vulnerable/wamuu_derecha_debil.png","/images/Pinky/vulnerable/wamuu_abajo_debil.png","/images/Pinky/vulnerable/wamuu_izquierda_debil.png"};
	}

	@Override
	public String[] getImagenesFantasma3() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Inky/normal/santana_arriba.gif","/images/Inky/normal/santana_derecha.gif","/images/Inky/normal/santana_abajo.gif","/images/Inky/normal/santana_izquierda.gif","/images/Inky/vulnerable/santana_arriba_debil.gif","/images/Inky/vulnerable/santana_derecha_debil.gif","/images/Inky/vulnerable/santana_abajo_debil.gif","/images/Inky/vulnerable/santana_izquierda_debil.gif"};
	}

	@Override
	public String[] getImagenesFantasma4() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Clyde/normal/esidisi_arriba.gif","/images/Clyde/normal/esidisi_derecha.gif","/images/Clyde/normal/esidisi_abajo.gif","/images/Clyde/normal/esidisi_izquierda.gif","/images/Clyde/vulnerable/esidisi_arriba_debil.gif","/images/Clyde/vulnerable/esidisi_derecha_debil.gif","/images/Clyde/vulnerable/esidisi_abajo_debil.gif","/images/Clyde/vulnerable/esidisi_izquierda_debil.gif"};
	}

	@Override
	public String[] getImagenPared() {
		return new String[] {"/images/pared/pared2.png"};
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
		return new String[] {"/images/inmune/inmune_2.gif"};
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
		return "src/Musica/Tetris.wav";
	}
	
	public String[] niveles() {
		return new String [] {"/images/nivel 1/nivel1Parte2.png","/images/nivel 2/nivel2Parte2.png","/images/nivel 3/nivel3Parte2.png"};
	}
	
	public String[] getPuerta() {
		return new String[] {"/images/pared/Puerta.png"};
	}

}
