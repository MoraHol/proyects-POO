
package test;

import projects.Costos;
import projects.ISilo;
import silo3.Silo3;
import silo3.SiloCilindro3;
import silo3.SiloCono3;
import silo3.SiloEsfera3;

/**
 * Esta clase se utiliza para probar las clases SiloCilindro3, SiloCono3 y
 * SiloEsfera3
 *
 * @author
 */
public class PruebaSilo3 {

	/**
	 * Método main() en el que se invocan a los métodos de las clases SiloCilindro3,
	 * SiloCono3 y SiloEsfera3 para probarlos
	 *
	 * @param args
	 *            Los argumentos en la línea de comando
	 */
	public static void main(String[] args) {
		new PruebaSilo3();
		ISilo silo[] = new ISilo[5];
		// Crea 5 silos de diferente tipo
		silo[0] = new SiloCilindro3(1.0, 1.0, Costos.LAMINA_CAL12);
		silo[1] = new SiloEsfera3(1.0, Costos.BASE_SIMPLE, Costos.LAMINA_CAL12);
		silo[2] = new SiloCono3(1.0, 1.0, Costos.BASE_SIMPLE, Costos.LAMINA_CAL12);
		silo[3] = new SiloCilindro3(2.0, 1.0, Costos.LAMINA_CAL14);
		silo[4] = new SiloCilindro3(1.0, 2.0, Costos.LAMINA_CAL16);
		// Para cada silo
		for (int i = 0; i < 5; i++) {
			// Calcula la superficie del silo
			silo[i].calculaSuperficie();
			// Calcula el volumen del silo
			silo[i].calculaVolumen();
			// Calcula el costo del silo
			silo[i].calculaCosto();
		}
		// Para cada silo
		for (int i = 0; i < 5; i++) // Escribe los valores de sus atributos
		{
			System.out.println(silo[i]);
		}
		// Escribe el número de silos creados
		System.out.println("Silos creados: " + Silo3.contadorSilos);
	}
}
