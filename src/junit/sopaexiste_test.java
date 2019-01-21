package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static colores.Colores.*;

class sopaexiste_test {

	
	String [][] sopa = { {"", "", "", ""},
	
						{"", "", "", ""},
						
						{"", "", "", ""},
				
						{"", "", "", ""}};
	
	String [][] sopa2 = { {"", "", "", ""},
			
			{"", "", "", ""},
			
			{"", "", "", ""},
	
			{"", "", "", "S"}};
	
	

	
	
	@Test
	void test() {
		
		
		assertTrue(sopaexiste(rellenar(sopa)));
		
		assertFalse(sopaexiste(sopa2));
	
		
	}

}
