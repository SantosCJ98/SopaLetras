package funciones;

import static colores.Colores.*;

import static teclado.Teclado.*;

import java.util.Random;

public class funciones {

	// Enum con las orientaciones

	public enum Orientaciones {

		ARRIBA, ABAJO, IZQ, DCHA, ARRIBAIZQ, ARRIBADCHA, ABAJOIZQ, ABAJODCHA

	}

	// Funcion para jugar a la sopa de letras.

	/*
	 * Si no hay palabras en la sopa, no se podrá jugar. En caso de haberlas, se
	 * iniciará el juego. Por cada intento, se mostrará el número de palabras
	 * acertadas y el total de palabras de la sopa. El programa le pedirá al
	 * usuario, en que fila, columna y orientación ha visto una palabra. Si es
	 * correcto, se coloreará esa parte de la sopa, y se incrementará el número de
	 * palabras acertadas. La palabra acertada se eliminará de la lista. Tanto si
	 * acierta como si no, se mostrará la sopa, para que el jugador pueda ver si ha
	 * acertado o no. Cuando el jugador acierte todas las palabras, se le felicitará
	 * y se le mostrará el número de intentos que ha necesitado.
	 */

	public static void jugar(String[][] sopa, String[] palabras) {

		/*
		 * sopa contiene la sopa de letras, es de referencia y es de entrada y salida.
		 * 
		 * palabras contiene las palabras de la sopa, es de referencia, y es de entrada.
		 */

		String[] aux = palabras;

		Orientaciones orientacion = Orientaciones.ARRIBA;

		int numintentos = 0;

		int numpalabras = contarpalabrasvalidas(palabras);

		int palabrasacertadas = 0;

		if (numpalabras > 0) {

			while (palabrasacertadas < numpalabras) {

				System.out.println("Has acertado " + palabrasacertadas + " palabras de " + numpalabras);

				System.out.println("Indica la fila de una palabra:");

				int fila = readRange(1, sopa.length, Rangos.AMBOSIN);

				System.out.println("Indica la columna de una palabra:");

				int columna = readRange(1, sopa.length, Rangos.AMBOSIN);

				System.out.println(
						"¿Orientacion?\n1. Arriba\n2. Abajo\n3. Izquierda\n4. Derecha\n5. Arriba Izq\n6. Arriba Dcha\n7. Abajo Izq\n8. Abajo Dcha");

				int opcion = readRange(1, 8, Rangos.AMBOSIN);

				switch (opcion) {

				case 1:
					orientacion = Orientaciones.ARRIBA;
					break;

				case 2:
					orientacion = Orientaciones.ABAJO;
					break;

				case 3:
					orientacion = Orientaciones.IZQ;
					break;

				case 4:
					orientacion = Orientaciones.DCHA;
					break;

				case 5:
					orientacion = Orientaciones.ARRIBAIZQ;
					break;

				case 6:
					orientacion = Orientaciones.ARRIBADCHA;
					break;

				case 7:
					orientacion = Orientaciones.ABAJOIZQ;
					break;

				case 8:
					orientacion = Orientaciones.ABAJODCHA;
					break;

				}

				for (int i = 0; i < aux.length; i++) {

					if (buscarpalabra(sopa, aux[i], fila, columna, orientacion)) {

						System.out.println("¡Correcto!");

						sopa = colorear(sopa, aux[i], fila, columna, orientacion);

						aux[i] = "found";

						palabrasacertadas++;

					}

					else {

					}

				}

				numintentos++;

				mostrarSopaLetras(sopa);

			}

			System.out.println("¡Enhorabuena! ¡Has completado la sopa de letras en " + numintentos + " intentos!");

		}

		else {

			System.out.println("No se puede jugar. No hay palabras validas.");

		}

	}

	// Función que devuelve la cantidad de palabras que han sido admitidas al crear
	// la sopa.

	public static int contarpalabrasvalidas(String[] palabras) {

		// palabras contiene las palabras de la sopa, es de referencia y es de entrada

		int novalidas = 0;

		for (int i = 0; i < palabras.length; i++) {

			if (palabras[i].equals("invalido")) {

				novalidas++;

			}

		}

		return palabras.length - novalidas;

	}

	// Funcion para colorear la sopa de letras.

	/*
	 * Se le resta uno a la fila y a la columna introducida (para convertirlas en
	 * posiciones de la matriz)
	 * 
	 * Dependiendo de la orientacion y de la palabra indicada, coloreará esa parte
	 * de la matriz en amarillo hasta que alcance el final de la palabra.
	 */

	public static String[][] colorear(String[][] sopa, String palabra, int fila, int columna, Orientaciones or) {

		/*
		 * sopa contiene la sopa de letras, es de referencia, y es de entrada y salida.
		 * 
		 * palabra contiene la palabra a colorear en la sopa, es de valor, y es de
		 * entrada.
		 * 
		 * fila y columna contienen, respectivamente, la fila y la columna donde empieza
		 * la palabra, son por valor, y son de entrada.
		 * 
		 * Orientacion indica en que sentido está escrita la palabra, es de referencia,
		 * y es de entrada.
		 */

		int filainicial = fila - 1;

		int colinicial = columna - 1;

		if (or == Orientaciones.DCHA) {

			for (int j = colinicial, k = 0; k < palabra.length(); k++, j++) {

				sopa[filainicial][j] = AMARILLO + sopa[filainicial][j] + RESET;

			}

		}

		else if (or == Orientaciones.IZQ) {

			for (int j = colinicial, k = 0; k < palabra.length(); k++, j--) {

				sopa[filainicial][j] = AMARILLO + sopa[filainicial][j] + RESET;

			}

		}

		else if (or == Orientaciones.ABAJO) {

			for (int i = filainicial, k = 0; k < palabra.length(); i++, k++) {

				sopa[i][colinicial] = AMARILLO + sopa[i][colinicial] + RESET;

			}

		}

		else if (or == Orientaciones.ARRIBA) {

			for (int i = filainicial, k = 0; k < palabra.length(); i--, k++) {

				sopa[i][colinicial] = AMARILLO + sopa[i][colinicial] + RESET;

			}

		}

		else if (or == Orientaciones.ABAJODCHA) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i++, j++, k++) {

				sopa[i][j] = AMARILLO + sopa[i][j] + RESET;

			}

		}

		else if (or == Orientaciones.ABAJOIZQ) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i++, j--, k++) {

				sopa[i][j] = AMARILLO + sopa[i][j] + RESET;

			}

		}

		else if (or == Orientaciones.ARRIBAIZQ) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i--, j--, k++) {

				sopa[i][j] = AMARILLO + sopa[i][j] + RESET;

			}

		}

		else if (or == Orientaciones.ARRIBADCHA) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i--, j++, k++) {

				sopa[i][j] = AMARILLO + sopa[i][j] + RESET;

			}

		}

		return sopa;

	}

	// Función para buscar una palabra en la sopa.

	/*
	 * Se le resta uno a la fila y a la columna introducida (para convertirlas en
	 * posiciones de la matriz)
	 * 
	 * Con la fila, columna y orientación indicadas, se recorre la matriz buscando
	 * letras que coinciden con las de la palabra. Si una letra coincide, se le suma
	 * uno al número de letras encontradas, y asi hasta encontrar todas las letras.
	 * Si una letra no coincide, se deja de buscar. Si al final el número de letras
	 * que han coincidido concuerda con la longitud de la palabra, se dice que ha
	 * encontrado la palabra.
	 * 
	 */

	public static boolean buscarpalabra(String[][] sopa, String palabra, int fila, int columna, Orientaciones or) {

		/*
		 * sopa contiene la sopa de letras, es de referencia, y es de entrada.
		 * 
		 * palabra contiene la palabra a buscar en la sopa, es de valor, y es de
		 * entrada.
		 * 
		 * fila y columna contienen, respectivamente, la fila y la columna donde se
		 * supone que empieza la palabra, son por valor, y son de entrada.
		 * 
		 * Orientacion indica en que sentido está escrita la palabra, es de referencia,
		 * y es de entrada.
		 */

		int filainicial = fila - 1;

		int colinicial = columna - 1;

		boolean encontrado = true;

		int contador = 0;

		if (or == Orientaciones.DCHA) {

			for (int j = colinicial, k = 0; j < sopa.length && k < palabra.length() && encontrado; j++, k++) {

				if (!sopa[filainicial][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[filainicial][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.IZQ) {

			for (int j = colinicial, k = 0; j >= 0 && k < palabra.length() && encontrado; j--, k++) {

				if (!sopa[filainicial][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[filainicial][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.ABAJO) {

			for (int i = filainicial, k = 0; i < sopa.length && k < palabra.length() && encontrado; i++, k++) {

				if (!sopa[i][colinicial].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[i][colinicial].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.ARRIBA) {

			for (int i = filainicial, k = 0; i >= 0 && k < palabra.length() && encontrado; i--, k++) {

				if (!sopa[i][colinicial].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[i][colinicial].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.ARRIBAIZQ) {

			for (int i = filainicial, j = colinicial, k = 0; i >= 0 && j >= 0 && k < palabra.length()
					&& encontrado; i--, j--, k++) {

				if (!sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.ARRIBADCHA) {

			for (int i = filainicial, j = colinicial, k = 0; i >= 0 && j < sopa[i].length && k < palabra.length()
					&& encontrado; i--, j++, k++) {

				if (!sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.ABAJODCHA) {

			for (int i = filainicial, j = colinicial, k = 0; i < sopa.length && j < sopa[i].length
					&& k < palabra.length() && encontrado; i++, j++, k++) {

				if (!sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		else if (or == Orientaciones.ABAJOIZQ) {

			for (int i = filainicial, j = colinicial, k = 0; i < sopa.length && j >= 0 && k < palabra.length()
					&& encontrado; i++, j--, k++) {

				if (!sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = false;

				}

				else if (sopa[i][j].contains(String.valueOf(palabra.charAt(k)))) {

					encontrado = true;

				}

				if (encontrado == true) {

					contador++;

				}

			}

		}

		if (contador == palabra.length()) {

			return true;

		}

		else {

			return false;

		}

	}
	// Función para saber que palabras son válidas para la sopa y cuáles no.
	/*
	 * Se le resta uno a la fila y a la columna introducida (para convertirlas en
	 * posiciones de la matriz)
	 * 
	 * Si la palabra empieza con una mayúscula y termina en minúscula, la palabra se
	 * admite. (Se admiten palabras compuestas, pero no pueden tener espacios y cada
	 * palabra debe empezar con mayúscula). También se admite si cabe en la sopa.
	 * 
	 * También se pueden cruzar, pero las letras donde se cruzan deben coincidir.
	 * 
	 */

	public static boolean admitirpalabra(String[][] sopa, int fila, int columna, Orientaciones or, String palabra) {

		/*
		 * sopa contiene la sopa de letras, es de referencia, y es de entrada.
		 * 
		 * palabra contiene la palabra a evaluar, es de valor, y es de entrada.
		 * 
		 * fila y columna contienen, respectivamente, la fila y la columna donde
		 * empezaría la palabra, son por valor, y son de entrada.
		 * 
		 * Orientacion indica en que sentido estaría escrita la palabra, es de
		 * referencia, y es de entrada.
		 */

		boolean cruzar = true;

		boolean valido = false;

		int filainicial = fila - 1;

		int colinicial = columna - 1;

		int espacios = 0;

		if (palabra.matches("[A-ZÑ][a-zñ]+([A-ZÑ]{1,2}[a-zñ]+)*") && palabra.length() <= sopa.length) {

			if (or == Orientaciones.DCHA) {

				for (int j = colinicial; j < sopa[filainicial].length; j++) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = colinicial; k < palabra.length() && cruzar; j++, k++) {

						if (!sopa[filainicial][j].equals(" ")) {

							if (sopa[filainicial][j].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = true;

							}

							else if (!sopa[filainicial][j].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[filainicial][j].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.IZQ) {

				for (int j = colinicial; j >= 0; j--) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = colinicial; k < palabra.length() && cruzar; j--, k++) {

						if (!sopa[filainicial][j].equals(" ")) {

							if (sopa[filainicial][j].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = true;

							}

							else if (!sopa[filainicial][j].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[filainicial][j].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.ABAJO) {

				for (int i = filainicial; i < sopa.length; i++) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = filainicial; k < palabra.length() && cruzar; j++, k++) {

						if (!sopa[j][colinicial].equals(" ")) {

							if (sopa[j][colinicial].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = true;

							}

							else if (!sopa[j][colinicial].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[j][colinicial].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.ARRIBA) {

				for (int i = filainicial; i >= 0; i--) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = filainicial; k < palabra.length() && cruzar; j--, k++) {

						if (!sopa[j][colinicial].equals(" ")) {

							if (sopa[j][colinicial].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = true;

							}

							else if (!sopa[j][colinicial].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[j][colinicial].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.ABAJOIZQ) {

				for (int i = filainicial, j = colinicial; i < sopa.length && j >= 0; i++, j--) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = filainicial, i = colinicial; k < palabra.length() && cruzar; j++, i--, k++) {

						if (!sopa[j][i].equals(" ")) {

							if (sopa[j][i].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = true;

							}

							else if (!sopa[j][i].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[j][i].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.ABAJODCHA) {

				for (int i = filainicial, j = colinicial; i < sopa.length && j < sopa[i].length; i++, j++) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = filainicial, i = colinicial; k < palabra.length() && cruzar; j++, i++, k++) {

						if (!sopa[j][i].equals(" ")) {

							if (sopa[j][i].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = true;

							}

							else if (!sopa[j][i].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[j][i].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.ARRIBAIZQ) {

				for (int i = filainicial, j = colinicial; i >= 0 && j >= 0; i--, j--) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = filainicial, i = colinicial; k < palabra.length() && cruzar; j--, i--, k++) {

						if (!sopa[j][i].equals(" ")) {

							if (sopa[j][i] == String.valueOf(palabra.charAt(k))) {

								cruzar = true;

							}

							else if (!sopa[j][i].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[j][i].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

			else if (or == Orientaciones.ARRIBADCHA) {

				for (int i = filainicial, j = colinicial; i >= 0 && j < sopa.length; i--, j++) {

					espacios++;

				}

				if (espacios >= palabra.length()) {

					for (int k = 0, j = filainicial, i = colinicial; k < palabra.length() && cruzar; j--, i++, k++) {

						if (!sopa[j][i].equals(" ")) {

							if (sopa[j][i] == String.valueOf(palabra.charAt(k))) {

								cruzar = true;

							}

							else if (!sopa[j][i].equals(String.valueOf(palabra.charAt(k)))) {

								cruzar = false;

							}

						}

						else if (sopa[j][i].equals(" ")) {

							cruzar = true;

						}

						if (cruzar) {

							valido = true;

						}

						else {

							valido = false;

						}

					}

				}

			}

		}

		else {

			valido = false;

		}

		return valido;

	}

	// Función para pedir las palabras.

	// Las palabras no pueden repetirse. Si una se repite se pedira de nuevo hasta
	// que no se repita.

	public static String[] peticionPalabra(int numpalabras) {

		// numpalabras contiene el numero de palabras a pedir, es de valor y es de
		// entrada

		String[] palabras = new String[numpalabras];

		String aux;

		boolean repetido = false;

		int i = 0;

		while (i < palabras.length) {

			System.out.println("Introduce la palabra nº " + (i + 1));

			aux = readString();

			repetido = false;

			for (int j = 0; j < palabras.length; j++) {

				if (aux.equals(palabras[j])) {

					repetido = true;

				}

			}

			if (!repetido && aux.contains(" ")) {

				palabras[i] = aux;

				i++;

			}

		}

		return palabras;

	}

	// Función para generar una letra aleatoria.

	// Creamos un array con todas las letras que se admiten (De la A a la Z,
	// minúsculas y mayúsculas, Ñ incluida).

	// Se elige una letra al azar.

	public static String randomchar() {

		Random random = new Random();

		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

		String resultado = letras[random.nextInt(letras.length)];

		return resultado;

	}

	// Función para rellenar las posiciones vacías de la sopa con letras aleatorias.

	// Recorremos la sopa en busca de espacios. Si encuentra uno, lo sustituye por
	// una letra aleatoria.

	public static String[][] rellenar(String[][] sopa) {

		// sopa es la sopa de letras que debemos rellenar, es de referencia, y es de
		// entrada y salida.

		for (int i = 0; i < sopa.length; i++) {

			for (int j = 0; j < sopa[i].length; j++) {

				if (sopa[i][j] == " ") {

					sopa[i][j] = randomchar();

				}

			}

		}

		return sopa;

	}

	// Función para rellenar las posiciones vacías de la sopa con letras aleatorias.
	// (recursiva)

	/*
	 * Si encuentra un espacio vacio, lo sustituye por una letra aleatoria.
	 * 
	 * Si estamos en la ultima columna, se incrementa la fila, y volvemos hasta la
	 * primera columna.
	 * 
	 * Si no, incrementamos la columna.
	 * 
	 */

	public static String[][] rellenar_recursivo(String[][] sopa, int i, int j) {

		// sopa es la sopa de letras que debemos rellenar, es de referencia, y es de
		// entrada y salida.

		if (sopa[i][j] == " ") {

			sopa[i][j] = randomchar();

		}

		if (i != sopa.length - 1 || j != sopa[i].length - 1) {

			if (j == sopa[i].length - 1) {

				i++;

				j = 0;

			}

			else {

				j++;

			}

			return rellenar_recursivo(sopa, i, j);

		}

		return sopa;

	}

	// Función que mete las palabras en la sopa de letras.

	/*
	 * Se le resta uno a la fila y a la columna introducida (para convertirlas en
	 * posiciones de la matriz)
	 * 
	 * Se recorre la sopa en la orientacion indicada, rellenando cada posición con
	 * cada letra de la palabra.
	 * 
	 */

	public static String[][] insertar(String[][] sopa, int fila, int columna, Orientaciones or, String palabra) {

		/*
		 * sopa es la sopa de letras en la que insertaremos la palabra, es de referencia
		 * y de entrada y salida.
		 * 
		 * fila y columna son las posiciones en los que empezaría la inserción. Son de
		 * valor y de entrada.
		 * 
		 * Orientacion indica el sentido en el que se inserta la palabra. Es de
		 * referencia y de entrada.
		 * 
		 * Palabra es la palabra a insertar. Es de valor, y de entrada.
		 * 
		 */

		int filainicial = fila - 1;

		int colinicial = columna - 1;

		if (or == Orientaciones.DCHA) {

			for (int i = colinicial, k = 0; k < palabra.length(); i++, k++) {

				sopa[filainicial][i] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.IZQ) {

			for (int i = colinicial, k = 0; k < palabra.length(); i--, k++) {

				sopa[filainicial][i] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.ABAJO) {

			for (int i = filainicial, k = 0; k < palabra.length(); i++, k++) {

				sopa[i][colinicial] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.ARRIBA) {

			for (int i = filainicial, k = 0; k < palabra.length(); i--, k++) {

				sopa[i][colinicial] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.ABAJODCHA) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i++, j++, k++) {

				sopa[i][j] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.ABAJOIZQ) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i++, j--, k++) {

				sopa[i][j] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.ARRIBADCHA) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i--, j++, k++) {

				sopa[i][j] = String.valueOf(palabra.charAt(k));

			}

		}

		else if (or == Orientaciones.ARRIBAIZQ) {

			for (int i = filainicial, j = colinicial, k = 0; k < palabra.length(); i--, j--, k++) {

				sopa[i][j] = String.valueOf(palabra.charAt(k));

			}

		}

		return sopa;

	}

	// Función que muestra la sopa de letras.

	/*
	 * Muestra la sopa con las filas y columnas enumeradas del 1 hasta la longitud
	 * de la sopa. (el número de cada fila tiene color verde, y el de cada columna,
	 * azul.)
	 */

	public static void mostrarSopaLetras(String[][] sopa) {

		// sopa es la sopa de letras a mostrar. Es de referencia, y de entrada y salida.

		int numfilas = sopa.length;

		int numcolumnas = sopa[numfilas - 1].length;

		for (int fila = 0; fila <= numfilas; fila++) {

			for (int columna = 0; columna < numcolumnas; columna++) {

				if (columna == 0 && fila != numfilas && fila < 9) {

					System.out.printf(VERDE + "%d " + RESET, (fila + 1));

				}

				else if (columna == 0 && fila != numfilas && fila >= 9) {

					System.out.printf(VERDE + "%d" + RESET, (fila + 1));

				}

				else if (fila == numfilas && columna == 0) {

					System.out.print("  ");

				}

				if (fila != numfilas)

					System.out.printf(" %s ", sopa[fila][columna]);

				else if (fila == numfilas && columna < 9)

					System.out.printf(CELESTE + " %d " + RESET, (columna + 1));

				else if (fila == numfilas && columna >= 9)

					System.out.printf(CELESTE + "%d " + RESET, (columna + 1));

			}

			System.out.println();

		}

	}

	// Función que genera la sopa de letras.

	/*
	 * Por cada palabra, se le preguntará al usuario en que fila, columna y
	 * orientacion desea colocarla). Si admite la palabra, la coloca. Si no, la
	 * tacha de la lista. Por cada palabra admitida, se mostrará la sopa. Una vez se
	 * termine de insertar todas las palabras válidas, se rellenará el resto de
	 * espacios con letras aleatorias, y se mostrará el resultado.
	 * 
	 */

	public static String[][] crearSopaLetras(int n, String[] palabras) {

		/*
		 * n es el tamaño de la sopa de letras. Es de valor, y de entrada.
		 * 
		 * palabras son las palabras a insertar en la sopa. Es de referencia y de
		 * entrada y salida.
		 * 
		 */

		Orientaciones orientacion = Orientaciones.ARRIBA;

		String[][] sopa = new String[n][n];

		sopa = espacios(sopa);

		for (int i = 0; i < palabras.length; i++) {

			System.out.println("La palabra a introducir es " + palabras[i]);

			System.out.println("¿En que fila quiere colocarla?");

			int fila = readRange(1, sopa.length, Rangos.AMBOSIN);

			System.out.println("¿En que columna?");

			int columna = readRange(1, sopa.length, Rangos.AMBOSIN);

			System.out.println(
					"¿Orientacion?\n1. Arriba\n2. Abajo\n3. Izquierda\n4. Derecha\n5. Arriba Izq\n6. Arriba Dcha\n7. Abajo Izq\n8. Abajo Dcha");

			int opcion = readRange(1, 8, Rangos.AMBOSIN);

			switch (opcion) {

			case 1:
				orientacion = Orientaciones.ARRIBA;
				break;

			case 2:
				orientacion = Orientaciones.ABAJO;
				break;

			case 3:
				orientacion = Orientaciones.IZQ;
				break;

			case 4:
				orientacion = Orientaciones.DCHA;
				break;

			case 5:
				orientacion = Orientaciones.ARRIBAIZQ;
				break;

			case 6:
				orientacion = Orientaciones.ARRIBADCHA;
				break;

			case 7:
				orientacion = Orientaciones.ABAJOIZQ;
				break;

			case 8:
				orientacion = Orientaciones.ABAJODCHA;
				break;

			}

			if (admitirpalabra(sopa, fila, columna, orientacion, palabras[i])) {

				sopa = insertar(sopa, fila, columna, orientacion, palabras[i]);

				mostrarSopaLetras(sopa);

			}

			else {

				palabras[i] = "invalido";

			}

		}

		System.out.println(
				"Se han insertado todas las palabras válidas.\n" + "Se procedera a rellenar el resto de la sopa.");

		sopa = rellenar_recursivo(sopa, 0, 0);

		mostrarSopaLetras(sopa);

		return sopa;

	}

	// Función que llena de espacios los huecos libres de la sopa (Para evitar que
	// muestre "null").

	public static String[][] espacios(String[][] sopa) {

		// sopa es la sopa de letras. Es de referencia y de entrada y salida.

		for (int i = 0; i < sopa.length; i++) {

			for (int j = 0; j < sopa[i].length; j++) {

				if (sopa[i][j] == null || sopa[i][j].equals("")) {

					sopa[i][j] = " ";

				}

			}

		}

		return sopa;

	}

	// Función que verifica si se ha creado una sopa de letras. (Se considera que
	// esta creada si no tiene espacios en blanco)

	// Función del menú del juego.

	/*
	 * Se le dará la bienvenida al jugador, y continuación se le dará a elegir entre
	 * crear una sopa, mostrarla, jugar o salir del programa. Si al empezar el
	 * programa o después de haber jugado, se elige la 2ª o la 3ª opción, se pedirá
	 * que primero se cree una sopa de letras.
	 * 
	 * Cuando se vaya a crear la sopa, se le preguntará al usuario el tamaño de esta
	 * (mínimo 3: máximo: 20), el número de palabras (mínimo: 1, máximo: tamaño de
	 * la sopa) y se llamará a la función de crear la sopa.
	 * 
	 * 
	 * Antes de mostrar o jugar a una sopa, primero se comprobará si primero se ha
	 * creado.
	 * 
	 * Antes de salir, el programa le dará las gracias al jugador por jugar.
	 */

	public static void menu() {

		int opcion = 0;

		int n;

		int numpalabras;

		System.out.println("¡Bienvenido al juego de la Sopa de Letras!");

		String[][] sopa = null;

		String[] palabras = null;

		while (opcion != 4) {

			if (opcion == 3) {

				sopa = null;

				palabras = null;

			}

			System.out.println(
					"Seleccione una opción:\n1. Crear sopa de letras\n2. Mostrar sopa de letras\n3. Jugar\n4. Salir");

			opcion = readRange(1, 4, Rangos.AMBOSIN);

			switch (opcion) {

			case 1:
				System.out.println("¿De qué tamaño quieres que sea la sopa?\n" + "(Mínimo: 3, Maximo: 20)");

				n = readRange(3, 20, Rangos.AMBOSIN);

				System.out.println("¿Cuántas palabras quieres que tenga?\n" + "(Mínimo: 1)");

				numpalabras = readEqui(1, Equivalencias.MAYORIGUAL);

				sopa = crearSopaLetras(n, palabras = peticionPalabra(numpalabras));

				break;

			case 2:

				if (sopa != null) {

					mostrarSopaLetras(sopa);

				}

				else {

					System.out.println("Primero tienes que crear una sopa de letras.");

				}

				break;

			case 3:

				if (sopa != null) {

					jugar(sopa, palabras);

				}

				else {

					System.out.println("Primero tienes que crear una sopa de letras.");

				}

				break;

			case 4:
				System.out.println("¡Gracias por jugar!");
				break;

			}

		}

	}
}
