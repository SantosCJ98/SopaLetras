package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class contarpalabrasvalidas_test {
	
	String [] palabras = {"Hola", "Pepe", "invalido"};

	@Test
	void test() {
		
		assertEquals(2, contarpalabrasvalidas(palabras));
		
	}

}
