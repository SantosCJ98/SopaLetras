package junit;

import static funciones.funciones.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static colores.Colores.*;

class espacios_test {

	
	String [][] sopa = { {"", "", "", ""},
	
						{"", "", "", ""},
						
						{"", "", "", ""},
				
						{"", "", "", ""}};
	
	String [][] sopa2 = { {null, null, null, null},
			
			{null, null, null, null},
			
			{null, null, null, null},
	
			{null, null, null, null}};
	
	
	@Test
	void test() {
		
		assertArrayEquals(espacios(sopa), sopa);
		
		assertArrayEquals(espacios(sopa2), sopa2);
	
		
	}

}
