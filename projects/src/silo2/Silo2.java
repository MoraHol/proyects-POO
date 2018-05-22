
package silo2;

/**
 * Esta clase abstracta es la clase padre de las clases SiloCilindro2, SiloCono2
 * y SiloEsfera2
 *
 * @author
 */
public abstract class Silo2 {

	protected String tipoSilo;
	protected int grosorLamina;
	protected double superficie;
	protected double volumen;
	protected double costo;
	protected int numSilo;
	public static int contadorSilos = 0;

	/**
	 * Constructor. Inicializa el atributo tipoSilo e incrementa el contador de
	 * silos en uno cada vez que se crea un silo. También le asigna el valor de ese
	 * contador al atributo numSilo para numerar cada silo.
	 *
	 * @param tipoSilo
	 *            Tipo de silo: "Cilindro", "Cono", "Esfera"
	 * @param grosorLamina
	 *            Grosor de la lámina del silo cilÃ­ndrico
	 */
	public Silo2(String tipoSilo, int grosorLamina) {
		// Inicializa los atributos
		this.tipoSilo = tipoSilo;
		this.grosorLamina = grosorLamina;
		// Incrementa el contador de silos creados
		contadorSilos++;
		// Le asigna un número a este silo
		numSilo = contadorSilos;
	}

	public abstract void calculaSuperficie();

	public abstract void calculaVolumen();

	public abstract void calculaCosto();

	/**
	 * Genera una cadena con la representación de esta clase
	 *
	 * @return Una cadena con la representación de esta clase
	 */
	@Override
	public String toString() {
		return numSilo + ": " + tipoSilo + ", Grosor lÃ¡mina: " + grosorLamina;
	}
}
