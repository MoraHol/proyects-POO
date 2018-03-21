package alternativas;

public class Inteligencia {
	char[][] board;

	public Inteligencia(char[][] tablero) {
		this.board = tablero;
	}

	public boolean CerrarJugador() {
		boolean y = false;
		if (board[0][0] == 'X' && board[0][1] == 'X' || board[0][0] == 'X' && board[0][2] == 'X'
				|| board[0][1] == 'X' && board[0][2] == 'X') {
			for (int i = 0; i < 3; i++) {
				if (board[0][i] == ' ') {
					board[0][i] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;
		} else if (board[1][0] == 'X' && board[1][1] == 'X' || board[1][0] == 'X' && board[1][2] == 'X'
				|| board[1][1] == 'X' && board[1][2] == 'X') {
			for (int i = 0; i < 3; i++) {
				if (board[1][i] == ' ') {
					board[1][i] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;

		} else if (board[2][0] == 'X' && board[2][1] == 'X' || board[2][0] == 'X' && board[2][2] == 'X'
				|| board[2][1] == 'X' && board[2][2] == 'X') {
			for (int i = 0; i < 3; i++) {
				if (board[2][i] == ' ') {
					board[2][i] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;

		} else if (board[0][0] == 'X' && board[1][0] == 'X' || board[0][0] == 'X' && board[2][0] == 'X'
				|| board[1][0] == 'X' && board[2][0] == 'X') {
			for (int i = 0; i < 3; i++) {
				if (board[i][0] == ' ') {
					board[i][0] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;

		} else if (board[0][1] == 'X' && board[1][1] == 'X' || board[0][1] == 'X' && board[2][1] == 'X'
				|| board[1][1] == 'X' && board[2][1] == 'X') {
			for (int i = 0; i < 3; i++) {
				if (board[i][1] == ' ') {
					board[i][1] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;
		} else if (board[0][2] == 'X' && board[1][2] == 'X' || board[0][2] == 'X' && board[2][2] == 'X'
				|| board[1][2] == 'X' && board[2][2] == 'X') {
			for (int i = 0; i < 3; i++) {
				if (board[i][2] == ' ') {
					board[i][2] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;
		/*} /*else if (board[0][2] == 'X' && board[1][1] == 'X' || board[0][2] == 'X' && board[2][0] == 'X'
				|| board[2][0] == 'X' && board[1][1] == 'X') {
			for (int x = 0; x < 3; x++) {
				int j = 2, i = 0;
				if (board[i + 1][j - 1] == ' ') {
					board[i][j] = 'O';
					y = true;
				} else {
					y = false;
				}
			}
			return y;*/
		} else {
			return false;
		}

	}
}
