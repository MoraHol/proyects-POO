package ordenamiento;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Ordenamiento hecho por consola y con parámetros 
 * @author Alexis
 *
 */
public class TestConsole {
	static algoritmosOrdenamiento ord = new algoritmosOrdenamiento();
	static Archivos arc = new Archivos();
	static operaciones op = new operaciones();

	public static void main(String[] args) throws Exception {
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int option;
			if (args.length == 2) {
				System.out.println(
						"de que manera desea ordenar los numeros \n" + "1. Menor a Mayor \n" + "2. Mayor a Menor");
				option = scan.nextInt();
			} else {
				throw new Exception();
			}

			// esta linea debe ser cambiada por la ubicación de archivo numeros
			ArrayList<Integer> array = Archivos.cargarArchivo(args[0]);
			array = algoritmosOrdenamiento.quickSort(array);
			if (option == 1) {
				Archivos.escribirArchivoMenor(args[1], array);
			} else {
				Archivos.escribirArchivoMayor(args[1], array);
			}
			System.out.println("Se han organizado correctamente los números");
			System.out.println("la suma total de los numeros es:");
			System.out.println(op.sumaArray(array));
			System.out.println("numero que desea buscar:");
			int num = scan.nextInt();
			System.out.println(ord.busquedaBin1(array, num));
			System.out.println("el numero mas repetido es :");
			int[] numeroRepetido = operaciones.NumeroMasRepetido(array);
			System.out.println(numeroRepetido[0] + " se repitio " + numeroRepetido[1] + " veces");
		} catch (Exception e) {
			System.out.println("error: sintaxis incorrecta");
			System.out.println(
					"comando: ordenamieno [ruta de .txt a ordenar] [ruta de .txt donde almacenara los numeros ordenados]");
		}
	}
}
