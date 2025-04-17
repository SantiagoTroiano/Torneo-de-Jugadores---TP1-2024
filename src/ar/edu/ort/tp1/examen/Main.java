package ar.edu.ort.tp1.examen;

import ar.edu.ort.tp1.examen.modelo.AmateurMayor;
import ar.edu.ort.tp1.examen.modelo.AmateurMenor;
import ar.edu.ort.tp1.examen.modelo.Dispositivo;
import ar.edu.ort.tp1.examen.modelo.Jugador;
import ar.edu.ort.tp1.examen.modelo.Profesional;
import ar.edu.ort.tp1.examen.modelo.RandomUtil;
import ar.edu.ort.tp1.examen.modelo.TipoJugador;
import ar.edu.ort.tp1.examen.modelo.Torneo;

public class Main {

	private static int id = 10;

	public static void main(String[] args) {

		Torneo torneo = new Torneo("Pro Evolution Soccer 2024");

		crearJugadores(torneo);
		System.out.println("-".repeat(95));
		torneo.mostrarCantidadDispositivosPorTipoyDispositivo();
		System.out.println("-".repeat(95));
		// TODO - Realizar una partida y mostrar al ganador con sus datos.
	}

	private static void crearJugadores(Torneo torneo) {

		// Probando validaciones
		inscribirJugadorAmeteurMayorInvladido(torneo, "Un Id", 16);
		inscribirJugadorProfesionalInvalido(torneo, "Un Id", -3, true);
		inscribirJugadorProfesionalInvalido(torneo, "Un Id", 0, true);
		System.out.println("-".repeat(95));
		// se inscriben jugadores

		inscribirJugadorProfesional(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(500), true,
				new Dispositivo[] { Dispositivo.PS4, Dispositivo.PS5, Dispositivo.PC_GAMER });
		inscribirJugadorProfesional(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(500), true,
				new Dispositivo[] { Dispositivo.PS5, Dispositivo.PC_GAMER });
		inscribirJugadorProfesional(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(500), false,
				new Dispositivo[] { Dispositivo.NINTENDO_SWITCH });
		inscribirJugadorProfesional(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(500), true,
				new Dispositivo[] { Dispositivo.NINTENDO_SWITCH, Dispositivo.PC_GAMER });

		inscribirJugadorAmateurMayor(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(70) + 17,
				new Dispositivo[] { Dispositivo.PC_GAMER });
		inscribirJugadorAmateurMayor(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(70) + 17,
				new Dispositivo[] { Dispositivo.PS4, Dispositivo.PS5, Dispositivo.PC_GAMER });
		inscribirJugadorAmateurMayor(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(70) + 17,
				new Dispositivo[] { Dispositivo.PS4, Dispositivo.PC_GAMER });
		inscribirJugadorAmateurMayor(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(70) + 17,
				new Dispositivo[] { Dispositivo.NINTENDO_SWITCH, Dispositivo.PS4, Dispositivo.PC_GAMER });
		inscribirJugadorAmateurMayor(torneo, "Un Id" + ++id, RandomUtil.obtenerAleatorio(70) + 17,
				new Dispositivo[] { Dispositivo.PS4 });

		inscribirJugadorAmateurMenor(torneo, "Un Id" + ++id, true, new Dispositivo[] { Dispositivo.NINTENDO_SWITCH });
		inscribirJugadorAmateurMenor(torneo, "Un Id" + ++id, false,
				new Dispositivo[] { Dispositivo.PS4, Dispositivo.PS5, Dispositivo.NINTENDO_SWITCH });
		inscribirJugadorAmateurMenor(torneo, "Un Id" + ++id, false,
				new Dispositivo[] { Dispositivo.NINTENDO_SWITCH, Dispositivo.PS4 });
		inscribirJugadorAmateurMenor(torneo, "Un Id" + ++id, true,
				new Dispositivo[] { Dispositivo.PS4, Dispositivo.PC_GAMER });
		
		System.err.println("///////////////////////////////////////////////////////////////////////////"
				+ TipoJugador.AMATEUR_MAYOR.ordinal());
		
		System.out.println(TipoJugador.AMATEUR_MAYOR.ordinal());
		
	}

	private static void inscribirJugadorProfesionalInvalido(Torneo torneo, String id, int exp, boolean habilitado) {
		try {
			Jugador j = new Profesional(id, exp, habilitado);
			torneo.inscribir(j);

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	private static void inscribirJugadorAmeteurMayorInvladido(Torneo torneo, String id, int edad) {

		try {
			Jugador j = new AmateurMayor(id, edad);
			torneo.inscribir(j);

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	private static void inscribirJugadorAmateurMenor(Torneo torneo, String id, boolean autorizacion,
			Dispositivo[] dispositivos) {
		Jugador j = new AmateurMenor(id, autorizacion);
		agregarDispositivos(dispositivos, j);
		torneo.inscribir(j);
	}

	private static void inscribirJugadorAmateurMayor(Torneo torneo, String id, int edad, Dispositivo[] dispositivos) {
		Jugador j = new AmateurMayor(id, edad);
		agregarDispositivos(dispositivos, j);
		torneo.inscribir(j);
	}

	private static void inscribirJugadorProfesional(Torneo torneo, String id, int exp, boolean habilitado,
			Dispositivo[] dispositivos) {
		Jugador j = new Profesional(id, exp, habilitado);
		agregarDispositivos(dispositivos, j);
		torneo.inscribir(j);
	}

	private static void agregarDispositivos(Dispositivo[] dispositivos, Jugador j) {
		for (Dispositivo dispositivo : dispositivos) {
			// TODO Descomentar
			j.agregarDispositivo(dispositivo);
		}
	}

}
