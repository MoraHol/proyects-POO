
package projects;

/**
 * Esta interfaz declara los métodos que implementarán las clases SiloCilindro3,
 * SiloCono3 SiloEsfera3, SiloCilindro4, SiloCono4 y SiloEsfera4
 *
 * @author
 */
public interface ISilo {

	/**
	 * Calcula la superficie de un silo
	 */
	public void calculaSuperficie();

	/**
	 * Calcula el volumen de un silo
	 */
	public void calculaVolumen();

	/**
	 * Calcula el costo de un silo
	 */
	public void calculaCosto();
}
