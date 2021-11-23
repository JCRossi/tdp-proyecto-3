package Entidades;

public abstract class PowerUp extends Consumible {
	protected char efecto;
	protected long duracion;
	public abstract long getDuracion();
	public abstract char getEfecto();
	public abstract char getQuitarEfecto();
	public abstract void terminaEfecto();
}
