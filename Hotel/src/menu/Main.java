package menu;

import java.io.IOException;

import habitaciones.Habitacion;
import personas.Persona;

public class Main {
	public Habitacion[] hb = new Habitacion[20];
	Persona[] pr = new Persona[200];
	static int posicion = 0;
	static Menu mu = new Menu();
	public static void main(String[]args) throws NumberFormatException, IOException {
		
		mu.inicializar();
		do {
			mu.Parameters(mu.mostar());
		} while (mu.exit);
	}
}
