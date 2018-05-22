package silo3;

/**
 * Esta clase es la clase padre de las clases SiloCilindro3, SiloCono3 y
 * SiloEsfera3
 *
 * @author
 */
public abstract class Silo3 {

	protected String tipoSilo;
	protected double superficie;
	protected double volumen;
	protected double costo;
	protected int grosorLamina;
	protected int numSilo;
	public static int contadorSilos = 0;

	/**
	 * Constructor. Inicializa el atributo tipoSilo e incrementa el contador de
	 * silos en uno cada vez que se crea un silo.
	 *
	 * @param tipoSilo
	 *            Tipo de silo: "Cilindro", "Cono", "Esfera"
	 * @param grosorLamina
	 *            Grosor de la lÃ¡mina del silo cilíndrico
	 */
	public Silo3(String tipoSilo, int grosorLamina) {
		// Inicializa los atributos
		this.tipoSilo = tipoSilo;
		this.grosorLamina = grosorLamina;
		// Incrementa el contador de silos creados
		contadorSilos++;
		// Le asigna un numero a este silo
		numSilo = contadorSilos;
	}

	/**
	 * Genera una cadena con la representación de esta clase
	 *
	 * @return Una cadena con la representación de esta clase
	 */
	@Override
	public String toString()

	{
		return numSilo + ": " + tipoSilo + ", Grosor lÃ¡mina: " + grosorLamina;
	}
}
