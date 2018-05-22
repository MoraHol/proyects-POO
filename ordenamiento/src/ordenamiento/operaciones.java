package ordenamiento;

import java.util.ArrayList;

public class operaciones {
	static algoritmosOrdenamiento ord = new algoritmosOrdenamiento();

	public long sumaArray(ArrayList<Integer> array) {
		long sum = 0;
		for (int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}

		return sum;
	}

	public static int[] NumeroMasRepetido(ArrayList<Integer> array) {
		int count = 0, aux = 0, posicion = 0;
		int[] valores = new int[2];
		for (int i = 0; i < array.size(); i++) {
			count = ord.busquedaBin1(array, array.get(i));
			if (aux < count) {
				aux = count;
				posicion = i;
			}
			count = 0;
		}
		valores[0] = array.get(posicion);
		valores[1] = aux;
		return valores;
	}
}
