
package silo3;

import projects.Costos;
import projects.ISilo;

/**
 * Esta clase permite crear objetos de tipo SiloCono3
 *
 * @author
 */
public class SiloCono3 extends Silo3 implements ISilo {

	private final double radio;
	private final double altura;
	private final int tipoBase;

	/**
	 * Construye un objeto de esta clase e inicializa sus atributos
	 *
	 * @param radio
	 *            Radio del silo c�nico
	 * @param altura
	 *            Altura del silo c�nico
	 * @param tipoBase
	 *            Tipo de la base del silo c�nico
	 * @param grosorLamina
	 *            Grosor de la l�mina del silo c�nico
	 */
	public SiloCono3(double radio, double altura, int tipoBase, int grosorLamina) {
		// Llama al constructor de la clase padre: Silo3
		super("Silo Canico", grosorLamina);
		// Inicializa los atributos
		this.radio = radio;
		this.altura = altura;
		this.tipoBase = tipoBase;
	}

	/**
	 * Calcula la superficie del cono
	 */
	@Override
	public void calculaSuperficie() {
		superficie = Math.PI * radio * (radio + Math.sqrt(radio * radio + altura * altura));
	}

	/**
	 * Calcula el volumen del cono
	 */
	@Override
	public void calculaVolumen() {
		volumen = Math.PI * radio * radio * altura / 3;

	}

	/**
	 * Calcula el precio del silo c�nico
	 */
	@Override
	public void calculaCosto() {
		costo = Costos.get(tipoBase) + superficie * Costos.get(grosorLamina);
	}

	/**
	 * Genera una cadena con la representaci�n de esta clase
	 *
	 * @return Una cadena con la representaci�n de esta clase
	 */
	@Override
	public String toString() {
		return super.toString() + ", radio = " + radio + ", altura = " + altura + ", superficie = " + superficie
				+ ", v = " + volumen + ", Costo: " + costo;
	}
}
