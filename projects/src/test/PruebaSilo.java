
package test;

import silo1.Silo;
import silo1.SiloCilindro;
import silo1.SiloCono;
import silo1.SiloEsfera;

/**
 * Esta clase se utiliza para probar las clases SiloCilindro, SiloCono y
 * SiloEsfera
 *
 * @author
 */
public class PruebaSilo {

	/**
	 * Método main() en el que se invocan a los métodos de las clases
	 * SiloCilindro, SiloCono y SiloEsfera para probarlos
	 *
	 * @param args
	 *            Los argumentos en la línea de comando
	 */
	public static void main(String[] args) {
		new PruebaSilo();
		Silo silo[] = new Silo[5];
		// Crea 5 silos de diferente tipo
		silo[0] = new SiloCilindro(1.0, 1.0);
		silo[1] = new SiloEsfera(1.0);
		silo[2] = new SiloCono(1.0, 1.0);
		silo[3] = new SiloCilindro(2.0, 1.0);
		silo[4] = new SiloCilindro(1.0, 2.0);
		// Para cada silo
		for (int i = 0; i < 5; i++) {
			// Calcula la superficie del silo
			silo[i].calculaSuperficie();
			// Calcula el volumen del silo
			silo[i].calculaVolumen();
		}
		// Para cada silo
		for (int i = 0; i < 5; i++) // Escribe los valores de sus atributos
		{
			System.out.println(silo[i]);
		}
	}
}
