package ordenamiento;


import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Alexis Holguin
 *
 */
public class test {
	static algoritmosOrdenamiento ord = new algoritmosOrdenamiento();
	static Archivos arc = new Archivos();
	static operaciones op = new operaciones();
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("de que manera desea ordenar los numeros \n" + "1. Menor a Mayor \n" + "2. Mayor a Menor");
		int option = scan.nextInt();
		// esta linea debe ser cambiada por la ubicación de archivo numeros
		ArrayList<Integer> array = Archivos.cargarArchivo("C:\\Users\\Alexis\\Desktop\\numeros.txt");
		array = algoritmosOrdenamiento.quickSort(array);
		if (option == 1) {
			Archivos.escribirArchivoMenor("src/ordenamiento/test.txt", array);
		}else {
			Archivos.escribirArchivoMayor("src/ordenamiento/test.txt", array);
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
	}
	
	

	
}
