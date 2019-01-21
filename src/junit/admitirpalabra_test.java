package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static colores.Colores.*;

class admitirpalabra_test {

	
	String [][] sopa = new String [4][4];
	
	
	String palabras [] = {"Hola", "Cola", "Zoológico", "H la"};
	
	@Test
	void test() {
		
		assertTrue(admitirpalabra(espacios(sopa), 1, 4, Orientaciones.ABAJOIZQ, palabras[0]));
		
		assertTrue(admitirpalabra(espacios(sopa), 4, 4, Orientaciones.ARRIBAIZQ, palabras[0]));
		
		assertTrue(admitirpalabra(espacios(sopa), 2, 4, Orientaciones.IZQ, palabras[1]));
		
		assertTrue(admitirpalabra(espacios(sopa), 4, 1, Orientaciones.ARRIBADCHA, palabras[0]));
		
		assertFalse(admitirpalabra(espacios(sopa), 4, 4, Orientaciones.DCHA, palabras[0]));
		
		assertFalse(admitirpalabra(espacios(sopa), 4, 4, Orientaciones.ARRIBAIZQ, palabras[2]));
		
		assertFalse(admitirpalabra(espacios(sopa), 1, 1, Orientaciones.ABAJO, palabras[2]));
		
		assertFalse(admitirpalabra(espacios(sopa), 1, 1, Orientaciones.ABAJO, palabras[3]));
		
	}

}
