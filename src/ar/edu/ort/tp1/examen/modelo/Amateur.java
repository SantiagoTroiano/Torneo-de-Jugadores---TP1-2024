package ar.edu.ort.tp1.examen.modelo;

public abstract class Amateur extends Jugador {

	public Amateur(String id) {
		super(id);
	}

	@Override
	public boolean puedeEnfrentar(Jugador jugador) {
		return jugador instanceof Amateur;
	}

}