package alternativas;

public class Reglas {
	char[][] board;

	public Reglas(char[][] tablero) {
		this.board = tablero;
	}

	public boolean GanadorMachine(char[][] tablero) {
		if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
			return true;
		} else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
			return true;
		} else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
			return true;
		} else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
			return true;
		} else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
			return true;
		} else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
			return true;
		} else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
			return true;
		} else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
			return true;
		} else {
			return false;
		}
	}

	public boolean GanadorUser(char[][] tablero) {
		if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
			return true;
		} else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
			return true;
		} else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
			return true;
		} else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
			return true;
		} else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
			return true;
		} else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
			return true;
		} else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
			return true;
		} else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
			return true;
		} else {
			return false;
		}
	}

	public boolean Empate(char[][] tablero) {
		boolean aux= false,temp = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tablero[i][j] == 'O' || tablero[i][j] == 'X') {
					aux = true;
				}else {
					aux=false;
				}
				temp = aux && aux;
			}
		}
		return temp;
	}
}
