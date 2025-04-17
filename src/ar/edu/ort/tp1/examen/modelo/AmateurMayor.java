package ar.edu.ort.tp1.examen.modelo;

public class AmateurMayor extends Amateur {
	private final static String ERROR_EDAD = "La edad no puede ser menor a 18 anios.";

	private int edad;

	public AmateurMayor(String id, int edad) {
		super(id);
		setEdad(edad);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 18) {
			throw new IllegalArgumentException(ERROR_EDAD);
		}
		this.edad = edad;
	}

	@Override
	protected int obtenerPoder() {
		return RandomUtil.obtenerAleatorio(edad);
	}

	@Override
	public String toString() {
		return " Edad = " + edad;
	}

	public void mostrar() {
		super.mostrar();
		System.out.println(toString());
	}

}