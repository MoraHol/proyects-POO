package alternativas;

import java.io.IOException;
import java.util.Random;

public class Fill {

	// instancia de objeto
	static Alternativas al = new Alternativas();
	static Random rd = new Random();

	public static char[][] fillMatrixUser(char[][] tablero, int i, int j) throws NumberFormatException, IOException {
		if (tablero[i][j] == ' ') {
			tablero[i][j] = 'X';
		} else {
			System.out.println("este lugar ya esta ocupado");
			Alternativas.PreguntaPosicion(tablero);
		}

		return tablero;
	}

	public char[][] fillMachine(char[][] tablero) {
		int i, j;
		i = rd.nextInt(3);
		j = rd.nextInt(3);
		if (tablero[i][j] == ' ') {
			tablero[i][j] = 'O';
		} else {
			fillMachine(tablero);
		}
		return tablero;

	}
}
