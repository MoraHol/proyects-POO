package gui;
import java.util.ArrayList;
import java.util.Random;

public class lab {
	public lab(int rows,int col) {
		Recorridos = new ArrayList<>();
		maze = new int[rows][col];
		maze = fillMAze(maze);
		while (!findPathFrom1(1, 1, clone(maze))) {
			maze = fillMAze(maze);
		}
		findPathFrom(1, 1, clone(maze));
	}
	public int[][] getMaze(){
		return maze;
	}
	public ArrayList<int[][]> getRecorridos(){
		return Recorridos;
	}
	/**
	 * Main class of the Java program. This code allows you to solve a maze
	 * recursively using backtracking algorithm.
	 * 
	 */
	// 0 - obstacle
	// 1 - open space
	// 2 - path taken
	// 3 - goal
	private int[][] maze;
	private ArrayList<int[][]> Recorridos;
	static int[][] fillMAze(int[][] maze) {
		maze = new int[maze.length][maze[0].length];
		Random rd = new Random();
		int vecino = -1;
		for (int i = 0; i < maze[0].length; i++) {
			maze[0][i] = 1;
			maze[maze.length - 1][i] = 1;

		}
		for (int i = 0; i < maze.length; i++) {
			maze[i][0] = 1;
			maze[i][maze[0].length - 1] = 1;
		}
		for (int i = 1; i < maze.length; i++) {
			for (int j = 1; j < maze[i].length; j++) {
				if (i % 2 != 0 && j % 2 != 0) {
					if (rd.nextInt(10) > 0) {
						maze[i][j] = 1;
						vecino = rd.nextInt(4);
					}
				}
				switch (vecino) {
				case 0:
					if (i != maze.length - 1) {
						maze[i + 1][j] = 1;
					}
					break;
				case 1:
					if (j != maze[i].length - 1) {
						maze[i][j + 1] = 1;
					}
					break;
				case 2:
					if (i != 0)
						maze[i - 1][j] = 1;
					break;
				case 3:
					if (j != 0)
						maze[i][j - 1] = 1;
					break;

				}
				vecino = -1;

			}
		}
		maze[1][1] = 2;
		maze[maze.length - 2][maze[maze.length - 2].length - 2] = 3;
		return maze;
	}

	// Try to findPathFrom initial position if the maze is solved print the solution
	/*public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * if (findPathFrom(1, 0)) { print(); } else {
		 * System.out.println("no solution found"); }
		 */
		// maze = RandomFillMaze(maze, 10);
		/*Recorridos = new ArrayList<>();
		maze = new int[15][15];
		maze = fillMAze(maze);
		while (!findPathFrom1(1, 1, clone(maze))) {
			maze = fillMAze(maze);
		}
		print(maze);
		System.out.println(findPathFrom(1, 1, maze));
		print(maze);
		System.out.println(Recorridos.size());
		if (scan.nextInt() == 1) {
			for (int i = 0; i < Recorridos.size(); i++) {
				print(Recorridos.get(i));
			}
		}

	}*/

	private boolean findPathFrom1(int row, int col, int[][] maze) {

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
		if (isAvailablePosition(row - 1, col, maze) && findPathFrom1(row - 1, col, maze)) {
			return true;
		}
		if (isAvailablePosition(row + 1, col, maze) && findPathFrom1(row + 1, col, maze)) {
			return true;
		}
		if (isAvailablePosition(row, col - 1, maze) && findPathFrom1(row, col - 1, maze)) {
			return true;
		}
		if (isAvailablePosition(row, col + 1, maze) && findPathFrom1(row, col + 1, maze)) {
			return true;
		}

		// If none of previous positions is valid or matches the goal, it is necessary
		// to revert the
		// temporary state. This reversal or backtrack is what gives name to the
		// algorithm: backtracking
		maze[row][col] = 0;

		return false;
	}

	private boolean findPathFrom(int row, int col, int[][] maze) {

		// when we reach the goal we have solved the problem
		if (maze[row][col] == 3) {
			return true;
		}
		// add the position to our path changing its value to '2'
		maze[row][col] = 2;
		//print(maze);
		Recorridos.add(clone(maze));

		// try all available neighbours
		// North (row-1, col), South (row+1, col), East (row, col+1) and West (row,
		// col-1)
		// if any of these return true then we have solved the problem
		if (isAvailablePosition(row - 1, col, maze) && findPathFrom(row - 1, col, maze)) {
			return true;
		}
		if (isAvailablePosition(row + 1, col, maze) && findPathFrom(row + 1, col, maze)) {
			return true;
		}
		if (isAvailablePosition(row, col - 1, maze) && findPathFrom(row, col - 1, maze)) {
			return true;
		}
		if (isAvailablePosition(row, col + 1, maze) && findPathFrom(row, col + 1, maze)) {
			return true;
		}

		// If none of previous positions is valid or matches the goal, it is necessary
		// to revert the
		// temporary state. This reversal or backtrack is what gives name to the
		// algorithm: backtracking
		maze[row][col] = 0;

		return false;
	}

	// A position is available if: (1) it is inside the bounds of the maze
	// (2) if it is an open space or (3) it is the goal
	private boolean isAvailablePosition(int row, int col, int[][] maze) {
		boolean result = row >= 0 && row < maze.length && col >= 0 && col < maze[row].length
				&& (maze[row][col] == 0 || maze[row][col] == 3);
		return result;
	}

	private int[][] clone(int[][] matriz) {
		int[][] clon = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			clon[i] = matriz[i].clone();
		}
		return clon;
	}

}
