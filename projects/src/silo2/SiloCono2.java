
package silo2;

import projects.Costos;

/**
 * Esta clase permite crear objetos de tipo SiloCono2
 *
 * @author
 */
public class SiloCono2 extends Silo2 {

	private final double radio;
	private final double altura;
	private final int tipoBase;

	/**
	 * Construye un objeto de esta clase e inicializa sus atributos
	 *
	 * @param radio
	 *            Radio del silo cónico
	 * @param altura
	 *            Altura del silo cónico
	 * @param tipoBase
	 *            Tipo de la base del silo cónico
	 * @param grosorLamina
	 *            Grosor de la lámina del silo cónico
	 */
	public SiloCono2(double radio, double altura, int tipoBase, int grosorLamina) {
		// Llama al constructor de la clase padre: Silo2
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
	 * Calcula el precio del silo cÃ³nico
	 */
	@Override
	public void calculaCosto() {
		costo = Costos.get(tipoBase) + superficie * Costos.get(grosorLamina);
	}

	/**
	 * Genera una cadena con la representaciÃ³n de esta clase
	 *
	 * @return Una cadena con la representaciÃ³n de esta clase
	 */
	@Override
	public String toString() {
		return super.toString() + ", tipo base = " + tipoBase + ", radio = " + radio + ", altura = " + altura
				+ ", superficie = " + superficie + ", volumen = " + volumen + ", costo: " + costo;
	}
}