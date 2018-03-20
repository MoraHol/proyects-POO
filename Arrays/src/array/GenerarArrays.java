package array;

import java.util.Random;

public class GenerarArrays {
	Random rd = new Random();

	private int[] generarArray(int[] array) {
		int tama�o = rd.nextInt(10);
		array = new int[tama�o];
		for (int i = 0; i < tama�o; i++) {
			array[i] = rd.nextInt(10) + 1;
		}
		return array;
	}

	private char[] generarArray(char[] array) {
		int tama�o = rd.nextInt(10);
		array = new char[tama�o];
		for (int i = 0; i < tama�o; i++) {
			array[i] = rd.nextInt(1) == 1 ? 'a' : 'b';
		}
		return array;
	}

	private double[] generarArray(double[] array) {
		int tama�o = rd.nextInt(10);
		array = new double[tama�o];
		for (int i = 0; i < tama�o; i++) {
			array[i] = rd.nextInt(10) + rd.nextDouble();
		}
		return array;
	}

	private boolean[] generarArray(boolean[] array) {
		int tama�o = rd.nextInt(10);
		array = new boolean[tama�o];
		for (int i = 0; i < tama�o; i++) {
			array[i] = rd.nextInt(1) == 1 ? true : false;
		}
		return array;
	}

	private String[] generarArray(String[] array) {
		int tama�o = rd.nextInt(10);
		array = new String[tama�o];
		for (int i = 0; i < tama�o; i++) {
			array[i] = rd.nextInt(1) == 1 ? "adasdf" : "iyyuuhr";
		}
		return array;
	}

	private void PrintArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 2)
				System.out.print(array[i]);
			else
				System.out.println(array[i] + ",");
		}
		System.out.print("]");
	}
	private void PrintArray(char[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 2)
				System.out.print(array[i]);
			else
				System.out.println(array[i] + ",");
		}
		System.out.print("]");
	}
	private void PrintArray(double[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 2)
				System.out.print(array[i]);
			else
				System.out.println(array[i] + ",");
		}
		System.out.print("]");
	}
	private void PrintArray(boolean[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 2)
				System.out.print(array[i]);
			else
				System.out.println(array[i] + ",");
		}
		System.out.print("]");
	}
	private void PrintArray(String[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 2)
				System.out.print(array[i]);
			else
				System.out.println(array[i] + ",");
		}
		System.out.print("]");
	}
}
