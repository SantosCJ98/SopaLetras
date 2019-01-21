package colores;
import static colores.Colores.*;

public class UsoColores {

	public static void main(String[] args) {
		
		System.out.println(ROJO + "Este texto es de color rojo");
		System.out.println(RESET + "Volvemos al color por defecto");
		System.out.println(VERDE + "...y ahora es verde");
		System.out.println(FONDO_MORADO + "Fondo morado");
		System.out.println(CELESTE + FONDO_BLANCO + "Fondo blanco con texto celeste");
		System.out.println(CELESTE + FONDO_BLANCO + NEGRITA + "Fondo blanco con texto celeste en negrita");
		System.out.println(CELESTE + FONDO_BLANCO + SUBRAYADO + "Fondo blanco con texto celeste subrayado");
		System.out.printf("%s",AMARILLO + FONDO_ROJO + (char)9733);//Estrella
		
	}
}
