
package silo3;

import projects.Costos;
import projects.ISilo;

/**
 * Esta clase permite crear objetos de tipo SiloCilindro3
 *
 * @author
 */
public class SiloCilindro3 extends Silo3 implements ISilo {

	private final double radio;
	private final double altura;

	/**
	 * Construye un objeto de esta clase e inicializa sus atributos
	 *
	 * @param radio
	 *            Radio del silo cil�ndrico
	 * @param altura
	 *            Altura del silo cil�ndrico
	 * @param grosorLamina
	 *            Grosor de la l�mina del silo cil�ndrico
	 */
	public SiloCilindro3(double radio, double altura, int grosorLamina) {
		// Llama al constructor de la clase padre: Silo3
		super("Silo Cilindrico", grosorLamina);
		// Inicializa los atributos
		this.radio = radio;
		this.altura = altura;
	}

	/**
	 * Calcula la superficie del cilindro
	 */
	@Override
	public void calculaSuperficie() {
		superficie = 2 * Math.PI * radio * (radio + altura);
	}

	/**
	 * Calcula el volumen del cilindro
	 */
	@Override
	public void calculaVolumen() {
		volumen = Math.PI * radio * radio * altura;
	}

	/**
	 * Calcula el precio del silo cilíndrico
	 */
	@Override
	public void calculaCosto() {
		costo = superficie * Costos.get(grosorLamina);
	}

	/**
	 * Genera una cadena con la representaci�n de esta clase
	 * 
	 * @return Una cadena con la representaci�n de esta clase
	 */
	@Override
	public String toString() {
		return super.toString() + ", radio = " + radio + ", altura = " + altura + ", superficie = " + superficie
				+ ", volumen = " + volumen + ", costo: " + costo;
	}
}
