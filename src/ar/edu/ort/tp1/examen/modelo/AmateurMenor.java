package ar.edu.ort.tp1.examen.modelo;

public class AmateurMenor extends Amateur {

	private boolean poseeAutorizacion;

	public AmateurMenor(String id, boolean poseeAutorizacion) {
		super(id);
		this.poseeAutorizacion = poseeAutorizacion;
	}

	@Override
	protected int obtenerPoder() {
		return RandomUtil.obtenerAleatorio(super.getGanados() + 1);
	}

	public void sumarTriunfo() {
		super.sumarTriunfo();
		super.sumarTriunfo();
	}

	public boolean estaAutorizado() {
		return poseeAutorizacion;
	}

	@Override
	public String toString() {
		return "El amateur Menor posee autorizacion? = " + poseeAutorizacion;
	}

	public void mostrar() {
		super.mostrar();
		System.out.println(toString());
	}
	
	public boolean puedeEnfrentar(Jugador jugador) {
		return super.puedeEnfrentar(jugador) && this.poseeAutorizacion == true;
	}

}