package ar.edu.ort.tp1.examen.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaInscriptos extends ListaOrdenadaNodos<String, Jugador> {

	public int compare(Jugador jugador1, Jugador jugador2) {
		return jugador1.getId().compareTo(jugador2.getId());
	}

	@Override
	public int compareByKey(String id, Jugador jugador) {
		// TODO Auto-generated method stub
		return id.compareTo(jugador.getId());
	}
}
