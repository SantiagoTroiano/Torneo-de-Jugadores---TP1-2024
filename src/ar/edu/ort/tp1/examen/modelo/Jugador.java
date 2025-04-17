package ar.edu.ort.tp1.examen.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public abstract class Jugador implements Mostrable {

	private final static String ERROR_ID = "El id no puede ser nulo ni estar vacio.";

	private String id;
	private int ganados;
	// TODO - Cada jugador podra tener mas de un dispositivo
	// private Dispositivo dispositivo;
	private PilaNodos<Dispositivo> pilaDispositivos;

	// TODO - Validar, donde creas necesario, que los datos requeridos para cada
	// tipo de jugador sean válidos, aqui o en las derivadas.
	public Jugador(String id) {
		setId(id);
		pilaDispositivos = new PilaNodos<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException(ERROR_ID);
		}
		this.id = id;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public boolean mismoId(Jugador jugador) {
		return jugador.id == this.id;
	}

	public boolean enfrentar(Jugador jugador) {
		boolean gane = false;
		int miPoder = obtenerPoder();
		int elOtroPoder = jugador.obtenerPoder();

		if (miPoder >= elOtroPoder) {
			gane = true;
		}

		return gane;
	}

	public boolean tienenMismoDispositivo(Jugador contrincante) {
		// TODO - Cada jugador podra tener mas de un dispositivo, por lo tanto habrá que
		// trabajar mas aqui.
		boolean tienen = false;
		PilaNodos<Dispositivo> aux = new PilaNodos<>();
		Dispositivo dispositivo = null;

		PilaNodos<Dispositivo> pilaContrincante = contrincante.pilaDispositivos;
		PilaNodos<Dispositivo> auxContrincante = new PilaNodos<>();
		Dispositivo dispContrincante = null;

		while (!pilaDispositivos.isEmpty()) {
			dispositivo = pilaDispositivos.pop();
			aux.push(dispositivo);

			while (!pilaContrincante.isEmpty() && tienen != true) {
				dispContrincante = pilaContrincante.pop();
				auxContrincante.push(dispContrincante);

				if (dispositivo.equals(dispContrincante)) {
					tienen = true;
				}

			}
			while (!auxContrincante.isEmpty()) {
				pilaContrincante.push(auxContrincante.pop());
			}

		}

		while (!aux.isEmpty()) {
			pilaDispositivos.push(aux.pop());
		}

		return tienen;
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		pilaDispositivos.push(dispositivo);
	}

	// TODO - Asegurarse de agregar la nueva logica de validacion antes de un
	// enfrentamiento donde corresponda.
	public abstract boolean puedeEnfrentar(Jugador jugador1);

	protected abstract int obtenerPoder();

	public void sumarTriunfo() {
		ganados++;
	}

	protected int getGanados() {
		return ganados;
	}

	@Override
	public String toString() {
		return getClass().getName() + " id =" + id + " Encuentros ganados = " + ganados;
	}

	public void mostrar() {
		System.out.println(toString());
	}

	// TODO - Implementar Mostrable donde corresponda.

	public int getCantidadDeDispositivos() {
		int dispositivos = 0;
		PilaNodos<Dispositivo> aux = new PilaNodos<Dispositivo>();
		Dispositivo dispositivo;

		while (!pilaDispositivos.isEmpty()) {
			dispositivo = pilaDispositivos.pop();
			aux.push(dispositivo);
			dispositivos++;
		}
		while (!aux.isEmpty()) {
			pilaDispositivos.push(aux.pop());
		}

		return dispositivos;
	}

}