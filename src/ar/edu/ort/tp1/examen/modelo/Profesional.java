package ar.edu.ort.tp1.examen.modelo;

public class Profesional extends Jugador {
	private final static String ERROR_EXP = "El valor de experiencia del jugador debe ser mayor o igual a 1.";

	private int experiencia;
	private boolean habilitado;

	public Profesional(String id, int experiencia, boolean habilitado) {
		super(id);
		this.habilitado = habilitado;
		setExperiencia(experiencia);
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		if (experiencia < 1) {
			throw new IllegalArgumentException(ERROR_EXP);
		}
		this.experiencia = experiencia;
	}

	@Override
	public boolean puedeEnfrentar(Jugador jugador) {
		return jugador instanceof Profesional && this.habilitado == true;
	}

	@Override
	protected int obtenerPoder() {
		return super.getGanados() + experiencia;
	}

	public boolean estaHabilitado() {
		return habilitado;
	}

	@Override
	public String toString() {
		return " Experiencia=" + experiencia;
	}

	public void mostrar() {
		String mensaje = "No esta habilitado";

		super.mostrar();

		if (this.habilitado == true) {
			mensaje = "Esta habilitado.";
		}

		System.out.println(toString() + mensaje);
	}

}