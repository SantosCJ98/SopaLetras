package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static colores.Colores.*;

class insertar_test {

	
	String [][] sopa = { {"H", "o", "l", "a"},
	
						{"", "", "", ""},
						
						{"", "", "", ""},
				
						{"", "", "", ""}};
	
	String [][] sopa2 = { {"", "C", "", ""},
			
			{"", "o", "", ""},
			
			{"", "l", "", ""},
	
			{"", "a", "", ""}};
	
	
	String palabras [] = {"Hola", "Col", "Zoo"};
	
	@Test
	void test() {
		
		assertArrayEquals(espacios(sopa), insertar(espacios(sopa), 1, 1, Orientaciones.DCHA, "Hola"));
		
		assertArrayEquals(espacios(sopa2), insertar(espacios(sopa2), 1, 2, Orientaciones.ABAJO, "Cola"));
	
		
	}

}
