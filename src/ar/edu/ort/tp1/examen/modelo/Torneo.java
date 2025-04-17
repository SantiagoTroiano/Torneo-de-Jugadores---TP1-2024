package ar.edu.ort.tp1.examen.modelo;

import java.util.ArrayList;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class Torneo {

	private String juego;
	// Debe cambiarse por la estructura que cumpla con el requisito esperado:
	// ordenada por id de jugador y accesible a la posición que se desee.
	// private ArrayList<Jugador> jugadores;
	private ListaOrdenadaInscriptos jugadores;

	public Torneo(String juego) {
		this.juego = juego;
		// this.jugadores = new ArrayList<Jugador>();
		jugadores = new ListaOrdenadaInscriptos();
	}

	public boolean inscribir(Jugador jugador) {
		boolean retorno = false;
		if (jugador != null && !existe(jugador)) {
			jugadores.add(jugador);
			// TODO - Reemplazar por lo que corresponda
			jugador.mostrar();
			System.out.print("Jugador inscripto\n");
			retorno = true;
		}
		return retorno;
	}

	private boolean existe(Jugador jugador) {
		boolean existe = false;
		if (jugadores.search(jugador.getId()) != null) {
			existe = true;
		}
//		int i = 0;
//		while (!existe && i < jugadores.size()) {
//			existe = jugadores.get(i).mismoId(jugador);
//			i++;
//		}
		return existe;
	}

	// TODO - Debe asegurar un ganador (no debe devolver null).
	public void desarrollarPartida() {
		int i1 = obtenerIndice(0);
		int i2 = obtenerIndice(i1);

		Jugador retador = jugadores.get(i1 - 1);
		Jugador contrincante = jugadores.get(i2 - 1);

		retador.mostrar();
		contrincante.mostrar();

		Jugador ganador = enfrentar(retador, contrincante);

		ganador.mostrar();
	}

	private int obtenerIndice(int otroIdx) {
		int idx;
		do {
			idx = RandomUtil.obtenerAleatorio(jugadores.size());
		} while (idx == otroIdx);
		return idx;
	}

	private Jugador enfrentar(Jugador retador, Jugador contrincante) {
		// TODO - Hay algo que parece mal aqui.
		Jugador ganador = retador;
		if (cumplenReglas(retador, contrincante)) {
			if (retador.enfrentar(contrincante)) {
				ganador = retador;
			} else {
				ganador = contrincante;
			}
			ganador.sumarTriunfo();
		}
		return ganador;
	}

	private boolean cumplenReglas(Jugador retador, Jugador contrincante) {
		return retador.tienenMismoDispositivo(contrincante) && retador.puedeEnfrentar(contrincante);
	}

	public void mostrarCantidadDispositivosPorTipoyDispositivo() {

		System.out.println("Torneo de " + this.juego);
		System.out.printf("%17s", " ");
		for (int i = 0; i < Dispositivo.values().length; i++) {
			System.out.printf("%17s", Dispositivo.values()[i]);
			
			for (Jugador jugador : jugadores) {
				int acumulador = jugador.getCantidadDeDispositivos();
			}
		}
		for (int j = 0; j < TipoJugador.values().length; j++) {
			System.out.println();
			System.out.println(TipoJugador.values()[j]);
		}
		System.out.println();
		System.out.println("-".repeat(85));
		// TODO A Completar con la salida esperada y mostrada en el ejemplo del
		// enunciado
	}

}