package ordenamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos {

	public static ArrayList<Integer> cargarArchivo(String archivo) throws Exception {
		ArrayList<Integer> numeros = new ArrayList<>();
		String texto = "";
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		do {
			texto = lector.readLine();
			// System.out.println(texto);
			if (texto != null) {
				numeros.add(Integer.parseInt(texto));
			}
		} while (texto != null);
		lector.close();
		return numeros;
	}

	public static void escribirArchivoMenor(String archivo, ArrayList<Integer> array) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		for (int i = 0; i < array.size(); i++) {
			bw.write(array.get(i) + " \n");
		}
		bw.close();
	}

	public static void escribirArchivoMayor(String archivo, ArrayList<Integer> array) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		for (int i = array.size() - 1; i >= 0; i--) {
			bw.write(array.get(i) + " \n");
		}
		bw.close();
	}

}
