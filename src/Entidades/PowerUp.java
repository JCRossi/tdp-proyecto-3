package Entidades;

public abstract class PowerUp extends Consumible {
	protected char efecto;
	protected long duracion;
	public abstract long getDuracion();
	public abstract void terminaEfecto();
}
