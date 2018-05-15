import java.util.Random;

public class lab {
	/**
	 * Main class of the Java program. This code allows you to solve a maze
	 * recursively using backtracking algorithm.
	 * 
	 */
	// 0 - obstacle
	// 1 - open space
	// 2 - path taken
	// 3 - goal
	private static int[][] maze = { { 0, 0, 1, 1, 1, 1, 1, 1 }, { 2, 0, 1, 0, 0, 0, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0 },
			{ 1, 1, 1, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1, 1, 1, 1 }, { 0, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 0, 3 }, { 1, 1, 1, 0, 1, 1, 0, 0 } };
	// use symbols to make reading the output easier...
	// 0 - obstacle - '#'
	// 1 - open space - '.'
	// 2 - path taken - '+'
	// 3 - goal - '*'
	private static final char[] MAZE_SYMBOLS = { '#', '.', '+', '*' };

	private static int[][] RandomFillMaze(int[][] maze, int n) {
		Random rd = new Random();
		maze = new int[n][n];
		maze[0][0] = 2;
		maze[n - 1][n - 1] = 3;
		int[] posicion = new int[2];
		while (true) {

			switch (rd.nextInt(4)) {
			case 0:
				if (posicion[0] != 0) {
					if (maze[posicion[0] - 1][posicion[1]] != 2) {
						if (VerificarFinal(maze, posicion, n)) {
							return maze;
						}
						if (verificarBucle1(maze, n, posicion)) {
							maze = verificarBucle(maze, n, posicion);
						} else {
							maze[posicion[0] - 1][posicion[1]] = 1;
							posicion[0] = posicion[0] - 1;
						}
					}

				}
				break;
			case 1:
				if (posicion[0] != n - 1) {
					if (maze[posicion[0] + 1][posicion[1]] != 2) {
						if (VerificarFinal(maze, posicion, n)) {
							return maze;
						}
						if (verificarBucle1(maze, n, posicion)) {
							maze = verificarBucle(maze, n, posicion);
						} else {
							maze[posicion[0] + 1][posicion[1]] = 1;
							posicion[0] = posicion[0] + 1;
						}
					}
				}
				break;
			case 2:
				if (posicion[1] != 0) {
					if (maze[posicion[0]][posicion[1] - 1] != 2) {
						if (VerificarFinal(maze, posicion, n)) {
							return maze;
						}
						if (verificarBucle1(maze, n, posicion)) {
							maze = verificarBucle(maze, n, posicion);
						} else {
							maze[posicion[0]][posicion[1] - 1] = 1;
							posicion[1] = posicion[1] - 1;
						}
					}

				}
				break;
			case 3:
				if (posicion[1] != n - 1) {
					if (maze[posicion[0]][posicion[1] + 1] != 2) {
						if (VerificarFinal(maze, posicion, n)) {
							return maze;
						}
						if (verificarBucle1(maze, n, posicion)) {
							maze = verificarBucle(maze, n, posicion);
						} else {
							maze[posicion[0]][posicion[1] + 1] = 1;
							posicion[1] = posicion[1] + 1;
						}
					}

				}
				break;
			}
			print(maze);
			System.out.println();
		}

	}

	static boolean verificarBucle1(int[][] maze, int n, int[] posicion) {
		boolean[] aux = new boolean[4];
		if (posicion[1] != 0) {
			if (maze[posicion[0]][posicion[1] - 1] == 1) {
				aux[0] = true;
			}
		}
		if (posicion[1] != n - 1) {
			if (maze[posicion[0]][posicion[1] + 1] == 1) {
				aux[1] = true;
			}
		}
		if (posicion[0] != n - 1) {
			if (maze[posicion[0] + 1][posicion[1]] == 1) {
				aux[2] = true;
			}
		}
		if (posicion[0] != 0) {
			if (maze[posicion[0] - 1][posicion[1]] == 1) {
				aux[3] = true;
			}
		}

		return aux[0] && aux[1] && aux[2] && aux[3];
	}

	static int[][] verificarBucle(int[][] maze, int n, int[] posicion) {
		for (int i = 1; i < n; i++) {
			if (posicion[1] != 0 && posicion[1] - i > 0) {
				if (maze[posicion[0]][posicion[1] - i] != 1 && maze[posicion[0]][posicion[1] - i] >= 0) {
					posicion[1] = posicion[1] - i;
					return maze;
				}
			}
			if (posicion[1] != n - 1 && posicion[1] + i < n - 1) {
				if (maze[posicion[0]][posicion[1] + i] != 1 && maze[posicion[0]][posicion[1] + i] >= 0) {
					posicion[1] = posicion[1] + i;
					return maze;
				}
			}
			if (posicion[0] != n - 1 && posicion[0] + i < n - 1) {
				if (maze[posicion[0] + i][posicion[1]] != 1 && maze[posicion[0] + i][posicion[1]] >= 0) {
					posicion[0] = posicion[0] + i;
					return maze;
				}
			}
			if (posicion[0] != 0 && posicion[0] - i > 0) {
				if (maze[posicion[0] - i][posicion[1]] != 1 && maze[posicion[0] - i][posicion[1]] > 0) {
					posicion[0] = posicion[1] - i;
					return maze;
				}
			}
		}

		return maze;
	}

	static boolean VerificarFinal(int[][] maze, int[] posicion, int n) {
		if (posicion[1] != 0) {
			if (maze[posicion[0]][posicion[1] - 1] == 3) {
				return true;
			}
		}
		if (posicion[1] != n - 1) {
			if (maze[posicion[0]][posicion[1] + 1] == 3) {
				return true;
			}
		}
		if (posicion[0] != n - 1) {
			if (maze[posicion[0] + 1][posicion[1]] == 3) {
				return true;
			}
		}
		if (posicion[0] != 0) {
			if (maze[posicion[0] - 1][posicion[1]] == 3) {
				return true;
			}
		}
		return false;
	}

	// Try to findPathFrom initial position if the maze is solved print the solution
	public static void main(String[] args) {
		/*
		 * if (findPathFrom(1, 0)) { print(); } else {
		 * System.out.println("no solution found"); }
		 */
		maze = RandomFillMaze(maze, 10);
		print(maze);
	}

	private static boolean findPathFrom(int row, int col) {

		// when we reach the goal we have solved the problem
		if (maze[row][col] == 3) {
			return true;
		}

		// add the position to our path changing its value to '2'
		maze[row][col] = 2;

		// try all available neighbours
		// North (row-1, col), South (row+1, col), East (row, col+1) and West (row,
		// col-1)
		// if any of these return true then we have solved the problem
		if (isAvailablePosition(row - 1, col) && findPathFrom(row - 1, col)) {
			return true;
		}
		if (isAvailablePosition(row + 1, col) && findPathFrom(row + 1, col)) {
			return true;
		}
		if (isAvailablePosition(row, col - 1) && findPathFrom(row, col - 1)) {
			return true;
		}
		if (isAvailablePosition(row, col + 1) && findPathFrom(row, col + 1)) {
			return true;
		}

		// If none of previous positions is valid or matches the goal, it is necessary
		// to revert the
		// temporary state. This reversal or backtrack is what gives name to the
		// algorithm: backtracking
		maze[row][col] = 1;

		return false;
	}

	// A position is available if: (1) it is inside the bounds of the maze
	// (2) if it is an open space or (3) it is the goal
	private static boolean isAvailablePosition(int row, int col) {
		boolean result = row >= 0 && row < maze.length && col >= 0 && col < maze[row].length
				&& (maze[row][col] == 1 || maze[row][col] == 3);
		return result;
	}

	// print the output using MAZE_SYMBOLS
	private static void print(int[][] maze) {
		for (int row = 0; row < maze.length; ++row) {
			for (int col = 0; col < maze[row].length; ++col) {
				System.out.print(MAZE_SYMBOLS[maze[row][col]]);
			}
			System.out.println();
		}
	}

}
