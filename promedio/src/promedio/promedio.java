package promedio;
/**
 * @since 21/05/2018
 * @author Alexis Holguin
 */
public class promedio {

	public static void main(String[] args) {
		try {
			int[] numeros = new int[args.length];
			System.out.println("la suma de los numeros ingresados es:" + suma(numeros) / numeros.length);
		} catch (Exception e) {
			System.out.println("error: sintaxis incorrecta");
			System.out.println("el comando es: promedio [numeros a sacar promedio separados por un espacio]");
		}
	}

	private static int suma(int[] numero) {
		int sum = 0;
		for (int i = 0; i < numero.length; i++) {
			sum += numero[i];
		}
		return sum;
	}
}
