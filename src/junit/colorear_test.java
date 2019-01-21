package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static colores.Colores.*;

class colorear_test {

	
	String [][] sopa = { {"H", "o", "l", "a"},
	
						{"", "", "", ""},
						
						{"", "", "", ""},
				
						{"", "", "", ""}};
	
	String [][] sopa2 = { {AMARILLO + "H" + RESET, AMARILLO + "o" + RESET, AMARILLO + "l" + RESET, AMARILLO + "a" + RESET},
			
			{"", "", "", ""},
			
			{"", "", "", ""},
	
			{"", "", "", ""}};

	
	@Test
	void test() {
		
		assertArrayEquals(sopa2, colorear(sopa, "Hola",  1, 1 , Orientaciones.DCHA));
		
	}

}
