package teclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
	
	//enums
	
	public enum Equivalencias {
		
		MAYORIGUAL, MENORIGUAL, MAYOR, MENOR
		
	}
	
	public enum Rangos {
		
		AMBOSIN, AMBOSEX, MININMAXEX, MINEXMAXIN
		
	}
	
	//Clase keyboard
	
	static Scanner keyboard = new Scanner(System.in);
	
	//Función para cerrar el teclado.
	
	public static void closekb() {
	
		keyboard.close();
		
	}
	
	//Función para leer caracter
	
	public static char readChar() {
		
		String x="";
		
		do {
		
		x = keyboard.nextLine();
		
		} while (x.equals(""));              // Como un caracter no puede valer '', hasta que no sea distinto a ese valor seguira pidiendolo.
		
		char y = x.charAt(0);
	
		return y;
		
		
		
		
	}
	
	
	//Función para leer cadena
	
	public static String readString() {
		
		String x;
		
		do {
		
		x = keyboard.nextLine();
		
		} while (x.equals(""));
		
		return x;
		
	}
	
	// Función para leer booleano (Respuesta 1 o 2)
	
	public static boolean readBoolean (String mensaje, String mensaje2, String mensaje3) {
		
		int res=0;
		
		boolean bolres=false;
		
		boolean error = false;
		
		do {
			try {

				do {

					System.out.printf("%s%n1.%s%n2.%s%n", mensaje, mensaje2, mensaje3);

					res = keyboard.nextInt();

					error = false;

				} while (res != 1 && res != 2);                   // La respuesta debe ser obligatoriamente 1 o 2.

			}

			catch (InputMismatchException e) {

				System.out.println("Error: el tipo de dato introducido no es válido");   //Si no se introduce un número, se introduce un error.

				error = true;

			}

			finally {

				keyboard.nextLine();

			}
			if (res == 1) {

				bolres = true;                                          // Si la respuesta es 1, devuelve true

				error = false;

			}

			else if (res == 2) {

				bolres = false;

				error = false;											// Si la respuesta es 2, devuelve false

			}

			else {

				System.out.println("Ha ocurrido un error");				//Si no es ni 1 ni 2, hay un error.

				error = true;

			}
			
		} while (error == true);										//Si hay un error, volvera a pedir el número.
		
		return bolres;
			
		
		
		
	}
	
	// Función para leer booleano (Respuesta s/n || S/N)
	
	public static boolean readBoolean (String mensaje) {
		
		boolean res=false;
		
		boolean error = false;
		
		String x;
		
		char y;
		
		do {
		
		do {
		
		System.out.printf("%s (s/n)%n", mensaje);
		
		x = keyboard.nextLine();
		
		} while (x.equals(""));															//El caracter no puede ser '';
		
		y = x.charAt(0);
		
		} while ((y != 's' && y != 'S') && (y != 'n' && y != 'N'));						//El caracter debe ser 's', 'S', 'n' o 'N' obligatoriamente.
		
		do {
	
		if (y == 's' || y == 'S') {
			
			res = true;
			
			error = false;
			
		}																				//Si el caracter es 's' o 'S', devuelve true.
		
		else if (y == 'n' || y == 'N') {
			
			res = false;
			
			error = false;
			
		}																				//Si el caracter es 'n' o 'N', devuelve false.
		
		else  {
			
			System.out.println("Ha ocurrido un error");
			
			error = true;																//Si no, da error.
			
		}
				
		} while (error == true);														// Y si da error, vuelve a pedir los datos.
		
		return res;
		
	}
	
	// Funciones para leer números (Pide el número y si no se introduce un número, o esta fuera del rango, da error, y vuelve a pedirlo)
	
	public static int readInt () {
		
		int x=0;
		
		boolean error = false;
		
		do {
		
		try {
		
			x = keyboard.nextInt();
			
			error = false;
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: No has introducido un número entero");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return x;
		
		
		
	}
	
	public static byte readByte () {
		
		byte x=0;
		
		boolean error = false;
		
		do {
		
		try {
		
			x = keyboard.nextByte();
			
			error = false;
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: No has introducido un número byte");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return x;
		
		
		
	}
	
	public static short readShort () {
		
		short x=0;
		
		boolean error = false;
		
		do {
		
		try {
		
			x = keyboard.nextShort();
			
			error = false;
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: No has introducido un número short");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return x;
		
		
		
	}
	
	public static double readDouble () {
		
		double x=0;
		
		boolean error = false;
		
		do {
		
		try {
		
			x = keyboard.nextDouble();
			
			error = false;
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: No has introducido un número double");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return x;
		
		
		
	}

	
	public static float readFloat () {
		
		float x=0;
		
		boolean error = false;
		
		do {
		
		try {
		
			x = keyboard.nextFloat();
			
			error = false;
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: No has introducido un número float");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return x;
		
		
		
	
	}
	
	public static long readLong () {
		
		long x=0;
		
		boolean error = false;
		
		do {
		
		try {
		
			x = keyboard.nextLong();
			
			error = false;
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: No has introducido un número long");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return x;
		
		
		
	}
	
	// Funciones para leer numeros con equivalencias.
	
	public static int readEqui (int x, Equivalencias equi) {
		
		int num = 0;
		
		boolean error = false;
		
		do {
		
		try {
		
		switch (equi) {
		
		case MAYORIGUAL:                                //Introducir un número mayor o igual al del primer parámetro.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num < x);
			
			break;
			
		case MENORIGUAL:								//Introducir un número menor o igual al del primer parámetro.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num > x);
			
			break;
			
		case MAYOR:										//Introducir un número mayor al del primer parámetro.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num <= x);
			
			break;
			
		case MENOR:										//Introducir un número menor al del primer parámetro.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num >= x);
			
			break;
		
		}
		
		//Se repite mientras no se cumpla el requisito.
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: no se ha introducido un número entero");
			
			error = true;															//Si no se introduce un número, o esta fuera del rango, hay un error.
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);														//Repetir mientras persista el error.
		
		return num;
		
	}
	
	public static double readEqui (double x, Equivalencias equi) {
		
		double num = 0;
		
		boolean error = false;
		
		do {
		
		try {
		
		switch (equi) {
		
		case MAYORIGUAL:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num < x);
			
			break;
			
		case MENORIGUAL:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num > x);
			
			break;
			
		case MAYOR:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num <= x);
			
			break;
			
		case MENOR:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num >= x);
			
			break;
		
		}
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: no se ha introducido un número double");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return num;
		
	}
	
	public static short readEqui (short x, Equivalencias equi) {
	
	short num = 0;
	
	boolean error = false;
	
	do {
	
	try {
	
	switch (equi) {
	
	case MAYORIGUAL:
		
		do {
		
		num = keyboard.nextShort();
		
		error = false;
		
		} while (num < x);
		
		break;
		
	case MENORIGUAL:
		
		do {
		
		num = keyboard.nextShort();
		
		error = false;
		
		} while (num > x);
		
		break;
		
	case MAYOR:
		
		do {
		
		num = keyboard.nextShort();
		
		error = false;
		
		} while (num <= x);
		
		break;
		
	case MENOR:
		
		do {
		
		num = keyboard.nextShort();
		
		error = false;
		
		} while (num >= x);
		
		break;
	
	}
	
	}
	
	catch (InputMismatchException e) {
		
		System.out.println("Error: no se ha introducido un número short");
		
		error = true;
		
	}
	
	finally {
		
		keyboard.nextLine();
		
	}
	
	} while (error == true);
	
	return num;
	
}
	
	public static byte readEqui (byte x, Equivalencias equi) {
		
		byte num = 0;
		
		boolean error = false;
		
		do {
		
		try {
		
		switch (equi) {
		
		case MAYORIGUAL:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num < x);
			
			break;
			
		case MENORIGUAL:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num > x);
			
			break;
			
		case MAYOR:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num <= x);
			
			break;
			
		case MENOR:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num >= x);
			
			break;
		
		}
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: no se ha introducido un número byte");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return num;
		
	}
	
	public static float readEqui (float x, Equivalencias equi) {
		
		float num = 0;
		
		boolean error = false;
		
		do {
		
		try {
		
		switch (equi) {
		
		case MAYORIGUAL:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num < x);
			
			break;
			
		case MENORIGUAL:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num > x);
			
			break;
			
		case MAYOR:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num <= x);
			
			break;
			
		case MENOR:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num >= x);
			
			break;
		
		}
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: no se ha introducido un número float");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return num;
		
	}
	
	public static long readEqui (long x, Equivalencias equi) {
		
		long num = 0;
		
		boolean error = false;
		
		do {
		
		try {
		
		switch (equi) {
		
		case MAYORIGUAL:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num < x);
			
			break;
			
		case MENORIGUAL:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num > x);
			
			break;
			
		case MAYOR:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num <= x);
			
			break;
			
		case MENOR:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num >= x);
			
			break;
		
		}
		
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: no se ha introducido un número long");
			
			error = true;
			
		}
		
		finally {
			
			keyboard.nextLine();
			
		}
		
		} while (error == true);
		
		return num;
		
	}

	// Funciones para leer números comprendidos entre un rango.
	
	public static int readRange (int min, int max, Rangos ran) {
		
		int num=0;
		
		boolean error = false;
		
		if (min > max) {
			
			throw new IllegalArgumentException();    //Si el extremo máximo es menor que el mínimo, lanzar excepcion.
			
		}
		
		else if (min <= max) {
			
			do {
			
			try {
		
		switch (ran) {
		
		case AMBOSIN:					//Ambos extremos incluidos.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num < min || num > max);
		
			break;
			
		case AMBOSEX:						//Ambos extremos excluidos.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num <= min || num >= max);
		
			break;
			
		case MININMAXEX:					//Extremo inferior incluido y exterior incluido
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num < min || num >= max);
		
			break;
			
		case MINEXMAXIN:						//Extremo inferior incluido y exterior excluido.
			
			do {
			
			num = keyboard.nextInt();
			
			error = false;
			
			} while (num <= min || num > max);
		
			break;
		
		
		}
		
		
		//Se repite mientras no se cumpla el requisito.
		
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: no se introducido un número entero");
				
				error = true;						//Si no se introduce un número, o esta fuera del rango, se produce un error.
				
			}
			
			finally {
				
				keyboard.nextLine();
				
			}
		
		} while (error == true);						//Repetir mientras persiste el error.
			
		} 
		
		return num;
		
	}
	
	public static double readRange (double min, double max, Rangos ran) {
		
		double num=0;
		
		boolean error = false;
		
		if (min > max) {
			
			throw new IllegalArgumentException();
			
		}
		
		else if (min <= max) {
			
			do {
			
			try {
		
		switch (ran) {
		
		case AMBOSIN:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num < min || num > max);
		
			break;
			
		case AMBOSEX:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num <= min || num >= max);
		
			break;
			
		case MININMAXEX:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num < min || num >= max);
		
			break;
			
		case MINEXMAXIN:
			
			do {
			
			num = keyboard.nextDouble();
			
			error = false;
			
			} while (num <= min || num > max);
		
			break;
		
		
		}
		
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: no se introducido un número double");
				
				error = true;
				
			}
			
			finally {
				
				keyboard.nextLine();
				
			}
		
		} while (error == true);
			
		} 
		
		return num;
		
		
		
	}
	
	public static byte readRange (byte min, byte max, Rangos ran) {
		
		byte num=0;
		
		boolean error = false;
		
		if (min > max) {
			
			throw new IllegalArgumentException();
			
		}
		
		else if (min <= max) {
			
			do {
			
			try {
		
		switch (ran) {
		
		case AMBOSIN:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num < min || num > max);
		
			break;
			
		case AMBOSEX:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num <= min || num >= max);
		
			break;
			
		case MININMAXEX:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num < min || num >= max);
		
			break;
			
		case MINEXMAXIN:
			
			do {
			
			num = keyboard.nextByte();
			
			error = false;
			
			} while (num <= min || num > max);
		
			break;
		
		
		}
		
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: no se introducido un número byte");
				
				error = true;
				
			}
			
			finally {
				
				keyboard.nextLine();
				
			}
		
		} while (error == true);
			
		} 
		
		return num;
		
		
		
	}
	
	public static short readRange (short min, short max, Rangos ran) {
		
		short num=0;
		
		boolean error = false;
		
		if (min > max) {
			
			throw new IllegalArgumentException();
			
		}
		
		else if (min <= max) {
			
			do {
			
			try {
		
		switch (ran) {
		
		case AMBOSIN:
			
			do {
			
			num = keyboard.nextShort();
			
			error = false;
			
			} while (num < min || num > max);
		
			break;
			
		case AMBOSEX:
			
			do {
			
			num = keyboard.nextShort();
			
			error = false;
			
			} while (num <= min || num >= max);
		
			break;
			
		case MININMAXEX:
			
			do {
			
			num = keyboard.nextShort();
			
			error = false;
			
			} while (num < min || num >= max);
		
			break;
			
		case MINEXMAXIN:
			
			do {
			
			num = keyboard.nextShort();
			
			error = false;
			
			} while (num <= min || num > max);
		
			break;
		
		
		}
		
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: no se introducido un número short");
				
				error = true;
				
			}
			
			finally {
				
				keyboard.nextLine();
				
			}
		
		} while (error == true);
			
		} 
		
		return num;
		
		
		
	}
	
	public static float readRange (float min, float max, Rangos ran) {
		
		float num=0;
		
		boolean error = false;
		
		if (min > max) {
			
			throw new IllegalArgumentException();
			
		}
		
		else if (min <= max) {
			
			do {
			
			try {
		
		switch (ran) {
		
		case AMBOSIN:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num < min || num > max);
		
			break;
			
		case AMBOSEX:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num <= min || num >= max);
		
			break;
			
		case MININMAXEX:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num < min || num >= max);
		
			break;
			
		case MINEXMAXIN:
			
			do {
			
			num = keyboard.nextFloat();
			
			error = false;
			
			} while (num <= min || num > max);
		
			break;
		
		
		}
		
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: no se introducido un número float");
				
				error = true;
				
			}
			
			finally {
				
				keyboard.nextLine();
				
			}
		
		} while (error == true);
			
		} 
		
		return num;
		
		
		
	}
	
	public static long readRange (long min, long max, Rangos ran) {
		
		long num=0;
		
		boolean error = false;
		
		if (min > max) {
			
			throw new IllegalArgumentException();
			
		}
		
		else if (min <= max) {
			
			do {
			
			try {
		
		switch (ran) {
		
		case AMBOSIN:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num < min || num > max);
		
			break;
			
		case AMBOSEX:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num <= min || num >= max);
		
			break;
			
		case MININMAXEX:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num < min || num >= max);
		
			break;
			
		case MINEXMAXIN:
			
			do {
			
			num = keyboard.nextLong();
			
			error = false;
			
			} while (num <= min || num > max);
		
			break;
		
		
		}
		
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: no se introducido un número long");
				
				error = true;
				
			}
			
			finally {
				
				keyboard.nextLine();
				
			}
		
		} while (error == true);
			
		} 
		
		return num;
		
		
		
	}
}