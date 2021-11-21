package GUI;



public class TematicaParte3 extends Tematica {

	@Override
	public String[] getImagenesPacman() {
		return new String[] {"/images/pacman/muerto/jotaro_muerto.gif","/images/pacman/normal/jotaro_arriba.gif","/images/pacman/normal/jotaro_derecha.gif","/images/pacman/normal/jotaro_abajo.gif","/images/pacman/normal/jotaro_izquierda.gif","/images/pacman/bomba/jotaro_arriba_bomba.gif","/images/pacman/bomba/jotaro_derecha_bomba.gif","/images/pacman/bomba/jotaro_abajo_bomba.gif","/images/pacman/bomba/jotaro_izquierda_bomba.gif","/images/pacman/x2velocidad/jotaro_arriba_x2.gif","/images/pacman/x2velocidad/jotaro_derecha_x2.gif","/images/pacman/x2velocidad/jotaro_abajo_x2.gif","/images/pacman/x2velocidad/jotaro_izquierda_x2.gif","/images/pacman/inmunidad/starplatinum_arriba.gif","/images/pacman/inmunidad/starplatinum_derecha.gif","/images/pacman/inmunidad/starplatinum_abajo.gif","/images/pacman/inmunidad/starplatinum_izquierda.gif"};
	}

	@Override
	public String[] getImagenesFantasma1() {
		return  new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Blinky/normal/dioStand_arriba.png","/images/Blinky/normal/dioStand_derecha.png","/images/Blinky/normal/dioStand_abajo.png","/images/Blinky/normal/dioStand_izquierda.png","/images/Blinky/vulnerable/dio_arriba.png","/images/Blinky/vulnerable/dio_derecha.png","/images/Blinky/vulnerable/dio_abajo.png","/images/Blinky/vulnerable/dio_izquierda.png"};
	}

	@Override
	public String[] getImagenesFantasma2() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Pinky/normal/enya_arriba.png","/images/Pinky/normal/enya_derecha.png","/images/Pinky/normal/enya_abajo.png","/images/Pinky/normal/enya_izquierda.png","/images/Pinky/vulnerable/enya_arriba_huyendo.png","/images/Pinky/vulnerable/enya_derecha_huyendo.png","/images/Pinky/vulnerable/enya_abajo_huyendo.png","/images/Pinky/vulnerable/enya_izquierda_huyendo.png"};
	}

	@Override
	public String[] getImagenesFantasma3() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Inky/normal/darby_arriba.gif","/images/Inky/normal/darby_derecha.gif","/images/Inky/normal/darby_abajo.gif","/images/Inky/normal/darby_izquierda.gif","/images/Inky/vulnerable/darby_arriba_debil.gif","/images/Inky/vulnerable/darby_derecha_debil.gif","/images/Inky/vulnerable/darby_abajo_debil.gif","/images/Inky/vulnerable/darby_izquierda_debil.gif"};
	}

	@Override
	public String[] getImagenesFantasma4() {
		return new String[] {"/images/Blinky/enemigo_muerto.gif","/images/Clyde/normal/vanilla_arriba.gif","/images/Clyde/normal/vanilla_derecha.gif","/images/Clyde/normal/vanilla_abajo.gif","/images/Clyde/normal/vanilla_izquierda.gif","/images/Clyde/vulnerable/vanilla_arriba_debil.gif","/images/Clyde/vulnerable/vanilla_derecha_debil.gif","/images/Clyde/vulnerable/vanilla_abajo_debil.gif","/images/Clyde/vulnerable/vanilla_izquierda_debil.gif"};
	}

	@Override
	public String[] getImagenPared() {
		return new String[] {"/images/pared/pared3.png"};
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
		return "src/Musica/Tetris.wav";
	}
	
	public String[] niveles() {
		return new String [] {"/images/nivel 1/nivel1Parte3.png","/images/nivel 2/nivel2Parte3.png","/images/nivel 3/nivel3Parte3.png"};
	}
	
	public String[] getPuerta() {
		return new String[] {"/images/pared/Puerta.png"};
	}
	

}
