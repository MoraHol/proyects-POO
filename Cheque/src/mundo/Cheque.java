package mundo;

public class Cheque {
	// ------------------------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------------------------
	/**
	 * fecha de realización de cheque
	 */
	private String fecha;
	/**
	 * numero de cheque
	 */
	private int numero;
	/**
	 * monto del cheque
	 */
	private double cantidad;
	/**
	 * Identificación de la persona que realiza el cheque
	 */
	private String Identificaion;
	/**
	 * nombre del destinatario del cheque
	 */
	private String Destinatario;
	// ------------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------------

	/**
	 * crea cheque con todos sus campos
	 * 
	 * @param fecha
	 *            - fecha del cheque
	 * @param numero
	 *            - numero del cheque
	 * @param cantidad
	 *            - monto del cheque
	 * @param identificacion
	 *            - identificación de la persona asociada a la cuenta
	 * @param destinatario
	 *            - persona que recibirá el cheque
	 */
	public Cheque(String fecha, int numero, double cantidad, String identificacion, String destinatario) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.cantidad = cantidad;
		Identificaion = identificacion;
		Destinatario = destinatario;
	}

	// ------------------------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------------------------
	/**
	 * devuelve la fecha del cheque
	 * @return fecha del cheque
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * devuelve el numero del cheque
	 * @return numero del cheque
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * devuelve el monto del cheque
	 * @return monto del cheque
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * devuelve la identificación de la persona asociada a la cuenta
	 * @return identificación de la persona
	 */
	public String getIdentificacion() {
		return Identificaion;
	}

	/**
	 * devuelve el destinatario del cheque
	 * @return destinatario del cheque
	 */
	public String getDestinatario() {
		return Destinatario;
	}

	@Override
	public String toString() {
		return Identificaion + "," + Integer.toString(numero) + "," + fecha + "," + Destinatario + ","
				+ Double.toString(cantidad);

	}

}
