
package projects;

/**
 * Esta clase permite consultar los costos de las componentes de los silos
 *
 * @author
 */

public class Costos {
	// Indices de los costos en el arreglo costos

	public static final int BASE_SIMPLE = 0;
	public static final int BASE_REFORZADA = 1;
	public static final int LAMINA_CAL12 = 2;
	public static final int LAMINA_CAL14 = 3;
	public static final int LAMINA_CAL16 = 4;
	// Arreglo con los costos
	private static final double costos[] = { 600.0, 900.0, 35.0, 45.0, 60.0 };

	/**
	 * Regresa el costo del componente del silo
	 *
	 * @param componente
	 *            Índice del componente del que se desea el costo
	 * @return El costo del componente del silo
	 */
	public static double get(int componente) {
		return costos[componente];
	}
}
