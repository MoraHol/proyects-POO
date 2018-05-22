
package silo1;

/**
 * Esta clase abstracta es la clase padre de las clases SiloCilindro, SiloCono y
 * SiloEsfera
 *
 * @author
 */
public abstract class Silo {
	protected String tipoSilo;
	protected double superficie;
	protected double volumen;

	/**
	 * Constructor. Inicializa el atributo tipoSilo.
	 * 
	 * @param tipoSilo
	 *            Tipo de silo: "Cilindro", "Cono", "Esfera"
	 */
	public Silo(String tipoSilo) {
		this.tipoSilo = tipoSilo;
	}

	public abstract void calculaSuperficie();

	public abstract void calculaVolumen();

	/**
	 * Genera una cadena con la representación de esta clase
	 * 
	 * @return Una cadena con la representación de esta clase
	 */
	@Override
	public String toString() {
		return tipoSilo;
	}
}