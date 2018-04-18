package alternativas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Alternativas {
	static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	// instancia de objetos
	static Fill fl = new Fill();
	static Reglas rl = new Reglas(board);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Random rd = new Random();

	public static void InicioTurno(int turno) throws NumberFormatException, IOException {
		if (turno == 0) { // juega primero la maquina
			int i = rd.nextInt(3);
			int j = rd.nextInt(3);
			board[i][j] = 'O';
		} else {
			System.out.println("Empiezas tu:");
			PrintMatrix(board);
			PreguntaPosicion(board);
		}
	}

	public static char[][] PreguntaPosicion(char[][] tablero) throws NumberFormatException, IOException {
		int i, j;
		System.out.print("eliga la fila en donde quiere jugar:");
		i = (Integer.parseInt(br.readLine())) - 1;
		System.out.print("eliga la columna en donde quiere jugar:");
		j = (Integer.parseInt(br.readLine())) - 1;
		System.out.println();
		tablero = Fill.fillMatrixUser(tablero, i, j);
		return tablero;
	}

	public static void PrintMatrix(char[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + " |");
			}
			System.out.println();
		}
	}

	public static void Juego(int inicio) throws NumberFormatException, IOException {
		if (inicio == 1) {
			fl.fillMachine(board);
		}
		boolean m = false;
		PrintMatrix(board);
		while (m == false) {
			if (rl.GanadorMachine(board) == false && rl.GanadorUser(board) == false && rl.Empate(board) == false) {
				PreguntaPosicion(board);
				if (rl.contador != 8) {
					board = fl.fillMachine(board);
				}
				PrintMatrix(board);
			} else if (rl.GanadorUser(board) == true) {
				m = true;
				System.out.println("el jugador ha ganado");
				return;
			} else if (rl.GanadorMachine(board) == true) {
				m = true;
				System.out.println("has perdido");
				return;
			} else {
				m = true;
				System.out.println("hay empate");
				return;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int inicio = rd.nextInt(2);
		InicioTurno(inicio);
		Juego(inicio);

	}

}
