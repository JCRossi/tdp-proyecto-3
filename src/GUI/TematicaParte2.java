package GUI;

public class TematicaParte2 extends Tematica {

	@Override
	public String[] getImagenesPacman() {
		return new String[] {"/images/joseph_muerto.gif","/images/joseph_arriba.gif","/images/joseph_derecha.gif","/images/joseph_abajo.gif","/images/joseph_izquierda.gif"};
	}

	@Override
	public String[] getImagenesFantasma1() {
		return  new String[] {"/images/enemigo_muerto.gif","/images/kars_arriba.gif","/images/kars_derecha.gif","/images/kars_abajo.gif","/images/kars_izquierda.gif","/images/kars_arriba_huyendo.gif","/images/kars_derecha_huyendo.gif","/images/kars_abajo_huyendo.gif","/images/kars_izquierda_huyendo.gif"};
	}

	@Override
	public String[] getImagenesFantasma2() {
		return new String[] {"/images/enemigo_muerto.gif","/images/acdc_arriba.gif","/images/acdc_derecha.gif","/images/acdc_abajo.gif","/images/acdc_izquierda.gif","/images/acdc_arriba_huyendo.gif","/images/acdc_derecha_huyendo.gif","/images/acdc_abajo_huyendo.gif","/images/acdc_izquierda_huyendo.gif"};
	}

	@Override
	public String[] getImagenesFantasma3() {
		return new String[] {"/images/enemigo_muerto.gif","/images/wamuu_arriba.gif","/images/wamuu_derecha.gif","/images/wamuu_abajo.gif","/images/wamuu_izquierda.gif","/images/wamuu_arriba_huyendo.gif","/images/wamuu_derecha_huyendo.gif","/images/wamuu_abajo_huyendo.gif","/images/wamuu_izquierda_huyendo.gif"};
	}

	@Override
	public String[] getImagenesFantasma4() {
		return new String[] {"/images/enemigo_muerto.gif","/images/santana_arriba.gif","/images/santana_derecha.gif","/images/santana_abajo.gif","/images/santana_izquierda.gif","/images/santana_arriba_huyendo.gif","/images/santana_derecha_huyendo.gif","/images/santana_abajo_huyendo.gif","/images/santana_izquierda_huyendo.gif"};
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

}
