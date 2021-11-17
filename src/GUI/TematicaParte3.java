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
		return new String[] {"/images/enemigo_muerto.gif","/images/enya_arriba.gif","/images/enya_derecha.gif","/images/enya_abajo.gif","/images/enya_izquierda.gif","/images/enya_arriba_huyendo.gif","/images/enya_derecha_huyendo.gif","/images/enya_abajo_huyendo.gif","/images/enya_izquierda_huyendo.gif"};
	}

	@Override
	public String[] getImagenesFantasma3() {
		return new String[] {"/images/enemigo_muerto.gif","/images/hol_arriba.gif","/images/hol_derecha.gif","/images/hol_abajo.gif","/images/hol_izquierda.gif","/images/hol_arriba_huyendo.gif","/images/hol_derecha_huyendo.gif","/images/hol_abajo_huyendo.gif","/images/hol_izquierda_huyendo.gif"};
	}

	@Override
	public String[] getImagenesFantasma4() {
		return new String[] {"/images/enemigo_muerto.gif","/images/darby_arriba.gif","/images/darby_derecha.gif","/images/darby_abajo.gif","/images/darby_izquierda.gif","/images/darby_arriba_huyendo.gif","/images/darby_derecha_huyendo.gif","/images/darby_abajo_huyendo.gif","/images/darby_izquierda_huyendo.gif"};
	}

	@Override
	public String[] getImagenPared() {
		return new String[] {"/images/pared25px.png"};
	}

	@Override
	public String[] getImagenPacDot() {
		return new String[] {"/images/pacdot25px.gif"};
	}

	@Override
	public String[] getImagenPowerPellet() {
		return  new String[] {"/images/powerpellet25px.png"};
	}

	@Override
	public String[] getImagenZaWarudo() {
		return new String[] {"/images/zaWarudo25px.png"};
	}

	@Override
	public String[] getImagenx2Velocidad() {
		return new String[] {"/images/x2speed25px.png"};
	}

	@Override
	public String[] getImagenInmunidad() {
		return new String[] {"/images/inmune25px.gif"};
	}

	@Override
	public String[] getImagenFruta() {
		return new String[] {"/images/fruit25px.png"};
	}

	@Override
	public String[] getImagenBomba() {
		return new String[] {"/images/bomb25px.gif","/images/explosion.gif"};
	}

	@Override
	public String pathDeMusica() {
		return "src/Musica/Tetris.wav";
	}
	
	

}
