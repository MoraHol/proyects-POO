package ordenamiento;

import java.util.ArrayList;

public class algoritmosOrdenamiento {

	public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {
		ArrayList<Integer> array1 = new ArrayList<>();
		ArrayList<Integer> less_subarray = new ArrayList<>();
		ArrayList<Integer> greater_subarray = new ArrayList<Integer>();

		if (array.size() == 0) {
			// el arreglo esta ordenado
			return array;
		} else {
			// tomar el primer elemento como pivote
			int pivot = array.get(0);
			for (int i = 1; i < array.size(); i++) {
				if (array.get(i) < pivot) {
					less_subarray.add(array.get(i));
				} else {
					greater_subarray.add(array.get(i));
				}
			}

			less_subarray = quickSort(less_subarray);
			greater_subarray = quickSort(greater_subarray);

			if (less_subarray.size() < 1 && greater_subarray.size() < 1) {
				array1.add(pivot);
			} else {
				if (less_subarray.size() < 1) {
					array1.add(pivot);
					for (int i = 0; i < greater_subarray.size(); i++) {
						array1.add(greater_subarray.get(i));
					}
				} else {
					if (greater_subarray.size() < 1) {
						for (int i = 0; i < less_subarray.size(); i++) {
							array1.add(less_subarray.get(i));
						}
						array1.add(pivot);
					} else {
						for (int i = 0; i < less_subarray.size(); i++) {
							array1.add(less_subarray.get(i));
						}
						array1.add(pivot);
						for (int i = 0; i < greater_subarray.size(); i++) {
							array1.add(greater_subarray.get(i));
						}
					}
				}
			}

		}
		return array1;
	}

	// Ordenamiento por intercambio para un array
	public ArrayList<Integer> ordIntercambioArray(ArrayList<Integer> array) {
		int aux;
		for (int i = 0; i < array.size() - 1; i++) {
			for (int j = 0; j < array.size() - i - 1; j++) {
				if (array.get(j + 1) < array.get(j)) {
					aux = array.get(j + 1);
					array.set(j + 1, array.get(j));
					array.set(j, aux);
				}
			}
		}
		return array;
	}

	// Ordenación por selección
	public ArrayList<Integer> ordSeleccionArray(ArrayList<Integer> array) {
		int indiceMenor, aux;
		for (int col = 0; col < array.size() - 1; col++) {
			indiceMenor = col;
			for (int sCol = col + 1; sCol < array.size(); sCol++) {
				if (array.get(sCol) < array.get(indiceMenor)) {
					indiceMenor = sCol;
				}
			}
			if (col != indiceMenor) {
				aux = array.get(col);
				array.set(col, array.get(indiceMenor));
				array.set(indiceMenor, aux);
			}
		}
		return array;
	}

	// Ordenamiento por Inserción

	public ArrayList<Integer> ordInsercionArray(ArrayList<Integer> array) {
		int aux, j;
		for (int i = 1; i < array.size(); i++) {
			j = i;
			aux = array.get(i);
			while (j > 0 && aux < array.get(j - 1)) {
				array.set(j, array.get(j - 1));
				j--;
			}
			array.set(j, aux);
		}
		return array;
	}

	// Ordenamiento por Burbuja modificado
	public ArrayList<Integer> ordBurbujaModificadoArray(ArrayList<Integer> array) {
		int i = array.size() - 1, indiceIntercambio, aux;
		while (i > 0) {
			indiceIntercambio = 0;
			for (int j = 0; j < i; j++) {
				if (array.get(j + 1) < array.get(j)) {
					aux = array.get(j);
					array.set(j, array.get(j + 1));
					array.set(j + 1, aux);
					indiceIntercambio = j;
				}
			}
			i = indiceIntercambio;
		}
		return array;
	}

	// Ordenamiento Shell
	public ArrayList<Integer> ordShellArray(ArrayList<Integer> array) {
		int intervalo = array.size() / 2, j, k, temp;
		while (intervalo > 0) {
			for (int i = intervalo; i < array.size(); i++) {
				j = i - intervalo;
				while (j >= 0) {
					k = j + intervalo;
					if (array.get(j) <= array.get(k)) {
						j = -1;
					} else {
						temp = array.get(j);
						array.set(j, array.get(k));
						array.set(k, temp);
						j -= intervalo;
					}
				}
			}
			intervalo = intervalo / 2;
		}
		return array;
	}

	public int busquedaBin1(ArrayList<Integer> array, int clave){
        int valorCentral, central, bajo = 0, alto = array.size()-1,sum = 1;
        while (bajo <= alto){
            central = (bajo + alto) / 2;
            valorCentral = array.get(central);
            if (clave == valorCentral) {
                 sum++;
                 if (clave <= valorCentral) {
                     alto = central -1;
                 }else{
                     bajo = central +1;
                 }
            }else{
                if (clave <= valorCentral) {
                    alto = central -1;
                }else{
                    bajo = central +1;
                }
            }
        }
        return sum;
    }

}
