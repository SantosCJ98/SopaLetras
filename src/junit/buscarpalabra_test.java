package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static colores.Colores.*;

class buscarpalabra_test {

	
	String [][] sopa = { {"H", "o", "l", "a"},
	
						{"q", "l", "o", "C"},
						
						{"w", "w", "o", "w"},
				
						{"w", "w", "Z", "w"}};
	
	
	String palabras [] = {"Hola", "Col", "Zoo"};
	
	@Test
	void test() {
		
		assertTrue(buscarpalabra(sopa, "Col", 2, 4, Orientaciones.IZQ));
		
		assertTrue(buscarpalabra(sopa, "Hola", 1, 1, Orientaciones.DCHA));
		
		assertTrue(buscarpalabra(sopa, "Zoo", 4, 3, Orientaciones.ARRIBA));
		
		assertFalse(buscarpalabra(sopa, "Zoo", 4, 3, Orientaciones.IZQ));
		
	}

}
