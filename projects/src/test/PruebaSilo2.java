
package test;

import projects.Costos;
import silo2.Silo2;
import silo2.SiloCilindro2;
import silo2.SiloCono2;
import silo2.SiloEsfera2;

/**
 * Esta clase se utiliza para probar las clases SiloCilindro2, SiloCono2 y
 * SiloEsfera2
 *
 * @author
 */
public class PruebaSilo2 {

	/**
	 * Método main() en el que se invocan a los métodos de las clases
	 * SiloCilindro2, SiloCono2 y SiloEsfera2 para probarlos
	 *
	 * @param args
	 *            Los argumentos en la línea de comando
	 */
	public static void main(String[] args) {
		new PruebaSilo2();
		Silo2 silo[] = new Silo2[5];
		// Crea 5 silos de diferente tipo
		silo[0] = new SiloCilindro2(1.0, 1.0, Costos.LAMINA_CAL12);
		silo[1] = new SiloEsfera2(1.0, Costos.BASE_SIMPLE, Costos.LAMINA_CAL12);
		silo[2] = new SiloCono2(1.0, 1.0, Costos.BASE_SIMPLE, Costos.LAMINA_CAL12);
		silo[3] = new SiloCilindro2(2.0, 1.0, Costos.LAMINA_CAL14);
		silo[4] = new SiloCilindro2(1.0, 2.0, Costos.LAMINA_CAL16);
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
		System.out.println("Silos creados: " + Silo2.contadorSilos);
	}
}
