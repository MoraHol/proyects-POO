
package silo3;

import projects.Costos;
import projects.ISilo;

/**
 * Esta clase permite crear objetos de tipo SiloEsfera3
 *
 * @author
 */

public class SiloEsfera3 extends Silo3 implements ISilo {

	private final double radio;
	private final int tipoBase;

	/**
	 * Construye un objeto de esta clase e inicializa sus atributos
	 *
	 * @param radio
	 *            Radio del silo esférico
	 * @param tipoBase
	 * @param grosorLamina
	 */
	public SiloEsfera3(double radio, int tipoBase, int grosorLamina) {
		// Llama al constructor de la clase padre: Silo3
		super("Silo Esferico", grosorLamina);
		// Inicializa los atributos
		this.radio = radio;
		this.tipoBase = tipoBase;
	}

	/**
	 * Calcula la superficie de la esfera
	 */
	@Override
	public void calculaSuperficie() {
		superficie = 4 * Math.PI * radio * radio;
	}

	/**
	 * Calcula el volumen de la esfera
	 */
	@Override
	public void calculaVolumen() {
		volumen = 4 * Math.PI * radio * radio * radio / 3;
	}

	/**
	 * Calcula el precio del silo esférico
	 */
	@Override
	public void calculaCosto() {
		costo = Costos.get(tipoBase) + superficie * Costos.get(grosorLamina);
	}

	/**
	 * Genera una cadena con la representación de esta clase
	 *
	 * @return Una cadena con la representación de esta clase
	 */
	@Override
	public String toString() {
		return super.toString() + ", radio = " + radio + ", superficie = " + superficie + ", volumen = " + volumen
				+ ", costo: " + costo;
	}
}
