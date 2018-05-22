package projects;

import java.util.ArrayList;
/**
 *
 * @author AlonSoftware
 */
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Esta clase contabiliza las palabras diferentes del texto contenido en una
 * lista de cadenas
 */
public class CuentaPalabras {
	Map<String, Integer> mapaPalabras;
	List<String> texto;

	/**
	 * Inicializa la clase con el texto contenido en una lista de cadenas
	 * 
	 * @param texto
	 *            Lista de cadenas con el texto a procesar
	 */
	public CuentaPalabras(List<String> texto) {
		this.texto = texto;
		mapaPalabras = new TreeMap<String, Integer>();
	}

	/**
	 * Regresa las palabras contenidas en el texto y su cuenta
	 * 
	 * @return Las palabras contenidas en el texto y su cuenta
	 */
	public Map<String, Integer> getMapaPalabras() {
		return mapaPalabras;
	}

	/**
	 * Este método procesa las cadenas de la lista
	 */
	public void procesaTexto() {
		texto.forEach((linea) -> {
			procesaLinea(linea);
		});
	}

	/**
	 * Este método procesa una cadena encontrando la cuenta de cada palabra
	 * diferente
	 *
	 * @param linea
	 *            Cadena a procesar
	 *
	 */
	public void procesaLinea(String linea) {
		int pos1 = 0;
		int pos2;
		boolean continua = true;
		String palabra;
		// Mientras no se haya llegado al final de la cadena
		while (continua) {
			// Determina donde termina la palabra
			pos2 = linea.indexOf(' ', pos1);
			// Obtiene la palabra
			if (pos2 < 0) {
				palabra = linea.substring(pos1);
				continua = false;
			} else {
				palabra = linea.substring(pos1, pos2);
			}
			// Si la palabra es nueva
			if (!mapaPalabras.containsKey(palabra)) {
				mapaPalabras.put(palabra, 1);
			} // Si la palabra esta repetida
			else {
				int n = mapaPalabras.get(palabra);
				mapaPalabras.put(palabra, n + 1);
			}
			pos1 = pos2 + 1;
		}
	}

	public static void main(String[] args) {
		// se hará por línea de comando y con argumentos
		if (args.length > 0) {
			List<String> texto = new ArrayList<>();
			for (int i = 0; i < args.length; i++) {
				texto.add(args[i]);
			}
			CuentaPalabras co = new CuentaPalabras(texto);
			co.procesaTexto();
			Map<String, Integer> mapaPalabras = co.getMapaPalabras();
			System.out.println("Palabras encontradas: ");
			System.out.println(mapaPalabras);
		} else {
			System.out.println("error: sintaxis incorrecta");
			System.out.println("comando: cuentaPalabras [cadena de texto]");
		}
	}
}
