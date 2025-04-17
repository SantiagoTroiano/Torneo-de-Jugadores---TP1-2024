package ar.edu.ort.tp1.examen.modelo;

import java.util.concurrent.ThreadLocalRandom;

/**
*/
public class RandomUtil {

	public static int obtenerAleatorio(int maximo) {
		return ThreadLocalRandom.current().nextInt(1, maximo + 1);
	}

}